package BinaryTree;

/**
 * Created by wuzhi1234 on 15/9/2.
 */

/*错误解法，按值传递搞错了*/
public class MaxDistance {
    public static class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    public int getMaxDistance(TreeNode node, int maxLeft, int maxRight){
        // maxLeft, 左子树中的节点距离左子树根节点的最远距离
        // maxRight, 右子树中的节点距离左子树根节点的最远距离
        if (node==null){
            maxLeft=0;
            maxRight=0;
            return 0;
        }
        int maxLL=0,maxLR=0,maxRL=0,maxRR=0;
        int maxDistLeft,maxDistRight;
        if (node.left!=null){
            maxDistLeft= getMaxDistance(node.left,maxLL,maxLR);
            maxLeft=Math.max(maxLL,maxLR)+1;
        }
        else {
            maxDistLeft=0;
            maxLeft=0;
        }
        if (node.right!=null){
            maxDistRight= getMaxDistance(node.right,maxRL,maxRR);
            maxRight=Math.max(maxRL,maxRR)+1;
        }
        else {
            maxDistRight=0;
            maxRight=0;
        }
        int result = Math.max(Math.max(maxDistLeft,maxDistRight),maxLeft+maxRight+1);
        return result;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        node1.left=node2;
        node1.right=node3;
        node2.left=node4;

        int i=0,j=0;
        MaxDistance m = new MaxDistance();
        int a = m.getMaxDistance(node1, i, j);
        System.out.println(a);
        System.out.println(i);
        System.out.println(j);

    }
}
