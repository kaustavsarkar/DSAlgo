package download.dsalgo.green.graph;

import java.util.*;

public class DisjointSet {

	private Map<Long, Node> map = new HashMap<>();

	public void makeSet(long data) {
		Node node = new Node();
		node.rank = 0;
		node.data = data;
		node.parent = node;
		map.put(data, node);
	}

	public void union(long data1, long data2) {
		Node node1 = map.get(data1);
		Node node2 = map.get(data2);

		Node parent1 = findSet(node1);
		Node parent2 = findSet(node2);

		if (parent1 == parent2) {
			return;
		}

		if (parent1.rank >= parent2.rank) {
			parent1.rank = parent1.rank == parent2.rank ? parent1.rank + 1
					: parent1.rank;
			parent2.parent = parent1;
		} else {
			parent1.parent = parent2;
		}

	}

	public long findSet(Long data) {
		return findSet(map.get(data)).data;
	}

	private Node findSet(Node node) {
		Node parent = node.parent;
		if (parent == node) {
			return node;
		}
		node.parent = findSet(node.parent);
		return node.parent;
	}

	private static class Node {
		long data;
		int rank;
		Node parent;
	}
}
