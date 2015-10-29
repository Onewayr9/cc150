package cc150;

public class PairwiseSwap {
	public static int swap(int num){
		int HexEven = 0xaaaaaaaa;
		int HexOdd = 0x55555555;
		int Even = (num & HexEven)>>>1;
		int Odd = (num & HexOdd)<<1;
		return Even|Odd;
	}
	public static void main(String[] args){
		System.out.println(swap(10));
	}
}
