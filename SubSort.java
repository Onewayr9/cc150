package cc150;

public class SubSort {
	public int[] getSub(int[] nums){
		if(nums.length==0){
			return new int[]{0,0};
		}
		int left = 0, right = nums.length-1;
		while(left<nums.length-1){
			if(nums[left]<=nums[left+1]){
				left++;
			}else{
				break;
			}
		}
		if(left==nums.length-1) return null;
		while(right>=1){
			if(nums[right]>=nums[right-1]){
				right--;
			}else{
				break;
			}
		}
		int min_index = right;
		int max_index = left;
		for(int i = left+1;i<right;i++){
			if(nums[i]<nums[min_index]) min_index = i;
			if(nums[i]>nums[max_index]) max_index = i;
		}
		int min = nums[min_index], max = nums[max_index];
		for(int i = left;i>=0;i--){
			if(nums[i]<=min){
				min_index = i;
				break;
			}
		}
		for(int i = right;i<nums.length;i++){
			if(nums[i]>=max){
				max_index = i;
				break;
			}
		}
		return new int[]{min_index,max_index};
	}
}
