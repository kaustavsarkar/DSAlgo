package download.dsalgo.problems;

import java.util.*;

/**
 * Given an array of positive elements, you have to flip the sign of some of its
 * elements such that the resultant sum of the elements of array should be
 * minimum non-negative(as close to zero as possible). Return the minimum no. of
 * elements whose sign needs to be flipped such that the resultant sum is
 * minimum non-negative.
 * 
 * Constraints:
 * 
 * 1 <= n <= 100 Sum of all the elements will not exceed 10,000.
 * 
 * Example:
 * 
 * A = [15, 10, 6] ans = 1 (Here, we will flip the sign of 15 and the resultant
 * sum will be 1 )
 * 
 * A = [14, 10, 4] ans = 1 (Here, we will flip the sign of 14 and the resultant
 * sum will be 0)
 * 
 * Note that flipping the sign of 10 and 4 also gives the resultant sum 0 but
 * flippings there are not minimum
 * 
 * @author kaussark
 *
 */
public class Problem209 {

	public static void main(String[] args) {
		Integer[] array = { 10, 22, 9, 33, 21, 50, 41, 60 };
		 //{14, 10, 4};
		// { 15, 10, 6 };
		System.out.println(new Problem209()._solve(Arrays.asList(array)));
	}

	public int _solve(final List<Integer> A) {
		int[] a = new int[A.size()];
		for (int i = 0; i < a.length; i++) {
			a[i] = A.get(i);
		}
		int sum = 0;
		for (int x : a) {
			sum += x;
		}
		// find a subset with sum = sum/2 in a;
		int[][] dp = new int[sum / 2 + 1][a.length + 1];
		for (int i = 0; i <= a.length; i++) {
			dp[0][i] = 0;
		}
		for (int i = 1; i <= sum / 2; i++) {
			dp[i][0] = 1000000;
		}
		for (int currSum = 1; currSum <= sum / 2; currSum++) {
			for (int position = 1; position <= a.length; position++) {
				dp[currSum][position] = dp[currSum][position - 1];
				int value = a[position-1];
				if (currSum >= a[position - 1]) {
					if (dp[currSum][position] > dp[currSum - a[position - 1]][position - 1] + 1) {
						dp[currSum][position] = dp[currSum - a[position - 1]][position - 1] + 1;
					}
				}
			}
		}
		int max = 0;
		for (int i = 0; i <= sum / 2; i++) {
			if (dp[i][a.length] != 1000000) {
				max = i;
			}
		}
		return dp[max][a.length];
	}

	public int solve(final List<Integer> A) {
		if (A == null || A.isEmpty()) {
			return 0;
		}

		if (A.size() == 1) {
			return A.get(0);
		}

		int sum = 0;
		for (int num : A) {
			sum += num;
		}

		int[][] memo = new int[A.size()][A.size()];
		int min = -1;
		int start = 0;
		int end = 0;
		memo[0][0] = sum - 2 * A.get(0);

		if (memo[0][0] > 0) {
			min = memo[0][0];
			start = 0;
			end = 0;
		}

		for (int row = 0; row < A.size(); row++) {
			for (int col = 0; col < A.size(); col++) {
				if (col == 0 && row == 0) {
					continue;
				}
				if (col < row) {
					memo[row][col] = sum;
				} else if (col > 0) {
					memo[row][col] = memo[row][col - 1] - 2 * A.get(col);
					if (memo[row][col] > 0 && memo[row][col] < min) {
						start = row;
						end = col;
						min = memo[row][col];
					} else if (memo[row][col] > 0 && memo[row][col] < min
							&& end - start + 1 > col - row + 1) {
						start = row;
						end = col;
					}
				}
			}
		}

		if (start == end) {
			return 1;
		}

		return end - start;
	}
}
