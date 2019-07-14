package download.dsalgo.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Find the largest continuous sequence in a array which sums to zero.
 * 
 * Example:
 * 
 * 
 * Input: {1 ,2 ,-2 ,4 ,-4} Output: {2 ,-2 ,4 ,-4}
 * 
 * NOTE : If there are multiple correct answers, return the sequence which
 * occurs first in the array.
 * 
 * @author kaussark
 *
 */
public class Problem128 {

	public static void main(String[] args) {
		Integer[] array = { -9, -13, 6, -28, 27, -5, -27, 17, 15, -17, -25, 6,
				-8, 2, -13, -13, -23, 21, -4, 22, -9, -10, 0, -28, -11, 8, 8,
				17 };
		// {1, 2, -2, 4, -4};
		System.out.println(
				new Problem128().lszero(new ArrayList<>(Arrays.asList(array))));
	}

	public ArrayList<Integer> lszero(ArrayList<Integer> A) {
		Map<Integer, List<Integer>> sums = new HashMap<>();
		ArrayList<Integer> result = new ArrayList<>();
		int sum = 0;

		for (int i = 0; i <= A.size(); i++) {
			List<Integer> oldIndex = sums.get(sum);
			if (oldIndex == null && i == A.size()) {
				continue;
			} else if (oldIndex == null) {
				List<Integer> temp = new ArrayList<>();
				temp.add(i);
				sums.put(sum, temp);

			} else {
				sums.get(sum).add(i);

			}
			if (i < A.size())
				sum += A.get(i);
		}

		// Find max diff object
		int maxDiff = 0;
		int start = 0;
		int end = 0;

		for (Map.Entry<Integer, List<Integer>> entry : sums.entrySet()) {
			List<Integer> indices = entry.getValue();
			Integer key = entry.getKey();

			int diff = indices.get(indices.size() - 1) - indices.get(0);
			if (maxDiff < diff) {
				maxDiff = diff;
				start = indices.get(0);
				end = indices.get(indices.size() - 1);
			} else if(maxDiff == diff && indices.get(0) < start) {
				start = indices.get(0);
				end = indices.get(indices.size() - 1);
			}

		}

		if (maxDiff > 0) {
			return new ArrayList<>(A.subList(start, end));
		}

		return result;
	}
}
