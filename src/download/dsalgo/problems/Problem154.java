package download.dsalgo.problems;

import java.util.Arrays;
import java.util.List;

/**
 * Given an array where elements are sorted in ascending order, convert it to a
 * height balanced BST.
 * 
 * Balanced tree : a height-balanced binary tree is defined as a binary tree in
 * which the depth of the two subtrees of every node never differ by more than
 * 1. Example :
 * 
 * 
 * Given A : [1, 2, 3] A height balanced BST :
 * 
 * @author kaussark
 *
 */
public class Problem154 {

	public static void main(String[] args) {
		Integer[] array = {1,2,3,4,5,6};
		System.out.println(new Problem154().sortedArrayToBST(Arrays.asList(array)));
	}

	public TreeNode sortedArrayToBST(final List<Integer> a) {
		if (a.isEmpty()) {
			return null;
		}
		return generateBalBST(null, a, 0, a.size() - 1);

	}

	private TreeNode generateBalBST(TreeNode node, List<Integer> a, int start,
			int end) {

		if (start > end) {
			return null;
		}

		int midIndex = (start + end) >> 1;
		int rootVal = a.get(midIndex);
		node = new TreeNode(rootVal);

		node.left = generateBalBST(node.left, a, start, midIndex - 1);
		node.right = generateBalBST(node.right, a, midIndex + 1, end);
		return node;
	}
}
