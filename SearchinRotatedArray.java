package cc150;

public class SearchinRotatedArray {
	public int search(int[] nums,int x){
		int right = nums.length-1;
		return helper(nums,0,right,x);
	}
	public int helper(int[] nums,int left,int right,int x){		
		while(left<=right){
			if(nums[left]==nums[right]){
				left++;
			}else{
				break;
			}
		}
		if(right>right){
			return -1;
		}
		int middle = (left+right)/2;
		if(nums[middle]==x){
			return middle;
		}
		if(nums[middle]>nums[left]){
			if(x>=nums[left]&&x<nums[middle]){
				return helper(nums,left,middle-1,x);
			}else{
				return helper(nums,middle+1,right,x);
			}
		}else{
			if(x>nums[middle]&&x<=nums[right]){
				return helper(nums,middle+1,right,x);
			}else{
				return helper(nums,left,middle-1,x);
			}
		}
	}
	public static void main(String[] args){
		int[] a = {15,16,19,20,25,1,3,4,5,7,10,14};
		SearchinRotatedArray b = new SearchinRotatedArray();
		System.out.println(b.search(a, 5));
	}
}
