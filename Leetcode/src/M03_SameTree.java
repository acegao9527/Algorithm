/**
 * Created by wuzhi1234 on 15/7/25.
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class M03_SameTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p==null&&q==null){
            return true;
        }
        if (p==null||q==null){
            return false;
        }
        if (p.val!=q.val){
            return false;
        }
        if (p.val==q.val){
            return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
        }
        return false;
    }

    public static void main(String[] args) {
        M03_SameTree a = new M03_SameTree();
        TreeNode treenodea1 = new TreeNode(1);
        TreeNode treenodea2 = new TreeNode(2);
        TreeNode treenodea3 = new TreeNode(3);
        TreeNode treenodeb1 = new TreeNode(1);
        TreeNode treenodeb2 = new TreeNode(2);
        TreeNode treenodeb3 = new TreeNode(3);
        treenodea1.left = treenodea2;
        treenodea2.right = treenodeb2;
        treenodeb1.left = treenodeb2;
        treenodeb2.right = treenodeb3;
        boolean t = a.isSameTree(treenodea1,treenodeb1);
        System.out.println(t);
    }

}
