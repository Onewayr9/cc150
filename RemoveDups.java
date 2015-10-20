package cc150;

import java.util.HashSet;
import java.util.Set;

public class RemoveDups {
	public ListNode RemoveDups(ListNode head){
		if(head==null||head.next==null){
			return head;
		}
		ListNode node = head;
		Set<Integer> set = new HashSet<Integer>();
		while(head!=null){
			set.add(node.val);
			ListNode next = node.next;
			while(set.contains(next.val)){
				next = next.next;
				node.next = next;
			}
			node = node.next;
		}
		return head;
	}
}
