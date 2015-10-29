package cc150;

import java.util.HashMap;

public class SubSequence {
	public int solution(int[] A){
		if(A.length<=1){
			return A.length;
		}
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int num:A){
			if(!map.containsKey(num)){
				map.put(num, 1);
			}else{
				map.put(num, map.get(num)+1);
			}
		}
		int max = 0;
		for(int num:map.keySet()){
			int sum = map.get(num);
			if(map.containsKey(num+1)){
				sum += map.get(num+1);
			}
			max = Math.max(sum, max);
		}
		return max;
	}
	public static void main(String[] args){
		int[] A = {6,10,6,9,7,8};
		System.out.println(new SubSequence().solution(A));
	}
}
