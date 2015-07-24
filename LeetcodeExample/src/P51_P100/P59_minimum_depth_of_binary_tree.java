package P51_P100;

public class P59_minimum_depth_of_binary_tree {

	public class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
	public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        if(root.left==null&&root.right==null){
            return 1;
        }
        if(root.right==null){
            return 1+minDepth(root.left);
        }
        if(root.left==null){
            return 1+minDepth(root.right);
        }
        return 1+Math.min(minDepth(root.left),minDepth(root.right));
    }
}
