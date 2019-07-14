package download.dsalgo.problems;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * You are given an array A consisting of strings made up of the letters ‘a’ and
 * ‘b’ only. Each string goes through a number of operations, where:
 * 
 * 1. At time 1, you circularly rotate each string by 1 letter. 2. At time 2,
 * you circularly rotate the new rotated strings by 2 letters. 3. At time 3, you
 * circularly rotate the new rotated strings by 3 letters. 4. At time i, you
 * circularly rotate the new rotated strings by i % length(string) letters.
 * 
 * Eg: String is "abaa"
 * 
 * 1. At time 1, string is "baaa", as 1 letter is circularly rotated to the back
 * 2. At time 2, string is "aaba", as 2 letters of the string "baaa" is
 * circularly rotated to the back 3. At time 3, string is "aaab", as 3 letters
 * of the string "aaba" is circularly rotated to the back 4. At time 4, string
 * is again "aaab", as 4 letters of the string "aaab" is circularly rotated to
 * the back 5. At time 5, string is "aaba", as 1 letters of the string "aaab" is
 * circularly rotated to the back After some units of time, a string becomes
 * equal to it’s original self. Once a string becomes equal to itself, it’s
 * letters start to rotate from the first letter again (process resets). So, if
 * a string takes t time to get back to the original, at time t+1 one letter
 * will be rotated and the string will be it’s original self at 2t time. You
 * have to find the minimum time, where maximum number of strings are equal to
 * their original self. As this time can be very large, give the answer modulo
 * 109+7.
 * 
 * Note: Your solution will run on multiple test cases so do clear global
 * variables after using them.
 * 
 * Input:
 * 
 * A: Array of strings. Output:
 * 
 * Minimum time, where maximum number of strings are equal to their original
 * self. Constraints:
 * 
 * 1 <= size(A) <= 10^5 1 <= size of each string in A <= 10^5 Each string
 * consists of only characters 'a' and 'b' Summation of length of all strings <=
 * 10^7 Example:
 * 
 * Input
 * 
 * A: [a,ababa,aba] Output
 * 
 * 4
 * 
 * String 'a' is it's original self at time 1, 2, 3 and 4. String 'ababa' is
 * it's original self only at time 4. (ababa => babaa => baaba => babaa =>
 * ababa) String 'aba' is it's original self at time 2 and 4. (aba => baa =>
 * aba)
 * 
 * Hence, 3 strings are their original self at time 4.
 * 
 * @author kaussark
 *
 */
public class Problem57 {

	public static void main(String[] args) {
		String[] array = { "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "babaaaabbaba",
				"baaaaababaabbaaaaabbbbbbbaabbaaaababbabaababaabaaabbbaaaaa",
				"abaabb",
				"aababbbbabbaaaabbaaaaaaaababbbabbbbaabbaabaabbaabaababbbababaababaabbababaaabaaaab",
				"babaaaaababbbbbabbbbabbaaabaaaababbabbaabbbabbaaaabbbabaaaabaaaababb",
				"bbbbbbaaaaaabbbbbbababaabaabbbbbaaabbabbaabbbbaaaaaababbabaaabbabbabbbabbaabbabbbbaabbbaaaaabbabaaab",
				"aabaaabaabbbbababbabbabaaaababbababbbabbbbaabbaaaaababbbbbababbbbaaababababab",
				"aaaababbbaabbbabaabb", "ababaaaabbabbbbaaabbababbbabbbabaaa",
				"aaabaabbbabaa", "baababbababbbbbabbabaabbabbbbbaaaabaaaababaa",
				"babaa",
				"abbabababbbbbbbbbbbaaaaaababbababaaabbbaaaabbbababbabaabbaabbbbaabbbaabbababababaabaaabbaaabbba",
				"ababbaabbaaabbbabaabababbbabaaabbbaababaaa",
				"abbaaaababbbbaaabaaaabaaaaabaababbabbaababbbabbbbbbbbbabbaabaaabbaaababbbaa",
				"bbabababaabbabbabbbabbaababbabaaabbbababab", "abbbaaabaab",
				"bbaaabbaaabbaabbabababa",
				"aabaabaaaaaaabaabbbaaababbbbbbababbaabababbaaaaabbabbbabbbaababbaabababbbbbbbbbaabaab",
				"babbaaabbabbaabaaabbb", "bbabaabba",
				"baabaaaaabbaaaaaabbbbaaaabababa", "babbaababaaba",
				"baabaabaabbababbaabbabbbbbabaaaabbbbbabbabbbbbabbbabaabbbbabbbbaaabbbbabababaaaababbaaabbabb",
				"abbbbaaaabaabbabbaababaabbababbbaaabbabbbbbaaabbabbaabbb",
				"bababaaaaabababbabbaabababbbaabbaabaabaabbabbbababbaaabababbababbbb",
				"abaaabbbabbbaabba",
				"bbbbaaaabbbababaabbbababaaaababbaaaaaabbbabbaababababbba",
				"bababaabaaaabbaabbababbaabbaabaabbaaaaaaaababbaaaaaabbaaabaabaaababbababbbbaabbabbabaabab",
				"aabbbabaaabababaabbbbaabbabaaabbbaaabbabbbbabaabbbbaabbbaaaaabbbabbbbb",
				"aabbbbbbabaabbbabbaababbababaabaaababbbbabbbaababaaaabbaaabaaabaaaabbbabababbab",
				"abaaaaababbabaabbbaaaaabbaaaabaaaaaaaababbaabbbaabbabbbabbaaaaaab",
				"bbbaabbabbbbbbaaaabbabbbbbbbaaabaababbaaaabbbaababbaaabbbbbbbbabbabababbaaabaabaaabaaaabbbbbabaabaaa",
				"bbaaabaaabaaabaabaaabbaabaabbabaabaabbababaaaaabaabbbbaba",
				"abaababaaabbabaabaabbbaaabbaabababbabaaabbbbabbbbbaaaaa",
				"abba",
				"abbbababbaaabbaaabbbabaabbababaaabbbbaaaaababbabbaabbabbbaaabaabbaaaaabaaaabbbaabbbabbbbbbbabb",
				"bbabbaaabaaaabbaaaabbbaaaababbbaabaaaaab",
				"abbaabaabbaaaaaaaabbaabbabbababaaaaaaabbabaabaabbbabbaabbaababbaabbaba",
				"bbbbaababbaaaaaaaaabbbabbbabaabababaababaababa",
				"baaabaabbbbbbaabbabbbabaaaaababaabaababbbaaaaaaaabbbbbabbabaaaaaaaabababaabaababaaabbaaaaaaaaabaa",
				"aababbbabbaaaaababbabaababbbbbbbbaaabbaaaaabbaabbbba",
				"ababababaaaaaabbbabbaaababaabb", "bababbaababaabbbabbaab",
				"baababababbaaaaabbbbbbbbbaabababb", "bbbbb",
				"aabaabbbaabababbababaaaaabbbbaababaabbabbbbbbaabbaaabbababbbabbabbbaabbbab",
				"bbaabbbbaabbaaaaaabbbaabababbbaabaaabbbbbabaababbbaababbbaaabaaabaaaababbbbaabbaababb",
				"aaababbaaaaabaabababbabaabbbbabbaba" };
		// { "ab", "a", "abbb" };
		ArrayList<String> input = new ArrayList<>(Arrays.asList(array));
		Problem57 problem = new Problem57();
		System.out.println(problem.solve(input));
	}

	public int solve(ArrayList<String> A) {
		int commMul = 0;
		int mod = 1000000007;
		int[] nums = new int[A.size()];
		for (int i = 0; i < A.size(); i++) {
			nums[i] = findNum(A.get(i));
		}

		commMul = (int) (commonFactor(nums) % mod);

		return commMul;
	}

	private long commonFactor(int[] array) {
		long commFact = 1;
		int mod = 1000000007;
		for (int a : array) {
			commFact = lowestCommFact(commFact, a) % mod;
		}

		return commFact;
	}

	private long lowestCommFact(long commFact, long b) {
		if (commFact < b) {
			commFact = b + commFact;
			b = (commFact - b);
			commFact = commFact - b;
		}
		if (commFact % b == 0) {
			return commFact;
		} else {
			for (int i = 1; i < b; i++) {
				if ((i * b) % commFact == 0) {
					return i * b;
				}
			}
		}

		return commFact * b;
	}

	private int findNum(String s) {
		int num = 0;
		String temp = s;
		int length = s.length();
		while (num == 0 || !(temp).equals(s)) {
			num++;
			temp = temp + temp.substring(0, num % length);
			temp = temp.substring(num % length);
		}

		return num;
	}
}
