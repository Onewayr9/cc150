package cc150;

public class Partition {
	public static ListNode partitionList(ListNode head, int n){
		if(head==null||head.next==null){
			return head;
		}
		ListNode newhead = new ListNode(0);
		newhead.next = head;
		ListNode p1 = newhead;
		ListNode p2 = head;
		while(p1.next.val<n){
			p1 = p1.next;
		}
		while(p2.val<n&&p2!=null){
			p2 = p2.next;
		}
		if(p2==null){
			return head;
		}else{
			while(p2.next!=null){
				if(p2.next.val>=n){
					p2 = p2.next;
				}else{
					ListNode temp = p2.next;
					p2.next = p2.next.next;
					temp.next = p1.next;
					p1.next = temp;
				}
			}
			return newhead.next;
		}
	}
	public static void printList(ListNode head){
		while(head!=null){
			System.out.println(head.val+" ");
			head = head.next;
		}
	}
	public static void main(String[] args){
		ListNode a = new ListNode(3);
		ListNode b = new ListNode(5);
		ListNode c = new ListNode(8);
		ListNode d = new ListNode(5);
		ListNode e = new ListNode(10);
		ListNode f = new ListNode(2);
		ListNode g = new ListNode(1);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = f;
		f.next = g;
		ListNode head = partitionList(a,5);
		printList(head);
	}
}
