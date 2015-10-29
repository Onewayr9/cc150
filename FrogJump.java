package cc150;

import java.util.HashMap;

public class FrogJump {
	public int solution(int[] A, int N, int X, int D){
		if(X==0||X<=D){
			return 0;
		}else if(N==0){
			return -1;
		}
		HashMap<Integer,Integer> leaves = new HashMap<Integer,Integer>();
		leaves.put(0, 0);
		for(int i=0;i<A.length;i++){
			if(!leaves.containsKey(A[i])){
				leaves.put(A[i],i);
			}
		}
		int[] ans = new int[N+1];
		ans[0] = D;
		for(int i=1;i<=N;i++){
			ans[i] = ans[i-1];
			for(int j = ans[i-1];j>=ans[i-1]-D;j--){
				if(leaves.containsKey(j)){
					if(leaves.get(j)<=i){
						ans[i] = j + D;
						break;
					}
				}
			}
			if(ans[i]>=X){
				return i;
			}
		}
		return -1;
	}
	public static void main(String[] args){
		int[] A = {1,3,1,4,2,5};
		System.out.println(new FrogJump().solution(A, 6, 7, 3));
	}
}
