package P51_P100;

public class P83_validate_binary_search_tree {

	public class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
	public boolean isValidBST(TreeNode root) {
        if(root ==null){
            return true;
        }
        int []range = rangeOfBST(root);
        if(range[0]<=range[1]){
            return true;
        }
        else {
            return false;
        }
    }
    public int[] rangeOfBST(TreeNode root) {
        int []result = {root.val,root.val};
        if(root.left !=null){
            int []range = rangeOfBST(root.left);
            if(range[0]<=range[1]&&range[1]<root.val){
                result[0]=range[0];
            }
            else {
                result[0] = 1;result[1] = -1;
                return result;
            }
        }
        if(root.right !=null){
            int []range = rangeOfBST(root.right);
            if(range[0]<=range[1]&&range[0]>root.val){
                result[1]=range[1];
            }
            else {
                result[0] = 1;result[1] = -1;
                return result;
            }
        }
        return result;
    }
}
