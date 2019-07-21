package download.dsalgo.problems;

/**
 * Given a binary tree, invert the binary tree and return it. Look at the
 * example for more details.
 * 
 * Example : Given binary tree
 * 
 * 1 / \ 2 3 / \ / \ 4 5 6 7 invert and return
 * 
 * 1 / \ 3 2 / \ / \ 7 6 5 4
 * 
 * @author kaussark
 *
 */
public class Problem161 {

	public static void main(String[] args) {

	}

	public TreeNode invertTree(TreeNode A) {
		if (A == null) {
			return null;
		}
		TreeNode leftChild = invertTree(A.left);
		TreeNode rightChild = invertTree(A.right);

		A.left = rightChild;
		A.right = leftChild;

		return A;
	}
}
