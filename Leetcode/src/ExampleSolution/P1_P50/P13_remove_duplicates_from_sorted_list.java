package ExampleSolution.P1_P50;

public class P13_remove_duplicates_from_sorted_list {

	public class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) {
	        val = x;
	        next = null;
	    }
	}
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        if (head == null){
            return head;
        }
        while(temp.next!=null){
            if (temp.val == temp.next.val){
                if( temp.next.next!=null){
                    temp.next = temp.next.next;
                }
                else {
                    temp.next = null;
                }
            }
            else if(temp.val != temp.next.val){
                temp = temp.next;
            }
        }
        return head;
    }
}
