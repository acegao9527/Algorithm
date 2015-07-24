package P101_P150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class P115_clone_graph {

	class UndirectedGraphNode {
	    int label;
	    ArrayList<UndirectedGraphNode> neighbors;
	    UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
	}
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null)
			return null;
        UndirectedGraphNode retNode = new UndirectedGraphNode(node.label);
        HashMap<UndirectedGraphNode,UndirectedGraphNode> box = new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
        box.put(node,retNode);
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.add(node);
        while (!queue.isEmpty()) {
        	UndirectedGraphNode cur = queue.poll();
        	UndirectedGraphNode newCur = box.get(cur);
        	for (int i = 0;i<cur.neighbors.size();i++) {
        		UndirectedGraphNode nei = cur.neighbors.get(i);
        		if (box.containsKey(nei)) {
        			newCur.neighbors.add(box.get(nei));
        		}
        		else {
        			UndirectedGraphNode newNode = new UndirectedGraphNode(nei.label);
        			box.put(nei, newNode);
        			queue.add(nei);
        			newCur.neighbors.add(newNode);
        		}
        	}
        }
        return retNode;
    }
}
