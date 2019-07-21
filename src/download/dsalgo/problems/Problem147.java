package download.dsalgo.problems;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Given a binary tree, return the postorder traversal of its nodes’ values.
 * 
 * Example :
 * 
 * Given binary tree
 * 
 * 1 \ 2 / 3 return [3,2,1].
 * 
 * Using recursion is not allowed.
 * 
 * @author kaussark
 *
 */
public class Problem147 {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		
		System.out.println(new Problem147().postorderTraversal(root));
	}

	public ArrayList<Integer> postorderTraversal(TreeNode A) {
		Stack<TreeNode> childNodes = new Stack<>();
		Stack<Integer> parentNode = new Stack<>();
		ArrayList<Integer> result = new ArrayList<>();
		childNodes.push(A);

		while (!childNodes.isEmpty()) {
			TreeNode temp = childNodes.pop();
			if (temp != null) {
				parentNode.add(temp.val);
				childNodes.push(temp.left);
				childNodes.push(temp.right);
			}
		}

		while (!parentNode.isEmpty()) {
			result.add(parentNode.pop());
		}
		return result;
	}
}
