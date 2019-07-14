package download.dsalgo.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Write a function to find the longest common prefix string amongst an array of
 * strings.
 * 
 * Longest common prefix for a pair of strings S1 and S2 is the longest string S
 * which is the prefix of both S1 and S2.
 * 
 * As an example, longest common prefix of "abcdefgh" and "abcefgh" is "abc".
 * 
 * Given the array of strings, you need to find the longest S which is the
 * prefix of ALL the strings in the array.
 * 
 * Example:
 * 
 * Given the array as:
 * 
 * [
 * 
 * "abcdefgh",
 * 
 * "aefghijk",
 * 
 * "abcefgh" ] The answer would be “a”.
 * 
 * @author kaussark
 *
 */
public class Problem54 {

	public static void main(String[] args) {
		String[] strings = {"abcd", "abde", "abcf"};
//			{
//				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
//				"aaaaaaaaaaaaa", "aaaa", "aaaaaaaaaaaaaaaaaaaa",
//				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
//				"aaaaaaaaaaa",
//				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
//				"a", "aaaaaaaaaaaaaaaaaaaa",
//				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
//				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
//				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
//				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
//				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
//				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
//				"aaaaaaa",
//				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
//				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" };
		// { "abcdefgh", "aefghijk", "abcefgh" };
		ArrayList<String> input = new ArrayList<>(Arrays.asList(strings));

		Problem54 problem = new Problem54();

		System.out.println(problem.longestCommonPrefix(input));

	}

	public String longestCommonPrefix(ArrayList<String> A) {
		StringBuilder prefix = new StringBuilder();
		int col = 0;
		int sum = 0;
		while (col < A.get(0).length()) {
			int row = 0;
			sum = 0;
			while (row < A.size() && col < A.get(row).length()) {
				sum += A.get(row).charAt(col);
				row++;
			}

			if (A.get(0).charAt(col) * A.size() == sum) {
				prefix.append(A.get(row - 1).charAt(col));
			} else {
				return prefix.toString();
			}
			col++;
		}

		return prefix.toString();
	}

}
