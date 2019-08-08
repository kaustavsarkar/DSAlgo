package download.dsalgo.problems;

import java.util.*;

/**
 * Find largest distance Given an arbitrary unweighted rooted tree which
 * consists of N (2 <= N <= 40000) nodes. The goal of the problem is to find
 * largest distance between two nodes in a tree. Distance between two nodes is a
 * number of edges on a path between the nodes (there will be a unique path
 * between any pair of nodes since it is a tree). The nodes will be numbered 0
 * through N - 1.
 * 
 * The tree is given as an array P, there is an edge between nodes P[i] and i (0
 * <= i < N). Exactly one of the i’s will have P[i] equal to -1, it will be root
 * node.
 * 
 * Example: If given P is [-1, 0, 0, 0, 3], then node 0 is the root and the
 * whole tree looks like this: 0 / | \ 1 2 3 \ 4 One of the longest path is 1 ->
 * 0 -> 3 -> 4 and its length is 3, thus the answer is 3. Note that there are
 * other paths with maximal distance.
 * 
 * @author kaussark
 *
 */
public class Problem240 {

	public static void main(String[] args) {
		Integer[] nodes = { -1, 0, 0, 0, 3};
			//{-1,0};
		System.out.println(new Problem240().solve(new ArrayList<>(Arrays.asList(nodes))));
	}

	List<int[]> pair;
	List<Integer>[] adj;

	public int solve(ArrayList<Integer> A) {
		if(A.size() == 1) {
			return 0;
		}
		if(A.size() == 2) {
			return 1;
		}
		pair = new ArrayList<>();
		adj = new ArrayList[A.size()];
		
		//Initialise adj
		for(int i = 0; i < adj.length; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for (int index = 1; index < A.size(); index++) {
			adj[A.get(index)].add(index);
			adj[index].add(A.get(index));
		}
		findLongestNode(0);
		findLongestNode(pair.get(0)[0]);
		
		return pair.get(1)[1];
	}

	private void findLongestNode(int node) {
		int distance[] = new int[adj.length];
		Arrays.fill(distance, -1);
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(node);
		distance[node] = 0;
		while (!queue.isEmpty()) {
			int vertex = queue.poll();
			for (int index = 0; index < adj[vertex].size(); index++) {
				int adjacent = adj[vertex].get(index);
				if (distance[adjacent] == -1) {
					queue.add(adjacent);
					distance[adjacent] = distance[vertex] + 1;
				}
			}
		}
		
		int[] temp = new int[2];
		for(int index = 0; index < distance.length; index++) {
			if(distance[index] > temp[1]) {
				temp[1] = distance[index];
				temp[0] = index;
			}
		}
		
		pair.add(temp);
	}
}
