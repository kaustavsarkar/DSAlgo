package download.dsalgo.problems;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given an array ‘A’ of sorted integers and another non negative integer k,
 * find if there exists 2 indices i and j such that A[i] - A[j] = k, i != j.
 * 
 * Example: Input : A : [1 3 5] k : 4 Output : YES as 5 - 1 = 4 Return 0 / 1 ( 0
 * for false, 1 for true ) for this problem
 * 
 * Try doing this in less than linear space complexity.
 * 
 * @author kaussark
 *
 */
public class Problem89 {

	public static void main(String[] args) {
		Integer[] array = { 1, 3, 5 };
		System.out.println(new Problem89()
				.diffPossible(new ArrayList<>(Arrays.asList(array)), 0));
	}

	public int diffPossible(ArrayList<Integer> A, int B) {

		for (int i = 0; i < A.size(); i++) {
			int counter = A.size() - 1;
			while (A.get(counter) - A.get(i) > B) {
				counter--;
			}
			if (A.get(counter) - A.get(i) == B && counter != i) {
				return 1;
			}
		}

		return 0;
	}
}
