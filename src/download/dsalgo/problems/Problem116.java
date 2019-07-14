package download.dsalgo.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a digit string, return all possible letter combinations that the number
 * could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given
 * below.
 * 
 * 
 * 
 * The digit 0 maps to 0 itself. The digit 1 maps to 1 itself.
 * 
 * Input: Digit string "23" Output: ["ad", "ae", "af", "bd", "be", "bf", "cd",
 * "ce", "cf"]. Make sure the returned strings are lexicographically sorted.
 * 
 * @author kaussark
 *
 */
public class Problem116 {

	public static void main(String[] args) {

	}

	String[] map = new String[] { "0", "1", "abc", "def", "ghi", "jkl", "mno",
			"pqrs", "tuv", "wxyz" };

	public ArrayList<String> _letterCombinations(String A) {
		ArrayList<String> ans = new ArrayList<String>();

		back(A, ans, "", 0);
		return ans;
	}

	public void back(String A, ArrayList<String> ans, String str, int index) {
		if (index >= A.length()) {
			ans.add(str);
			return;
		}
		int idx = (int) (A.charAt(index) - '0');
		String temp = map[idx];
		for (int j = 0; j < temp.length(); j++) {
			back(A, ans, str + temp.charAt(j), index + 1);
		}
	}

	public ArrayList<String> letterCombinations(String A) {
		ArrayList<String> result = new ArrayList<>();

		return result;
	}

	public void concatenate(String a, String comb, ArrayList<String> result,
			int counter) {
		if (counter >= a.length()) {
			result.add(comb);
			return;
		}

		int index = (int) (a.charAt(counter) - '0');
		String temp = getLetters(index);
		for (int i = 0; i < temp.length(); i++) {
			concatenate(a, comb + temp.charAt(i), result, index + 1);
		}

	}

	private String getLetters(int num) {
		switch (num) {
		case 1:
			return "1";
		case 2:
			return "abc";
		case 3:
			return "def";
		case 4:
			return "ghi";
		case 5:
			return "jkl";
		case 6:
			return "mno";
		case 7:
			return "pqrs";
		case 8:
			return "tuv";
		case 9:
			return "wxyz";
		default:
			return "0";
		}
	}
}
