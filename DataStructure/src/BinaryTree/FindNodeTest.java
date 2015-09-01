package BinaryTree;

/**
 * Created by wuzhi1234 on 15/9/1.
 */
public class FindNodeTest {
    static class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    public static boolean FindNode(TreeNode root,TreeNode node){
        if (root==null || node==null){
            return false;
        }
        if (root==node){
            return true;
        }
        boolean found = FindNode(root.left,node);
        if (!found){
            found = FindNode(root.right,node);
        }
        return found;
    }

    public static TreeNode getLastCommonParent(TreeNode root, TreeNode tmp1, TreeNode tmp2){
        if (FindNode(root.left,tmp1)){
            if (FindNode(root.right,tmp2)){
                return root;
            }
            else {
                return getLastCommonParent(root.left,tmp1,tmp2);
            }
        }
        else {
            if (FindNode(root.left, tmp2)) {
                return root;
            }
            else {
                return getLastCommonParent(root.right, tmp1, tmp2);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        //单独测试就没有问题了
        TreeNode a = getLastCommonParent(node1,node4,node3);
        System.out.println(a.value);
    }
}
