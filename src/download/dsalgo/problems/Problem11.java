package download.dsalgo.problems;

import java.util.Arrays;

/*
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

Example:

Given n = 3,

You should return the following matrix:

[
  [ 1, 2, 3 ],
  [ 8, 9, 4 ],
  [ 7, 6, 5 ]
]
 */
public class Problem11 {

	public static void main(String[] args) {
		Problem11 problem = new Problem11();
		int[][] matrix = null;
		matrix = problem.generateMatrix(100);

		for (int[] arr : matrix) {
			System.out.println(Arrays.toString(arr));
		}
	}

	public int[][] _generateMatrix(int num) {
		if (num == 0) {
			return new int[0][0];
		}

		long square = num * num;
		int[][] matrix = new int[num][num];
		int row = 0, column = 1;
		matrix[0][0] = 1;
		int number = 2;
		while (number < square) {

			while (column >= 0 && column < num && row >= 0 && row < num) {
				// go right
				if (matrix[row][column] == 0) {
					matrix[row][column++] = number++;
				}
			}
			row++;
			column--;

		}

		return matrix;
	}

	public int[][] generateMatrix(int num) {
		if (num == 0) {
			return new int[0][0];
		}
		long square = num * num;
		int[][] matrix = new int[num][num];
		int row = 0, column = 1;
		matrix[0][0] = 1;
		for (int i = 2; i <= square;) {
			// passing right across columns
			while (column >= 0 && column < num && row >= 0 && row < num
					&& matrix[row][column] == 0) {
				matrix[row][column++] = i++;
			}
			column--;
			row++;
			// passing down rows
			while (column >= 0 && column < num && row >= 0 && row < num
					&& matrix[row][column] == 0) {
				matrix[row++][column] = i++;
			}
			row--;
			column--;
			// passing left across columns
			while (column >= 0 && column < num && row >= 0 && row < num
					&& matrix[row][column] == 0) {
				matrix[row][column--] = i++;
			}
			row--;
			column++;

			// passing up rows
			while (column < num && row < num && matrix[row][column] == 0) {
				matrix[row--][column] = i++;
			}
			row++;
			column++;

		}

		return matrix;
	}
}
