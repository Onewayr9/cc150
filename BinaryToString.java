package cc150;

public class BinaryToString {
	public static String transfer(double num){
		if(num==0){
			return "0";
		}
		if(num==1){
			return "1";
		}
		String ans = "0.";
		for(int i=0;i<=31;i++){
			double temp = num * 2.0;
			if(temp>=1){
				ans+="1";
				num = temp - 1.0;
			}else{
				num = temp;
				ans+="0";
			}
			if(num==0){
				break;
			}
		}
		if(num==0){
			return ans; 
		}else{
			return "ERROR";
		}
	}
	public static void main(String[] args){
		System.out.println(transfer(0.125));
	}
}
