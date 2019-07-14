package download.dsalgo.problems;

import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Given a string, find the rank of the string amongst its permutations sorted
 * lexicographically. Assume that no characters are repeated.
 * 
 * Example :
 * 
 * Input : 'acb' Output : 2
 * 
 * The order permutations with letters 'a', 'c', and 'b' : abc acb bac bca cab
 * cba The answer might not fit in an integer, so return your answer % 1000003
 * 
 * @author kaussark
 *
 */
public class Problem39 {

	public static void main(String[] args) {
		Problem39 problem = new Problem39();
		int rank = problem.findRank("VIEW");
		System.out.println(rank);
	}

	public int findRank(String s) {
		final int m = 1000003;
		final int n = s.length();
		final int[] f = new int[n + 1];
		f[0] = f[1] = 1;
		for (int i = 2; i <= n; i++) {
			f[i] = f[i - 1] * i;
			f[i] %= m;
		}

		int rank = 0;

		final SortedSet<Character> set = new TreeSet<>();

		for (int i = n - 1; i >= 0; i--) {
			final char c = s.charAt(i);
			final int less = set.headSet(c).size();

			rank += less * f[n - 1 - i];
			rank %= m;

			set.add(c);
		}

		return rank + 1;
	}

	private int getFactorial(int i) {
		int fact = 1;
		if (i == 0 || i == 1) {
			return fact;
		}

		for (int k = 2; k <= i; k++) {
			fact *= k;
		}

		return fact;
	}
}
