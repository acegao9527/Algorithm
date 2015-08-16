package ExampleSolution.P1_P50;

public class P28_balanced_binary_tree {

	public class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
	
    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }
        int hLeft = returnHight(root.left);
        int hRight = returnHight(root.right);
        if (hLeft-hRight<-1||hLeft-hRight>1||hLeft==-2||hRight==-2){
            return false;
        }
        else {
            return true;
        }
    }
    public int returnHight(TreeNode root) {
        if (root == null){
            return 0;
        }
        int hLeft = returnHight(root.left);
        int hRight = returnHight(root.right);
        if (hLeft-hRight<-1||hLeft-hRight>1||hLeft==-2||hRight==-2){
            return -2;
        }
        else {
            return (hLeft>hRight?hLeft:hRight)+1;
        }
    }
}
