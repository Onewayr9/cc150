package cc150;

public class LoopDetection {
	public static ListNode findLoop(ListNode head){
		if(head==null||head.next==null){
			return null;
		}
		ListNode slow = head;
		ListNode fast = head;
		int cycleLength = 0;
		boolean find = false;
		while(fast!=null&&fast.next!=null){
			slow = slow.next;
			fast = fast.next.next;
			cycleLength++;
			if(fast==slow){
				find = true;
				break;
			}
		}
		if(!find){
			return null;
		}else{
			slow = head;
			fast = head;
			while(cycleLength-->0){
				fast = fast.next;
			}
			while(slow!=fast){
				slow = slow.next;
				fast = fast.next;
			}
			return slow;
		}
	}
}
