package download.dsalgo.problems;

/**
 * Implement wildcard pattern matching with support for '?' and '*'.
 * 
 * '?' : Matches any single character. '*' : Matches any sequence of characters
 * (including the empty sequence). The matching should cover the entire input
 * string (not partial).
 * 
 * The function prototype should be:
 * 
 * int isMatch(const char *s, const char *p) Examples :
 * 
 * isMatch("aa","a") → 0 isMatch("aa","aa") → 1 isMatch("aaa","aa") → 0
 * isMatch("aa", "*") → 1 isMatch("aa", "a*") → 1 isMatch("ab", "?*") → 1
 * isMatch("aab", "c*a*b") → 0 Return 1/0 for this problem.
 * 
 * @author kaussark
 *
 */
public class Problem217 {

	public static void main(String[] args) {
		String string = 
				//"bbbcbcb"; 
				//"bcabbbbcb";
		 "bb";
		// "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		String regex = //"**b"; 
				"?b*?b*b";
		 //"bca*aaa*b*bb";
		 //"a**************************************************************************************";
		System.out.println(new Problem217()._isMatch(string, regex));
	}

	public int _isMatch(final String A, final String B) {

		if (B.equals("*"))
			return 1;

		int aLength = A.length();
		int bLength = B.length();

		int[] prevMem = new int[aLength + 1];// Stores previous data
		int[] currMem = new int[aLength + 1];// Stores current data

		prevMem[0] = 1;

		for (int bCounter = 1; bCounter <= bLength; bCounter++) {
			for (int aCounter = 0; aCounter <= aLength; aCounter++) {
				char character = aCounter > 0 ? A.charAt(aCounter - 1) : '\0';
				char patt = bCounter > 0 ? B.charAt(bCounter - 1) : '\0';
				if (aCounter == 0) {
					currMem[aCounter] = computeMatch(prevMem, currMem,
							character, patt, aCounter, bCounter);
				} else {
					currMem[aCounter] = computeMatch(prevMem, currMem,
							character, patt, aCounter, bCounter);
				}

			}
			prevMem = currMem.clone();
		}

		return currMem[aLength];
	}

	private int computeMatch(int[] prevMem, int[] currMem, char character,
			char pattern, int aCounter, int bCounter) {
		if (pattern == '?' || pattern == character) {
			return aCounter == 0 ? 0 : prevMem[aCounter - 1];
		} else if (pattern == '*') {
			return aCounter == 0 ? prevMem[aCounter]
					: prevMem[aCounter] | currMem[aCounter - 1];
		}
		return 0;
	}

	public int isMatch(final String A, final String B) {
		if (B.equals("*")) {
			return 1;
		}
		int aLength = A.length();
		int bLength = B.length();
		int memo[][] = new int[bLength + 1][aLength + 1]; // fails heap check
		memo[0][0] = 1;
		for (int bCounter = 1; bCounter <= bLength; bCounter++) {
			for (int aCounter = 0; aCounter <= aLength; aCounter++) {
				char aChar = aCounter > 0 ? A.charAt(aCounter - 1) : '\0';
				char bChar = bCounter > 0 ? B.charAt(bCounter - 1) : '\0';
				if (bCounter == 0) {
					memo[bCounter][aCounter] = 0;
					// System.out.print(memo[bCounter][aCounter]);
				} else if (aCounter == 0) {
					memo[bCounter][aCounter] = computeMatch(memo, aChar, bChar,
							aCounter, bCounter);
					// System.out.print(memo[bCounter][aCounter]);
				} else {
					memo[bCounter][aCounter] = computeMatch(memo, aChar, bChar,
							aCounter, bCounter);
					// System.out.print(memo[bCounter][aCounter]);
				}
			}
			// System.out.println();
		}
		return memo[bLength][aLength];
	}

	private int computeMatch(int[][] memo, char character, char regex,
			int aCounter, int bCounter) {
		if (regex == '?' || regex == character) {
			return aCounter == 0 && regex == '?' ? 0
					: memo[bCounter - 1][aCounter - 1];
		} else if (regex == '*') {
			return aCounter == 0 ? memo[bCounter - 1][aCounter]
					: memo[bCounter - 1][aCounter]
							| memo[bCounter][aCounter - 1];
		} else {
			return 0;
		}
	}
}
