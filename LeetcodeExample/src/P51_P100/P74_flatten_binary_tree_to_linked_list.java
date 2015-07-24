package P51_P100;

public class P74_flatten_binary_tree_to_linked_list {

	public class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
	public void flatten(TreeNode root) {
        generateFlatten(root);
    }
    public TreeNode generateFlatten(TreeNode root) {
        if (root ==null){
            return null;
        }
        TreeNode saveRight=null;
        if(root.right!=null){
            saveRight = root.right;
        }
        if(root.left != null){
            root.right = root.left;
            root.left = null;
            generateFlatten(root.right);
            TreeNode temp =root.right;
            while(temp.right !=null){
                temp = temp.right;
            }
            temp.right = saveRight;
        }
        generateFlatten(saveRight);
        return root;
    }
}
