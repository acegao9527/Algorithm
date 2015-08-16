package ExampleSolution.P51_P100;

public class P89_insertion_sort_list {

	public class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) {
	        val = x;
	        next = null;
	    }
	}
	public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode supHead = new ListNode(0);
        supHead.next = head;
        ListNode tempFather = head;
        ListNode tempCheck = head.next;
        while (tempCheck != null){
            if(tempFather.val<=tempCheck.val) {
                tempFather = tempCheck;
                tempCheck = tempCheck.next;
            }
            else {
                ListNode temp = supHead;
                while (temp.next.val<tempCheck.val)
                    temp = temp.next;
                ListNode headNext = temp.next;
                tempFather.next = tempCheck.next;
                temp.next = tempCheck;
                tempCheck.next = headNext;
                tempCheck = tempFather.next;
            }
        }
        return supHead.next;
    }
}
