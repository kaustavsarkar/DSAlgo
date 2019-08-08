package download.dsalgo.problems;

import java.util.*;

/**
 * Given an array of integers, return the highest product possible by
 * multiplying 3 numbers from the array
 * 
 * Input:
 * 
 * array of integers e.g {1, 2, 3} NOTE: Solution will fit in a 32-bit signed
 * integer Example:
 * 
 * [0, -1, 3, 100, 70, 50]
 * 
 * => 70*50*100 = 350000
 * 
 * @author kaussark
 *
 */
public class Problem226 {

	public static void main(String[] args) {

	}

	public int maxp3(ArrayList<Integer> A) {
		if (A == null || A.isEmpty() || A.size() < 3) {
			return 0;
		}
		Collections.sort(A);
		int length = A.size();
		int maxP1 = A.get(0) * A.get(1) * A.get(length - 1);
		int maxP2 = A.get(0) * A.get(length - 1) * A.get(length - 2);
		int maxp3 = A.get(length - 1) * A.get(length - 2) * A.get(length - 3);
		return Math.max(maxP1, Math.max(maxP2, maxp3));
	}

}
