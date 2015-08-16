package ExampleSolution.P51_P100;

public class P84_reverse_linked_list_II {

	public class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) {
	        val = x;
	        next = null;
	    }
	}
	public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode superHead = new ListNode(0);
        superHead.next = head;
        ListNode supCheck = superHead;
        ListNode curCheck = head;
        
        int count = 1;
        while (count <= n){
            if(count<m){
                supCheck = curCheck;
                curCheck = curCheck.next;
            }
            else if(count > m){
                if(head.next!=null){
                    ListNode nextNodeFromCheck = curCheck.next.next;
                    ListNode nextNodeFromInsert = supCheck.next;
                    supCheck.next = curCheck.next;
                    curCheck.next.next = nextNodeFromInsert;
                    curCheck.next = nextNodeFromCheck;
                }
            }
            count++;
        }
        return superHead.next;
    }
}
