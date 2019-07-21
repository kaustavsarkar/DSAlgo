package download.dsalgo.problems;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric
 * around its center).
 * 
 * Example :
 * 
 * 1 / \ 2 2 / \ / \ 3 4 4 3 The above binary tree is symmetric. But the
 * following is not:
 * 
 * 1 / \ 2 2 \ \ 3 3 Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 * 
 * @author kaussark
 *
 */
public class Problem152 {

	public static void main(String[] args) {

	}

	public int isSymmetric(TreeNode A) {
		if (A == null) {
			return 1;
		}
		return checkSymmetry(A.left, A.right);
	}

	public int checkSymmetry(TreeNode leftSubTree, TreeNode rightSubTree) {
		if (rightSubTree == null && leftSubTree == null) {
			return 1;
		}

		if (rightSubTree == null || leftSubTree == null) {
			return 0;
		}

		int isValueEqual = rightSubTree.val == leftSubTree.val ? 1 : 0;

		return isValueEqual
				& checkSymmetry(leftSubTree.right, rightSubTree.left)
				& checkSymmetry(leftSubTree.left, rightSubTree.right);
	}
}
