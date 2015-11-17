package cc150;

public class FactorialZeros {
	public int computeZero(int n){
		int ans = 0, ten = 10, five = 5, a = 2, b = 1;
		while(n/ten!=0||n%ten>=five){
			ans+= a*(n/ten);
			if(n%ten>=five) ans+=b;
			ten*=10;
			five*=10;
			a*=2;
			b*=2;
		}
		return ans;
	}
	public static void main(String[] args){
		FactorialZeros a = new FactorialZeros();
		System.out.println(a.computeZero(15));
	}
}
