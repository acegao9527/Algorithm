package ExampleSolution.P1_P50;

public class P29_swap_node_in_pairs {

	public static class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) {
	        val = x;
	        next = null;
	    }
	}
	public static ListNode swapPairs(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode superHead = new ListNode(-1);
        superHead.next = head;
        ListNode itr = superHead;
        while (itr.next != null){
            if(itr.next.next != null){
                ListNode p1 = itr.next;
                ListNode p2 = p1.next;
                ListNode p3 = p2.next;
                itr.next = p2;
                p2.next = p1;
                p1.next = p3;
                itr = p1;
            }
            else {
                break;
            }
        }
        return superHead.next;
    }
    public static void main(String[] args) {
		// TODO Auto-generated method stub

    	ListNode a = new ListNode(1);
    	ListNode b = new ListNode(2);
    	a.next = b;
    	swapPairs(a);
    	
	}
}
