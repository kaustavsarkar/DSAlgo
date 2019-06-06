package bst;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree {

    private static class Node {
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

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.root = new Node(1);
        bst.root.left = new Node(2);
        bst.root.right = new Node(3);
        bst.root.left.left = new Node(4);
        bst.root.left.right = new Node(5);
        bst.root.right.left = new Node(6);
        bst.root.right.right = new Node(7);
        bst.root.left.left.left = new Node(8);
        bst.root.left.left.right = new Node(9);

        List<Integer> inorder = new ArrayList<>();
        bst.inorderTreeTrav(bst.root, inorder);
        System.out.println(inorder);// 8, 4, 9, 2, 5, 1, 6, 3, 7

        List<Integer> inorderIt = bst.inorderTreeTravIt(bst.root);
        System.out.println(inorderIt);

        List<Integer> preOrder = new ArrayList<>();
        bst.preOrderTrav(bst.root, preOrder);
        System.out.println(preOrder);

        List<Integer> preOrderIt = bst.preOrderTravIt(bst.root);
        System.out.println(preOrderIt);

        List<Integer> postOrder = new ArrayList<>();
        bst.postOrderTrav(bst.root, postOrder);
        System.out.println(postOrder);

        Stack<Integer> postOrderIt = bst.postOrderTravIt(bst.root);
        while (!postOrderIt.isEmpty()) {
            System.out.print(postOrderIt.pop() + ",");
        }

        System.out.println();
        
        int height = bst.treeHeight(bst.root);
        int htIt = bst.treeHeightIt(bst.root);
        
        List<Integer> levelOrder = bst.levelTreeTrav(bst.root);
        System.out.println(levelOrder);
        
    }

    public List<Integer> levelTreeTrav(Node node) {
        Queue<Node> nodeQueue = new LinkedList<>();
        List<Integer> levelOrder = new ArrayList<>();
        Node current = node;
        while (current != null || !nodeQueue.isEmpty()) {
            if (current != null) {
                if (current.left != null) {
                    nodeQueue.add(current.left);
                }
                if (current.right != null) {
                    nodeQueue.add(current.right);
                }
            }
            levelOrder.add(current.key);
            current = nodeQueue.poll();
        }
        return levelOrder;
    }

    public void inorderTreeTrav(Node node, List<Integer> inorder) {
        // Stack<Integer> nodeStack = new Stack<>();
        if (node != null) {
            // Traversing left of the current node
            inorderTreeTrav(node.left, inorder);
            inorder.add(node.key);
            // Traversing right of the current node
            inorderTreeTrav(node.right, inorder);
        }
    }

    public void preOrderTrav(Node node, List<Integer> preOrder) {
        if (node != null) {
            preOrder.add(node.key);
            preOrderTrav(node.left, preOrder);
            preOrderTrav(node.right, preOrder);
        }
    }

    public void postOrderTrav(Node node, List<Integer> postOrder) {
        if (node != null) {
            postOrderTrav(node.left, postOrder);
            postOrderTrav(node.right, postOrder);
            postOrder.add(node.key);
        }
    }

    public List<Integer> inorderTreeTravIt(Node node) {
        Stack<Node> nodeStack = new Stack<>();
        Node current = node;
        List<Integer> inorderList = new ArrayList<>();

        while (current != null || !nodeStack.isEmpty()) {
            // First Iterating all left nodes respective of current node
            while (current != null) {
                nodeStack.push(current);
                current = current.left;
            }
            current = nodeStack.pop();
            inorderList.add(current.key); // The last value had null left so
            // popping it out
            current = current.right;
        }
        return inorderList;
    }

    public List<Integer> preOrderTravIt(Node node) {
        List<Integer> preOrderList = new ArrayList<>();
        Stack<Node> nodeStack = new Stack<>();
        Node current = node;

        while (current != null || !nodeStack.isEmpty()) {
            while (current != null) {
                preOrderList.add(current.key);
                nodeStack.push(current);
                current = current.left;
            }
            current = nodeStack.pop().right;
        }

        return preOrderList;
    }

    public Stack<Integer> postOrderTravIt(Node node) {

        Stack<Integer> postOrderStack = new Stack<>();
        Stack<Node> nodeStack = new Stack<>();
        nodeStack.push(node);

        while (!nodeStack.isEmpty()) {
            Node current = nodeStack.pop();
            postOrderStack.push(current.key);
            if (current.left != null) {
                nodeStack.push(current.left);
            }
            if (current.right != null) {
                nodeStack.push(current.right);
            }
        }
        return postOrderStack;
    }

    public int treeHeight(Node node) {
        if (node == null) {
            return 0;
        }
        int lDepth = treeHeight(node.left);
        int rDepth = treeHeight(node.right);
        if (lDepth > rDepth) {
            return lDepth + 1;
        } else {
            return rDepth + 1;
        }
    }

    public int treeHeightIt(Node node) {
        if (node == null) {
            return 0;
        }
        Stack<Node> nodeStack = new Stack<>();
        Node current = node;
        int depth = 0;
        int currentDepth = 0;
        while (current != null || !nodeStack.isEmpty()) {
            if (current != null) {
                nodeStack.push(current);
                current = current.left;
                currentDepth++;
            } else {
                current = nodeStack.pop();
                current = current.right;
                currentDepth--;
            }
            depth = depth > currentDepth ? depth : currentDepth;
        }
        return depth;
    }
}
