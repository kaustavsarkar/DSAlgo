package download.dsalgo.problems;

import java.util.*;

/**
 * Given N * M field of O's and X's, where O=white, X=black Return the number of
 * black shapes. A black shape consists of one or more adjacent X's (diagonals
 * not included)
 * 
 * Example:
 * 
 * OOOXOOO OOXXOXO OXOOOXO
 * 
 * answer is 3 shapes are : (i) X X X (ii) X (iii) X X Note that we are looking
 * for connected shapes here.
 * 
 * For example,
 * 
 * XXX XXX XXX is just one single connected black shape.
 * 
 * @author kaussark
 *
 */
public class Problem238 {

	public static void main(String[] args) {

	}

	public int black(ArrayList<String> A) {
		int count = 0;
		for (int row = 0; row < A.size(); row++) {
			for (int col = 0; col < A.get(row).length(); col++) {
				if(A.get(row).charAt(col) == 'X') {
					markVisited(A,row,col);
					count++;
				}
			}
		}
		return count;
	}

	private void markVisited(ArrayList<String> a, int row, int col) {
		if(row < 0 || col < 0 || row >= a.size() || col >= a.get(row).length()) {
			return;
		}
		
		if(a.get(row).charAt(col) != 'X' ) {
			return;
		}
		
		//Mark visited
		StringBuilder line = new StringBuilder(a.get(row));
		line.setCharAt(col, 'V');
		a.set(row, line.toString());
		
		//Check adjacent cells
		markVisited(a, row+1, col);
		markVisited(a, row-1, col);
		markVisited(a, row, col+1);
		markVisited(a, row, col-1);
	}

}
