package P1_P50;

import java.util.ArrayList;
import java.util.Stack;


public class P11_binary_tree_preorder_traversal_II {

	public class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
	public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root ==null){
            return result;
        }
        Stack<TreeNode> stk = new Stack<TreeNode>();
        TreeNode temp = root;
        while(!stk.empty()||temp!=null){
            while(temp!=null){
                result.add(temp.val);
                stk.add(temp);
                temp = temp.left;
            }
            temp = stk.pop().right;
        }
        return result;
    }

}
