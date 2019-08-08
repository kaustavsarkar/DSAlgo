package download.dsalgo.problems;

import java.util.*;

/**
 * On a N * M chessboard, where rows are numbered from 1 to N and columns from 1
 * to M, there are queens at some cells. Return a N * M array A, where A[i][j]
 * is number of queens that can attack cell (i, j). While calculating answer for
 * cell (i, j), assume there is no queen at that cell.
 * 
 * Notes:
 * 
 * Queen is able to move any number of squares vertically, horizontally or
 * diagonally on a chessboard. A queen cannot jump over another queen to attack
 * a position. You are given an array of N strings, each of size M. Each
 * character is either a 1 or 0 denoting if there is a queen at that position or
 * not, respectively. Expected time complexity is worst case O(N*M). For
 * example,
 * 
 * Let chessboard be, [0 1 0] [1 0 0] [0 0 1]
 * 
 * where a 1 denotes a queen at that position.
 * 
 * Cell (1, 1) is attacked by queens at (2, 1), (1,2) and (3,3). Cell (1, 2) is
 * attacked by queen at (2, 1). Note that while calculating this, we assume that
 * there is no queen at (1, 2). Cell (1, 3) is attacked by queens at (3, 3) and
 * (1, 2). and so on...
 * 
 * Finally, we return matrix [3, 1, 2] [1, 3, 3] [2, 3, 0]
 * 
 * @author kaussark
 *
 */
public class Problem200 {

	public static void main(String[] args) {
		String[] array = { "010 ", " 100", "001" };
		System.out.println(new Problem200()
				.queenAttack(new ArrayList<>(Arrays.asList(array))));

	}

	public ArrayList<ArrayList<Integer>> _queenAttack(ArrayList<String> A) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		if (A.isEmpty()) {
			return result;
		}

		boolean threat[][][] = new boolean[A.size()][A.get(0).length()][8];
		// 0 -> south west
		// 1 -> south
		// 2 -> south east
		// 3 -> east
		// 4 -> north east
		// 5 -> north
		// 6 -> north west
		// 7 -> west

		for (int row = 0; row < A.size(); row++) {
			result.add(new ArrayList<>());
			for (int col = 0; col < A.get(row).length(); col++) {
				int num = 0;

				if (col > 0) {
					if (threat[row][col - 1][7]
							|| A.get(row).charAt(col - 1) == '1') {
						num++;
						threat[row][col][7] = true;
					}
					if (row > 0) {
						if (threat[row - 1][col - 1][6]
								|| A.get(row - 1).charAt(col - 1) == '1') {
							num++;
							threat[row][col][6] = true;
						}
					}
				}
				if (row > 0) {
					if (threat[row - 1][col][5]
							|| A.get(row - 1).charAt(col) == '1') {
						num++;
						threat[row][col][5] = true;
					}
					if (col < A.get(row).length() - 1) {
						if (threat[row - 1][col + 1][4]
								|| A.get(row - 1).charAt(col + 1) == '1') {
							num++;
							threat[row][col][4] = true;
						}
					}
				}
				result.get(row).add(num);
			}

		}

		for (int row = A.size() - 1; row >= 0; row--) {
			for (int col = A.get(row).length() - 1; col >= 0; col--) {
				int num = 0;
				if (col < A.get(row).length() - 1) {
					if (threat[row][col + 1][3]
							|| A.get(row).charAt(col + 1) == '1') {
						num++;
						threat[row][col][3] = true;
					}
					if (row < A.size() - 1) {
						if (threat[row + 1][col + 1][2]
								|| A.get(row + 1).charAt(col + 1) == '1') {
							num++;
							threat[row][col][2] = true;
						}
					}
				}
				if (row < A.size() - 1) {
					if (threat[row + 1][col][1]
							|| A.get(row + 1).charAt(col) == '1') {
						threat[row][col][1] = true;
						num++;
					}
					if (col > 0) {
						if (threat[row + 1][col - 1][0]
								|| A.get(row + 1).charAt(col - 1) == '1') {
							num++;
							threat[row][col][0] = true;
						}
					}
				}
				result.get(row).set(col, num + result.get(row).get(col));
			}
		}
		return result;
	}

	public ArrayList<ArrayList<Integer>> queenAttack(ArrayList<String> A) {

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (A.size() == 0)
			return result;

		boolean[][][] h = new boolean[A.size()][A.get(0).length()][8];

		for (int i = 0; i < A.size(); i++) {
			result.add(new ArrayList<Integer>());
			for (int j = 0; j < A.get(i).length(); j++) {
				int num = 0;
				if (j > 0) {
					if (h[i][j - 1][7] || A.get(i).charAt(j - 1) == '1') {
						num++;
						h[i][j][7] = true;
					}
					if (i > 0) {
						if (h[i - 1][j - 1][6]
								|| A.get(i - 1).charAt(j - 1) == '1') {
							num++;
							h[i][j][6] = true;
						}
					}
				}

				if (i > 0) {
					if (h[i - 1][j][5] || A.get(i - 1).charAt(j) == '1') {
						num++;
						h[i][j][5] = true;
					}
					if (j < A.get(i).length() - 1) {
						if (h[i - 1][j + 1][4]
								|| A.get(i - 1).charAt(j + 1) == '1') {
							// System.out.println(i + " " + j + " " +
							// A.get(i-1).charAt(j+1) + " " + (((h[i-1][j+1] &
							// (1<<4)) != 0)?1:0));
							num++;
							h[i][j][4] = true;
						}
					}
				}
				// System.out.println(num);
				result.get(i).add(num);
			}
		}

		for (int i = A.size() - 1; i >= 0; i--) {
			for (int j = A.get(i).length() - 1; j >= 0; j--) {
				int num = 0;
				if (j < A.get(i).length() - 1) {
					if (h[i][j + 1][3] || A.get(i).charAt(j + 1) == '1') {
						num++;
						h[i][j][3] = true;
					}
					if (i < A.size() - 1) {
						if (h[i + 1][j + 1][2]
								|| A.get(i + 1).charAt(j + 1) == '1') {
							num++;
							h[i][j][2] = true;
						}
					}
				}

				if (i < A.size() - 1) {
					if (h[i + 1][j][1] || A.get(i + 1).charAt(j) == '1') {
						num++;
						h[i][j][1] = true;
					}
					if (j > 0) {
						if (h[i + 1][j - 1][0]
								|| A.get(i + 1).charAt(j - 1) == '1') {
							num++;
							h[i][j][0] = true;
						}
					}
				}
				result.get(i).set(j, num + result.get(i).get(j));
			}
		}

		return result;
	}
}
