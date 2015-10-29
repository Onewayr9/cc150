package cc150;

public class MagicIndex {
	public static int findMagicIndexWithoutDup(int[] num){
		if(num.length==0){
			return -1;
		}
		int left = 0;
		int right = num.length-1;
		while(left<=right){
			int mid = (right+left)/2;
			if(num[mid]==mid){
				return mid;
			}else if(num[mid]<mid){
				left = mid+1;
			}else{
				right = mid-1;
			}
		}
		return -1;
	}
	public static void main(String[] args){
		int[] index = {-1,1,3,4,5};
		System.out.println(findMagicIndexWithoutDup(index));
	}
}
