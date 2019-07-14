package download.dsalgo.problems;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard
 * such that no two queens attack each other.
 * 
 * N Queens: Example 1
 * 
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * 
 * Each solution contains a distinct board configuration of the n-queens’
 * placement, where 'Q' and '.' both indicate a queen and an empty space
 * respectively.
 * 
 * For example, There exist two distinct solutions to the 4-queens puzzle:
 * 
 * [ [".Q..", // Solution 1 "...Q", "Q...", "..Q."],
 * 
 * ["..Q.", // Solution 2 "Q...", "...Q", ".Q.."] ]
 * 
 * @author kaussark
 *
 */
public class Problem115 {

	public static void main(String[] args) {
		System.out.println(new Problem115().solveNQueens(4));
	}

	public ArrayList<ArrayList<String>> _solveNQueens(int a) {

		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();

		if (a <= 0) {
			return result;
		}

		int[] colx = new int[a];
		compute(result, a, 0, colx);
		return result;
	}

	private void compute(ArrayList<ArrayList<String>> output, int len, int row,
			int[] columns) {

		if (row == len) {
			addResults(output, columns);
			return;
		}

		for (int col = 0; col < len; col++) {
			if (canQueenBePlaced(row, col, columns)) {
				columns[row] = col;
				compute(output, len, row + 1, columns);
			}
		}
	}

	private boolean canQueenBePlaced(int row1, int column1, int[] columns1) {
		for (int row2 = 0; row2 < row1; row2++) {
			int column2 = columns1[row2];

			if (column1 == column2) {
				return false;
			}

			int dColumn = Math.abs(column2 - column1);
			int dRow = row1 - row2;

			if (dColumn == dRow) {
				return false;
			}
		}
		return true;
	}

	private void addResults(ArrayList<ArrayList<String>> output,
			int[] tempCol) {
		ArrayList<String> res = new ArrayList<String>();

		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < tempCol.length; i++) {
			int pos = tempCol[i];
			for (int j = 0; j < tempCol.length; j++) {
				if (pos == j) {
					builder.append('Q');
				} else {
					builder.append('.');
				}
			}
			if (i != tempCol.length - 1) {
				builder.append(' ');
			}
		}
		res.add(builder.toString());
		output.add(res);
	}

	public ArrayList<ArrayList<String>> solveNQueens(int a) {
		ArrayList<ArrayList<ArrayList<Integer>>> allCoords = new ArrayList<>();
		boolean isSolved = false;
		for (int i = 0; i < a; i++) {
			ArrayList<ArrayList<Integer>> coords = new ArrayList<>();
			isSolved = pushQueens(coords, i, a);
			if (isSolved) {
				System.out.println(coords);
				allCoords.add(coords);
			}
		}
		System.out.println(allCoords);
		// ArrayList<ArrayList<String>> queenCoords = new ArrayList<>();
		// if (isSolved) {
		// for (int i = 0; i < a; i++) {
		// queenCoords.add(new ArrayList<>());
		// for (int j = 0; j < a; j++) {
		// queenCoords.get(i).add(".");
		// }
		// }
		// for (ArrayList<ArrayList<Integer>> coord : allCoords) {
		// int row = coord.get(0);
		// int col = coord.get(1);
		//
		// queenCoords.get(row).set(col, "Q");
		// }
		//
		// return queenCoords;
		// }
		return null;
	}

	public boolean pushQueens(ArrayList<ArrayList<Integer>> queens, int col,
			int a) {
		if (col >= a) {
			return true;
		}

		int row = 0;
		while (row < a) {
			ArrayList<Integer> coords = new ArrayList<>(
					Arrays.asList(new Integer[] { row, col }));
			queens.add(coords);
			if (isSafe(queens, row, col) && pushQueens(queens, col + 1, a)) {
				return true;
			}
			queens.remove(queens.size() - 1);
			row++;
		}

		return false;
	}

	// 1. No two queens in same row
	// 2. |row1-row2| != |col1-col2|
	private boolean isSafe(ArrayList<ArrayList<Integer>> queens, int row,
			int col) {
		for (int i = 0; i < queens.size() - 1; i++) {
			int rowCheck = queens.get(i).get(0);
			int colCheck = queens.get(i).get(1);

			if (rowCheck == row) {
				return false;
			}

			if (Math.abs(rowCheck - row) == Math.abs(colCheck - col)) {
				return false;
			}
		}
		return true;
	}
}
