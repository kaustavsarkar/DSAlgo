package download.dsalgo.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * 
 * Note: You may assume that duplicates do not exist in the tree. Example :
 * 
 * Input : Preorder : [1, 2, 3] Inorder : [2, 1, 3]
 * 
 * Return : 1 / \ 2 3
 * 
 * @author kaussark
 *
 */
public class Problem156 {

	public static void main(String[] args) {

	}

	public TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {
		return buildPreInTree(null, A, B);
	}

	private TreeNode buildPreInTree(TreeNode node, List<Integer> preOrder,
			List<Integer> inOrder) {

		if (inOrder.isEmpty() || preOrder.isEmpty()) {
			return null;
		}

		node = new TreeNode(preOrder.remove(0));
		int inorderIndex = findInorderIndex(inOrder, node.val);

		node.left = buildPreInTree(node.left, preOrder,
				inOrder.subList(0, inorderIndex));
		node.right = buildPreInTree(node.right, preOrder,
				inOrder.subList(inorderIndex + 1, inOrder.size()));
		return node;
	}

	private int findInorderIndex(List<Integer> inOrder, int val) {

		for (int i = 0; i < inOrder.size(); i++) {
			if (inOrder.get(i) == val) {
				return i;
			}
		}

		return 0;
	}

}
