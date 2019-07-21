package download.dsalgo.problems;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Given a binary tree, return the preorder traversal of its nodes’ values.
 * 
 * Example : Given binary tree
 * 
 * 1 \ 2 / 3 return [1,2,3].
 * 
 * Using recursion is not allowed.
 * 
 * @author kaussark
 *
 */
public class Problem148 {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		
		System.out.println(new Problem148().preorderTraversal(root));
	}

	public ArrayList<Integer> preorderTraversal(TreeNode A) {
		ArrayList<Integer> result = new ArrayList<>();
		Stack<TreeNode> nodeStack = new Stack<>();

		nodeStack.push(A);

		while (!nodeStack.isEmpty()) {
			TreeNode temp = nodeStack.pop();
			if (temp != null) {
				nodeStack.push(temp.right);
				nodeStack.push(temp.left);
				result.add(temp.val);
			}
		}

		return result;
	}
}
