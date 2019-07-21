package download.dsalgo.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.SortedMap;
import java.util.Stack;
import java.util.TreeMap;

/**
 * Given a binary tree, return a 2-D array with vertical order traversal of it.
 * Go through the example and image for more details.
 * 
 * Example : Given binary tree:
 * 
 * 6 / \ 3 7 / \ \ 2 5 9 returns
 * 
 * [ [2], [3], [6 5], [7], [9] ]
 * 
 * 
 * Note : If 2 Tree Nodes shares the same vertical level then the one with
 * lesser depth will come first.
 * 
 * @author kaussark
 *
 */
public class Problem145 {

	public static void main(String[] args) {

	}

	private static class NodeDistance {
		int distance = 0;
		TreeNode node;

		public NodeDistance(TreeNode node, int distance) {
			this.node = node;
			this.distance = distance;
		}
	}

	public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
		Queue<NodeDistance> nodeQueue = new LinkedList<>();
		SortedMap<Integer, ArrayList<Integer>> distanceNode = new TreeMap<>();
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		nodeQueue.add(new NodeDistance(A, 0));
		// Do a Level Order traversal and add values to map
		while (!nodeQueue.isEmpty()) {
			NodeDistance nodeDist = nodeQueue.poll();
			if (nodeDist != null && nodeDist.node != null) {
				if (!distanceNode.containsKey(nodeDist.distance)) {
					ArrayList<Integer> nodeValues = new ArrayList<>();
					nodeValues.add(nodeDist.node.val);
					distanceNode.put(nodeDist.distance, nodeValues);
				} else {
					distanceNode.get(nodeDist.distance).add(nodeDist.node.val);
				}
				nodeQueue.add(new NodeDistance(nodeDist.node.left,
						nodeDist.distance - 1));
				nodeQueue.add(new NodeDistance(nodeDist.node.right,
						nodeDist.distance + 1));
			}

		}

		// Traverse map and add values to result
		for (Map.Entry<Integer, ArrayList<Integer>> entry : distanceNode
				.entrySet()) {
			ArrayList<Integer> verticalNodes = entry.getValue();
			result.add(verticalNodes);
		}
		return result;

	}
}
