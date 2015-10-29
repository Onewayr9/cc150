package cc150;

public class NextNumber {
	public static int getNext(int num){
		int temp = num;
		int rightMostZero = 0;
		int Ones = 0;
		while(temp!=0){
			if((temp&1)==1){
				Ones++;
				rightMostZero++;
			}else{
				if(Ones==0){
					rightMostZero++;
				}else{
					break;
				}
			}
			temp>>=1;
		}
		int a = ~0;
		a <<= rightMostZero;
		num |= 1<<(rightMostZero+1);
		num &= a;
		int b = 1<<(Ones-1) - 1;
		num |= b;
		return num;
	}
	public static int getPrev(int num){
		int temp = num;
		int rightMostOne = 0;
		int Zeros = 0;
		while(temp!=0){
			if((temp&1)==0){
				Zeros++;
				rightMostOne++;
			}else{
				if(Zeros==0){
					rightMostOne++;
				}else{
					break;
				}
			}
			temp>>=1;
		}
		if(Zeros==0){
			return -1;
		}
		int a = ~0;
		num &= (a<<(rightMostOne+1));
		int Ones = rightMostOne - Zeros;
		int b = 1<<(Ones+1) - 1;
		num |= b<<(Zeros-1);
		return num;
	}
}
