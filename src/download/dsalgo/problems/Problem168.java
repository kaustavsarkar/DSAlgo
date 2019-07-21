package download.dsalgo.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path
 * could represent a number.
 * 
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * 
 * Find the total sum of all root-to-leaf numbers % 1003.
 * 
 * Example :
 * 
 * 1 / \ 2 3 The root-to-leaf path 1->2 represents the number 12. The
 * root-to-leaf path 1->3 represents the number 13.
 * 
 * Return the sum = (12 + 13) % 1003 = 25 % 1003 = 25.
 * 
 * @author kaussark
 *
 */
public class Problem168 {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		System.out.println(new Problem168().sumNumbers(root));
	}

	public int sumNumbers(TreeNode A) {
		return sumArrayHelper(A, 0);
	}

	public int sumArrayHelper(TreeNode node, int val) {
		if (node == null) {
			return 0;
		}
		val = (val * 10 + node.val)%1003;
		if (node.left == null && node.right == null) {
			return val;
		}

		int leftSum = sumArrayHelper(node.left, val);
		int rightSum = sumArrayHelper(node.right, val);
		return (leftSum + rightSum)%1003;
	}
}
