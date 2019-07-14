package download.dsalgo.problems;

import java.util.ArrayList;

/**
 * Given a string s, partition s such that every string of the partition is a
 * palindrome.
 * 
 * Return all possible palindrome partitioning of s.
 * 
 * For example, given s = "aab", Return
 * 
 * [ ["a","a","b"] ["aa","b"], ] Ordering the results in the answer : Entry i
 * will come before Entry j if : len(Entryi[0]) < len(Entryj[0]) OR
 * (len(Entryi[0]) == len(Entryj[0]) AND len(Entryi[1]) < len(Entryj[1])) OR
 *
 *
 *
 * (len(Entryi[0]) == len(Entryj[0]) AND … len(Entryi[k] < len(Entryj[k])) In
 * the given example, ["a", "a", "b"] comes before ["aa", "b"] because len("a")
 * < len("aa")
 * 
 * @author kaussark
 *
 */
public class Problem121 {

	public static void main(String[] args) {
		String string = "aab";

		System.out.println(new Problem121()._partition(string));
	}

	public ArrayList<ArrayList<String>> _partition(String a) {

		ArrayList<ArrayList<String>> res = new ArrayList<>();
		ArrayList<String> temp = new ArrayList<>();
		int end = a.length();

		palinPart(0, end, res, temp, a);

		return res;
	}

	public void palinPart(int start, int end, ArrayList<ArrayList<String>> res,
			ArrayList<String> temp, String str) {
		if (start >= end) {
			res.add(new ArrayList<>(temp));
			return;
		}

		for (int i = start; i < end; i++) {

			if (isPal(str.substring(start, i + 1))) {
				temp.add(str.substring(start, i + 1));

				palinPart(i + 1, end, res, temp, str);

				temp.remove(temp.size() - 1);
			}
		}
	}

	boolean isPal(String str) {
		int start = 0, end = str.length() - 1;

		while (start < end) {

			if (str.charAt(start) != str.charAt(end))
				return false;

			start++;
			end--;
		}

		return true;
	}

	public ArrayList<ArrayList<String>> partition(String a) {
		ArrayList<ArrayList<String>> result = new ArrayList<>();
		if (a.isEmpty()) {
			return result;
		}
		// Lengths
		for (int length = 1; length <= a.length(); length++) {
			// Indices to choose
			ArrayList<String> pallins = new ArrayList<>();
			for (int idx = 0; idx < a.length(); idx += length) {
				int end = idx + length > a.length() ? a.length() : idx + length;
				String substring = a.substring(idx, end);
				if (isPallindrome(substring)) {
					pallins.add(substring);
				}
			}
			if (!pallins.isEmpty())
				result.add(pallins);
		}

		return result;
	}

	private boolean isPallindrome(String substring) {
		int start = 0;
		int end = substring.length() - 1;
		while (start <= end
				&& substring.charAt(start) == substring.charAt(end)) {
			start++;
			end--;
		}
		if (start <= end) {
			return false;
		}
		return true;
	}
}
