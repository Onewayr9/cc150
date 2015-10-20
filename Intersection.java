package cc150;

public class Intersection {
	public static ListNode Intersection(ListNode root1, ListNode root2){
		if(root1==null||root2==null){
			return null;
		}
		int length1 = 0,length2 = 0;
		ListNode node = root1;
		while(node!=null){
			length1++;
			node = node.next;
		}
		node = root2;
		while(node!=null){
			length2++;
			node = node.next;
		}
		int diff = Math.abs(length2-length1);
		while(diff>0){
			diff--;
			if(length2>length1){
				root2 = root2.next;
			}else{
				root1 = root1.next;
			}
		}
		while(root1!=null){
			if(root1==root2){
				return root1;
			}
			root1 = root1.next;
			root2 = root2.next;
		}
		return null;
	}
}
