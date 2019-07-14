package download.dsalgo.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Given a set of candidate numbers (C) and a target number (T), find all unique
 * combinations in C where the candidate numbers sums to T.
 * 
 * The same repeated number may be chosen from C unlimited number of times.
 * 
 * Note: All numbers (including target) will be positive integers. Elements in a
 * combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤
 * … ≤ ak). The combinations themselves must be sorted in ascending order.
 * CombinationA > CombinationB iff (a1 > b1) OR (a1 = b1 AND a2 > b2) OR … (a1 =
 * b1 AND a2 = b2 AND … ai = bi AND ai+1 > bi+1) The solution set must not
 * contain duplicate combinations. Example, Given candidate set 2,3,6,7 and
 * target 7, A solution set is:
 * 
 * [2, 2, 3] [7] Warning : DO NOT USE LIBRARY FUNCTION FOR GENERATING
 * COMBINATIONS. Example : itertools.combinations in python. If you do, we will
 * disqualify your submission retroactively and give you penalty points.
 * 
 * @author kaussark
 *
 */
public class Problem118 {

	public static void main(String[] args) {
		Integer[] array = { 17, 8, 17, 20, 20, 18, 14, 15, 20, 3 };
		// { 2, 3, 6, 7 };
		System.out.println(new Problem118()
				.combinationSum(new ArrayList<>(Arrays.asList(array)), 14));
	}

	public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A,
			int b) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();

		Set<Integer> inputSet = new HashSet<>(A);
		A = new ArrayList<>(inputSet);
		Collections.sort(A);
		if (A.get(0) > b) {
			return result;
		}
		findSumComb(result, new ArrayList<>(), 0, 0, b, A);
		return result;
	}

	public void findSumComb(ArrayList<ArrayList<Integer>> result,
			ArrayList<Integer> numbers, int sum, int index, int b,
			ArrayList<Integer> A) {

		if (sum == b) {
			result.add((ArrayList<Integer>) numbers.clone());
			return;
		}

		for (int i = index; i < A.size(); i++) {
			numbers.add(A.get(i));
			sum += A.get(i);
			if (sum <= b) {
				findSumComb(result, numbers, sum, i, b, A);
				int num = numbers.remove(numbers.size() - 1);
				sum -= num;
			} else {
				int num = numbers.remove(numbers.size() - 1);
				sum -= num;
				break;
			}
		}
	}
}
