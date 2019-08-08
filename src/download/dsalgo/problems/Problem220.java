package download.dsalgo.problems;

/**
 * Given A, how many structurally unique BST’s (binary search trees) that store
 * values 1...A?
 * 
 * Example :
 * 
 * Given A = 3, there are a total of 5 unique BST’s.
 * 
 * 
 * 1 3 3 2 1 \ / / / \ \ 3 2 1 1 3 2 / / \ \ 2 1 2 3
 * 
 * @author kaussark
 *
 */
public class Problem220 {

	public static void main(String[] args) {
		int nodes = 3;
		System.out.println(new Problem220().numTrees(nodes));
	}

	public int numTrees(int A) {
		if (A == 0 || A == 1) {
			return 1;
		}
		int[] memo = new int[A + 1];
		memo[0] = memo[1]= 1;
		
		for(int nodes = 2; nodes <= A; nodes++) {
			for(int root = 1; root <= nodes; root++) {
				memo[nodes] += memo[root-1]*memo[nodes-root];
			}
		}
		return memo[A];
	}

}
