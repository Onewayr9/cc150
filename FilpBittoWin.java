package cc150;

public class FilpBittoWin {
	public static int getLongestLength(int num){
		if(~num==0){
			return Integer.BYTES*8;
		}
		int prevLength = 0;
		int currLength = 0;
		int ans = 1;
		while(num!=0){
			if((num&1)!=0){
				currLength++;
			}else{
				prevLength = currLength;
				currLength = 0;
			}
			ans = Math.max(prevLength+currLength+1, ans);
			num>>>=1;
		}
		return ans;
	}
	public static void main(String[] args){
		System.out.println(getLongestLength(1775));
	}
}
