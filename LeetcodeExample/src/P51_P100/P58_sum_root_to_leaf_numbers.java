package P51_P100;

public class P58_sum_root_to_leaf_numbers {

	public class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
	public int sum = 0;
    public int sumNumbers(TreeNode root) {
        if(root==null) {
            return 0;
        }
        generateNumber(root,0);
        return sum;
    }
    public void generateNumber(TreeNode root,int headSum){
        if(root==null) {
            return;
        }
        headSum = headSum*10+root.val;
        if(root.left==null&&root.right==null){
            sum+=headSum;
            return;
        }
        generateNumber(root.left,headSum);
        generateNumber(root.right,headSum);
    }
}
