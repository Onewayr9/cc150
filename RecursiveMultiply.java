package cc150;

public class RecursiveMultiply {
	public int multiply(int a,int b){
		if(b>>>1==0){
			return b==1?a:0;
		}
		int t = b&1;
		int sum = 0;
		if(t==1){
			sum = a;
		}
		sum += multiply(a<<1,b>>>1);
		return sum;
	}
	public static void main(String[] args){
		System.out.println(new RecursiveMultiply().multiply(13,21));
	}
}
