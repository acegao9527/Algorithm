package P51_P100;

public class P56_populating_next_right_pointers_in_each_node_II {

	public class TreeLinkNode {
	    int val;
	    TreeLinkNode left, right, next;
	    TreeLinkNode(int x) { val = x; }
	}
	public void connect(TreeLinkNode root) {
        if (root==null){
            return;
        }
        TreeLinkNode NextRoot = root.next;
        TreeLinkNode temp = null;
        while (NextRoot!=null){
            if(NextRoot.left!=null){
                temp = NextRoot.left;
                break;
            }
            else if (NextRoot.right!=null){
                temp = NextRoot.right;
                break;
            }
            NextRoot = NextRoot.next;
        }
        if (root.right!=null){
            root.right.next = temp;
        }
        else if(root.left!=null){
            root.left.next = temp;
        }
        if(root.left!=null&&root.right!=null){
            root.left.next = root.right;
        }
        connect(root.right);
        connect(root.left);
    }
}
