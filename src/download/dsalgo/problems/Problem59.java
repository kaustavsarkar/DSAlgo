package download.dsalgo.problems;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * Given a string S, find the longest palindromic substring in S.
 * 
 * Substring of string S:
 * 
 * S[i...j] where 0 <= i <= j < len(S)
 * 
 * Palindrome string:
 * 
 * A string which reads the same backwards. More formally, S is palindrome if
 * reverse(S) = S.
 * 
 * Incase of conflict, return the substring which occurs first ( with the least
 * starting index ).
 * 
 * Example :
 * 
 * Input : "aaaabaaa" Output : "aaabaaa"
 * 
 * @author kaussark
 *
 */
public class Problem59 {

	public static void main(String[] args) {
		String input = "cbbd";
		ManarchersAlgo man = new Problem59.ManarchersAlgo();
		//System.out.println(Integer.MAX_VALUE);
		//System.out.println(Integer.MIN_VALUE);
		//System.out.println(Long.MIN_VALUE);
		//System.out.println(-2%10);
		BigDecimal b = new BigDecimal("-9223372036854775808");
		System.out.println(b.compareTo(new BigDecimal(Integer.MAX_VALUE)));
		System.out.println(b.intValue());
		System.out.println(man.longestPalindrome(input));
	}

	private static class ManarchersAlgo {

		public String longestPalindrome(String A) {
			StringBuilder pallin = new StringBuilder();

			char[] array = addHash(A);
			int[] length = new int[array.length];

			int center = 0;
			int rightBoundary = 0;
			int maxIndex = 0;

			for (int i = 1; i < array.length; i++) {
				int mirror = 2 * center - i < 0 ? 0 :length[2 * center - i];

				if (i < rightBoundary) {
					length[i] = Math.min(mirror, rightBoundary - i);
				}

				length[i] = pallindromLength(array, length[i], i);

				if (i + length[i] > rightBoundary) {
					center = i;
					rightBoundary = i + length[i];
				}

				if (length[maxIndex] < length[i]) {
					maxIndex = i;

				}
			}
			
			int start = maxIndex - length[maxIndex];
			int end = maxIndex + length[maxIndex];
			

			for (int i = start; i <= end; i++ ) {
				if (array[i] != '#') {
					pallin.append(array[i]);
				}
			}

			return pallin.toString();
		}

		public char[] addHash(String s) {
			char[] array = new char[2*s.length() + 1];

			int counter = 0;
			for (char c : s.toCharArray()) {
				array[counter] = '#';
				array[++counter] = c;
				counter++;
			}
			array[counter] = '#';
			return array;
		}

		public int pallindromLength(char[] array, int length, int index) {
			int start = index - length - 1;
			int end = index + length + 1;

			while (start >= 0 && end < array.length) {
				if (array[start--] == array[end++]) {
					length++;
				} else {
					break;
				}
			}
			return length;
		}

	}

}
