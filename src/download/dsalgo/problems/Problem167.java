package download.dsalgo.problems;

/**
 * Given a binary tree, find its minimum depth.
 * 
 * The minimum depth is the number of nodes along the shortest path from the
 * root node down to the nearest leaf node.
 * 
 * NOTE : The path has to end on a leaf node. Example :
 * 
 * 1 / 2 min depth = 2.
 * 
 * @author kaussark
 *
 */
public class Problem167 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minDepth(TreeNode node) {
		if (node == null) {
			return 0;
		}
		if(node.left == null && node.right == null) {
			return 1;
		}
		int leftHeight = node.left != null ?minDepth(node.left) : Integer.MAX_VALUE;
		int rightHeight = node.right != null ? minDepth(node.right) : Integer.MAX_VALUE;
		
		return 1+Math.min(leftHeight, rightHeight);
	}
}
