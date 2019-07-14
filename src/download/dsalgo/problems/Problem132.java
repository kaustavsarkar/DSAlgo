package download.dsalgo.problems;

import java.util.Arrays;
import java.util.List;

/**
 * Determine if a Sudoku is valid, according to:
 * http://sudoku.com.au/TheRules.aspx
 * 
 * The Sudoku board could be partially filled, where empty cells are filled with
 * the character ‘.’.
 * 
 * 
 * 
 * The input corresponding to the above configuration :
 * 
 * ["53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1",
 * "7...2...6", ".6....28.", "...419..5", "....8..79"] A partially filled sudoku
 * which is valid.
 * 
 * Note: A valid Sudoku board (partially filled) is not necessarily solvable.
 * Only the filled cells need to be validated. Return 0 / 1 ( 0 for false, 1 for
 * true ) for this problem
 * 
 * 
 * @author kaussark
 *
 */
public class Problem132 {

	public static void main(String[] args) {
		String[] board = { "..5.....6", "....14...", ".........", ".....92..",
				"5....2...", ".......3.", "...54....", "3.....42.",
				"...27.6.." };

		for (String s : board) {
			System.out.println(s);
		}
		System.out
				.println(new Problem132().isValidSudoku(Arrays.asList(board)));
	}

	public int isValidSudoku(final List<String> A) {

		for (int rowx = 0; rowx < A.size(); rowx++) {
			String row = A.get(rowx);
			for (int colx = 0; colx < row.length(); colx++) {
				if (row.charAt(colx) != '.'
						&& !isValidEntry(rowx, colx, A, row.charAt(colx)))
					return 0;
			}
		}

		return 1;
	}

	private boolean isValidEntry(int row, int col, List<String> board,
			Character number) {

		// Check all rows
		for (int rowx = 0; rowx < board.size(); rowx++) {
			if (rowx != row && number == board.get(rowx).charAt(col)) {
				return false;
			}
		}

		// Check all cols
		for (int colx = 0; colx < board.get(row).length(); colx++) {
			if (colx != col && number == board.get(row).charAt(colx)) {
				return false;
			}
		}

		// Check subBox
		int topLeftRow = (row / 3) * 3;
		int topLeftCol = (col / 3) * 3;

		for (int rowx = 0; rowx < 3; rowx++) {
			for (int colx = 0; colx < 3; colx++) {
				if (number == board.get(topLeftRow + rowx)
						.charAt(topLeftCol + colx)) {
					if (topLeftCol + colx != col || topLeftRow + rowx != row)
						return false;
				}
			}
		}

		return true;
	}
}
