package ExampleSolution.P1_P50;
import java.util.ArrayList;


public class P32_binary_tree_level_trder_traversal_II {

	public class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root == null){
            return result;
        }
        ArrayList<ArrayList<Integer>> rLeft = levelOrderBottom(root.left);
        ArrayList<ArrayList<Integer>> rRight = levelOrderBottom(root.right);
        if (rLeft.size()>=rRight.size()){
            result = rLeft;
            for (int i = rLeft.size()-rRight.size();i<rLeft.size();i++){
                result.get(i).addAll(rRight.get(i-(rLeft.size()-rRight.size())));
            }
        }
        else {
            for (int i = 0;i<rRight.size()-rLeft.size();i++){
                result.add(rRight.get(i));
            }
            result.addAll(rLeft);
            for (int i = rRight.size()-rLeft.size();i<rRight.size();i++){
                result.get(i).addAll(rRight.get(i));
            }
        }
        ArrayList<Integer> last = new ArrayList<Integer>();
        last.add(root.val);
        result.add(last);
        return result;
    }
}
