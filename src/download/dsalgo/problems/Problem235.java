package download.dsalgo.problems;

import java.util.*;

public class Problem235 {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		System.out.println(new Problem235().levelOrder(root));
	}

	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {
		if (A == null) {
			return new ArrayList<>();
		}
		ArrayList<ArrayList<Integer>> levelOrder = new ArrayList<>();
		Queue<TreeNode> nodeStack = new LinkedList<>();
		ArrayList<Integer> levelList = new ArrayList<>();

		nodeStack.add(A);
		nodeStack.add(null);
		TreeNode node = null;
		while (!nodeStack.isEmpty()) {
			levelList.clear();
			while (nodeStack.peek() != null) {
				node = nodeStack.poll();
				levelList.add(node.val);
				if (node.left != null) {
					nodeStack.add(node.left);
				}
				if (node.right != null) {
					nodeStack.add(node.right);
				}
			}
			node = nodeStack.poll();
			if (node == null && !nodeStack.isEmpty()) {
				nodeStack.add(null);
			}
			levelOrder.add(new ArrayList<>(levelList));
		}

		return levelOrder;
	}
}
