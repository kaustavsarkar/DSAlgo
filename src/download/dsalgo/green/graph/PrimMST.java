package download.dsalgo.green.graph;

import java.util.*;

public class PrimMST {

	public static void main(String[] args) {

	}

	public List<Edge<Integer>> PrimMST(Graph<Integer> graph) {
		BinaryMinHeap<Vertex<Integer>> minHeap = new BinaryMinHeap<>();
		Map<Vertex<Integer>, Edge<Integer>> vertexToEdge = new HashMap<>();
		List<Edge<Integer>> result = new ArrayList<>();

		for (Vertex<Integer> vertex : graph.getAllVertices()) {
			minHeap.add(Integer.MAX_VALUE, vertex);
		}
		// Get a random vertex
		Vertex<Integer> vertex = graph.getAllVertices().iterator().next();

		minHeap.descrease(vertex, 0);

		while (!minHeap.isEmpty()) {
			Vertex<Integer> current = minHeap.extractMin();

			Edge<Integer> spanningTreeEdge = vertexToEdge.get(current);
			if (spanningTreeEdge != null) {
				result.add(spanningTreeEdge);
			}

			for (Edge<Integer> edge : current.getAllEdges()) {
				Vertex<Integer> adjacent = getVertexForEdge(current, edge);

				if (minHeap.containsData(adjacent)
						&& minHeap.getWeight(adjacent) > edge.getWeight()) {
					minHeap.descrease(adjacent, edge.getWeight());
					vertexToEdge.put(adjacent, edge);
				}
			}

		}
		return result;
	}

	private Vertex<Integer> getVertexForEdge(Vertex<Integer> v1,
			Edge<Integer> edge) {
		return edge.getVertex1() == v1 ? edge.getVertex2() : edge.getVertex1();
	}

}
