package download.dsalgo.problems;

/**
 * Implement regular expression matching with support for '.' and '*'.
 * 
 * '.' Matches any single character. '*' Matches zero or more of the preceding
 * element.
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * The function prototype should be:
 * 
 * int isMatch(const char *s, const char *p) Some examples:
 * 
 * isMatch("aa","a") → 0 isMatch("aa","aa") → 1 isMatch("aaa","aa") → 0
 * isMatch("aa", "a*") → 1 isMatch("aa", ".*") → 1 isMatch("ab", ".*") → 1
 * isMatch("aab", "c*a*b") → 1 Return 0 / 1 ( 0 for false, 1 for true ) for this
 * problem
 * 
 * @author kaussark
 *
 */
public class Problem218 {

	public static void main(String[] args) {
		String string = "abbbc";
		String pattern = "ab*c";
		System.out.println(new Problem218().isMatch(string, pattern));
	}

	public int isMatch(final String string, final String pattern) {
		if ((string == null || string.isEmpty())
				&& (pattern == null || pattern.isEmpty())) {
			return 1;
		}
		if ((string == null || string.isEmpty())
				&& (pattern != null && !pattern.isEmpty())) {
			return 0;
		}
		if (pattern.equals(".*")) {
			return 1;
		}
		int stringLen = string.length();
		int patternLen = pattern.length();
		boolean[][] memo = new boolean[stringLen + 1][patternLen + 1];
		memo[0][0] = true;
		// Fill rows for patterns like a*, a*b*
		for (int pattCount = 1; pattCount <= patternLen; pattCount++) {
			if (pattern.charAt(pattCount - 1) == '*') {
				memo[0][pattCount] = memo[0][pattCount - 2];
			}
		}

		for (int stringCount = 1; stringCount <= stringLen; stringCount++) {
			for (int pattCount = 1; pattCount <= patternLen; pattCount++) {
				char patt = pattern.charAt(pattCount - 1);
				char str = string.charAt(stringCount - 1);
				if (patt == '.' || patt == str) {
					memo[stringCount][pattCount] = memo[stringCount
							- 1][pattCount - 1];
				} else if (patt == '*') {
					memo[stringCount][pattCount] = memo[stringCount][pattCount
							- 2];
					if (pattern.charAt(pattCount - 1) == '.'
							|| pattern.charAt(pattCount - 2) == string
									.charAt(stringCount - 1)) {
						memo[stringCount][pattCount] = memo[stringCount][pattCount]
								|| memo[stringCount - 1][pattCount];
					}
				}
			}
		}

		return memo[stringLen][patternLen] ? 1 : 0;
	}
}
