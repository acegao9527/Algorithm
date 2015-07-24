package P51_P100;

public class P86_construct_binary_tree_from_preorder_and_inorder_traversal {

	public class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        return generateTree(preorder, inorder, 0, 0, inorder.length-1);
    }
    public TreeNode generateTree(int[] preorder, int[] inorder, int rootInPre, int start, int end){
        if(start>end){
            return null;
        }
        TreeNode root = new TreeNode(preorder[rootInPre]);
        int rootInIn = start;
        for(int i = start;i<=end;i++){
            if(inorder[i]==preorder[rootInPre]){
                rootInIn = i;
                break;
            }
        }
        root.left = generateTree(preorder, inorder, rootInPre+1, start, rootInIn-1);
        root.right = generateTree(preorder, inorder, rootInPre+1+rootInIn-start, rootInIn+1, end);
        return root;
    }
}
