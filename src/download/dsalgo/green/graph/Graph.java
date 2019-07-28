package download.dsalgo.green.graph;

import java.util.*;

public class Graph<T> {

	private boolean isDirected;
	private List<Edge<T>> allEdges;
	private Map<Long, Vertex<T>> allVertices;

	public Graph(boolean isDirected) {
		this.isDirected = isDirected;
		allEdges = new ArrayList<>();
		allVertices = new HashMap<>();
	}

	public void addEdge(long id1, long id2) {
		addEdge(id1, id2, 0);
	}

	private void addEdge(long id1, long id2, int weight) {
		Edge<T> edge = null;
		Vertex<T> vertex1 = null, vertex2 = null;
		if (allVertices.containsKey(id1)) {
			vertex1 = allVertices.get(id1);
		} else {
			vertex1 = new Vertex<>(id1);
			allVertices.put(id1, vertex1);
		}

		if (allVertices.containsKey(id2)) {
			vertex2 = allVertices.get(id2);
		} else {
			vertex2 = new Vertex<>(id2);
			allVertices.put(id2, vertex2);
		}

		edge = new Edge<>(vertex1, vertex2, weight, isDirected);
		allEdges.add(edge);
		vertex1.addAdjVertex(edge, vertex2);
		if (!isDirected) {
			vertex2.addAdjVertex(edge, vertex1);
		}
	}

	public void addVertex(Vertex<T> vertex) {
		if (allVertices.containsKey(vertex)) {
			return;
		}

		allVertices.put(vertex.getId(), vertex);
		allEdges.addAll(vertex.getAllEdges());
	}

	public Vertex<T> addSingleVertex(long id) {
		if (allVertices.containsKey(id)) {
			return allVertices.get(id);
		}

		Vertex<T> vertex = new Vertex<>(id);
		allVertices.put(id, vertex);

		return vertex;
	}

	public Vertex<T> getVertex(long id) {
		return allVertices.get(id);
	}

	public List<Edge<T>> getAllEdges() {
		return allEdges;
	}

	public Collection<Vertex<T>> getAllVertices() {
		return allVertices.values();
	}

	public void setDataForVertex(Long id, T data) {
		if (allVertices.containsKey(id)) {
			allVertices.get(id).setData(data);
		}
	}
}
