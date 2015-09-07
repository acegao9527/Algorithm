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
    /*从头到尾遍历原链表，每遍历一个结点，
    将其摘下放在新链表的最前端。注意链表为空和只有一个结点的情况。时间复杂度为O（n）。
    */
    public static LinkedNode ReverseList(LinkedNode node){
        if (node==null || node.next==null){
            return node;
        }
        LinkedNode result = null;
        LinkedNode current = node;
        while (current!=null){
            LinkedNode tmp =current;//存下当前节点
            current=current.next;//当前节点指向下个节点
            tmp.next=result;//将当前节点的next指向原来的结果头
            result=tmp;
        }
        return result;
    }


}
