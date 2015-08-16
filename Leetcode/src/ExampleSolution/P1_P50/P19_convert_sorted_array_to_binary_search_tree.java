package ExampleSolution.P1_P50;


public class P19_convert_sorted_array_to_binary_search_tree {

	 public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
    public TreeNode sortedArrayToBST(int[] num) {
        if (num.length ==0){
            return null;
        }
        int mid = num.length/2;
        TreeNode root = new TreeNode(num[mid]);
        if (mid>=1){
            int []p1 = new int [mid];
            System.arraycopy(num, 0, p1, 0, mid);
            root.left = sortedArrayToBST(p1);
        }
        if (num.length-mid-1>=1){
            int []p2 = new int [num.length-mid-1];
            System.arraycopy(num, mid+1, p2, 0, num.length-mid-1);
            root.right = sortedArrayToBST(p2);
        }
        return root;
    }
}
