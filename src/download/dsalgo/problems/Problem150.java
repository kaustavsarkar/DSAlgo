package download.dsalgo.problems;

/**
 * Given a binary tree, determine if it is height-balanced.
 * 
 * Height-balanced binary tree : is defined as a binary tree in which the depth
 * of the two subtrees of every node never differ by more than 1. Return 0 / 1 (
 * 0 for false, 1 for true ) for this problem
 * 
 * Example :
 * 
 * Input : 1 / \ 2 3
 * 
 * Return : True or 1
 * 
 * Input 2 : 3 / 2 / 1
 * 
 * Return : False or 0 Because for the root node, left subtree has depth 2 and
 * right subtree has depth 0. Difference = 2 > 1.
 * 
 * @author kaussark
 *
 */
public class Problem150 {

	public static void main(String[] args) {

	}

	public int isBalanced(TreeNode A) {
		if(checkBalanced(A) > 0) {
			return 1;
		}
		
		return 0;
	}

	public int checkBalanced(TreeNode node) {
		if (node == null) {
			return 0;
		}
		int leftHeight = checkBalanced(node.left);
		int rightHeight = checkBalanced(node.right);

		if (leftHeight == -1 || rightHeight == -1)
			return -1;
		if (Math.abs(leftHeight - rightHeight) > 1)
			return -1;

		return Math.max(leftHeight, rightHeight) + 1;
	}
}
