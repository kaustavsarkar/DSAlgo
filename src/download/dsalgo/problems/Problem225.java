package download.dsalgo.problems;

/**
 * Given a string s, partition s such that every substring of the partition is a
 * palindrome.
 * 
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * 
 * Example : Given s = "aab", Return 1 since the palindrome partitioning
 * ["aa","b"] could be produced using 1 cut.
 * 
 * @author kaussark
 *
 */
public class Problem225 {

	public static void main(String[] args) {

	}

	public int minCut(String A) {
		if (A == null || A.isEmpty() || A.length() == 1) {
			return 0;
		}
		int length = A.length();
		boolean isPallin[][] = new boolean[length][length];
		int[] cuts = new int[length];

		// establish pallindromes
		// For same index
		for (int index = 0; index < length; index++) {
			isPallin[index][index] = true;
		}

		// For len 2->len
		for (int len = 2; len <= length; len++) {
			for (int start = 0; start < length - len + 1; start++) {
				int end = start + len - 1;
				if (len == 2) {
					isPallin[start][end] = A.charAt(start) == A.charAt(end);
				} else {
					isPallin[start][end] = A.charAt(start) == A.charAt(end)
							&& isPallin[start + 1][end - 1];
				}
			}
		}

		// check cuts
		for (int charIndex = 0; charIndex < length; charIndex++) {
			if (isPallin[0][charIndex]) {
				cuts[charIndex] = 0;
			} else {
				cuts[charIndex] = Integer.MAX_VALUE;
				for (int prevIndex = 0; prevIndex < charIndex; prevIndex++) {
					if (isPallin[prevIndex + 1][charIndex]
							&& 1 + cuts[prevIndex] < cuts[charIndex]) {
						cuts[charIndex] = 1 + cuts[prevIndex];
					}
				}
			}
		}

		return cuts[length - 1];
	}

}
