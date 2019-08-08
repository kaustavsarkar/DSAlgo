package download.dsalgo.problems;

import java.util.*;

/**
 * Given two words (start and end), and a dictionary, find the shortest
 * transformation sequence from start to end, such that:
 * 
 * Only one letter can be changed at a time Each intermediate word must exist in
 * the dictionary If there are multiple such sequence of shortest length, return
 * all of them. Refer to the example for more details.
 * 
 * Example :
 * 
 * Given:
 * 
 * start = "hit" end = "cog" dict = ["hot","dot","dog","lot","log"] Return
 * 
 * [ ["hit","hot","dot","dog","cog"], ["hit","hot","lot","log","cog"] ] Note:
 * All words have the same length. All words contain only lowercase alphabetic
 * characters.
 * 
 * @author kaussark
 *
 */
public class Problem247 {

	public static void main(String[] args) {
		String start = "bbaa";
		String end = "babb";
		String[] dict = { "baba", "abba", "aaba", "bbbb", "abaa", "abab",
				"aaab", "abba", "abba", "abba", "bbba", "aaab", "abaa", "baba",
				"baaa" };
		// { "hot", "dot", "dog", "lot", "log" };

		System.out.println(new Problem247().findLadders(start, end,
				new ArrayList<>(Arrays.asList(dict))));
	}

	private static class Node {
		String word;
		int depth;
		List<Node> adjNodes = new ArrayList<>();

		public String toString() {
			return word;
		}

		@Override
		public int hashCode() {
			return word.hashCode();
		}

		@Override
		public boolean equals(Object object) {
			if (object == null) {
				return false;
			}

			if (!(object instanceof Node)) {
				return false;
			}

			Node node = (Node) object;
			if (!node.word.equals(word)) {
				return false;
			}
			return true;
		}

	}

	public ArrayList<ArrayList<String>> findLadders(String start, String end,
			ArrayList<String> dict) {
		ArrayList<ArrayList<String>> result = new ArrayList<>();
		Node source = new Node();
		source.word = start;
		source.depth = 1;

		dict.add(start);
		dict.add(end);
		dict = new ArrayList<>(new HashSet<>(dict));

		Map<String, Node> graph = new HashMap<>();
		performBFS(start, end, dict, graph);
		performDFS(start, end, graph, result, new ArrayList<>());
		return result;
	}

	private void performBFS(String start, String end, ArrayList<String> dict,
			Map<String, Node> graph) {
		Node startNode = new Node();
		startNode.word = start;
		startNode.depth = 1;

		Queue<Node> nodeQ = new LinkedList<>();
		nodeQ.offer(startNode);

		graph.put(start, startNode);
		Set<String> visited = new HashSet<>();
		visited.add(startNode.word);
		while (!nodeQ.isEmpty()) {
			Node current = nodeQ.poll();
			graph.putIfAbsent(current.word, current);
			if (current.word.equals(end)) {
				break;
			}
			for (int adj = 0; adj < dict.size(); adj++) {
				if (dict.get(adj).length() == current.word.length()
						&& canTransform(dict.get(adj), current.word)) {
					Node adjNode = new Node();
					if (graph.containsKey(dict.get(adj))) {
						adjNode.depth = graph.get(dict.get(adj)).depth;
					} else {
						adjNode.depth = current.depth + 1;
					}
					adjNode.word = dict.get(adj);

					if (visited.add(adjNode.word) || adjNode.word.equals(end)) {
						nodeQ.offer(adjNode);
					}
					if (adjNode.depth == graph.get(current.word).depth + 1)
						graph.get(current.word).adjNodes.add(adjNode);
				}
			}
		}
	}

	private void performDFS(String start, String end, Map<String, Node> graph,
			ArrayList<ArrayList<String>> result, List<String> temp) {
		temp.add(start);
		if (start.equals(end)) {
			result.add(new ArrayList<>(temp));
		} else if (graph.containsKey(start)) {
			for (Node adj : graph.get(start).adjNodes) {
				performDFS(adj.word, end, graph, result, temp);
			}
		}
		if (!temp.isEmpty())
			temp.remove(temp.size() - 1);
	}

	private boolean canTransform(String string, String string2) {
		int diff = 0;
		for (int index = 0; index < string.length(); index++) {
			if (string.charAt(index) != string2.charAt(index)) {
				diff++;
			}
		}
		return diff == 1;
	}
}
