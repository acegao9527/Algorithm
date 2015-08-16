package ExampleSolution.P1_P50;

public class P02_maximum_depth_of_binary_tree {

	/**
	 * Definition for binary tree
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	 public static class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
    public int maxDepth(TreeNode root) {
    	if (root == null){
    		return 0;
    	}
        if (root.left == null && root.right == null){
            return 1;
        }
        else if (root.left == null){
            return maxDepth(root.right)+1;
        }
        else if (root.right == null){
            return maxDepth(root.left)+1;
        }
        else {
            return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
        }
    }

    public static void main(String[] args) {
        P02_maximum_depth_of_binary_tree P1 = new P02_maximum_depth_of_binary_tree();
        TreeNode treenode1 = new TreeNode(1);
        TreeNode treenode2 = new TreeNode(2);
        TreeNode treenode3 = new TreeNode(3);
        treenode1.left = treenode2;
        treenode2.right = treenode3;
        int a = P1.maxDepth(treenode1);
        System.out.println(a);
    }

}
