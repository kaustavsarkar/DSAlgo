package download.dsalgo.problems;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Implement an iterator over a binary search tree (BST). Your iterator will be
 * initialized with the root node of a BST.
 * 
 * The first call to next() will return the smallest number in BST. Calling
 * next() again will return the next smallest number in the BST, and so on.
 * 
 * Note: next() and hasNext() should run in average O(1) time and uses O(h)
 * memory, where h is the height of the tree. Try to optimize the additional
 * space complexity apart from the amortized time complexity.  * 
 * @author kaussark
 *
 */
public class Problem159 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	Queue<Integer> sortedTree;
	public Problem159(TreeNode root) {
		sortedTree = new LinkedList<>();
		performInorder(root);
	}
	private void performInorder(TreeNode root) {
		if(root == null) {
			return;
		}
		performInorder(root.left);
		sortedTree.add(root.val);
		performInorder(root.right);
	}
	
	 /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !sortedTree.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        if(sortedTree.isEmpty()) {
        	return Integer.MIN_VALUE;
        }
        return sortedTree.poll();
    }
}
