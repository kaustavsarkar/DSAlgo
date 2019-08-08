package download.dsalgo.problems;

import download.dsalgo.poc.Strings;

/**
 * Given a string s1, we may represent it as a binary tree by partitioning it to
 * two non-empty substrings recursively.
 * 
 * Below is one possible representation of s1 = “great”:
 * 
 * 
 * great / \ gr eat / \ / \ g r e at / \ a t
 * 
 * To scramble the string, we may choose any non-leaf node and swap its two
 * children.
 * 
 * For example, if we choose the node “gr” and swap its two children, it
 * produces a scrambled string “rgeat”.
 * 
 * rgeat / \ rg eat / \ / \ r g e at / \ a t We say that “rgeat” is a scrambled
 * string of “great”.
 * 
 * Similarly, if we continue to swap the children of nodes “eat” and “at”, it
 * produces a scrambled string “rgtae”.
 * 
 * rgtae / \ rg tae / \ / \ r g ta e / \ t a We say that “rgtae” is a scrambled
 * string of “great”.
 * 
 * Given two strings s1 and s2 of the same length, determine if s2 is a
 * scrambled string of s1. Return 0/1 for this problem.
 * 
 * @author kaussark
 *
 */
public class Problem219 {

	public static void main(String[] args) {
		String a = "abbbcbaaccacaacc";
		String b = "acaaaccabcabcbcb";
		System.out.println(new Problem219().isScramble(a, b));
	}

	public int isScramble(String A, String B) {
		if (A == null || B == null) {
			return 0;
		}
		if (A.length() != B.length())
			return 0;
		if (A.equals(B))
			return 1;

		int length = A.length();
		boolean[][][] scrambleMemo = new boolean[A.length()][B.length()][length
				+ 1]; // for brevity which is col and row
		for (int len = 1; len <= length; len++) {
			for (int acount = 0; acount + len <= length; acount++) {
				for (int bcount = 0; bcount + len <= length; bcount++) {
					if (len == 1) {
						scrambleMemo[acount][bcount][len] = A
								.charAt(acount) == B.charAt(bcount);
					} else {
						for (int subLen = 1; subLen < len
								&& !scrambleMemo[acount][bcount][len]; subLen++) {
							scrambleMemo[acount][bcount][len] = (scrambleMemo[acount][bcount][subLen]
									&& scrambleMemo[acount + subLen][bcount
											+ subLen][len - subLen])
									|| (scrambleMemo[acount][bcount + len
											- subLen][subLen]
											&& scrambleMemo[acount
													+ subLen][bcount][len
															- subLen]);
						}
					}

				}
			}

		}
		return scrambleMemo[0][0][length] ? 1 : 0;

	}

	public int isScrambleRecur(final String A, final String B) {
		if (A == null || A.isEmpty() || B == null || B.isEmpty()) {
			return 0;
		}
		if (A.equals(B))
			return 1;
		if (A.length() != B.length())
			return 0;
		int lenA = A.length();
		int lenB = B.length();

		if (!isAnagram(A, B))
			return 0;

		int scramble = 0;

		for (int len = 1; len < lenA; len++) {
			scramble = scramble
					| (isScrambleRecur(A.substring(0, len), B.substring(0, len))
							& isScrambleRecur(A.substring(len),
									B.substring(len)))
					| (isScrambleRecur(A.substring(0, len),
							B.substring(lenB - len))
							& isScrambleRecur(A.substring(len),
									B.substring(0, lenB - len)));
		}
		return scramble;
	}

	private boolean isAnagram(String a, String b) {
		if (a.length() != b.length())
			return false;
		int[] characters = new int[256];
		for (int i = 0; i < a.length(); i++) {
			characters[a.charAt(i)]++;
			characters[b.charAt(i)]--;
		}
		for (int i = 0; i < a.length(); i++) {
			if (characters[a.charAt(i)] != 0)
				return false;
		}
		// System.out.println("inside is anagram "+true);
		return true;
	}
}
