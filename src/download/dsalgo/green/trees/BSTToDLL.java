package download.dsalgo.green.trees;

/**
 * @author: Kaustav Sarkar
 * @created: 9/5/2019
 */
public class BSTToDLL {
    private static class Node {
        Node left;
        Node right;
        int data;
        public Node(int data) {
            this.data = data;
        }

        public String toString() {
            return String.valueOf(data);
        }
    }
    public static void main(String[] args) {
        // Let us create the tree shown in above diagram
        Node tree  = new Node(10);
        tree.left = new Node(12);
        tree.right = new Node(15);
        tree.left.left = new Node(25);
        tree.left.right = new Node(30);
        tree.right.left = new Node(36);

        BSTToDLL dll = new BSTToDLL();
        Node root = dll.bToDLL(tree);

        while(root != null) {
            System.out.println(root.data);
            root = root.right;
        }
    }

    Node head;
    Node bToDLL(Node root)
    {
        if(root == null) {
            return root;
        }
        head = bToDLLUtil(root);
        while(head != null && head.left != null) {
            head = head.left;
        }
        return head;
    }
    Node bToDLLUtil(Node root) {
        if(root == null) {
            return root;
        }
        if(root.left != null) {
            Node leftNode = bToDLLUtil(root.left);

            while(leftNode.right != null) leftNode = leftNode.right;

            leftNode.right = root;
            root.left = leftNode;

        }

        if(root.right != null) {
            Node rightNode = bToDLLUtil(root.right);
            while(rightNode.left != null) rightNode = rightNode.left;

            rightNode.left = root;
            root.right = rightNode;
        }
        return root;
    }
}
