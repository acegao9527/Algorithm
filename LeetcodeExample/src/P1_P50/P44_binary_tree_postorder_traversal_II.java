package P1_P50;

import java.util.ArrayList;
import java.util.Stack;

public class P44_binary_tree_postorder_traversal_II {

	public class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
	public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root==null){
            return result;
        }
        Stack<TreeNode> stk = new Stack<TreeNode>();
        TreeNode cur = root;
        TreeNode pre = null;
        stk.push(cur);
        while(!stk.empty()){
            cur = stk.peek();
            if(cur.left==null&&cur.right==null||(pre!=null&&(cur.left==pre||cur.right==pre))){
                result.add(cur.val);
                stk.pop();
                pre = cur;
            }
            else {
                if(cur.right!=null)
                    stk.push(cur.right);
                if(cur.left!=null)
                    stk.push(cur.left);
            }
        }
        return result;
    }
}

