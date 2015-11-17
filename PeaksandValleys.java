package cc150;

public class PeaksandValleys {
	public void alterArray(int[] nums){
		if(nums.length<=2){
			return;
		}else{
			boolean isPeak = nums[1]<=nums[0];
			for(int i=1;i<nums.length-1;i++){
				if(isPeak&&nums[i]>nums[i+1]){
					int temp = nums[i];
					nums[i] = nums[i+1];
					nums[i+1] = temp;
				}else if(!isPeak&&nums[i]<nums[i+1]){
					int temp = nums[i];
					nums[i] = nums[i+1];
					nums[i+1] = temp;
				}
				isPeak = !isPeak;
			}
		}
	}
	public static void main(String[] args){
		int[] nums = {3,5,2,5,7,8,1,0};
		PeaksandValleys a = new PeaksandValleys();
		a.alterArray(nums);
		for(int e:nums){
			System.out.println(e);
		}
	}
}
