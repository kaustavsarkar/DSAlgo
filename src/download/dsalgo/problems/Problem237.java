package download.dsalgo.problems;

import java.util.*;

/**
 * There are n islands and there are many bridges connecting them. Each bridge
 * has some cost attached to it.
 * 
 * We need to find bridges with minimal cost such that all islands are
 * connected.
 * 
 * It is guaranteed that input data will contain at least one possible scenario
 * in which all islands are connected with each other.
 * 
 * Example : Input
 * 
 * Number of islands ( n ) = 4 1 2 1 2 3 4 1 4 3 4 3 2 1 3 10 In this example,
 * we have number of islands(n) = 4 . Each row then represents a bridge
 * configuration. In each row first two numbers represent the islands number
 * which are connected by this bridge and the third integer is the cost
 * associated with this bridge.
 * 
 * In the above example, we can select bridges 1(connecting islands 1 and 2 with
 * cost 1), 3(connecting islands 1 and 4 with cost 3), 4(connecting islands 4
 * and 3 with cost 2). Thus we will have all islands connected with the minimum
 * possible cost(1+3+2 = 6). In any other case, cost incurred will be more.
 * 
 * @author kaussark
 *
 */
public class Problem237 {

	public static void main(String[] args) {
		int number = 4;
		Integer[][] paths = { { 1, 2, 1 }, { 2, 3, 2 }, { 3, 4, 4 },
				{ 1, 4, 3 } };
		ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
		for (Integer[] path : paths) {
			matrix.add(new ArrayList<>(Arrays.asList(path)));
		}

		System.out.println(new Problem237().solve(number, matrix));
	}

	private static class Path {
		int island1;
		int island2;
		Integer cost;
	}

	Set<Integer> islands = new HashSet<>();
	Map<Integer, Path> costPathMap = new HashMap<>();

	public int _solve(int A, ArrayList<ArrayList<Integer>> B) {
		List<Path> islandPaths = createPath(B);
		Collections.sort(islandPaths,
				(path1, path2) -> path1.cost.compareTo(path2.cost));

		int result = 0;
		return 0;

	}

	private List<Path> createPath(ArrayList<ArrayList<Integer>> b) {
		List<Path> islandPaths = new ArrayList<>();
		for (ArrayList<Integer> path : b) {
			Path island = new Path();
			islands.add(path.get(0));
			islands.add(path.get(1));
			island.island1 = path.get(0);
			island.island2 = path.get(1);
			island.cost = path.get(2);
			islandPaths.add(island);
		}
		return islandPaths;
	}

	public int solve(int A, ArrayList<ArrayList<Integer>> B) {
		Graph<Integer> graph = new Graph<>();

		createGraph(B, graph);
		List<Edge<Integer>> edges = runKMST(graph);

		Integer cost = 0;
		for (Edge<Integer> edge : edges) {
			cost += edge.weight;
		}
		return cost;
	}

	private List<Edge<Integer>> runKMST(Graph<Integer> graph) {
		List<Edge<Integer>> allEdges = graph.getAllEdges();
		List<Vertex<Integer>> allVertices = new ArrayList<>(
				graph.getAllVertices());
		List<Edge<Integer>> resultEdges = new ArrayList<>();

		Collections.sort(allEdges,
				(edge1, edge2) -> edge1.weight.compareTo(edge2.weight));
		DisjointSet ds = new DisjointSet();
		for (Vertex<Integer> vertex : allVertices) {
			ds.makeSet(vertex.id);
		}

		for (Edge<Integer> edge : allEdges) {
			long root1 = ds.findSet(edge.getVertex1().id);
			long root2 = ds.findSet(edge.getVertex2().id);

			if (root1 == root2) {
				continue;
			} else {
				ds.union(root1, root2);
				resultEdges.add(edge);
			}
		}

		return resultEdges;
	}

	private void createGraph(ArrayList<ArrayList<Integer>> matrix,
			Graph<Integer> graph) {
		for (ArrayList<Integer> path : matrix) {
			Vertex<Integer> vertex1 = graph.addSingleVertex(path.get(0));
			Vertex<Integer> vertex2 = graph.addSingleVertex(path.get(1));
			graph.addEdge(vertex1.id, vertex2.id, path.get(2));
		}
	}

	private static class DisjointSet {
		Map<Long, Node> map = new HashMap<>();

		public void makeSet(long data) {
			Node node = new Node();
			node.data = data;
			node.rank = 0;
			node.parent = node;
			map.put(data, node);
		}

		public Node findSet(Node node) {
			Node parent = node.parent;
			if (parent == node) {
				return node.parent;
			}

			node.parent = findSet(node.parent);
			return node.parent;
		}

		public Long findSet(Long data) {
			return findSet(map.get(data)).data;
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
			}
			parent2.parent = parent1;
		}
		public String toString() {
			return map.toString();
		}
	}

	private static class Node {
		long data;
		int rank;
		Node parent;
		
		public String toString() {
			return "data:"+data+" rank:"+rank+" parent:"+parent.data;
		}
	}

	private static class Graph<T> {
		private Map<Long, Vertex<T>> allVertices = new HashMap<>();
		private List<Edge<T>> allEdges = new ArrayList<>();

		public void addEdge(long id1, long id2) {
			addEdge(id1, id2, 0);
		}

		public void addEdge(long id1, long id2, int weight) {
			Edge<T> edge = null;
			Vertex<T> vertex1 = null, vertex2 = null;
			if (allVertices.containsKey(id1)) {
				vertex1 = allVertices.get(id1);
			} else {
				vertex1 = new Vertex<T>(id1);
				allVertices.put(id1, vertex1);
			}
			if (allVertices.containsKey(id2)) {
				vertex2 = allVertices.get(id2);
			} else {
				vertex2 = new Vertex<T>(id2);
				allVertices.put(id2, vertex2);
			}

			edge = new Edge<T>(vertex1, vertex2, weight);
			allEdges.add(edge);
			vertex1.addVertex(edge, vertex2);

		}

		public void addVertex(Vertex<T> vertex) {
			if (allVertices.containsKey(vertex)) {
				return;
			}
			allVertices.put(vertex.id, vertex);
			allEdges.addAll(vertex.getAllEdges());
		}

		public Vertex<T> addSingleVertex(long id) {
			if (allVertices.containsKey(id)) {
				return allVertices.get(id);
			}
			Vertex<T> vertex = new Vertex<T>(id);
			allVertices.put(id, vertex);
			return vertex;
		}

		public Vertex<T> getVertex(long id) {
			return allVertices.get(id);
		}

		public List<Edge<T>> getAllEdges() {
			return this.allEdges;
		}

		public Collection<Vertex<T>> getAllVertices() {
			return this.allVertices.values();
		}

		public void setDataVertices(long id, T data) {
			if (allVertices.containsKey(id)) {
				allVertices.get(id).setData(data);
			}
		}

		public String toString() {
			return "Edges " + allEdges + "\n Vertices : " + allVertices;
		}

	}

	private static class Vertex<T> {
		List<Edge<T>> allEdges;
		List<Vertex<T>> adjacentVertices;
		long id;
		T data;

		public Vertex(long id) {
			this.id = id;
			allEdges = new ArrayList<>();
			adjacentVertices = new ArrayList<>();
		}

		public void setData(T data) {
			this.data = data;
		}

		public T getData() {
			return this.data;
		}

		public List<Edge<T>> getAllEdges() {
			return this.allEdges;
		}

		public List<Vertex<T>> getAdjVertices() {
			return this.adjacentVertices;
		}

		public void addVertex(Edge<T> edge, Vertex<T> vertex) {
			adjacentVertices.add(vertex);
			allEdges.add(edge);
		}

		public int getDegree() {
			return this.allEdges.size();
		}

		@Override
		public String toString() {
			return "id " + id + "data " + data;
		}

		@Override
		public boolean equals(Object o) {
			if (o == null) {
				return false;
			}
			if (!(o instanceof Vertex)) {
				return false;
			}

			Vertex<T> vertex = (Vertex<T>) o;
			if (vertex.id != vertex.id) {
				return false;
			}

			if (vertex.data != vertex.data) {
				return false;
			}

			return true;
		}

		@Override
		public int hashCode() {
			int prime = 31;
			int result = 1;
			result = result * prime + (int) (id ^ (id >>> 32));
			return result;
		}
	}

	private static class Edge<T> {
		Vertex<T> vertex1;
		Vertex<T> vertex2;
		Integer weight;

		public Edge(Vertex<T> vertex1, Vertex<T> vertex2) {
			this.vertex1 = vertex1;
			this.vertex2 = vertex2;
		}

		public Edge(Vertex<T> vertex1, Vertex<T> vertex2, int weight) {
			this(vertex1, vertex2);
			this.weight = weight;
		}

		public Integer getWeight() {
			return this.weight;
		}

		public Vertex<T> getVertex1() {
			return vertex1;
		}

		public Vertex<T> getVertex2() {
			return vertex2;
		}

		@Override
		public String toString() {
			return "weight " + weight + " vertex1 " + vertex1.id + " vertex2 "
					+ vertex2.id;
		}
	}

}
