package ExampleSolution.P1_P50;

public class P38_linked_list_cycle_II {

	class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) {
	        val = x;
	        next = null;
	    }
	}
	public ListNode detectCycle(ListNode head) {
        if (head == null){
            return null;
        }
        if (head.next == null){
            return null;
        }
        ListNode pSlow = head.next;
        ListNode pFast = head.next.next;
        while (pSlow != pFast){
            if (pFast ==null){
                return null;
            }
            if (pFast.next==null){
                return null;
            }
            pSlow = pSlow.next;
            pFast = pFast.next.next;
        }
        while (head != pSlow){
            head = head.next;
            pSlow = pSlow.next;
        }
        return head;
    }
}
