package ExampleSolution.P51_P100;

import java.util.ArrayList;

public class P80_unique_binary_search_trees_II {

	public class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; left = null; right = null; }
	}
	public ArrayList<TreeNode> generateTrees(int n) {
        ArrayList<TreeNode> result = new ArrayList<TreeNode>();
        result = generateHelper(1,n);
        return result; 
    }
    public ArrayList<TreeNode> generateHelper(int start,int end) {
        ArrayList<TreeNode> result = new ArrayList<TreeNode>();
        if (start>end){
            return result;
        }
        for(int i =start;i<=end;i++){
            ArrayList<TreeNode> lResult = generateHelper(start,i-1);
            ArrayList<TreeNode> rResult = generateHelper(i+1,end);
            if (lResult.size()==0&&rResult.size()==0) {
                TreeNode root = new TreeNode(i);
                result.add(root);
            }
            else if (lResult.size()==0){
                for(int j = 0;j<rResult.size();j++){
                    TreeNode root = new TreeNode(i);
                    root.right = rResult.get(j);
                    result.add(root);
                }
            }
            else if (rResult.size()==0){
                for(int j = 0;j<lResult.size();j++){
                    TreeNode root = new TreeNode(i);
                    root.left = lResult.get(j);
                    result.add(root);
                }
            }
            else {
                for (int j = 0;j<lResult.size();j++){
                    for (int k = 0;k<rResult.size();k++) {
                        TreeNode root = new TreeNode(i);
                        root.left = lResult.get(j);
                        root.right = rResult.get(k);
                        result.add(root);
                    }
                }
            }
        }
        return result;
    }
}
