package download.dsalgo.problems;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given a 2 * N Grid of numbers, choose numbers such that the sum of the
 * numbers is maximum and no two chosen numbers are adjacent horizontally,
 * vertically or diagonally, and return it.
 * 
 * Example:
 * 
 * Grid: 1 2 3 4 2 3 4 5 so we will choose 3 and 5 so sum will be 3 + 5 = 8
 * 
 * 
 * Note that you can choose more than 2 numbers
 * 
 * @author kaussark
 *
 */
public class Problem211 {

	public static void main(String[] args) {
		Integer[][] input = 
//			{ { 16, 5, 54, 55, 36, 82, 61, 77, 66, 61 },
//				{ 31, 30, 36, 70, 9, 37, 1, 11, 68, 14 } };
		 { { 74, 37, 82, 1 }, { 66, 38, 16, 1 } };
		ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
		for (Integer[] row : input) {
			matrix.add(new ArrayList<>(Arrays.asList(row)));
		}
		System.out.println(new Problem211().adjacent(matrix));
	}

	public int adjacent(ArrayList<ArrayList<Integer>> A) {
		int rows = A.size();
		int cols = A.get(rows - 1).size();
		int maxSum = 0;
		for (int col = 0; col < A.get(0).size(); col++) {
			for (int row = 0; row < A.size(); row++) {
				int currNum = A.get(row).get(col);
				if (col > 1) {
					int nextRowPrev = row + 1 < rows
							? A.get(row + 1).get(col - 2)
							: A.get(row - 1).get(col - 2);
					int sameRowPrev = A.get(row).get(col - 2);
					int sum = Math.max(currNum + sameRowPrev,
							currNum + nextRowPrev);
					A.get(row).set(col, sum);
					maxSum = Math.max(maxSum, sum);
				} else {
					maxSum = Math.max(maxSum, currNum);
				}
				
				if(col > 0) {
					if(A.get(row).get(col) < A.get(row).get(col-1)) {
						A.get(row).set(col, A.get(row).get(col-1));
					}
				}
			}
		}
		return maxSum;
	}
}
