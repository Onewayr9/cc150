package cc150;

import java.util.ArrayList;
import java.util.List;

public class Parens {
	List<String> ans = new ArrayList<String>();
	public List<String> getParentheses(int n){
		if(n==0){
			return ans;
		}
		help("",0,0,n);
		return ans;
	}
	public void help(String temp,int left,int right,int n){
		if(left==right&&left==n){
			ans.add(temp);
			return;
		}
		if(left==right){
			help(temp+"(",left+1,right,n);
		}
		if(left>right){
			help(temp+")",left,right+1,n);
			if(left<n){
				help(temp+"(",left+1,right,n);
			}
		}
	}
	public static void main(String[] args){
		List<String> a = new Parens().getParentheses(13);
		for(String s:a){
			System.out.println(s);
		}
	}
}
