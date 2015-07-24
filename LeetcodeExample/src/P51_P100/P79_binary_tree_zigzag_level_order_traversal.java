package P51_P100;

import java.util.ArrayList;

public class P79_binary_tree_zigzag_level_order_traversal {

	public class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = generateFormalList(root);
        boolean changeOrder = true;
        for(int i =1;i<result.size();i++){
            if(changeOrder){
                ArrayList<Integer> temp = new ArrayList<Integer>();
                for(int j = result.get(i).size()-1;j>=0;j--){
                    temp.add(result.get(i).get(j));
                }
                result.set(i,temp);
            }
            changeOrder = !changeOrder;
        }
        return result;
    }
    public ArrayList<ArrayList<Integer>> generateFormalList(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(root ==null){
            return result;
        }
        ArrayList<Integer> head = new ArrayList<Integer>();
        head.add(root.val);
        result.add(head);
        ArrayList<ArrayList<Integer>> lResult = generateFormalList(root.left);
        ArrayList<ArrayList<Integer>> rResult = generateFormalList(root.right);
        result.addAll(lResult);
        for (int i = 0;i<rResult.size();i++){
            if(i<lResult.size()){
                result.get(i+1).addAll(rResult.get(i));
            }
            else {
                result.add(rResult.get(i));
            }
        }
        return result;
    }
}
