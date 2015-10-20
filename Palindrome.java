package cc150;

import java.util.Stack;

public class Palindrome {
	public static boolean isPalindromeList(ListNode root){
		if(root==null||root.next==null){
			return true;
		}
		Stack<ListNode> stack = new Stack<ListNode>();
		ListNode node = root;
		int capacity = 0;
		while(node!=null){
			stack.push(node);
			capacity++;
			node = node.next;
		}
		for(int i=1;i<=capacity/2;i++){
			if(root.val!=stack.pop().val){
				return false;
			}
			root = root.next;
		}
		return true;
	}
	public static void main(String[] args){
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(4);
		ListNode c = new ListNode(4);
		ListNode d = new ListNode(2);
		a.next = b;
		b.next = c;
		c.next = d;
		System.out.println(isPalindromeList(a));
	}
}
