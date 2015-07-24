package P1_P50;

public class P08_populating_next_right_pointer {

	/**
	 * Definition for binary tree with next pointer.
	 * public class TreeLinkNode {
	 *     int val;
	 *     TreeLinkNode left, right, next;
	 *     TreeLinkNode(int x) { val = x; }
	 * }
	 */
	public class TreeLinkNode {
	    int val;
	    TreeLinkNode left, right, next;
	    TreeLinkNode(int x) { val = x; }
	}
	
    public void connect(TreeLinkNode root) {
        if (root ==null)
            return;
        if (root.next !=null&&root.right !=null&&root.next.left!=null){
            root.right.next = root.next.left;
        }
        if (root.left!=null&&root.right!=null){
            root.left.next = root.right;
        }
        
        connect(root.left);
        connect(root.right);
    }
}
