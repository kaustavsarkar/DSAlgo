package download.dsalgo.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an input string, reverse the string word by word.
 * 
 * Example:
 * 
 * Given s = "the sky is blue",
 * 
 * return "blue is sky the".
 * 
 * A sequence of non-space characters constitutes a word. Your reversed string
 * should not contain leading or trailing spaces, even if it is present in the
 * input string. If there are multiple spaces between words, reduce them to a
 * single space in the reversed string.
 * 
 * @author kaussark
 *
 */
public class Problem64 {

	public static void main(String[] args) {
		Problem64 problem = new Problem64();
		System.out.println(problem.reverseWords("ankrqzzcel dyaiug y rkicv t"));

	}

	public String reverseWords(String a) {
		List<String> strings = new ArrayList<>();
		StringBuilder temp = new StringBuilder();
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) != ' ') {
				temp.append(a.charAt(i));
			} else if (temp.length() > 0) {
				strings.add(temp.toString());
				temp = new StringBuilder();
			}
		}
		
		if(temp.length() > 0) {
		strings.add(temp.toString());
		}

		temp = new StringBuilder();
		int start = 0;
		int end = strings.size() - 1;

		while (start <= end) {
			String t = strings.get(start);
			strings.set(start, strings.get(end));
			strings.set(end, t);
			start++;
			end--;
		}

		for (int i = 0; i < strings.size(); i++) {
			temp.append(strings.get(i));
			if (i != strings.size() - 1) {
				temp.append(" ");
			}
		}

		return temp.toString();
	}
}
