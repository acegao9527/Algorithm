package LinkedList;

/**
 * Created by wuzhi1234 on 15/9/7.
 */
public class LinkedListTest {
    public static class LinkedNode{
        int value;
        LinkedNode next;

        public LinkedNode(int value) {
            this.value = value;
        }
    }

    public static LinkedNode ReverseList(LinkedNode node){
        if (node==null || node.next==null){
            return node;
        }
        LinkedNode result = null;
        LinkedNode tmp = node;
        while (tmp!=null){
            result=node;
            tmp=
        }
    }
}
