package ExampleSolution.P51_P100;

import java.util.ArrayList;


public class P94_reverse_nodes_in_k_group {

	public static class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) {
	        val = x;
	        next = null;
	    }
	}
	public static ListNode reverseKGroup(ListNode head, int k) {
        if (head==null||k<=1){
            return head;
        }
        ListNode superHead = new ListNode(0);
        superHead.next=head;
        ListNode check = head;
        ListNode insert = superHead;
        int count = 1;
        ArrayList<ListNode> nodeArray = new ArrayList<ListNode>();
        while(check!=null){
            if(count < k) {
                nodeArray.add(check);
                check = check.next;
                count++;
            }
            else if (count == k) {
                ListNode nextNode = check.next;
                insert.next = check;
                insert = insert.next;
                for(int i = nodeArray.size()-1;i>=0;i--){
                    insert.next = nodeArray.get(i);
                    insert = insert.next;
                }
                insert.next = nextNode;
                nodeArray.clear();
                check = nextNode;
                count=1;
            }
        }
        return superHead.next;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		a.next = b;
		reverseKGroup(a, 2);
		
	}
}
