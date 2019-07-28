package download.dsalgo.green.graph;

public class Edge<T> {

	private Vertex<T> vertex1;
	private Vertex<T> vertex2;
	private boolean isDirected;
	private Integer weight;

	public Edge(Vertex<T> vertex1, Vertex<T> vertex2) {
		this.vertex1 = vertex1;
		this.vertex2 = vertex2;
	}

	public Edge(Vertex<T> vertex1, Vertex<T> vertex2, int weight) {
		this(vertex1, vertex2);
		this.weight = weight;
	}

	public Edge(Vertex<T> vertex1, Vertex<T> vertex2, int weight,
			boolean isDirected) {
		this(vertex1, vertex2, weight);
		this.isDirected = isDirected;
	}

	public Vertex<T> getVertex1() {
		return this.vertex1;
	}

	public Vertex<T> getVertex2() {
		return this.vertex2;
	}

	public int getWeight() {
		return this.weight;
	}

	public boolean isDirected() {
		return isDirected;
	}
}
