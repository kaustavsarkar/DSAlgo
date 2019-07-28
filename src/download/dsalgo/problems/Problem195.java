package download.dsalgo.problems;

import java.util.*;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top
 * left to bottom right which minimizes the sum of all numbers along its path.
 * 
 * Note: You can only move either down or right at any point in time. Example :
 * 
 * Input :
 * 
 * [ 1 3 2 4 3 1 5 6 1 ]
 * 
 * Output : 8 1 -> 3 -> 2 -> 1 -> 1
 * 
 * @author kaussark
 *
 */
public class Problem195 {

	public static void main(String[] args) {

	}

	public int minPathSum(ArrayList<ArrayList<Integer>> A) {
		int rows = A.size();
		int cols = A.get(A.size() - 1).size();

		// fill first row
		for (int col = 1; col < A.get(0).size(); col++) {
			int prev = A.get(0).get(col - 1);
			int curr = A.get(0).get(col);
			A.get(0).set(col, prev + curr);
		}

		// fill first col
		for (int row = 1; row < A.size(); row++) {
			int prev = A.get(row - 1).get(0);
			int curr = A.get(row).get(0);
			A.get(row).set(0, prev + curr);
		}

		// fill rest of coords
		for (int row = 1; row < A.size(); row++) {
			for (int col = 1; col < A.get(row).size(); col++) {
				int curr = A.get(row).get(col);
				int min = Math.min(A.get(row - 1).get(col),
						A.get(row).get(col - 1));
				A.get(row).set(col, curr + min);
			}
		}

		return A.get(rows - 1).get(cols - 1);
	}
}
