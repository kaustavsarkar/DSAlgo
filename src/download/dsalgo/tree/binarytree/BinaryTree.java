package download.dsalgo.tree.binarytree;

import java.util.*;

/**
 * @author: Kaustav Sarkar
 * @created: 8/11/2019
 */
public class BinaryTree<T> {
    private static class TreeNode<T> {
        TreeNode left;
        TreeNode right;
        T value;
        int level;

        public TreeNode(T value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

        public TreeNode(T value, int level) {
            this(value);
            this.level = level;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }
    private int height;

    public int getHeight(){
        return this.height;
    }

    /**
     * left right parent
     * @param root
     * @return
     */
    public List<TreeNode<T>> postOrderRecursive(TreeNode<T> root) {
        List<TreeNode<T>> postOrder = new ArrayList<>();

        postOrderRecurHelper(root, postOrder);

        return postOrder;
    }

    private void postOrderRecurHelper(TreeNode<T> root, List<TreeNode<T>> postOrder) {
        if(root == null) {
            return;
        }
        postOrderRecurHelper(root.left, postOrder);
        postOrderRecurHelper(root.right, postOrder);
        postOrder.add(root);
    }

    public List<TreeNode<T>> postOrderIterative(TreeNode<T> root) {
        List<TreeNode<T>> postOrder = new ArrayList<>();
        Stack<TreeNode<T>> nodeStack = new Stack<>();
        TreeNode<T> current = root;
        while(current != null || !nodeStack.isEmpty()) {
            if(current != null) {
                nodeStack.push(current);
                current = current.left;
            } else {
                TreeNode parent = nodeStack.peek();
                //check if right child is visited
                if(!postOrder.isEmpty() && postOrder.get(postOrder.size()-1).equals(parent.right)) {
                    postOrder.add(nodeStack.pop());
                } else if(parent.right == null) {
                    postOrder.add(nodeStack.pop());
                }else {
                    current = parent.right;
                }
            }
            height = Math.max(height, nodeStack.size());
        }
        return postOrder;
    }

    public List<TreeNode<T>> preOrderRecursive(TreeNode<T> root) {
        List<TreeNode<T>> preOrder = new ArrayList<>();
        preOrderRecurHelper(root, preOrder);
        return preOrder;
    }

    private void preOrderRecurHelper(TreeNode<T> root, List<TreeNode<T>> preOrder) {
        if(root == null) {
            return;
        }
        preOrder.add(root);
        preOrderRecurHelper(root.left, preOrder);
        preOrderRecurHelper(root.right, preOrder);

    }

    public List<TreeNode<T>> preOrderIterative(TreeNode<T> root) {
        List<TreeNode<T>> inOrder = new ArrayList<>();
        Stack<TreeNode<T>> nodeStack = new Stack<>();
        TreeNode<T> current =  root;
        while(!nodeStack.isEmpty() || current != null) {
            if(current != null) {
                inOrder.add(current);
                nodeStack.add(current);
                current = current.left;
            } else {
                current = nodeStack.pop().right;
            }
        }
        return inOrder;
    }

    public List<TreeNode<T>> inorderRecursive(TreeNode<T> root) {
        List<TreeNode<T>> inorder = new ArrayList<>();

        inorderRecurHelper(root,inorder);

        return inorder;
    }

    private void inorderRecurHelper(TreeNode<T> root, List<TreeNode<T>> inorder) {
        if(root == null) {
            return;
        }
        inorderRecurHelper(root.left, inorder);
        inorder.add(root);
        inorderRecurHelper(root.right, inorder);
    }

    public List<TreeNode<T>> inorderIterative(TreeNode<T> root) {
        List<TreeNode<T>> inorder = new ArrayList<>();
        Stack<TreeNode<T>> nodeStack = new Stack<>();
        TreeNode current = root;

        while(current!=null || !nodeStack.isEmpty()) {
            if(current != null) {
                nodeStack.push(current);
                current = current.left;
            } else {
                current = nodeStack.peek().right;
                inorder.add(nodeStack.pop());
            }
        }
        return inorder;
    }

    public List<TreeNode<T>> levelOrderIterative(TreeNode<T> root) {
        Queue<TreeNode<T>> nodeQ = new LinkedList<>();
        List<TreeNode<T>> levelOrder = new ArrayList<>();
        nodeQ.offer(root);
        while(!nodeQ.isEmpty()) {
            TreeNode<T> current = nodeQ.poll();
            levelOrder.add(current);
            if(current.left != null) nodeQ.offer(current.left);
            if(current.right != null) nodeQ.offer(current.right);
        }
        return levelOrder;
    }


    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(4);
        root.left.left.right.left = new TreeNode(5);
        root.left.left.right.right = new TreeNode(6);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(9);
        root.right.right.left = new TreeNode(10);

        BinaryTree<Integer> binaryTree = new BinaryTree();

        System.out.println(binaryTree.postOrderIterative(root));
        System.out.println(binaryTree.postOrderRecursive(root));
        System.out.println(binaryTree.preOrderRecursive(root));
        System.out.println(binaryTree.preOrderIterative(root));
        System.out.println(binaryTree.inorderIterative(root));
        System.out.println(binaryTree.inorderRecursive(root));
        System.out.println(binaryTree.levelOrderIterative(root));
        System.out.println(binaryTree.getHeight());

    }
}
