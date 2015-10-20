package cc150;

public class SumLists {
	public static void printList(ListNode head){
		while(head!=null){
			System.out.println(head.val+" ");
			head = head.next;
		}
	}
	public static ListNode SumReverseLists(ListNode head1,ListNode head2){
		int sum = 0;
		int plus = 0;
		ListNode newhead = new ListNode(0);
		ListNode node = newhead;
		while(head1!=null||head2!=null){
			int num1 = head1==null?0:head1.val;
			int num2 = head2==null?0:head2.val;
			sum = (num1+num2+plus)%10;
			plus = (num1+num2+plus)/10;
			node.next = new ListNode(sum);
			node = node.next;
			if(head1!=null){
				head1 = head1.next;
			}
			if(head2!=null){
				head2 = head2.next;
			}
		}
		if(plus==1){
			node.next = new ListNode(1);
		}
		return newhead.next;
	}
	public static ListNode reverseList(ListNode head){
		if(head==null||head.next==null){
			return head;
		}
		ListNode H = new ListNode(0);
		ListNode node = head;
		while(node!=null){
			ListNode temp = node;
			node = node.next;
			temp.next = H.next;
			H.next = temp;
		}
		return H.next;
	}
	public static ListNode SumForwardLists(ListNode head1,ListNode head2){
		head1 = reverseList(head1);
		head2 = reverseList(head2);
		return reverseList(SumReverseLists(head1,head2));
	}
	public static void main(String[] args){
		ListNode a = new ListNode(7);
		ListNode b = new ListNode(1);
		ListNode c = new ListNode(6);
		a.next = b;
		b.next = c;
		ListNode d = new ListNode(5);
		ListNode e = new ListNode(9);
		ListNode f = new ListNode(3);
		ListNode g = new ListNode(2);
		d.next = e;
		e.next = f;
		f.next = g;
		printList(SumForwardLists(a,d));
	}
}
