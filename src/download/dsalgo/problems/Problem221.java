package download.dsalgo.problems;

import java.util.*;

/**
 * You are given two positive integers A and B. For all permutations of [1, 2,
 * …, A], we create a BST. Count how many of these have height B.
 * 
 * Notes:
 * 
 * Values of a permutation are sequentially inserted into the BST by general
 * rules i.e in increasing order of indices. Height of BST is maximum number of
 * edges between root and a leaf. Return answer modulo 109 + 7. Expected time
 * complexity is worst case O(N4). 1 ≤ N ≤ 50 For example,
 * 
 * A = 3, B = 1
 * 
 * Two permutations [2, 1, 3] and [2, 3, 1] generate a BST of height 1. In both
 * cases the BST formed is
 * 
 * 2 / \ 1 3
 * 
 * 
 * Another example, A = 3, B = 2 Return 4.
 * 
 * Next question, can you do the problem in O(N3)?
 * 
 * @author kaussark
 *
 */
public class Problem221 {

	public static void main(String[] args) {

	}

	List<Integer> leftTree;
	List<Integer> rightTree;

	public int cntPermBST(int A, int B) {
		if (B > A || B == 0)
			return 0;
		long MOD = 1000000007;
		long[][] dp = new long[A + 1][B + 2];
		long[][] C = new long[A + 1][A + 1];

		for (int n = 0; n <= A; n++) {
			C[n][0] = 1;
			C[n][n] = 1;
		}

		for (int n = 1; n <= A; n++) {
			for (int r = 1; r < n; r++) {
				C[n][r] = (C[n - 1][r - 1] + C[n - 1][r]) % MOD;
			}
		}

		for (int h = 0; h <= B + 1; h++) {
			dp[0][h] = 1;
		}

		for (int a = 1; a <= A; a++) {
			for (int h = 1; h <= (B + 1); h++) {
				long ans = 0;
				for (int i = 0; i < a; i++) {
					long t = ((dp[i][h - 1] * dp[a - i - 1][h - 1])) % MOD;
					if (h > 1)
						t = (t + MOD
								- (dp[i][h - 2] * dp[a - i - 1][h - 2]) % MOD)
								% MOD;
					t = (t * C[a - 1][i]) % MOD;
					ans = (ans + t) % MOD;
				}
				ans %= MOD;
				dp[a][h] = (dp[a][h - 1] + ans) % MOD;
			}
		}
		return (int) ((dp[A][B + 1] - dp[A][B] + MOD) % MOD);
	}
}
