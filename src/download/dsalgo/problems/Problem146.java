package download.dsalgo.problems;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Given a binary tree, return the inorder traversal of its nodes’ values.
 * 
 * Example : Given binary tree
 * 
 * 1 \ 2 / 3 return [1,3,2].
 * 
 * Using recursion is not allowed.
 * 
 * @author kaussark
 *
 */
public class Problem146 {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		
		System.out.println(new Problem146().inorderTraversal(root));
	}

	public ArrayList<Integer> inorderTraversal(TreeNode A) {
		Stack<TreeNode> nodeStack = new Stack<>();
		ArrayList<Integer> result = new ArrayList<>();
		TreeNode node = A;
		while (!nodeStack.isEmpty() || node != null) {

			while (node != null) {
				nodeStack.push(node);
				node = node.left;
			}

			node = nodeStack.pop();
			if (node != null) {
				result.add(node.val);
				node = node.right;
			}
		}
		return result;
	}

}
