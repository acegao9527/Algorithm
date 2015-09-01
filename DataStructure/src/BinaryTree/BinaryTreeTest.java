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

    public static class TreeNode{
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

    /*广度优先遍历
    * 队列实现
    * */
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

    /*将二叉查找树变为有序的双向链表
    * 因为二叉树和双向链表内部都有俩个指针，所以可以相互转换
    * 递归解法：
    （1）如果二叉树查找树为空，不需要转换，对应双向链表的第一个节点是NULL，最后一个节点是NULL
    （2）如果二叉查找树不为空：
        如果左子树为空，
            对应双向有序链表的第一个节点是根节点，左边不需要其他操作；
        如果左子树不为空，
            转换左子树，二叉查找树对应双向有序链表的第一个节点就是左子树转换后双向有序链表的第一个节点，
            同时将根节点和左子树转换后的双向有序链 表的最后一个节点连接；
        如果右子树为空，
            对应双向有序链表的最后一个节点是根节点，右边不需要其他操作；
        如果右子树不为空，
            对应双向有序链表的最后一个节点就是右子树转换后双向有序链表的最后一个节点，
            同时将根节点和右子树转换后的双向有序链表的第一个节点连 接。
    * */
    @SuppressWarnings("unused")
    public static void Convert(TreeNode node,TreeNode FirstNode,TreeNode LastNode){
        TreeNode FirstLeft = null,FirstRight = null,LastLeft = null,LastRight=null;
        if (node==null) {
            FirstNode = null;
            LastNode = null;
            return;
        }
        if (node.left==null){
            FirstNode=node;
        }
        else {
            Convert(node.left,FirstLeft,LastLeft);
            FirstNode=FirstLeft;
            node.left=LastLeft;
        }

        if (node.right==null){
            LastLeft=node;
        }
        else {
            Convert(node.right,FirstRight,LastRight);
            LastNode=LastRight;
            node.right=FirstRight;
        }

    }

    /*
    * 6. 求二叉树第K层的节点个数
        递归解法：
        （1）如果二叉树为空或者k<1返回0
        （2）如果二叉树不为空并且k==1，返回1
        （3）如果二叉树不为空且k>1，返回左子树中k-1层的节点个数与右子树k-1层节点个数之和
    * */
    public static int getNodeNumKthLevel(TreeNode node,int k){
        if (node==null || k<1){
            return 0;
        }
        if (k==1){
            return 1;
        }
        int numLeft = getNodeNumKthLevel(node.left, k - 1);
        int numRight = getNodeNumKthLevel(node.right, k - 1);
        return (numLeft+numRight);
    }

    /*7. 求二叉树中叶子节点的个数
        递归解法：
        （1）如果二叉树为空，返回0
        （2）如果二叉树不为空且左右子树为空，返回1
        （3）如果二叉树不为空，且左右子树不同时为空，返回左子树中叶子节点个数加上右子树中叶子节点个数
    */
    public static int getLeafNodeNum(TreeNode node){
        if (node==null)
            return 0;
        if (node.left==null && node.right==null)
            return 1;
        int numLeft = getLeafNodeNum(node.left);
        int numRight = getLeafNodeNum(node.right);
        return (numLeft+numRight);
    }

    /*8. 判断两棵二叉树是否结构相同
        不考虑数据内容。结构相同意味着对应的左子树和对应的右子树都结构相同。
        递归解法：
        （1）如果两棵二叉树都为空，返回真
        （2）如果两棵二叉树一棵为空，另一棵不为空，返回假
        （3）如果两棵二叉树都不为空，如果对应的左子树和右子树都同构返回真，其他返回假
    */
    public static boolean StructureCmp(TreeNode node1,TreeNode node2){
        if (node1==null && node2==null){
            return true;
        }
        else if (node1==null || node2==null){
            return false;
        }
        else {
            boolean leftCmp = StructureCmp(node1.left,node2.left);
            boolean rightCmp = StructureCmp(node1.right,node2.right);
            return (leftCmp&&rightCmp);

        }
    }

    /*9. 判断二叉树是不是平衡二叉树
        递归解法：
        （1）如果二叉树为空，返回真
        （2）如果二叉树不为空，如果左子树和右子树都是AVL树并且左子树和右子树高度相差不大于1，返回真，其他返回假
    */
    public static boolean IsAVL(TreeNode node,int height){
        if (node==null){
            height=0;
            return true;
        }
        //预先设置一个值用来存结果，因为并没有方法只能有一个返回值
        int heightleft = 0;
        boolean resultleft = IsAVL(node.left,heightleft);
        int heightright = 0;
        boolean resultright = IsAVL(node.right,heightright);
        if (resultleft && resultright && Math.abs(heightleft-heightright)<=1){
            height=Math.max(heightleft,heightright)+1;
            return true;
        }
        else {
            height=Math.max(heightleft,heightright)+1;
            return false;
        }
    }

    /*10. 求二叉树的镜像
        递归解法：
        （1）如果二叉树为空，返回空
        （2）如果二叉树不为空，求左子树和右子树的镜像，然后交换左子树和右子树
    */
    public static TreeNode Mirror(TreeNode node){
        if (node==null){
            return null;
        }
        node.right = Mirror(node.left);
        node.left = Mirror(node.right);
        return node;
    }

    /*11. 求二叉树中两个节点的最低公共祖先节点
        递归解法：
        （1）如果两个节点分别在根节点的左子树和右子树，则返回根节点
        （2）如果两个节点都在左子树，则递归处理左子树；如果两个节点都在右子树，则递归处理右子树

        具体代码：设置一个布尔返回值的函数来判断节点是在跟节点的左右子树
                在给定根节点的情况下判断两个节点的最低公共祖先节点
    */
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
//        int a = getNodeNum(node1);
//        int b = getDepth(node1);
//        PreOrderTraverse(node1);
//        InOrderTraverse(node1);
//        LevelTraverse(node1);
//        int c = getNodeNumKthLevel(node1,1);
//        int d = getLeafNodeNum(node1);
//        boolean e = StructureCmp(node1, node2);
//        int height =0;
//        boolean f = IsAVL(node1,height);
//        TreeNode g = Mirror(node1);
//        boolean i =FindNode(node2, node4);
        TreeNode h = getLastCommonParent(node1, node4, node3);
        System.out.println(h.value);

    }
}
