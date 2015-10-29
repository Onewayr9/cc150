package cc150;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
	List<String> ans = new ArrayList<String>();
	public List<String> PermutationsWithoutDups(String str){
		String temp = "";
		int len = str.length();
		char[] strChar = str.toCharArray();
		help(strChar,0,len,temp);
		return ans;
	}
	public void help(char[] c,int begin,int len,String temp){
		if(begin==len){
			ans.add(temp);
			return;
		}
		for(int i=begin;i<len;i++){
			reverse(c,begin,i);
			help(c,begin+1,len,temp+c[begin]);
			reverse(c,begin,i);
		}
	}
	public void reverse(char[] c,int a, int b){
		if(a==b){
			return;
		}else{
			char temp = c[a];
			c[a] = c[b];
			c[b] = temp;
		}
	}
	public static void main(String[] args){
		List<String> ans = new Permutation().PermutationsWithoutDups("abcd");
		for(String s:ans){
			System.out.println(s);
		}
	}
}
