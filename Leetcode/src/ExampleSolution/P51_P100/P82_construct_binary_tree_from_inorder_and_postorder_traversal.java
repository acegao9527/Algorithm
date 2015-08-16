package ExampleSolution.P51_P100;

public class P82_construct_binary_tree_from_inorder_and_postorder_traversal {

	public class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
	public TreeNode buildTree(int[] inorder, int[] postorder) {
        return generateTree(inorder, postorder,0,postorder.length-1,postorder.length-1);
    }
    public TreeNode generateTree(int[] inorder, int[] postorder,int start,int end, int rootInPost){
        if(start>end)
            return null;
        TreeNode root = new TreeNode(postorder[rootInPost]);
        int rootInIn = start;
        for(int i = start;i<=end;i++){
            if (inorder[i]==postorder[rootInPost]){
                rootInIn = i;
                break;
            }
        }
        root.left = generateTree(inorder, postorder,start,rootInIn-1, rootInPost+rootInIn-end-1);
        root.right = generateTree(inorder, postorder,rootInIn+1,end, rootInPost-1);
        return root;
    }
}
