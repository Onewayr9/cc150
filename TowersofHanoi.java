package cc150;

import java.util.Stack;

public class TowersofHanoi {
	public void Hanoi(int n){
		Stack<Integer> tower1 = new Stack<Integer>();
		Stack<Integer> tower2 = new Stack<Integer>();
		Stack<Integer> tower3 = new Stack<Integer>();
		for(int i=n;i>=1;i--){
			tower1.push(i);
		}
		Hanoi(n,tower1,tower3,tower2);
		while(!tower3.empty()){
			System.out.println(tower3.pop());
		}
	}
	public void Hanoi(int n,Stack<Integer> origin,Stack<Integer> destination,Stack<Integer> buffer){
		if(n==0){
			return;
		}
		Hanoi(n-1,origin,buffer,destination);
		destination.push(origin.pop());
		Hanoi(n-1,buffer,destination,origin);
	}
	public static void main(String[] args){
		new TowersofHanoi().Hanoi(3);
	}
}
