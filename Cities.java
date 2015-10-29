package cc150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Cities {
	public int[] solution(int[] T){
		if(T.length<=1){
			return new int[0];
		}
		int capital = 0;
		ArrayList<ArrayList<Integer>> map = new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<T.length;i++){
			map.add(new ArrayList<Integer>());
		}
		for(int i=0;i<T.length;i++){
			if(T[i]==i){
				capital = i;
			}else{
				map.get(T[i]).add(i);
			}
		}
		int[] ans = new int[T.length-1];
		HashMap<Integer,Integer> dis = new HashMap<Integer,Integer>();
		dis.put(capital, 0);
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(capital);
		while(!queue.isEmpty()){
			int temp = queue.poll();
			for(int node:map.get(temp)){
				queue.offer(node);
				dis.put(node, dis.get(temp)+1);
				ans[dis.get(temp)]++;
			}
		}
		return ans;
	}
	public static void main(String[] args){
		int[] T = {0,0};
		int[] ans = new Cities().solution(T);
		for(int a:ans){
			System.out.println(a);
		}
	}
}
