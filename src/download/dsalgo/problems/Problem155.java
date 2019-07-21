package download.dsalgo.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * 
 * Note: You may assume that duplicates do not exist in the tree. Example :
 * 
 * Input : Inorder : [2, 1, 3] Postorder : [2, 3, 1]
 * 
 * Return : 1 / \ 2 3
 * 
 * @author kaussark
 *
 */
public class Problem155 {

	public static void main(String[] args) {
		Integer[] inOrder = { 2, 1, 3 };
		Integer[] postOrder = { 2, 3, 1 };

		System.out.println(new Problem155().buildTree(
				new ArrayList<>(Arrays.asList(inOrder)),
				new ArrayList<>(Arrays.asList(postOrder))));
	}

	public TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {

		return buildInPostOrderTree(null, A, B);
	}

	private TreeNode buildInPostOrderTree(TreeNode node, List<Integer> inorder,
			List<Integer> postOrder) {

		if (inorder.isEmpty() || postOrder.isEmpty()) {
			return null;
		}
		int postOrderLength = postOrder.size();
		node = new TreeNode(postOrder.remove(postOrderLength - 1));
		int inOrderIndex = findInorderIndex(inorder, node.val);

		node.right = buildInPostOrderTree(node.right,
				inorder.subList(inOrderIndex + 1, inorder.size()), postOrder);
		node.left = buildInPostOrderTree(node.left,
				inorder.subList(0, inOrderIndex), postOrder);

		return node;

	}

	// Do a binary search here
	private int findInorderIndex(List<Integer> inorder, int val) {
		for (int i = 0; i < inorder.size(); i++) {
			if (inorder.get(i) == val) {
				return i;
			}
		}
		return 0;
	}
}
