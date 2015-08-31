package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * Created by wuzhi1234 on 15/8/31.
 */
public class BinaryTreeTest {
    //先序遍历结果
    public static List<Integer> prelist = new ArrayList<>();
    //中序遍历结果
    public static List<Integer> listInorder = new ArrayList<>();
    //广度遍历结果
    public static List<Integer> listLevel = new ArrayList<>();

    static class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    /*
    * 求二叉树节点个数，递归解法：
      1.如果二叉树为空，节点个数为0
      2.如果二叉树不为空，二叉树节点个数 = 左子树节点个数 + 右子树节点个数 + 1
      */
    public static int getNodeNum(TreeNode node){
        if (node==null)
            return 0;
        return getNodeNum(node.left)+getNodeNum(node.right)+1;
    }

    /*求二叉树的深度
        递归解法：
    （1）如果二叉树为空，二叉树的深度为0
    （2）如果二叉树不为空，二叉树的深度 = max(左子树深度， 右子树深度) + 1
    */
    public static int getDepth(TreeNode node){
        if (node == null)
            return 0;
        int depthleft = getDepth(node.left);
        int depthright = getDepth(node.right);
        return depthleft>depthright? (depthleft+1):(depthright+1);
    }

    /*前序遍历*/
    public static void PreOrderTraverse(TreeNode node){

        if (node==null)
            return ;
        prelist.add(node.value);
        PreOrderTraverse(node.left);
        PreOrderTraverse(node.right);

    }
    /*中序遍历*/
    public static void InOrderTraverse(TreeNode node){
        if (node==null)
            return ;
        InOrderTraverse(node.left);
        listInorder.add(node.value);
        InOrderTraverse(node.right);

    }

    /*广度优先遍历*/
    public static void LevelTraverse(TreeNode node){
        if (node==null)
            return;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()){
            TreeNode tmp = q.peek();
            q.poll();
            listLevel.add(tmp.value);
            if (tmp.left!=null)
                q.add(tmp.left);
            if (tmp.right!=null)
                q.add(tmp.right);
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
        int a = getNodeNum(node1);
        int b = getDepth(node1);
        PreOrderTraverse(node1);
        InOrderTraverse(node1);
        LevelTraverse(node1);
        System.out.println(BinaryTreeTest.listLevel);

    }
}
