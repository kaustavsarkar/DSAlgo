package download.dsalgo.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Two elements of a binary search tree (BST) are swapped by mistake. Tell us
 * the 2 values swapping which the tree will be restored.
 * 
 * Note: A solution using O(n) space is pretty straight forward. Could you
 * devise a constant space solution? Example :
 * 
 * 
 * Input : 1 / \ 2 3
 * 
 * Output : [1, 2]
 * 
 * Explanation : Swapping 1 and 2 will change the BST to be 2 / \ 1 3 which is a
 * valid BST
 * 
 * @author kaussark
 *
 */
public class Problem160 {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(7);
		root.right = new TreeNode(15);
		root.left.left = new TreeNode(20);
		root.left.left.right = new TreeNode(8);
		root.left.left.left = new TreeNode(6);
		root.right.right = new TreeNode(24);
		root.right.left = new TreeNode(9);
		root.right.right.left = new TreeNode(23);
		root.right.right.right = new TreeNode(25);
		root.right.left.left = new TreeNode(11);
		root.right.left.right = new TreeNode(16);

		System.out.println(new Problem160().recoverTree(root));
	}
	TreeNode first = null, second = null;
	TreeNode prev = null;
	
	public void inorder(TreeNode root) {
	    if(root == null) return;
	    
	    inorder(root.left);
	
	    if(prev!=null) {
	        if(root.val < prev.val) {
	            if(first == null) first = prev;
	            second = root;
	        }
	    }
	    //if(first !=null && second != null) return; 
	    //if(root.val > 300)
	    //System.out.print(root.val + " ==> ");
	    prev = root;
	    
	    inorder(root.right);
	    
	}
	
	public ArrayList<Integer> _recoverTree(TreeNode a) {
	    
	    inorder(a);
	    ArrayList<Integer> out = new ArrayList<Integer>();
	    
	    if(second == null) {
	        out.add(first.val);
	        out.add(prev.val);
	    }
	    else if(first.val < second.val) {
	        out.add(first.val);
	        out.add(second.val);
	    }
	    else {
	        out.add(second.val);
	        out.add(first.val);
	    }
	    
	    
	    return out;
	}
	TreeNode previousNode = null;

	public ArrayList<Integer> recoverTree(TreeNode A) {
		ArrayList<Integer> vals = new ArrayList<>();
		recoverHelper(A, vals);
		return vals;
	}

	public void recoverHelper(TreeNode node, List<Integer> anomalous) {

		if (node == null) {
			return;
		}
		recoverHelper(node.left, anomalous);
		if (previousNode != null && anomalous.isEmpty()
				&& previousNode.val > node.val) {
			anomalous.add(previousNode.val);
		}
		if (!anomalous.isEmpty() && previousNode != null
				&& previousNode.val > node.val) {
			anomalous.add(node.val);
		}
		previousNode = node;
		recoverHelper(node.right, anomalous);

	}
}
