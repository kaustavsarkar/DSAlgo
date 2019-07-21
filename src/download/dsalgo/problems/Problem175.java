package download.dsalgo.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.xml.stream.events.Characters;

/**
 * A message containing letters from A-Z is being encoded to numbers using the
 * following mapping:
 * 
 * 'A' -> 1 'B' -> 2 ... 'Z' -> 26 Given an encoded message containing digits,
 * determine the total number of ways to decode it.
 * 
 * Example :
 * 
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 * 
 * The number of ways decoding "12" is 2.
 * 
 * @author kaussark
 *
 */
public class Problem175 {

	// A - 65
	// 1-49
	public static void main(String[] args) {
		String input = "1223";
		System.out.println(new Problem175().numDecodings(input));
	}

	public int _numDecodings(String str) {
		int n = str.length();
		if (str == null || n == 0)
			return 0;
		int dp[] = new int[n + 1];
		dp[0] = 1;
		if (str.charAt(0) != '0')
			dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			int first = Integer.parseInt(str.substring(i - 1, i));
			int second = Integer.parseInt(str.substring(i - 2, i));
			if (first >= 1 && first <= 9)
				dp[i] += dp[i - 1];
			if (second >= 10 && second <= 26)
				dp[i] += dp[i - 2];
		}
		return dp[n];
	}

	public int numDecodings(String string) {
		int[] possibilities = new int[string.length() + 1];

		possibilities[0] = 1;
		
		if (string.charAt(0) != '0') {
			possibilities[1] = 1;
		}

		for (int i = 2; i <= string.length(); i++) {

			int first = Integer.parseInt(string.substring(i-1, i));
			int second = Integer.parseInt(string.substring(i - 2, i));

			if (first > 0 && first <= 9) {
				possibilities[i] = possibilities[i - 1];
			}
			if (second >= 10 && second <= 26) {
				possibilities[i] = possibilities[i] + possibilities[i - 2];
			}

		}

		return possibilities[string.length()];
	}
}
