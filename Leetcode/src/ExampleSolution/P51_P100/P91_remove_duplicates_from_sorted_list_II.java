package ExampleSolution.P51_P100;

public class P91_remove_duplicates_from_sorted_list_II {

	public class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) {
	        val = x;
	        next = null;
	    }
	}
	public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode superHead = new ListNode(0);
        superHead.next = head;
        ListNode previous = superHead;
        ListNode check = head;
        boolean dup = false;
        while(check.next !=null){
            if(check.val == check.next.val){
                dup = true;
                check = check.next;
            }
            else {
                if (dup){
                    previous.next = check.next;
                    check = previous.next;
                    dup = false;
                }
                else {
                    previous = check;
                    check = check.next;
                }
            }
        }
        if(dup){
            previous.next = null;
        }
        return superHead.next;
    }
}
