package ExampleSolution.P51_P100;

import java.util.ArrayList;

public class P63_path_sum_II {

	public class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(root==null){
            return result;
        }
        ArrayList<Integer> path = new ArrayList<Integer>();
        generatePath(result, path, root, sum);
        return result;
    }
    public void generatePath(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> path, TreeNode root, int sum) {
        path.add(root.val);
        if(root.left==null&&root.right==null){
            if(root.val==sum){
                result.add(new ArrayList<Integer>(path));
                return;
            }
            else {
                return;
            }
        }
        if(root.left !=null) {
            generatePath(result, path, root.left, sum-root.val);
            path.remove(path.size()-1);
        }
        if(root.right!=null) {
            generatePath(result, path, root.right, sum-root.val);
            path.remove(path.size()-1);
        }
    }
}
