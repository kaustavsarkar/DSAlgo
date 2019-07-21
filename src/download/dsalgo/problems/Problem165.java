package download.dsalgo.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path’s
 * sum equals the given sum.
 * 
 * For example: Given the below binary tree and sum = 22,
 * 
 * 5 / \ 4 8 / / \ 11 13 4 / \ / \ 7 2 5 1 return
 * 
 * [ [5,4,11,2], [5,8,4,5] ]
 * 
 * @author kaussark
 *
 */
public class Problem165 {

	public static void main(String[] args) {

	}

	public ArrayList<ArrayList<Integer>> pathSum(TreeNode A, int B) {
		ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
		pathCalculator(A, B, paths, new ArrayList<>());
		return paths;
	}

	private void pathCalculator(TreeNode node, int sum,
			ArrayList<ArrayList<Integer>> paths, ArrayList<Integer> currentPath) {
		if (node == null) {
			return;
		}
		currentPath.add(node.val);
		if (node != null && node.left == null && node.right == null
				&& node.val == sum) {
			paths.add(currentPath);
			return;
		}
		
		pathCalculator(node.left, sum-node.val, paths, new ArrayList<>(currentPath));
		pathCalculator(node.right, sum-node.val, paths, new ArrayList<>(currentPath));

	}
}
