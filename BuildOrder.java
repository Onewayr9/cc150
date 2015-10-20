package cc150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BuildOrder {
	public static char[] getOrder(char[] projects,char[][] dependencies){
		List<List<Integer>> prerequists = new ArrayList<List<Integer>>();
		int[] preNumber = new int[projects.length];
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();
		for(int i=0;i<projects.length;i++){
			map.put(projects[i], i);
			prerequists.add(new ArrayList<Integer>());
		}
		for(int i=0;i<dependencies.length;i++){
			preNumber[map.get(dependencies[i][0])]++;
			prerequists.get(map.get(dependencies[i][1])).add(map.get(dependencies[i][0]));
		}
		char[] order = new char[projects.length];
		int count = 0;
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i=0;i<preNumber.length;i++){
			if(preNumber[i]==0){
				queue.offer(i);
			}
		}
		while(!queue.isEmpty()){
			int number = queue.poll();
			order[count++] = projects[number];
			for(int num:prerequists.get(number)){
				preNumber[num]--;
				if(preNumber[num]==0){
					queue.offer(num);
				}
			}
		}
		if(count==projects.length){
			return order;
		}else{
			return null;
		}
	}
	public static void main(String[] args){
		char[] projects = {'a','b','c','d','e','f'};
		char[][] dependencies = {{'a','c'},{'a','f'},{'d','f'}};
		char[] order = getOrder(projects,dependencies);
		for(char c:order){
			System.out.println(c+" ");
		}
	}
}
