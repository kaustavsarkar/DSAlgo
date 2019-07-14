package download.dsalgo.problems;

import java.util.Arrays;

/**
 * Given numRows, generate the first numRows of Pascal’s triangle.
 * 
 * Pascal’s triangle : To generate A[C] in row R, sum up A’[C] and A’[C-1] from
 * previous row R - 1.
 * 
 * @author kaussark
 *
 */
public class Problem12 {
	public static void main(String[] args) {
		Problem12 problem = new Problem12();
		int[][] pascalTriangle = null;
		pascalTriangle = problem.solve(10);

		for (int[] row : pascalTriangle) {
			System.out.println(Arrays.toString(row));
		}

	}

	public int[][] solve(int num) {
		int[][] pascal = new int[num][];
		int col = 1;
		int row = 0;
		int[] prev = new int[num];
		while (col <= num && row < num) {
			pascal[row] = new int[row + 1];
			pascal[row][0] = 1;
			while (col <= row) {
				if (col < prev.length) {
					pascal[row][col] = prev[col - 1] + prev[col];
				} else {
					pascal[row][col] = prev[col - 1];
				}
				col++;
			}
			prev = pascal[row++];
			col = 1;
		}

		return pascal;
	}

}
