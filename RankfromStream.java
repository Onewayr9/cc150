package cc150;

public class RankfromStream {
	class TreeNode{
		int leftchild;
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val, int leftchild){
			this.val = val;
			this.leftchild = leftchild;
		}
	}
	TreeNode root = null;
	public void track(int x){
		if(root==null){
			root = new TreeNode(x,0);
		}else{
			TreeNode node = new TreeNode(x,0);
			TreeNode temp = root;
			while(true){
				if(x>temp.val){
					if(temp.right==null){
						temp.right = node;
						break;
					}else{
						temp = temp.right;
					}
				}else{
					temp.leftchild++;
					if(temp.left==null){
						temp.left = node;
						break;
					}else{
						temp = temp.left;
					}
				}
			}
		}
	}
	public int getRankOfNumber(int i){
		if(root==null){
			return -1;
		}
		TreeNode node = root;
		int ans = 0;
		while(node!=null){
			if(i==node.val){
				return ans+node.leftchild;
			}else if(i<node.val){
				node = node.left;
			}else{
				ans += node.leftchild+1;
				node = node.right;
			}
		}
		return -1;
	}
	public static void main(String[] args){
		RankfromStream r = new RankfromStream();
		r.track(5);
		r.track(1);
		r.track(4);
		r.track(4);
		r.track(5);
		r.track(9);
		r.track(7);
		r.track(13);
		r.track(3);
		System.out.println(r.getRankOfNumber(4));
	}
}
