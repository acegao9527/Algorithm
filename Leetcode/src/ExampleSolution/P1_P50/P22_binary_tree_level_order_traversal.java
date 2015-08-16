package ExampleSolution.P1_P50;

import java.util.ArrayList;

public class P22_binary_tree_level_order_traversal {

	public class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result= new ArrayList<ArrayList<Integer>>();
        if(root == null){
            return result;
        }
        ArrayList<Integer> r = new ArrayList<Integer>();
        r.add(root.val);
        result.add(r);
        ArrayList<ArrayList<Integer>> rLeft = levelOrder(root.left);
        ArrayList<ArrayList<Integer>> rRight = levelOrder(root.right);
        for (int i=0;i<rLeft.size();i++){
            result.add(rLeft.get(i));
        }
        for (int i=0;i<rRight.size();i++){
            if(i<rLeft.size()){
                result.get(i+1).addAll(rRight.get(i));
            }
            else{
                result.add(rRight.get(i));
            }
        }
        return result;
    }
}
