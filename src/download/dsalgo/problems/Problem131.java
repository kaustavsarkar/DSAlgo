package download.dsalgo.problems;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Write a program to solve a Sudoku puzzle by filling the empty cells. Empty
 * cells are indicated by the character '.' You may assume that there will be
 * only one unique solution.
 * 
 * 
 * 
 * A sudoku puzzle,
 * 
 * 
 * 
 * and its solution numbers marked in red.
 * 
 * Example :
 * 
 * For the above given diagrams, the corresponding input to your program will be
 * 
 * @author kaussark
 *
 */
public class Problem131 {

	public static void main(String[] args) {
		String[] board = { "53..7....", "6..195...", ".98....6.", "8...6...3",
				"4..8.3..1", "7...2...6", ".6....28.", "...419..5",
				"....8..79" };
		ArrayList<ArrayList<Character>> sudoku = new ArrayList<>();
		
		System.out.println(Arrays.toString(board));
		
		for(String s : board) {
			ArrayList<Character> charArray = new ArrayList<>();
			char[] ch = s.toCharArray();
			for(char c : ch) {
				charArray.add(c);
			}
			sudoku.add(charArray);
		}
		
		
		new Problem131().solveSudoku(sudoku);
		System.out.println(sudoku);
	}

	public void solveSudoku(ArrayList<ArrayList<Character>> a) {
		solving(a, 0, 0);
	}

	public boolean solving(ArrayList<ArrayList<Character>> board, int row,
			int col) {
		// All columns in the row have been exhausted
		if (col == board.get(row).size()) {
			col = 0;// Go to the first column
			row++; // Go to the next row

			// All rows have been exhausted and none has returned false till
			// now.
			// So journey ends here.. Bye

			if (row == board.size()) {
				return true;
			}

		}

		// Proceed if current tuple is empty
		if (board.get(row).get(col) != '.') {
			solving(board, row, col + 1);
		}

		for (int value = 1; value < 10; value++) {
			char numToPlace = (char) (value + '0');

			if (canPlaceAt(row, col, board, numToPlace)) {
				board.get(row).set(col, numToPlace);
				if (solving(board, row, col + 1))
					return true;
			}

		}
		board.get(row).set(col, '.');
		return false;
	}

	private boolean canPlaceAt(int row, int col,
			ArrayList<ArrayList<Character>> board, char numToPlace) {
		// Check all columns
		for (int colx = 0; colx < board.size(); colx++) {
			if (numToPlace == board.get(row).get(colx)) {
				return false;
			}
		}

		// Check all rows
		for (int rowx = 0; rowx < board.size(); rowx++) {
			if (numToPlace == board.get(rowx).get(col)) {
				return false;
			}
		}

		// -----Check the sub-board for possible matches-----//
		// get the starting row/col
		int topLeftRow = (row / 3) * 3;
		int topleftCol = (col / 3) * 3;

		for (int rowx = 0; rowx < 3; rowx++) {
			for (int colx = 0; colx < 3; colx++) {
				if (numToPlace == board.get(topLeftRow + rowx)
						.get(topleftCol + colx)) {
					return false;
				}
			}
		}

		return true;
	}
}
