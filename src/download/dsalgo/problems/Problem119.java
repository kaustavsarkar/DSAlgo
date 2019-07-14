package download.dsalgo.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Given a collection of candidate numbers (C) and a target number (T), find all
 * unique combinations in C where the candidate numbers sums to T.
 * 
 * Each number in C may only be used once in the combination.
 * 
 * Note: All numbers (including target) will be positive integers. Elements in a
 * combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤
 * … ≤ ak). The solution set must not contain duplicate combinations. Example :
 * 
 * Given candidate set 10,1,2,7,6,1,5 and target 8,
 * 
 * A solution set is:
 * 
 * [1, 7] [1, 2, 5] [2, 6] [1, 1, 6] Warning : DO NOT USE LIBRARY FUNCTION FOR
 * GENERATING COMBINATIONS. Example : itertools.combinations in python. If you
 * do, we will disqualify your submission retroactively and give you penalty
 * points.
 * 
 * @author kaussark
 *
 */
public class Problem119 {

	public static void main(String[] args) {
		Integer[] array = { 15, 8, 15, 10, 19, 18, 10, 3, 11, 7, 17 }; 
			//{8, 10, 6, 11, 1, 16, 8 }; 
			//{ 10, 1, 2, 7, 6, 1, 5 };
		// { 17, 8, 17, 20, 20, 18, 14, 15, 20, 3 };
		// { 2, 3, 6, 7 };
		System.out.println(new Problem119()
				.combinationSum(new ArrayList<>(Arrays.asList(array)), 33));
	}

	public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a,
			int b) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		Collections.sort(a);

		System.out.println(a);
		
		if (a.get(0) > b) {
			return result;
		}

		uniqueSumComb(result, new ArrayList<>(), 0, 0, b, a);

		return result;
	}

	public void uniqueSumComb(ArrayList<ArrayList<Integer>> result,
			ArrayList<Integer> numbers, int sum, int index, int b,
			ArrayList<Integer> a) {

		// Base Case
		if (sum == b && ! result.contains(numbers)) {
			result.add((ArrayList<Integer>) numbers.clone());
			return;
		}

		for (int i = index; i < a.size(); i++) {

			numbers.add(a.get(i));
			sum += a.get(i);
			if (sum <= b) {
				uniqueSumComb(result, numbers, sum, i + 1, b, a);
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
