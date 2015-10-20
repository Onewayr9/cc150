package cc150;

public class OneAway {
	public static boolean solution(String s1,String s2){
		if(Math.abs(s1.length()-s2.length())>1){
			return false;
		}
		int credits = 1;
		for(int i=0,j=0;i<s1.length()&&j<s2.length();i++,j++){
			if(s1.charAt(i)!=s2.charAt(j)){
				if(credits==0){
					return false;
				}else{
					credits--;
					if(s1.length()>s2.length()){
						j--;
					}if(s1.length()<s2.length()){
						i--;
					}
				}
			}
		}
		return true;
	}
	public static void main(String[] args){
		System.out.println(solution("abc", "abcd"));
	}
}
