package download.dsalgo.problems;

import java.util.*;

/**
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by
 * 'X'.
 * 
 * A region is captured by flipping all 'O's into 'X's in that surrounded
 * region.
 * 
 * For example,
 * 
 * X X X X X O O X X X O X X O X X After running your function, the board should
 * be:
 * 
 * X X X X X X X X X X X X X O X X
 * 
 * @author kaussark
 *
 */
public class Problem239 {

	public static void main(String[] args) {

	}

	public void solve(ArrayList<ArrayList<Character>> a) {
		int length = a.size();
		if (a == null || length == 0) {
			return;
		}

		// start from row 0 and length-1
		for (int col = 0; col < a.get(0).size(); col++) {
			markSafe(a, 0, col);
			markSafe(a, length - 1, col);
		}

		// start from col 0 and a.get(length-1).size()
		for (int row = 0; row < a.size(); row++) {
			markSafe(a, row, 0);
			markSafe(a, row, a.get(row).size() - 1);
		}
		
		for(int row = 0; row < a.size(); row++) {
			for(int col = 0; col< a.get(row).size(); col++) {
				if(a.get(row).get(col) == 'S') {
					a.get(row).set(col, 'O');
				} else {
					a.get(row).set(col, 'X');
				}
			}
		}

	}

	private void markSafe(ArrayList<ArrayList<Character>> a, int row, int col) {
		if (row < 0 || row >= a.size() || col < 0 || col >= a.get(row).size()) {
			return;
		}

		if (a.get(row).get(col) == 'O') {
			a.get(row).set(col, 'S');
			markSafe(a, row + 1, col);
			markSafe(a, row - 1, col);
			markSafe(a, row, col - 1);
			markSafe(a, row, col + 1);
			return;
		}

	}
}
