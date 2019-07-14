package download.dsalgo.problems;

import java.util.Arrays;

/**
 * Implement strStr().
 * 
 * strstr - locate a substring ( needle ) in a string ( haystack ). Try not to
 * use standard library string functions for this question.
 * 
 * Returns the index of the first occurrence of needle in haystack, or -1 if
 * needle is not part of haystack.
 * 
 * NOTE: Good clarification questions: What should be the return value if the
 * needle is empty? What if both haystack and needle are empty? For the purpose
 * of this problem, assume that the return value should be -1 in both cases.
 * 
 * @author kaussark
 *
 */
public class Problem60 {

	public static void main(String[] args) {
		Problem60 problem = new Problem60();

		System.out.println(problem.strStr("HELLOWORLD", "LOW"));
		// System.out.println(Arrays.toString(problem.createRepPat("ABCD")));
	}

	public int strStr(final String A, final String B) {
		int index = -1;
		if (A == null || A.isEmpty() || B == null || B.isEmpty()
				|| A.length() < B.length()) {
			return index;
		}

		int[] repPat = createRepPat(B);
		int a = 0;
		int b = 0;

		while (b < B.length() && a < A.length()) {
			if (A.charAt(a) == B.charAt(b)) {
				a++;
				b++;
			} else if (b == 0) {
				a++;
			} else if (b > 0 && A.charAt(a) != B.charAt(b)) {
				b = repPat[b - 1];
			}
		}

		if (b == B.length()) {
			index = a - b;
		}

		return index;
	}

	private int[] createRepPat(String b) {
		int[] length = new int[b.length()];
		int sentinel = 1;
		int succ = 0;
		length[0] = 0;
		while (sentinel < b.length()) {
			if (b.charAt(sentinel) == b.charAt(succ)) {
				length[sentinel] = length[succ] + 1;
				sentinel++;
				succ++;
			} else if (succ == 0) {
				length[sentinel] = 0;
				sentinel++;
			} else {
				succ = length[succ - 1];
			}
		}

		return length;
	}

}
