package P1_P50;

import java.util.ArrayList;
import java.util.Stack;

public class P09_binary_tree_inorder_traversal_II {

	public class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null)
            return result;
        Stack<TreeNode> stk = new Stack<TreeNode>();
        TreeNode temp = root;
        while(!stk.empty()||temp!=null){
            while (temp!=null) {
                stk.push(temp);
                temp = temp.left;
            }
            temp = stk.pop();
            result.add(temp.val);
            temp = temp.right;
        }
        return result;
    }

}
