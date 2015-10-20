package cc150;

public class FirstCommonAncestor {
	boolean isCovered = false;
	public TreeNode FindCommonAncestor(TreeNode root,TreeNode p,TreeNode q){
		if(root==null||p==null||q==null){
			return null;
		}
		if(!isCovered&&(cover(p,q)||cover(q,p))){
			return cover(p,q)?p:q;
		}
		isCovered = true;
		boolean isLeftp = cover(root.left,p);
		boolean isLeftq = cover(root.left,q);
		if(isLeftp!=isLeftq){
			return root;
		}else{
			return isLeftp?FindCommonAncestor(root.left,p,q):FindCommonAncestor(root.right,p,q);
		}
	}
	public boolean cover(TreeNode p,TreeNode q){
		if(p==null){
			return false;
		}
		if(p==q){
			return true;
		}
		return cover(p.left,q)||cover(p.right,q);
	}
	public static void main(String[] args){
		TreeNode a = new TreeNode(3);
		TreeNode b = new TreeNode(4);
		TreeNode c = new TreeNode(5);
		TreeNode d = new TreeNode(6);
		TreeNode e = new TreeNode(7);
		TreeNode f = new TreeNode(8);
		TreeNode g = new TreeNode(9);
		a.left = b;
		a.right = c;
		b.left = d;
		b.right = e;
		c.left = f;
		d.left = g;
		TreeNode h = new FirstCommonAncestor().FindCommonAncestor(a, e, g);
		System.out.println(h.val);
	}
}
