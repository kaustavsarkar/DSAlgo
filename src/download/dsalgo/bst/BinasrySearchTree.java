package download.dsalgo.bst;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinasrySearchTree {

	private Node root;
	private Node node;

	public static void main(String[] args) {
		BinasrySearchTree tree = new BinasrySearchTree();

		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.left.right = new Node(4);
		tree.root.left.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		int depth = tree.maxTreeDepthit(tree.root);
		System.out.println("Depth : " + depth);

	}

	public void inorderTreeWalk(Node n) {
		if (n != null) {
			inorderTreeWalk(n.left);
			System.out.println(n.key);
			inorderTreeWalk(n.right);
		}
	}

	public int maxTreeDepthit(Node node) {
		if (node == null) {
			return 0;
		}
		Stack<Node> nodeStack = new Stack<>();
		Node current = node;
		int curentDepth = 0;
		int depth = 0;
		while (current != null || !nodeStack.isEmpty()) {
			if (current != null) {
				nodeStack.push(current);
				current = current.left;
				++curentDepth;
			} else {
				current = nodeStack.pop();
				--curentDepth;
				current = current.right;
			}
			depth = depth > curentDepth ? depth : curentDepth;
		}
		return depth;
	}

	public int maxTreeDepth(Node node) {
		if (node == null) {
			return 0;
		}
		int lDepth = maxTreeDepth(node.left);
		int rDepth = maxTreeDepth(node.right);

		if (lDepth > rDepth) {
			return 1 + lDepth;
		} else {
			return 1 + rDepth;
		}
	}

	private static class Node {

		public Node(int key) {
			this.key = key;
			this.right = null;
			this.left = null;
		}

		public Node(int key, Node parent) {
			this.key = key;
			this.right = null;
			this.left = null;
			this.parent = parent;
		}

		int key;
		Node right;
		Node left;
		Node parent;

		@Override
		public String toString() {
			return "Node [key=" + key + "]";
		}

	}

}
