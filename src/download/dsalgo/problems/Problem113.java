package download.dsalgo.problems;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given a collection of numbers, return all possible permutations.
 * 
 * Example:
 * 
 * [1,2,3] will have the following permutations:
 * 
 * [1,2,3] [1,3,2] [2,1,3] [2,3,1] [3,1,2] [3,2,1] NOTE No two entries in the
 * permutation sequence should be the same. For the purpose of this problem,
 * assume that all the numbers in the collection are unique. Warning : DO NOT
 * USE LIBRARY FUNCTION FOR GENERATING PERMUTATIONS. Example : next_permutations
 * in C++ / itertools.permutations in python. If you do, we will disqualify your
 * submission retroactively and give you penalty points.
 * 
 * @author kaussark
 *
 */
public class Problem113 {

	public static void main(String[] args) {
		Integer[] array = { 1, 2, 1 };
		System.out.println(new Problem113()
				.permute(new ArrayList<>(Arrays.asList(array))));
	}

	public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
		ArrayList<ArrayList<Integer>> permutations = new ArrayList<>();
		if (A.size() == 0 || A.size() == 1) {
			permutations.add(new ArrayList<>(A));
			return permutations;
		}
		generate(permutations, A, 0);

		return permutations;
	}

	private void generate(ArrayList<ArrayList<Integer>> permutations,
			ArrayList<Integer> list, int start) {
		if(start >= list.size()) {
			permutations.add((ArrayList<Integer>) list.clone());
			return;
		}
		for(int i = start; i < list.size(); i++) {
			swap(list, start, i);
			generate(permutations, list, start+1);
			swap(list, start, i);
		}
		
	}

	private void swap(ArrayList<Integer> a, int indexOne, int indexTwo) {
		if (indexOne == indexTwo) {
			return;
		}
		a.set(indexOne, a.get(indexTwo) + a.get(indexOne));
		a.set(indexTwo, a.get(indexOne) - a.get(indexTwo));
		a.set(indexOne, a.get(indexOne) - a.get(indexTwo));

	}

}
