package download.dsalgo.green.graph;

import java.util.*;

public class DijkstraSP {

	private static class Node<T> implements Comparable<Node<T>> {
		int weight;
		Vertex<T> vertex;

		Node(int weight, Vertex<T> vertex) {
			this.weight = weight;
			this.vertex = vertex;
		}

		@Override
		public int compareTo(Node<T> o) {
			if (this.weight > o.weight) {
				return 1;
			} else if (this.weight < o.weight) {
				return -1;
			}
			return 0;
		}

	}

	public static void main(String[] args) {

	}

	/**
	 * This is wrong implementation. Sorted Map shall not work the way expected here
	 * @param graph
	 * @param source
	 */
	public void dijkstra(Graph<Integer> graph, Vertex<Integer> source) {
		SortedMap<Long, Node<Integer>> nodeMap = new TreeMap<>();
		Map<Long, Integer> distanceMap = new HashMap<>();
		Map<Long, Vertex<Integer>> parentMap = new HashMap<>();

		// Filling all values in my nodes
		for (Vertex<Integer> vertex : graph.getAllVertices()) {
			nodeMap.put(vertex.getId(), new Node<>(Integer.MAX_VALUE, vertex));
		}
		nodeMap.get(source.getId()).weight = 0;
		distanceMap.put(source.getId(), 0);
		parentMap.put(source.getId(), null);

		while (!nodeMap.isEmpty()) {
			Long key = nodeMap.firstKey();
			Node<Integer> currNode = nodeMap.remove(key);
			Vertex<Integer> currVertex = currNode.vertex;

			distanceMap.put(key, currNode.weight);

			for (Edge<Integer> edge : currVertex.getAllEdges()) {

				Vertex<Integer> adjVertex = getAdjacentVertex(edge, currVertex);
				if (!nodeMap.containsKey(adjVertex.getId())) {
					continue;
				}
				int newDistance = nodeMap.get(currVertex.getId()).weight
						+ edge.getWeight();
				if (newDistance < nodeMap.get(adjVertex.getId()).weight) {
					nodeMap.get(adjVertex.getId()).weight = newDistance;
					parentMap.put(adjVertex.getId(), currVertex);
				}
			}

		}
		printDistanceMap(distanceMap,source);
	}

	private void printDistanceMap(Map<Long, Integer> distanceMap, Vertex<Integer> source) {
		
	}

	private Vertex<Integer> getAdjacentVertex(Edge<Integer> edge,
			Vertex<Integer> currVertex) {
		return (edge.getVertex1().equals(currVertex) ? edge.getVertex2()
				: edge.getVertex1());
	}

}
