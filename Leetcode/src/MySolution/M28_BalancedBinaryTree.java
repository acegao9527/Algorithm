package MySolution;

/**
 * Created by wuzhi1234 on 15/9/2.
 */
public class M28_BalancedBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int depth(TreeNode root){
        if(root==null){
            return 0;
        }
        int depthleft = depth(root.left);
        int depthright = depth(root.right);
        return depthleft>depthright?(depthleft+1):(depthright+1);
    }
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        int depthleft = depth(root.left);
        int depthright = depth(root.right);
        if(isBalanced(root.left)&&isBalanced(root.right)&&Math.abs(depthleft-depthright)<=1){
            return true;
        }
        return false;

    }
}
