package download.dsalgo.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Given an array of strings, return all groups of strings that are anagrams.
 * Represent a group by a list of integers representing the index in the
 * original list. Look at the sample case for clarification.
 * 
 * Anagram : a word, phrase, or name formed by rearranging the letters of
 * another, such as 'spar', formed from 'rasp' Note: All inputs will be in
 * lower-case. Example :
 * 
 * Input : cat dog god tca Output : [[1, 4], [2, 3]] cat and tca are anagrams
 * which correspond to index 1 and 4. dog and god are another set of anagrams
 * which correspond to index 2 and 3. The indices are 1 based ( the first
 * element has index 1 instead of index 0).
 * 
 * Ordering of the result : You should not change the relative ordering of the
 * words / phrases within the group. Within a group containing A[i] and A[j],
 * A[i] comes before A[j] if i < j.
 * 
 * @author kaussark
 *
 */
public class Problem125 {

	public static void main(String[] args) {
		String[] array = { "cat", "dog", "god", "tca" };
		System.out.println(new Problem125()
				.anagrams(new ArrayList<>(Arrays.asList(array))));
	}

	public ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		Map<String, List<Integer>> anaIndex = new HashMap<>();
		int counter = 0;
		for (String word : A) {
			char[] chars = word.toCharArray();
			Arrays.sort(chars);
			String sorted = String.valueOf(chars);
			if (anaIndex.containsKey(sorted)) {
				anaIndex.get(sorted).add(counter + 1);
			} else {
				List<Integer> temp = new ArrayList<>();
				temp.add(counter + 1);
				anaIndex.put(sorted, temp);
			}
			counter++;
		}

		for (List<Integer> indices : anaIndex.values()) {
			result.add((ArrayList<Integer>) indices);
		}

		return result;
	}
}
