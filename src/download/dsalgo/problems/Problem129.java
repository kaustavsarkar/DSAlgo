package download.dsalgo.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Given an array of integers, find two numbers such that they add up to a
 * specific target number.
 * 
 * The function twoSum should return indices of the two numbers such that they
 * add up to the target, where index1 < index2. Please note that your returned
 * answers (both index1 and index2 ) are not zero-based. Put both these numbers
 * in order in an array and return the array from your function ( Looking at the
 * function signature will make things clearer ). Note that, if no pair exists,
 * return empty list.
 * 
 * If multiple solutions exist, output the one where index2 is minimum. If there
 * are multiple solutions with the minimum index2, choose the one with minimum
 * index1 out of them.
 * 
 * Input: [2, 7, 11, 15], target=9 Output: index1 = 1, index2 = 2
 * 
 * @author kaussark
 *
 */
public class Problem129 {

	public static void main(String[] args) {
		Integer[] array = { 10, -3, 5, -7, -4, 5, 6, -7, 8, -5, 8, 0, 8, -5,
				-10, -1, 1, -6, 4, -1, -2, -2, 10, -2, -4, -7, 5, 1, 7, -10, 0,
				5, 8, 6, -8, 8, -8, -8, 3, -9, -10, -5, -5, -10, 10, -4, 8, 0,
				-6, -2, 3, 7, -5, 5, 1, -7, 0, -5, 1, -3, 10, -4, -3, 3, 3, 5,
				1, -2, -6, 3, -4, 10, -10, -3, -8, 2, -2, -3, 0, 10, -6, -8,
				-10, 6, 7, 0, 3, 9, -10, -7, 8, -7, -7 };
		// { 4, 7, -4, 2, 2, 2, 3, -5, -3, 9, -4, 9, -7, 7, -1,
		// 9, 9, 4, 1, -4, -2, 3, -3, -5, 4, -7, 7, 9, -4, 4, -8 };
		// {2, 7, 11, 15};
		System.out.println(new Problem129()
				.twoSum(new ArrayList<>(Arrays.asList(array)), -2));
	}

	public ArrayList<Integer> twoSum(final List<Integer> A, int B) {
		ArrayList<Integer> result = new ArrayList<>();

		if (A.isEmpty()) {
			return result;
		}
		Map<Integer, Integer> diffMap = new HashMap<>();
		for (int i = 0; i < A.size(); i++) {
			if (!diffMap.containsKey(B - A.get(i)))
				diffMap.put(B - A.get(i), i + 1);
		}

		for (int i = 0; i < A.size(); i++) {
			int start = 0;
			int end = 0;
			if (diffMap.containsKey(A.get(i))) {
				if (i+1 > diffMap.get(A.get(i))) {
					start = diffMap.get(A.get(i));
					end = i + 1;
				} else if(i+1 == diffMap.get(A.get(i))){
					continue;
				}else {
					start = i + 1;
					end = diffMap.get(A.get(i));
				}

				if (result.isEmpty()) {
					result.add(start);
					result.add(end);
				} else if (end < result.get(1)) {
					result.set(0, start);
					result.set(1, end);
				} else if (end == result.get(1) && start < result.get(0)) {
					result.set(0, start);
					result.set(1, end);
				}
			}
		}

		return result;
	}
}
