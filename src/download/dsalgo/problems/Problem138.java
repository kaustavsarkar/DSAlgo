package download.dsalgo.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * You are given a string, S, and a list of words, L, that are all of the same
 * length.
 * 
 * Find all starting indices of substring(s) in S that is a concatenation of
 * each word in L exactly once and without any intervening characters.
 * 
 * Example :
 * 
 * S: "barfoothefoobarman" L: ["foo", "bar"] You should return the indices:
 * [0,9]. (order does not matter).
 * 
 * @author kaussark
 *
 */
public class Problem138 {

	public static void main(String[] args) {
		String string = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		// "barfoothefoobarman";
		String[] array = { "aaa", "aaa", "aaa", "aaa", "aaa" };
		// { "foo", "bar" };

		System.out.println(
				new Problem138().findSubstring(string, Arrays.asList(array)));
	}

	public ArrayList<Integer> _findSubstring(String A, final List<String> B) {
		ArrayList<Integer> solution = new ArrayList<Integer>();
		int sizeA = A.length();
		int n = B.size();
		if (n == 0) {
			return null;
		}
		int wordSize = B.get(0).length();
		if (n * wordSize > sizeA)
			return solution;
		for (int start = 0; start < wordSize; start++) {
			// starting this iteration from index start.
			int iterstart = start;
			int iterend = iterstart + n * wordSize;
			HashMap<String, Integer> map = getIdealMap(B);
			if (iterend <= sizeA) {
				for (int i = 0; i < n; i++) {
					String substr = A.substring(iterstart + i * wordSize,
							iterstart + (i + 1) * wordSize);
					if (map.containsKey(substr))
						map.put(substr, map.get(substr) - 1);
				}
				while (iterend <= sizeA) {
					if (isokay(map, B)) {
						solution.add(iterstart);
					}
					iterstart += wordSize;
					iterend += wordSize;
					if (iterend > sizeA)
						break;
					String deleted = A.substring(iterstart - wordSize,
							iterstart);
					String added = A.substring(iterend - wordSize, iterend);
					if (map.containsKey(deleted))
						map.put(deleted, map.get(deleted) + 1);
					if (map.containsKey(added))
						map.put(added, map.get(added) - 1);
				}
			}
		}
		return solution;
	}

	HashMap<String, Integer> getIdealMap(List<String> B) {
		HashMap<String, Integer> toreturn = new HashMap<String, Integer>();
		for (String str : B) {
			if (!toreturn.containsKey(str))
				toreturn.put(str, 1);
			else
				toreturn.put(str, toreturn.get(str) + 1);
		}
		return toreturn;
	}

	boolean isokay(HashMap<String, Integer> map, List<String> B) {
		for (String str : B) {
			if (map.containsKey(str) && map.get(str) == 0)
				continue;
			else
				return false;
		}
		return true;
	}

	public ArrayList<Integer> findSubstring(String A, final List<String> B) {

		int wordSize = B.get(0).length();
		int wordsToMatch = B.size();
		ArrayList<Integer> result = new ArrayList<>();

		if (A.length() < B.size()) {
			return result;
		}

		Set<Character> startChars = new HashSet<>();
		for (String s : B) {
			startChars.add(s.charAt(0));
		}
		int start = 0;
		int end = 0;
		while (end < A.length() && start < A.length()) {
			Character endChar = A.charAt(end);
			if (start == end && !startChars.contains(endChar)) {
				start++;
				end++;
			} else if (start == end && startChars.contains(endChar)
					&& end < A.length() - wordSize) {
				int hook = end;
				start = end;
				end = end + wordSize;
				Set<String> stringSet = new HashSet<>();
				String temp = A.substring(start, end);
				if (B.contains(temp)) {

					int counter = 0;
					while (counter < wordsToMatch && !stringSet.contains(temp)
							&& B.contains(temp)
							&& end < A.length() - wordSize) {
						stringSet.add(temp);
						start = end;
						end += wordSize;
						temp = A.substring(start, end);
						counter++;
					}

					if (counter == wordsToMatch) {
						result.add(hook);
						end = start;
					} else {
						start = hook + 1;
						end = start;
					}
				}
			}
		}
		return result;
	}
}
