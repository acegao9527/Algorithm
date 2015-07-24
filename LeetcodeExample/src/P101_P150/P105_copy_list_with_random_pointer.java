package P101_P150;

public class P105_copy_list_with_random_pointer {

	class RandomListNode {
	    int label;
	    RandomListNode next, random;
	    RandomListNode(int x) { this.label = x; }
	}
	public RandomListNode copyRandomList(RandomListNode head) {
        if (head ==null){
            return null;
        }
        RandomListNode temp = head;
        while (temp!=null){
            RandomListNode copy = new RandomListNode(temp.label);
            RandomListNode nextNode = temp.next;
            temp.next = copy;
            copy.next = nextNode;
            temp = nextNode;
        }
        temp = head;
        RandomListNode ret = head.next;
        while (temp !=null){
            if(temp.random != null)
                temp.next.random = temp.random.next;
            temp = temp.next.next;
        }
        temp = head;
        while (temp !=null){
            RandomListNode nextNode = temp.next.next;
            if (nextNode != null)
                temp.next.next = nextNode.next;
            temp.next = nextNode;
            temp = nextNode;
        }
        return ret;
    }
}
