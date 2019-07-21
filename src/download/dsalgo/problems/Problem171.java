package download.dsalgo.problems;

import java.util.Stack;

/**
 * Given a binary tree, flatten it to a linked list in-place.
 * 
 * Example : Given
 * 
 * 
 * 1 / \ 2 5 / \ \ 3 4 6 The flattened tree should look like:
 * 
 * 1 \ 2 \ 3 \ 4 \ 5 \ 6 Note that the left child of all nodes should be NULL.
 * 
 * @author kaussark
 *
 */
public class Problem171 {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.right = new TreeNode(6);

		inorderTraverse(root);
		System.out.println();
		inorderTraverse(new Problem171().flatten(root));
	}

	static void inorderTraverse(TreeNode node) {
		if (node == null) {
			return;
		}

		inorderTraverse(node.left);
		System.out.print(node.val + " ");
		inorderTraverse(node.right);
	}

	private TreeNode prev;

	public TreeNode flatten(TreeNode node) {
		prev = node;
		inPlaceFlatten(node);
		return node;
	}

	private void inPlaceFlatten(TreeNode node) {

		if (node == null) {
			return;
		}

		TreeNode left = node.left;
		TreeNode right = node.right;

		if (prev != null && !prev.equals(node)) {
			prev.right = node;
			prev.left = null;
			prev = node;
		}

		inPlaceFlatten(left);
		inPlaceFlatten(right);
		if (left == null && right == null) {
			prev = node;
		}

	}

}
