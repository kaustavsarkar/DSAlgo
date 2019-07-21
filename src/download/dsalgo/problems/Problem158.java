package download.dsalgo.problems;

import java.util.HashSet;
import java.util.Set;

public class Problem158 {

	public static void main(String[] args) {

	}
	public int t2Sum(TreeNode A, int B) {
		return sumHelper(A, B, new HashSet<>());
		
    }
	
	private int sumHelper(TreeNode node, int sum, Set<Integer> visitedNodes) {
		
		if(node == null) {
			return 0;
		}
		
		if(sumHelper(node.left, sum, visitedNodes) == 1) {
			return 1;
		}
		if(visitedNodes.contains(sum-node.val)) {
			return 1;
		} else {
			visitedNodes.add(node.val);
		}
		
		return sumHelper(node.right, sum, visitedNodes);
		
	}
}
