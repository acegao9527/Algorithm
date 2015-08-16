package ExampleSolution.P101_P150;

public class P127_sort_list {

	class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) {
	        val = x;
	        next = null;
	    }
	}
	public ListNode sortList(ListNode head) {
		if(head==null)
            return null;
        int len = 0;
        ListNode temp = head;
        while(temp!=null){
            temp=temp.next;
            len++;
        }
        return sort(head, len);
    }
    public ListNode sort(ListNode head,int len){
        if(len ==1){
            head.next = null;
            return head;
        }
        else {
            ListNode lhead = head;
            ListNode rhead = head;
            int lLen = len/2;
            while(lLen>0){
                rhead = rhead.next;
                lLen--;
            }
            ListNode left = sort(lhead,len/2);
            ListNode right = sort(rhead,len-len/2);
            return merge(left, right);
        }
    }
    public ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        ListNode superHead = new ListNode(-1);
        ListNode temp = superHead;
        while (l1 != null&&l2 != null){
            if(l1.val<l2.val){
                temp.next = l1;
                l1 = l1.next;
            }
            else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        if (l1 != null){
            temp.next = l1;
        }
        if (l2 != null){
            temp.next = l2;
        }
        return superHead.next;
    }

}
