package download.dsalgo.green.graph;

import java.util.*;

public class BinaryMinHeap<T> {
	private static class Node<T> {
		int weight;
		T key;
	}

	private List<Node<T>> allNodes = new ArrayList<>();
	private Map<T, Integer> nodePosition = new HashMap<>();

	public boolean containsData(T key) {
		return nodePosition.containsKey(key);
	}

	public void add(int weight, T key) {
		Node<T> node = new Node<>();
		node.weight = weight;
		node.key = key;

		allNodes.add(node);
		int size = allNodes.size();
		int current = size - 1;
		nodePosition.put(node.key, current);

		int parentIndex = (current - 1) >> 1;

		while (parentIndex >= 0) {
			Node<T> parentNode = allNodes.get(parentIndex);
			Node<T> currentNode = allNodes.get(current);

			if (parentNode.weight > currentNode.weight) {
				swap(parentNode, currentNode);
				updatePositionMap(parentNode.key, currentNode.key, parentIndex,
						current);
				current = parentIndex;
				parentIndex = (parentIndex - 1) >> 1;
			} else {
				break;
			}
		}
	}

	public T min() {
		return allNodes.get(0).key;
	}

	public boolean isEmpty() {
		return allNodes.isEmpty();
	}

	private void swap(Node<T> node1, Node<T> node2) {
		T key = node1.key;
		int weight = node1.weight;
		node1.key = node2.key;
		node1.weight = node2.weight;
		node2.key = key;
		node2.weight = weight;
	}

	public void descrease(T data, int newWeight) {
		Integer position = nodePosition.get(data);
		Node<T> node = allNodes.get(position);
		node.weight = newWeight;
		int parentIndex = (position - 1) >> 1;

		while (parentIndex >= 0) {
			if (allNodes.get(parentIndex).weight > allNodes
					.get(position).weight) {
				swap(allNodes.get(parentIndex), allNodes.get(position));
				updatePositionMap(allNodes.get(parentIndex).key,
						allNodes.get(position).key, parentIndex, position);
				position = parentIndex;
				parentIndex = (parentIndex - 1) >> 1;
			} else {
				break;
			}
		}
	}

	public Node<T> extractMinNode() {
		int size = allNodes.size() - 1;
		Node<T> minNode = new Node<>();
		minNode.key = allNodes.get(0).key;
		minNode.weight = allNodes.get(0).weight;
		allNodes.get(0).key = allNodes.get(size).key;
		allNodes.get(0).weight = allNodes.get(size).weight;

		allNodes.remove(size);
		nodePosition.remove(minNode.key);
		nodePosition.remove(allNodes.get(0).key);
		nodePosition.put(allNodes.get(0).key, 0);

		int currentIndex = 0;

		while (true) {
			int leftIndex = (currentIndex << 1) + 1;
			int rightIndex = (currentIndex + 1) << 1;

			if (leftIndex > size) {
				break;
			}
			if (rightIndex > size) {
				rightIndex = leftIndex;
			}

			int smallerIndex = allNodes.get(leftIndex).weight <= allNodes
					.get(rightIndex).weight ? leftIndex : rightIndex;
			if (allNodes.get(currentIndex).weight >= allNodes
					.get(smallerIndex).weight) {
				swap(allNodes.get(smallerIndex), allNodes.get(currentIndex));
				updatePositionMap(allNodes.get(currentIndex).key,
						allNodes.get(smallerIndex).key, currentIndex,
						smallerIndex);
				currentIndex = smallerIndex;
			} else {
				break;
			}
		}

		return minNode;
	}

	public Integer getWeight(T key) {
		if (key == null || nodePosition.get(key) == null) {
			return null;
		}

		return allNodes.get(nodePosition.get(key)).weight;
	}

	public T extractMin() {
		Node<T> node = extractMinNode();
		return node.key;
	}

	private void updatePositionMap(T data1, T data2, int pos1, int pos2) {
		nodePosition.remove(data1);
		nodePosition.remove(data2);
		nodePosition.put(data1, pos1);
		nodePosition.put(data2, pos2);
	}
}
