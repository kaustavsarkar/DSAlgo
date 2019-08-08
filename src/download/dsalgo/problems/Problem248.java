package download.dsalgo.problems;

import java.util.*;

/**
 * Clone an undirected graph. Each node in the graph contains a label and a list
 * of its neighbors.
 * 
 * @author kaussark
 *
 */
class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;

	UndirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}
};

public class Problem248 {

	public static void main(String[] args) {
		UndirectedGraphNode node = new UndirectedGraphNode(703);
		// 703 [43 279 703 ] 43 [279 703 ] 279 [43 279 703 ]
		// q[
		// v[ 703 43 279]
	}

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		UndirectedGraphNode cloned = new UndirectedGraphNode(node.label);

		Map<Integer, UndirectedGraphNode> visited = new HashMap<>();
		Queue<UndirectedGraphNode> nodeQ = new LinkedList<>();
		nodeQ.offer(node);
		visited.put(cloned.label, cloned);
		while (!nodeQ.isEmpty()) {
			UndirectedGraphNode cNode = nodeQ.poll();
			UndirectedGraphNode gNode = visited.get(cNode.label);

			for (int index = 0; index < cNode.neighbors.size(); index++) {
				UndirectedGraphNode neighbour = visited.get(cNode.neighbors.get(index).label);
				
				if(neighbour == null) {
					neighbour = new UndirectedGraphNode(cNode.neighbors.get(index).label);
					nodeQ.offer(cNode.neighbors.get(index));
					visited.put(neighbour.label, neighbour);
				}
				gNode.neighbors.add(neighbour);
			}
		}

		return cloned;
	}
}
