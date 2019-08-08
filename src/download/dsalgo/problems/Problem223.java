package download.dsalgo.problems;

public class Problem223 {

	public static void main(String[] args) {
		System.out.println(new Problem223().maxPathSum(null));
	}

	int sum;

	public int maxPathSum(TreeNode A) {
		sum = Integer.MIN_VALUE;
		if (A == null) {
			return sum;
		}

		maxPathSumHelper(A);

		return sum;
	}

	private int maxPathSumHelper(TreeNode a) {
		if (a == null) {
			return 0;
		}

		int leftSum = maxPathSumHelper(a.left);
		int rightSum = maxPathSumHelper(a.right);

		int oneChildNodeSum = Math.max(a.val,
				a.val + Math.max(leftSum, rightSum));
		int childrenNodeSum = Math.max(oneChildNodeSum,
				leftSum + rightSum + a.val);
		
		sum = Math.max(childrenNodeSum, sum);
		
		return oneChildNodeSum;

	}
}
