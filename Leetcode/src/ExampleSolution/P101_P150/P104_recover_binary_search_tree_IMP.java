package ExampleSolution.P101_P150;

public class P104_recover_binary_search_tree_IMP {

	public class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
	public void recoverTree(TreeNode root) {
        if (root == null){
            return;
        }
        TreeNode fNode=null, sNode=null;
        TreeNode cur,pre,parent=null;
        boolean find = false;
        cur = root;
        while(cur!=null){
            if(cur.left==null){
                if(parent!=null&&cur.val<parent.val){
                    if(!find) {
                        fNode = parent;
                        find = true;
                    }
                    sNode = cur;
                }
                parent = cur;
                cur = cur.right;
            }
            else {
                pre = cur.left;
                while(pre.right != null && pre.right != cur)
                    pre = pre.right;
                if(pre.right == null)
                {
                    pre.right = cur;
                    cur = cur.left;
                }
                else
                {
                    pre.right = null;
                    if(parent.val > cur.val)
                    {
                        if(!find)
                        {
                            fNode = parent;       
                            find = true;
                        }
                        sNode = cur;
                    }
                    parent = cur;
                    cur = cur.right;     
                } 
            }
        }
        if(fNode !=null&&sNode!=null){
            int temp = fNode.val;
            fNode.val = sNode.val;
            sNode.val = temp;
        }
    }
}
