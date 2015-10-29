package cc150;

public class BooleanEvaluation {
	public int countEval(String boo, boolean result){
		if(boo.length()==0){
			return 0;
		}
		if(boo.length()==1){
			boolean temp = boo.charAt(0)=='0'?false:true;
			return temp==result?1:0;
		}
		int ans = 0;
		for(int i=1;i<boo.length();i+=2){
			String left = boo.substring(0,i);
			String right = boo.substring(i+1);
			int LeftTrue = countEval(left,true);
			int LeftFalse = countEval(left,false);
			int RightTrue = countEval(right,true);
			int RightFalse = countEval(right,false);
			int total = (LeftTrue+LeftFalse)*(RightTrue+RightFalse);
			int totalTrue = 0;
			if(boo.charAt(i)=='&'){
				totalTrue = LeftTrue*RightTrue;
			}else if(boo.charAt(i)=='|'){
				totalTrue = LeftTrue*(RightTrue+RightFalse) + LeftFalse*RightTrue;
			}else{
				totalTrue = LeftFalse*RightTrue+LeftTrue*RightFalse;
			}
			ans += result?totalTrue:total-totalTrue;
		}
		return ans;
	}
	public static void main(String[] args){
		BooleanEvaluation b = new BooleanEvaluation();
		System.out.println(b.countEval("0&0&0&1^1|0", true));
	}
}
