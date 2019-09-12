package download.dsalgo.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Given a string S and a string T, find the minimum window in S which will
 * contain all the characters in T in linear time complexity. Note that when the
 * count of a character C in T is N, then the count of C in minimum window in S
 * should be at least N.
 * 
 * Example :
 * 
 * S = "ADOBECODEBANC" T = "ABC" Minimum window is "BANC"
 * 
 * Note: If there is no such window in S that covers all characters in T, return
 * the empty string ''. If there are multiple such windows, return the first
 * occurring minimum window ( with minimum start index ).
 * 
 * @author kaussark
 *
 */
public class Problem136 {

	public static void main(String[] args) {
		String string1 = "ADOBECODEBANC";
		String string2 = "ABC";

		//System.out.println(new Problem136()._minWindow(string1, string2));
		for(int i = 91; i < 100; i++) {
			System.out.println((char) i);
		}
	}

	public String _minWindow(String s, String B) {
		int[] need = new int[52];
		for (char c : B.toCharArray())
			need[c-'A']++;
		int i = 0, j = 0, l = 0, r = 0, missing = B.length();
		while (r < s.length()) {
			int right = (char) (s.charAt(r) - 'A');
			if (need[right] > 0)
				missing -= 1;
			need[right]--;
			r += 1;
			while (missing == 0) {
				if (j == 0 || (r - l) < (j - i)) {
					j = r;
					i = l;
				}
				int left = (char) (s.charAt(l)-'A');
				need[left]++;
				if (need[left] > 0)
					missing += 1;
				l += 1;
			}
		}
		return s.substring(i, j);
	}

	public String minWindow(String A, String B) {
		String result = null;
		if (A.length() < B.length()) {
			return result;
		}
		int start = 0;
		int end = 0;
		SortedMap<Integer, String> indexByCharMap = new TreeMap<>();
		ArrayList<Integer> resultGrp = new ArrayList<>();

		while (start < A.length() && end < A.length()) {
			if (B.contains(A.substring(end, end + 1))) {
				indexByCharMap.put(end, A.substring(end, end + 1));

			} else {
				start++;
			}
			if (end <= start)
				end = start + 1;
			else
				end++;
		}

		String first = null;
		String sec = null;
		ArrayList<Integer> temp = new ArrayList<>();
		for (Entry<Integer, String> entry : indexByCharMap.entrySet()) {
			int index = entry.getKey();
			String alpha = entry.getValue();
			if (first == null) {
				first = alpha;
				temp.add(index);
			} else if (!first.equals(sec) && temp.size() < B.length()) {

			}

		}

		return result;
	}
}
