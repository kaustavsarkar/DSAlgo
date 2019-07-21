package download.dsalgo.problems;

import java.util.Stack;

/**
 * Input : 2 / \ 1 3
 * 
 * and k = 2
 * 
 * Return : 2
 * 
 * As 2 is the second smallest element in the tree. NOTE : You may assume 1 <= k
 * <= Total number of nodes in BST
 * 
 * @author kaussark
 *
 */
public class Problem157 {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(3);
		root.right = new TreeNode(5);

		System.out.println(new Problem157().kthsmallest(root, 2));

	}

	public int kthsmallest(TreeNode A, int B) {
		TreeNode node = runInorderTrav(A, B);
		return node.val;
	}

	private TreeNode runInorderTrav(TreeNode node, int B) {
		Stack<TreeNode> nodeStack = new Stack<>();
		TreeNode current = node;
		while (current != null || !nodeStack.isEmpty()) {
			while (current != null) {
				nodeStack.push(current);
				current = current.left;
			}

			current = nodeStack.pop();
			if (--B == 0) {
				return current;
			}
			current = current.right;
		}

		return current;
	}
}
