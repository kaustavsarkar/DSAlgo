package download.dsalgo.problems;

import java.util.*;

/**
 * Given a 2D matrix, find the number non-empty sub matrices, such that the sum
 * of the elements inside the sub matrix is equal to 0. (note: elements might be
 * negative).
 * 
 * Example:
 * 
 * Input
 * 
 * -8 5 7 3 7 -8 5 -8 9 Output 2
 * 
 * Explanation -8 5 7 3 7 -8 5 -8 9
 * 
 * -8 5 7 3 7 -8 5 -8 9
 * 
 * @author kaussark
 *
 */
public class Problem201 {

	public static void main(String[] args) {
		Integer[][] input = { { -8, 5, 7 }, { 3, 7, -8 }, { 5, -8, 9 } };
		// { { 0, 0, 0 }, { 0, 0, 0 } };
		ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
		for (Integer[] i : input) {
			matrix.add(new ArrayList<>(Arrays.asList(i)));
		}
		System.out.println(new Problem201()._solve(matrix));
	}

	public int zeroSubArray(ArrayList<Integer> arr) {
		HashMap<Integer, Integer> hMap = new HashMap<>();
		int noOfZeroSubArray = 0;
		Integer val = 0;
		for (Integer x : arr) {
			val += x;
			if (hMap.containsKey(val)) {
				hMap.put(val, hMap.get(val) + 1);
			} else {
				if (val == 0)
					hMap.put(val, 1);
				else
					hMap.put(val, 0);
			}
		}

		for (Integer value : hMap.values()) {
			noOfZeroSubArray += ((value * (value + 1)) >> 1);
		}
		return noOfZeroSubArray;
	}

	public int _solve(ArrayList<ArrayList<Integer>> A) {
		if (A.size() < 1 || A.get(0).size() < 1)
			return 0;
		int ans = zeroSubArray(A.get(0));
		ArrayList<Integer> arr = new ArrayList<>(
				Arrays.asList(new Integer[A.get(0).size()]));

		for (int i = 1; i < A.size(); i++) {
			for (int j = 0; j < A.get(i).size(); j++) {
				A.get(i).set(j, A.get(i - 1).get(j) + A.get(i).get(j));
				arr.set(j, A.get(i).get(j));
			}

			ans += zeroSubArray(arr);
			for (int j = 0; j < i; j++) {
				for (int k = 0; k < A.get(0).size(); k++) {
					arr.set(k, A.get(i).get(k) - A.get(j).get(k));
				}
				ans += zeroSubArray(arr);
			}
		}
		return ans;
	}

	public int solve(ArrayList<ArrayList<Integer>> A) {
		// int leftBound = 0;
		// int rightBound = 0;
		int maxCount = 0;

		for (int upBound = 0; upBound < A.size(); upBound++) {
			int temp[] = new int[A.get(upBound).size()];
			for (int lowBound = upBound; lowBound < A.size(); lowBound++) {
				for (int col = 0; col < temp.length; col++) {
					temp[col] += A.get(lowBound).get(col);
				}

				maxCount += findZeroes(temp, upBound, lowBound);

			}
		}
		return maxCount;
	}

	private int findZeroes(int[] temp, int upBound, int lowBound) {
		int count = 0;
		int sum = 0;
		int length = 0;
		Map<Integer, Integer> sumByIndex = new HashMap<>();

		for (int index = 0; index < temp.length; index++) {
			sum += temp[index];
			if (temp[index] == 0 && length == 0) {
				length = 1;
				count++;
			}
			if (sum == 0) {
				if (index + 1 > length) {
					count++;
				}
				length = index + 1;
			}
			if (sumByIndex.containsKey(sum)) {
				if (index + sumByIndex.get(sum) > length) {
					length = index + sumByIndex.get(sum);
				}
				count++;
			} else {
				sumByIndex.put(sum, index);
			}
		}

		return count;
	}
}
