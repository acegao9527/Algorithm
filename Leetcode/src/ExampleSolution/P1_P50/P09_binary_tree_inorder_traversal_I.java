package ExampleSolution.P1_P50;
import java.util.ArrayList;


public class P09_binary_tree_inorder_traversal_I {

	/**
	 * Definition for binary tree
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	
	public class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
	
    public ArrayList<Integer> inorderTraversal(TreeNode root) {

        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null){
            return result;
        }
        if(root.left!=null)
            result.addAll(inorderTraversal(root.left));
        
        result.add(root.val);
        
        if(root.right!=null)
            result.addAll(inorderTraversal(root.right));

        return result;
    }
}
