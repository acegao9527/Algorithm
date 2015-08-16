package ExampleSolution.P1_P50;

public class P07_linked_list_cycle {

	/**
	 * Definition for singly-linked list.
	 * class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) {
	 *         val = x;
	 *         next = null;
	 *     }
	 * }
	 */
	class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) {
	        val = x;
	        next = null;
	    }
	}
    public boolean hasCycle(ListNode head) {
        if (head ==null){
            return false;
        }
        if(head.next == null)
            return false;
        if(head.next.next == null)
            return false;
        ListNode p_fast = head.next.next;
        ListNode p_slow = head.next;
        while (p_slow != p_fast){
            if(p_fast.next == null){
                return false;
            }
            if(p_fast.next.next == null){
                return false;
            }
            p_slow = p_slow.next;
            p_fast = p_fast.next.next;
        }
        return true;
    }
}
