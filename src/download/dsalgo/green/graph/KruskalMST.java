package download.dsalgo.green.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class KruskalMST {

	public class EdgeComparator implements Comparator<Edge<Integer>> {

		@Override
		public int compare(Edge<Integer> o1, Edge<Integer> o2) {
			if (o1.getWeight() > o2.getWeight()) {
				return 1;
			} else if (o1.getWeight() < o2.getWeight()) {
				return -1;
			}
			return 0;
		}

	}

	public List<Edge<Integer>> getMST(Graph<Integer> graph) {
		List<Edge<Integer>> resultEdge = new ArrayList<Edge<Integer>>();
		List<Edge<Integer>> allEdges = graph.getAllEdges();

		Collections.sort(allEdges, new EdgeComparator());
		DisjointSet disjointSet = new DisjointSet();

		for (Vertex<Integer> vertex : graph.getAllVertices()) {
			disjointSet.makeSet(vertex.getId());
		}

		for (Edge<Integer> edge : allEdges) {
			long root1 = disjointSet.findSet(edge.getVertex1().getId());
			long root2 = disjointSet.findSet(edge.getVertex2().getId());

			if (root1 == root2) {
				continue;
			} else {
				resultEdge.add(edge);
				disjointSet.union(edge.getVertex1().getId(),
						edge.getVertex2().getId());
			}
		}

		return resultEdge;
	}
}
