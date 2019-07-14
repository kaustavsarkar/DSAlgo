package download.dsalgo.problems;

import java.util.ArrayList;

/**
 * Given two integers n and k, return all possible combinations of k numbers out
 * of 1 2 3 ... n.
 * 
 * Make sure the combinations are sorted.
 * 
 * To elaborate,
 * 
 * Within every entry, elements should be sorted. [1, 4] is a valid entry while
 * [4, 1] is not. Entries should be sorted within themselves. Example : If n = 4
 * and k = 2, a solution is:
 * 
 * [ [1,2], [1,3], [1,4], [2,3], [2,4], [3,4], ] Warning : DO NOT USE LIBRARY
 * FUNCTION FOR GENERATING COMBINATIONS. Example : itertools.combinations in
 * python. If you do, we will disqualify your submission retroactively and give
 * you penalty points.
 * 
 * @author kaussark
 *
 */
public class Problem117 {

	public static void main(String[] args) {
		System.out.println(new Problem117().combine(4, 2));
	}

	public ArrayList<ArrayList<Integer>> combine(int A, int B) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		if(B > A) {
			return result;
		}
		
		createComb(result, new ArrayList<>(), 1, B, A);
		return result;
	}

	public void createComb(ArrayList<ArrayList<Integer>> result,
			ArrayList<Integer> base, int index, int b, int a) {
		if (base.size() >= b) {
			result.add((ArrayList<Integer>) base.clone());
			return;
		}

		for (int i = index; i <= a; i++) {
			base.add(i);
			createComb(result, base, i + 1, b, a);
			base.remove(base.size() - 1);
		}
	}
}
