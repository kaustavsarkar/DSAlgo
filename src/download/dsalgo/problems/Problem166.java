package download.dsalgo.problems;

import java.util.Stack;

/**
 * Given a binary tree, find its maximum depth.
 * 
 * The maximum depth of a binary tree is the number of nodes along the longest
 * path from the root node down to the farthest leaf node.
 * 
 * NOTE : The path has to end on a leaf node. Example :
 * 
 * 1 / 2 max depth = 2.
 * 
 * @author kaussark
 *
 */
public class Problem166 {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		System.out.println(new Problem166().maxDepth(root));
	}
	 public int _maxDepth(TreeNode A) {
	        if(A==null){
	            return 0;
	        }
	        int left = 1+maxDepth(A.left);
	        int right = 1+maxDepth(A.right);
	        return Math.max(left,right);
	    }
	public int maxDepth(TreeNode A) {
		int maxDepth = 0;
		int currentDepth = 0;
		Stack<TreeNode> nodeStack = new Stack<>();
		TreeNode current = A;

		while (current != null || !nodeStack.isEmpty()) {
			if (current != null) {
				currentDepth++;
				nodeStack.push(current);
				current = current.left;
			} else {
				current = nodeStack.pop();
				--currentDepth;
				current = current.right;
			}
			
			maxDepth = Math.max(maxDepth, currentDepth);
		}

		return maxDepth+1;
	}

}
