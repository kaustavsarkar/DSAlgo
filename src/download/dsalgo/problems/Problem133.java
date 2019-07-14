package download.dsalgo.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Given an array A of integers and another non negative integer k, find if
 * there exists 2 indices i and j such that A[i] - A[j] = k, i != j.
 * 
 * Example :
 * 
 * Input :
 * 
 * A : [1 5 3] k : 2 Output :
 * 
 * 1 as 3 - 1 = 2
 * 
 * Return 0 / 1 for this problem.
 * 
 * @author kaussark
 *
 */
public class Problem133 {

	public static void main(String[] args) {

	}

	public int diffPossible(final List<Integer> A, int B) {
		Map<Integer, Integer> sumMap = new HashMap<>();

		for (int i = 0; i < A.size(); i++) {
			sumMap.put(B + A.get(i), i);
		}

		for (int i = 0; i < A.size(); i++) {
			if (sumMap.containsKey(A.get(i)) && i != sumMap.get(A.get(i))) {
				return 1;
			}
		}
		return 0;
	}
}
