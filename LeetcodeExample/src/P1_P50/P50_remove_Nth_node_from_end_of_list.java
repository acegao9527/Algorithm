package P1_P50;

import java.util.ArrayList;

public class P50_remove_Nth_node_from_end_of_list {

	public class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) {
	        val = x;
	        next = null;
	    }
	}
	public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n==0){
            return head;
        }
        ListNode temp = head;
        ArrayList<ListNode> list = new ArrayList<ListNode>();
        while (temp !=null){
            list.add(temp);
            temp = temp.next;
        }
        int total = list.size();
        if (total == n){
            if (n==1){
                return null;
            }
            else return head.next;
        }
        if (total >n){
            if (n!=1){
                list.get(list.size()-n-1).next = list.get(list.size()-n+1);
            }
            else {
                list.get(list.size()-2).next = null;
            }
        }
        return head;
    }
}
