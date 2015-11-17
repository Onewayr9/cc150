package cc150;

import java.util.HashMap;

public class PatternMatching {
	public boolean isMatching(String pattern, String str){
		HashMap<Character,String> map = new HashMap<>();
		return isMatching(pattern,str,map);
	}
	public boolean isMatching(String pattern, String str, HashMap<Character,String> map){
		if(str.length()==0){
			return pattern.length()==0;
		}
		if(map.containsKey(pattern.charAt(0))){
			String mat = map.get(pattern.charAt(0));
			if(str.length()<mat.length()||!str.substring(0,mat.length()).equals(mat)){
				return false;
			}else{
				return isMatching(pattern.substring(1),str.substring(mat.length()),map);
			}
		}else{
			for(int i=1;i<=str.length();i++){
				if(!map.containsValue(str.substring(0, i))){
					map.put(pattern.charAt(0), str.substring(0, i));
					if(isMatching(pattern.substring(1),str.substring(i),map)){
						return true;
					}
					map.remove(pattern.charAt(0));
				}
			}
			return false;
		}
	}
	public static void main(String[] args){
		PatternMatching p = new PatternMatching();
		System.out.println(p.isMatching("aabab", "catcatgocat"));
	}
}
