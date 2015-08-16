package ExampleSolution.P1_P50;

public class P44_path_sum {

	public class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
	public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null){
            return false;
        }
        if (root.left !=null||root.right !=null){
            return hasPathSum(root.left,sum-root.val)||hasPathSum(root.right,sum-root.val);
        }
        return (root.val==sum);
    }
}
