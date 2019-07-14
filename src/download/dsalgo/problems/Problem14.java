package download.dsalgo.problems;

import java.util.Arrays;
import java.util.Stack;

/**
 * Give a N*N square matrix, return an array of its anti-diagonals. Look at the
 * example for more details.
 * 
 * Example:
 * 
 * 
 * Input:
 * 
 * 1 2 3 4 5 6 7 8 9
 * 
 * Return the following :
 * 
 * [ [1], [2, 4], [3, 5, 7], [6, 8], [9] ]
 * 
 * 
 * Input : 1 2 3 4
 * 
 * Return the following :
 * 
 * [ [1], [2, 3], [4] ]
 * 
 * @author kaussark
 *
 */
public class Problem14 {

	public static void main(String[] args) {
		Problem14 problem = new Problem14();
		int[][] square = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int[][] dia = problem.diagonal(square);
		for (int[] row : dia) {
			System.out.println(Arrays.toString(row));
		}
	}

	
	public int[][] diagonal(int[][] square) {
		int rows = (square.length * 2) - 1;
		int[][] diag = new int[rows][];
		int counter = 0;
		int min = 0;
		int max = 0;
		while (counter < rows) {
			int innerCounter = 0;
			if (min > max) {
				min = min + max;
				max = min - max;
				min = min - max;
			}
			diag[counter] = new int[max - min + 1];
			while (innerCounter < diag[counter].length) {
				diag[counter][innerCounter++] = square[min++][max--];
				if (min == square.length || max < 0) {

					max++;
					if (min == square.length) {
						// go up
						min--;
						// go right
						max++;
					}
				}

			}
			counter++;
		}

		return diag;
	}

	private void swap(int min, int max) {

	}
}
