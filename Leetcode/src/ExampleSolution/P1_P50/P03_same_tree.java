package ExampleSolution.P1_P50;

public class P03_same_tree {

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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p ==null&&q ==null){
            return true;
        }
        if (p ==null||q == null){
            return false;
        }
        if (isSameTree(p.left,q.left)&&isSameTree(p.right,q.right)&&p.val == q.val){
            return true;
        }
        else {
            return false;
        }
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
