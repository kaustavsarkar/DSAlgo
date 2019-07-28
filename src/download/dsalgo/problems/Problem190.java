package download.dsalgo.problems;

import java.util.*;

/**
 * There are N coins (Assume N is even) in a line. Two players take turns to
 * take a coin from one of the ends of the line until there are no more coins
 * left. The player with the larger amount of money wins. Assume that you go
 * first.
 * 
 * Write a program which computes the maximum amount of money you can win.
 * 
 * Example:
 * 
 * suppose that there are 4 coins which have value 1 2 3 4 now you are first so
 * you pick 4 then in next term next person picks 3 then you pick 2 and then
 * next person picks 1 so total of your money is 4 + 2 = 6 next/opposite person
 * will get 1 + 3 = 4 so maximum amount of value you can get is 6
 * 
 * @author kaussark
 *
 */
public class Problem190 {

	public static void main(String[] args) {
		Integer[] array = {26, 88, 57, 26, 65, 60, 55, 40};
			//{ 1, 100, 500, 10 };
		// { 1, 2, 3, 4 };
		System.out.println(new Problem190()
				.maxcoin(new ArrayList<>(Arrays.asList(array))));
	}

	private static class Pair {
		int first;
		int second;

		public String toString() {
			return "(" + first + "," + second + ")";
		}

	}

	public int maxcoin(ArrayList<Integer> A) {
		Pair[][] moves = new Pair[A.size()][A.size()];

		// Initialize moves matrix
		for (int i = 0; i < moves.length; i++) {
			for (int j = i; j < moves[i].length; j++) {
				moves[i][j] = new Pair();
			}
		}
		// Populate diagonal values
		for (int i = 0; i < moves.length; i++) {
			moves[i][i].first = A.get(i);
			moves[i][i].second = 0;
		}

		// Run computation
		for (int scope = 2; scope <= A.size(); scope++) {
			for (int row = 0; row + scope - 1 <= A.size() - 1; row++) {
				int col = row + scope - 1;

				if (A.get(row) + moves[row + 1][col].second > A.get(col)
						+ moves[row][col - 1].second) {
					moves[row][col].first = A.get(row)
							+ moves[row + 1][col].second;
					moves[row][col].second = moves[row+1][col].first;
				} else {
					moves[row][col].first = A.get(col)
							+ moves[row][col - 1].second;
					moves[row][col].second = moves[row][col - 1].first;
				}
			}
		}
		return moves[0][A.size() - 1].first;
	}
}
