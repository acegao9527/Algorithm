package ExampleSolution.P51_P100;

import java.util.ArrayList;

public class P69_convert_sorted_list_to_binary_search_tree {

	public class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) { val = x; next = null; }
	}
	public class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
	public TreeNode sortedListToBST(ListNode head) {
        ArrayList<ListNode> checkBox = new ArrayList<ListNode>();
        if (head == null){
            return null;
        }
        while (head!=null){
            checkBox.add(head);
            head = head.next;
        }
        return generateTree(checkBox, 0, checkBox.size()-1);
    }
    public TreeNode generateTree(ArrayList<ListNode> checkBox,int start, int end){
        if (start == end){
            return new TreeNode(checkBox.get(start).val);
        }
        if(start>end){
            return null;
        }
        int mid = (end + start)/2;
        TreeNode result = new TreeNode(checkBox.get(mid).val);
        result.left = generateTree(checkBox,start,mid-1);
        result.right = generateTree(checkBox,mid+1,end);
        return result;
    }
}
