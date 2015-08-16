package ExampleSolution.P51_P100;

public class P77_partition_list {

	public class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) {
	        val = x;
	        next = null;
	    }
	}
	
	public ListNode partition(ListNode head, int x) {
        boolean find = false;
        ListNode superHead = new ListNode(0);
        superHead.next = head;
        ListNode tempHead = superHead;
        ListNode tempCheck = head;
        ListNode insert = null;
        while (tempCheck != null) {
            if(!find){
                if (tempCheck.val>= x){
                    find = true;
                    insert = tempHead;
                }
                tempHead = tempCheck;
                tempCheck = tempCheck.next;
            }
            else {
                if (tempCheck.val< x){
                    ListNode insertNext = insert.next;
                    insert.next = tempCheck;
                    tempHead.next = tempCheck.next;
                    tempCheck.next = insertNext;
                    tempCheck = tempHead.next;
                    insert = insert.next;
                }
                else {
                    tempHead = tempCheck;
                    tempCheck = tempCheck.next;
                }
            }
        }
        return superHead.next;
    }
}
