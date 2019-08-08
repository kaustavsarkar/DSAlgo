package download.dsalgo.problems;

import java.util.*;

/**
 * Given a string s and a dictionary of words dict, determine if s can be
 * segmented into a space-separated sequence of one or more dictionary words.
 * 
 * For example, given
 * 
 * s = "myinterviewtrainer", dict = ["trainer", "my", "interview"]. Return 1 (
 * corresponding to true ) because "myinterviewtrainer" can be segmented as "my
 * interview trainer".
 * 
 * Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 * 
 * @author kaussark
 *
 */
public class Problem224 {

	public static void main(String[] args) {
		String input = //"aababaaabaaababbbabbbaabababaaabbaabaabbabbaabbbbbbbabbbbabaaabaabaabbaaaaabbabaababbbabbbbbbaaaabbbaaaaaabaaaaaabbbbbbbabbbbbbbbaaabaaababbbaaaabaaaabaaaabbabbbabaabbabbabaaaabbabaaabbabbabbbabbabbaabbbabaabaabbbbbbbaabababbbbbbababbbaabaabbbabababbbbbaaaababbbabaaabaabbaababbbabbbbbaabbaaaaabbbbbaaaaaaaaaaaabbabbbabbaaabaaaaaabaabababaabaaaabaaabbbbbaaabbaabbababbabbbbaabaabaabaaaabbbaababbaabbbbbabaaababbabbbabbbbbabaababbbbbaabbbbabaabbabbababaaaabbbbabbbaaaabaabbbbaaaaababaaabaabbabaababbabbbababaaababbaabbbaaabaabbbaabbbbbbaaabaabbbbbabaaababaaabbbbbbaaaabababaaabbbbbbaabbaaabbbabaabbabababbabaabbaaabbaaabbaabbbbbababbaabbabbb";
		 "myinterviewtrainer";
		String[] dic = 
//			{ "baaaaaabba", "babbaababb", "abb", "bababaabab",
//				"baaa", "ab", "ab", "bb", "abbaaaa", "bbababa", "bbbbbbab",
//				"abbaaabba", "aaaabbab", "abaaab", "babab", "aabaaab",
//				"aabaabbabb", "aa", "bb", "ab", "a", "a", "bbaaab", "aba", "ba",
//				"bbabbaabab", "aaabbbbbb", "abbaaaabbb", "aabaabbaa", "bbba",
//				"abbabbba", "abbbbabb", "bbaaba", "abbbbaab", "bba",
//				"bbbbaabba", "ababbabaab", "baabba", "ababbaabb", "bbaab", "a",
//				"bbba", "aaaa", "aaabbbabba", "bab", "baaaabaa", "ab",
//				"aaabbaab", "bab", "aa", "ababababab", "aabbaaaba", "abbaaba",
//				"bbaabaa" };
		 { "interview", "my", "trainer" };
		System.out.println(new Problem224()._wordBreak(input,
				new ArrayList<>(Arrays.asList(dic))));
	}

	public int _wordBreak(String s, ArrayList<String> list) {

		if (s == null || s.length() == 0 || list == null || list.size() == 0)
			return 0;

		Set<String> set = new HashSet<>();
		for (int i = 0; i < list.size(); i++) {
			set.add(list.get(i));
		}

		int[] dp = new int[s.length() + 1];
		dp[0] = 1;

		for (int i = 1; i <= s.length(); i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (dp[j] == 1 && set.contains(s.substring(j, i))) {
					dp[i] = 1;
					break;
				}
			}
		}
		return dp[dp.length - 1];
	}

	public int wordBreak(String A, ArrayList<String> B) {
		if (A == null || A.isEmpty() || B == null || B.isEmpty()) {
			return 0;
		}
		StringBuilder builder = new StringBuilder();
		for (int index = 0; index < A.length();) {
			boolean found = false;
			builder.append(A.charAt(index));
			if (B.contains(builder.toString())) {
				B.remove(builder.toString());
				index = index + 1;
				found = true;
				builder = new StringBuilder();
			} else {
				index++;
			}
			if (index >= A.length() && !found) {
				return 0;
			}
		}
		return 1;
	}
}
