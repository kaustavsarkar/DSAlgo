package download.dsalgo.problems;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given an inorder traversal of a cartesian tree, construct the tree.
 * 
 * Cartesian tree : is a heap ordered binary tree, where the root is greater
 * than all the elements in the subtree. Note: You may assume that duplicates do
 * not exist in the tree. Example :
 * 
 * Input : [1 2 3]
 * 
 * Return : 3 / 2 / 1
 * 
 * @author kaussark
 *
 */
public class Problem153 {

	public static void main(String[] args) {
		Integer[] inorder = { 3, 5, 2, 6, 1, 4 };
		System.out.println(new Problem153()
				.buildTree(new ArrayList<>(Arrays.asList(inorder))));
	}

	public TreeNode buildTree(ArrayList<Integer> A) {
		TreeNode root = buildCartTree(null, A, 0, A.size()-1);

		return root;
	}

	private TreeNode buildCartTree(TreeNode node, ArrayList<Integer> a,
			int start, int end) {
		if (start > end) {
			return null;
		}
		int maxIndex = getMax(a, start, end);
		node = new TreeNode(a.get(maxIndex));

		if(start == end) {
			return node;
		}
		
		node.left = buildCartTree(node.left, a, start, maxIndex-1);
		node.right = buildCartTree(node.right, a, maxIndex + 1, end);
		return node;
	}

	private int getMax(ArrayList<Integer> a, int start, int end) {
		int max = 0;
		int maxIndex = 0;
		for (int i = start; i <= end; i++) {
			if (a.get(i) > max) {
				max = a.get(i);
				maxIndex = i;
			}
		}
		return maxIndex;
	}
}
