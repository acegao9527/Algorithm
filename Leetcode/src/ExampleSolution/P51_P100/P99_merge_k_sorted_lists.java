package ExampleSolution.P51_P100;

import java.util.ArrayList;

public class P99_merge_k_sorted_lists {

	public class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) {
	        val = x;
	        next = null;
	    }
	}
	public ListNode mergeKLists(ArrayList<ListNode> lists) {
        ListNode superHead = new ListNode(0);
        ListNode insert = superHead;
        for (int i =0;i<lists.size();i++){
            if (lists.get(i)==null){
                lists.remove(i);
                i--;
            }
        }
        while (lists.size()>0){
            int minIndex = 0;
            int minValue = lists.get(0).val;
            for(int i = 1;i<lists.size();i++){
                if (lists.get(i).val<minValue){
                    minIndex = i;
                    minValue = lists.get(i).val;
                }
            }
            insert.next = lists.get(minIndex);
            insert = insert.next;
            if(lists.get(minIndex).next !=null){
                ListNode temp = lists.get(minIndex).next;
                lists.remove(minIndex);
                lists.add(temp);
            }
            else{
                lists.remove(minIndex);
            }
        }
        return superHead.next;
    }
}
