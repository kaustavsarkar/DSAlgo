package download.dsalgo.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array A of integers, find the index of values that satisfy A + B = C
 * + D, where A,B,C & D are integers values in the array
 * 
 * Note:
 * 
 * 1) Return the indices `A1 B1 C1 D1`, so that A[A1] + A[B1] = A[C1] + A[D1] A1
 * < B1, C1 < D1 A1 < C1, B1 != D1, B1 != C1
 * 
 * 2) If there are more than one solutions, then return the tuple of values
 * which are lexicographical smallest.
 * 
 * Assume we have two solutions S1 : A1 B1 C1 D1 ( these are values of indices
 * int the array ) S2 : A2 B2 C2 D2
 * 
 * S1 is lexicographically smaller than S2 iff A1 < A2 OR A1 = A2 AND B1 < B2 OR
 * A1 = A2 AND B1 = B2 AND C1 < C2 OR A1 = A2 AND B1 = B2 AND C1 = C2 AND D1 <
 * D2 Example:
 * 
 * Input: [3, 4, 7, 1, 2, 9, 8] Output: [0, 2, 3, 5] (O index) If no solution is
 * possible, return an empty list.
 * 
 * @author kaussark
 *
 */
public class Problem134 {

	public static void main(String[] args) {
		Integer[] array = { 1, 1, 1, 1, 1 };
		System.out.println(
				new Problem134().equal(new ArrayList<>(Arrays.asList(array))));
	}

	public ArrayList<Integer> equal(ArrayList<Integer> A) {
		Map<Integer, ArrayList<Integer>> sumTracker = new HashMap<>();
		ArrayList<Integer> result = new ArrayList<>();
		ArrayList<ArrayList<Integer>> resultSet = new ArrayList<>();
		// Add all sums and their indices(A,B,C,D)
		for (int first = 0; first < A.size() - 1; first++) {
			for (int second = first + 1; second < A.size(); second++) {
				int sum = A.get(first) + A.get(second);
				if (!sumTracker.containsKey(sum)) {
					ArrayList<Integer> temp = new ArrayList<>();
					temp.add(first);// A
					temp.add(second);// B
					sumTracker.put(sum, temp);
				} else if (sumTracker.get(sum).size() < 3
						&& sumTracker.get(sum).get(0) < first
						&& sumTracker.get(sum).get(1) != second
						&& sumTracker.get(sum).get(1) != first) {
					sumTracker.get(sum).add(first);// C
					sumTracker.get(sum).add(second);// D
				}
			}
		}

		// Filter out all values with length 4
		for (Map.Entry<Integer, ArrayList<Integer>> entry : sumTracker
				.entrySet()) {
			ArrayList<Integer> list = entry.getValue();
			boolean isSize = list.size() == 4;
			if (isSize) {
				resultSet.add(list);
			}
		}
		Collections.sort(resultSet, (list1, list2) -> {
			if (list1.get(0) < list2.get(0)) {
				return -1;
			} else if (list1.get(0) == list2.get(0)
					&& list1.get(1) < list2.get(1)) {
				return -1;
			} else if (list1.get(0) == list2.get(0)
					&& list1.get(1) == list2.get(1)
					&& list1.get(2) < list2.get(2)) {
				return -1;
			} else if (list1.get(0) == list2.get(0)
					&& list1.get(1) == list2.get(1)
					&& list1.get(2) == list2.get(2)
					&& list1.get(3) < list2.get(3)) {
				return -1;
			} else {
				return 1;
			}
		});

		if(!resultSet.isEmpty()) {
			return resultSet.get(0);
		}
		return result;
	}
}
