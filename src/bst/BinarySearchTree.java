package bst;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinarySearchTree {

    private class Node {
        int key;
        Node right;;
        Node left;
        Node parent;

        Node(int key) {
            this(key, null);
        }

        Node(int key, Node parent) {
            this.key = key;
            this.parent = parent;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    public void inorderTreeTrav(BinarySearchTree tree) {
        inorderTreeTrav(tree.root);
    }

    public void inorderTreeTrav(Node node) {
        if (node != null) {
            // Traversing left of the current node
            inorderTreeTrav(node.left);
            System.out.println(node.key);
            // Traversing right of the current node
            inorderTreeTrav(node.right);
        }
    }

    public List<Node> inorderTreeTravIt(Node node) {
        Stack<Node> nodeStack = new Stack<>();
        Node current = node;
        List<Node> inorderList = new ArrayList<>();

        while (current != null || !nodeStack.isEmpty()) {
            // First Iterating all left nodes respective of current node
            while (current != null) {
                nodeStack.push(current);
                current = current.left;
            }
            current = nodeStack.pop();
            inorderList.add(current); // The last value had null left so
                                      // popping it out
            current = current.right;
        }
        return inorderList;
    }

    public void preOrderTrav(Node node) {
        if (node != null) {
            System.out.println(node.key);
            preOrderTrav(node.left);
            preOrderTrav(node.right);
        }
    }

    public List<Node> preOrderTravIt(Node node) {
        List<Node> preOrderList = new ArrayList<>();
        Stack<Node> nodeStack = new Stack<>();
        Node current = node;

        while (current != null || !nodeStack.isEmpty()) {
            while (current != null) {
                preOrderList.add(current);
                nodeStack.push(current);
                current = current.left;
            }
            current = nodeStack.pop().right;
        }

        return preOrderList;
    }

    public void postOrderTrav(Node node) {
        if (node != null) {
            postOrderTrav(node.left);
            postOrderTrav(node.right);
            System.out.println(node.key);
        }
    }

    public Stack<Node> postOrderTravIt(Node node) {
        Stack<Node> postOrderStack = new Stack<>();
        Stack<Node> nodeStack = new Stack<>();
        nodeStack.push(node);

        while (!nodeStack.isEmpty()) {
            Node current = nodeStack.pop();
            postOrderStack.push(current);
            if (current.left != null) {
                nodeStack.push(current.left);
            }
            if (current.right != null) {
                nodeStack.push(current.right);
            }
        }
        return postOrderStack;
    }
}
