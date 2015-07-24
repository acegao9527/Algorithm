package P101_P150;

public class P103_add_two_numbers {

	public class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) {
	        val = x;
	        next = null;
	    }
	}
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean inc = false;
        ListNode superHead = new ListNode(0);
        ListNode insert = superHead;
        while (l1!=null&&l2!=null){
            int value = l1.val+l2.val;
            if(inc){
                value++;
                inc = false;
            }
            if(value >=10){
                inc = true;
                value -=10;
            }
            ListNode temp = new ListNode(value);
            insert.next = temp;
            insert = insert.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1!=null){
            int value = l1.val;
            if(inc){
                value++;
                inc = false;
            }
            if(value >=10){
                inc = true;
                value -=10;
            }
            ListNode temp = new ListNode(value);
            insert.next = temp;
            insert = insert.next;
            l1 = l1.next;
        }
        while (l2!=null){
            int value = l2.val;
            if(inc){
                value++;
                inc = false;
            }
            if(value >=10){
                inc = true;
                value -=10;
            }
            ListNode temp = new ListNode(value);
            insert.next = temp;
            insert = insert.next;
            l2 = l2.next;
        }
        if(inc){
            ListNode temp = new ListNode(1);
            insert.next = temp;
        }
        return superHead.next;
    }
}
