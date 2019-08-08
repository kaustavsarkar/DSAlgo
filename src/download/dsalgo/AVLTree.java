package download.dsalgo;

public class AVLTree {

	public static void main(String[] args) {
	}

	private static class Node {
		Node left;
		Node right;
		int data;
		int height;
		int size;

		public static Node newNode(int data) {
			Node node = new Node();
			node.data = data;
			node.left = null;
			node.right = null;
			node.height = 1;
			node.size = 1;
			return node;
		}
	}
	
	public Node insert(Node root, int data) {
		if(root == null) {
			return Node.newNode(data);
		}
		
		if(data >= root.data) {
			root.right = insert(root.right, data);
		} else {
			root.left = insert(root.left, data);
		}
		
		int balance = balance(root.left, root.right);
		
		//Left Subtree is larger
		if(balance > 1) {
			if(height(root.left.left) >= height(root.left.right)) {
				root = rightRotate(root);
			} else {
				root.left = leftRotate(root.left);
				root = rightRotate(root);
			}
		}
		//Right subtree is larger
		else if(balance < -1) {
			if(height(root.right.right) >= height(root.right.left)) {
				root = leftRotate(root);
			} else {
				root.right = rightRotate(root.right);
				root = leftRotate(root);
			}
		} else {
			root.height = setHeight(root);
			root.size = setSize(root);
		}
		return root;
	}

	// Left Rotate
	private Node leftRotate(Node root) {
		Node newRoot = root.right;
		root.right = root.right.left;
		newRoot.left = root;
		root.height = setHeight(root);
		newRoot.height = setHeight(newRoot);
		return newRoot;
	}

	private Node rightRotate(Node root) {
		Node newRoot = root.left;
		root.left = root.left.right;
		newRoot.right = root;
		root.height = setHeight(root);
		newRoot.height = setHeight(newRoot);
		return newRoot;
	}

	private int setSize(Node root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.max(root.left != null ? root.left.size : 0,
				root.right != null ? root.right.size : 0);
	}

	private int setHeight(Node root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.max((root.left != null ? root.left.height : 0),
				(root.right != null ? root.right.height : 0));
	}

	private int height(Node root) {
		if (root == null)
			return 0;

		return root.height;
	}
	
	private int balance(Node leftNode, Node rightNode) {
		return height(leftNode) - height(rightNode);
	}

}
