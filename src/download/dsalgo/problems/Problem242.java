package download.dsalgo.problems;

import java.util.*;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cell, where
 * "adjacent" cells are those horizontally or vertically neighboring. The cell
 * itself does not count as an adjacent cell. The same letter cell may be used
 * more than once.
 * 
 * Example :
 * 
 * Given board =
 * 
 * [ ["ABCE"], ["SFCS"], ["ADEE"] ] word = "ABCCED", -> returns 1, word = "SEE",
 * -> returns 1, word = "ABCB", -> returns 1, word = "ABFSAB" -> returns 1 word
 * = "ABCD" -> returns 0 Note that 1 corresponds to true, and 0 corresponds to
 * false.
 * 
 * @author kaussark
 *
 */
public class Problem242 {

	public static void main(String[] args) {

	}
	
	
	
	public int exist(ArrayList<String> A, String B) {
		
		for(int row = 0; row < A.size(); row++) {
			for(int col = 0; col < A.get(row).length(); col++) {
				boolean found = false;
				if(B.charAt(0) == A.get(row).charAt(col)) {
					found = performDFS(A,B,row,col);
				}
				if(found) {
					return 1;
				}
			}
		}
		return 0;
    }



	private boolean performDFS(ArrayList<String> a, String b, int row,
			int col) {

		if(b == null || b.isEmpty()) {
			return true;
		}

		if(row < 0 || row > a.size() || col < 0 || col > a.get(row).length()) {
			return false;
		}


		boolean found = false;
		if(a.get(row).charAt(col) == b.charAt(0)) {
			found = performDFS(a, b.substring(1), row+1, col) ||
					performDFS(a, b.substring(1), row-1, col) ||
					performDFS(a, b.substring(1), row, col+1) ||
					performDFS(a, b.substring(1), row, col-1);
		}
		
		return found;
	}

}
