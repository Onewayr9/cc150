package cc150;

import java.util.Arrays;

public class SmallestDifference {
	public int findDiff(int[] a1, int[] a2){
		Arrays.sort(a1);
		Arrays.sort(a2);
		int diff = Math.abs(a1[0]-a2[0]);
		int i=0,j=0;
		while(i<a1.length&&j<a2.length){
			diff = Math.min(diff, Math.abs(a1[i]-a2[j]));
			if(a1[i]>a2[j]){
				j++;
			}else{
				i++;
			}
		}
		return diff;
	}
	public static void main(String[] args){
		int[] a1 = {1,3,15,11,2};
		int[] a2 = {23,127,235,19,8};
		SmallestDifference a = new SmallestDifference();
		System.out.println(a.findDiff(a1, a2));
	}
}
