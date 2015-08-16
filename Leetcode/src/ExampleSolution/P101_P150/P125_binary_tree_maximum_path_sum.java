package ExampleSolution.P101_P150;

public class P125_binary_tree_maximum_path_sum {

	public class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
	public int maxValue = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root==null){
            return 0;
        }
        return Math.max(maxSubPath(root),maxValue);
    }
    public int maxSubPath(TreeNode root) {
        int max = 0;
        int sum = root.val;
        if (root.left != null){
            int left = maxSubPath(root.left);
            max = Math.max(max,left);
            sum += Math.max(left,0);
        }
        if (root.right != null){
            int right = maxSubPath(root.right);
            max = Math.max(max,right);
            sum += Math.max(right,0);
        }
        if(sum>maxValue)
            maxValue = sum;
        return max+ root.val;
    }
}
