package P101_P150;

import java.util.ArrayList;

public class P109_rotate_list {

	public class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) {
	        val = x;
	        next = null;
	    }
	}
	public ListNode rotateRight(ListNode head, int n) {
        if(head==null||n<=0){
            return head;
        }
        ArrayList<ListNode> box = new ArrayList<ListNode>();
        ListNode temp = head;
        while(temp !=null){
            box.add(temp);
            temp = temp.next;
        }
        if(n>=box.size())
            n= n%box.size();
        if(box.size()==1||n==0)
            return head;
        else {
            head = box.get(box.size()-n);
            box.get(box.size()-1).next = box.get(0);
            box.get(box.size()-n-1).next = null;
        }
        return head;
    }
}
