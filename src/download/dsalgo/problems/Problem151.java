package download.dsalgo.problems;

public class Problem151 {

	public static void main(String[] args) {

	}

	public int isSameTree(TreeNode A, TreeNode B) {
		if (A == null && B == null) {
			return 1;
		}
		if (A == null || B == null) {
			return 0;
		}

		int isDataEqual = A.val == B.val ? 1 : 0;

		return isDataEqual & isSameTree(A.left, B.left)
				& isSameTree(A.right, B.right);
	}
}
