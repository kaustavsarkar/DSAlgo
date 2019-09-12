package download.dsalgo.problems;

import java.util.Arrays;

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
		String string = "mississippi";
		String pattern = "mis*is*p*.";
		System.out.println(new Problem218()._isMatch(string, pattern));
	}
	public boolean _isMatch(String s, String p) {
		if(p.equals(".*")) {
			return true;
		}
		int patternSize = p.length();
		boolean[] prev = new boolean[patternSize + 1];
		boolean[] current = new boolean[patternSize + 1];
		prev[0] = true;

		//Initialise prev for blank string
		for(int patIndex = 0; patIndex < patternSize; patIndex++) {
			if(p.charAt(patIndex) == '*') {
				prev[patIndex + 1] = prev[patIndex-1];
			}
		}
		System.out.println(Arrays.toString(prev));
		for(int stringIndex = 0; stringIndex < s.length(); stringIndex++) {
			for(int patIndex = 0; patIndex < patternSize; patIndex++) {
				current[patIndex+1] = false;
				if(p.charAt(patIndex) == '.' || p.charAt(patIndex) == s.charAt(stringIndex)) {
					current[patIndex + 1] = prev[patIndex];
				} else if(p.charAt(patIndex) == '*') {
					current[patIndex + 1] = current[patIndex - 1];
					if(p.charAt(patIndex) == '.' || p.charAt(patIndex - 1) == s.charAt(stringIndex)) {
						current[patIndex + 1] = current[patIndex + 1] || prev[patIndex + 1];
					}
				}
			}
			System.out.print(s.charAt(stringIndex));
			System.out.println(Arrays.toString(current));
			prev = current.clone();
		}

		return current[patternSize];
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
