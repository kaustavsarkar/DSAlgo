package download.dsalgo.green.graph;

import java.util.*;

public class Vertex<T> {
	private long id;
	private T data;
	private List<Edge<T>> edges;
	private List<Vertex<T>> adjVertices;

	public Vertex(long id) {
		this.id = id;
		edges = new ArrayList<>();
		adjVertices = new ArrayList<>();
	}

	public long getId() {
		return id;
	}

	public void setData(T data) {
		this.data = data;
	}

	public T getData() {
		return this.data;
	}

	public void addAdjVertex(Edge<T> edge, Vertex<T> vertex) {
		edges.add(edge);
		adjVertices.add(vertex);
	}

	public List<Edge<T>> getAllEdges() {
		return edges;
	}

	public List<Vertex<T>> getAdjVertices() {
		return adjVertices;
	}

	public int getDegree() {
		return edges.size();
	}

	@Override
	public int hashCode() {
		int prime = 31;
		int result = 1;
		result = result * prime + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Vertex<T> ver = (Vertex<T>) obj;
		if (data != ver.data) {
			return false;
		}
		if (id != ver.getId()) {
			return false;
		}

		return true;
	}
}
