package download.dsalgo.problems;

import java.util.*;

/**
 * The demons had captured the princess (P) and imprisoned her in the
 * bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid
 * out in a 2D grid. Our valiant knight (K) was initially positioned in the
 * top-left room and must fight his way through the dungeon to rescue the
 * princess.
 * 
 * The knight has an initial health point represented by a positive integer. If
 * at any point his health point drops to 0 or below, he dies immediately.
 * 
 * Some of the rooms are guarded by demons, so the knight loses health (negative
 * integers) upon entering these rooms; other rooms are either empty (0’s) or
 * contain magic orbs that increase the knight’s health (positive integers).
 * 
 * In order to reach the princess as quickly as possible, the knight decides to
 * move only rightward or downward in each step.
 * 
 * Write a function to determine the knight’s minimum initial health so that he
 * is able to rescue the princess.
 * 
 * For example, given the dungeon below, the initial health of the knight must
 * be at least 7 if he follows the optimal path
 * 
 * RIGHT-> RIGHT -> DOWN -> DOWN.
 * 
 * Dungeon Princess: Example 1
 * 
 * 
 * 
 * Input arguments to function: Your function will get an M*N matrix (2-D array)
 * as input which represents the 2D grid as described in the question. Your
 * function should return an integer corresponding to the knight’s minimum
 * initial health required.
 * 
 * 
 * 
 * Note: The knight’s health has no upper bound. Any room can contain threats or
 * power-ups, even the first room the knight enters and the bottom-right room
 * where the princess is imprisoned.
 * 
 * @author kaussark
 *
 */
public class Problem196 {

	public static void main(String[] args) {

	}

	public int calculateMinimumHP(ArrayList<ArrayList<Integer>> A) {
		List<List<Integer>> power = (List<List<Integer>>) A.clone();
		int rows = power.size();
		int cols = power.get(rows - 1).size();

		int lastVal = Math.abs(power.get(rows - 1).get(cols - 1));

		power.get(rows - 1).set(cols - 1, Math.max(lastVal + 1, 1));

		// fill last row
		for (int col = cols - 2; col >= 0; col--) {
			int rightVal = power.get(rows - 1).get(col + 1);
			int currVal = power.get(rows - 1).get(col);
			int diff = rightVal - currVal;
			if (diff < 0) { // Means current val is high positive
				power.get(rows - 1).set(col, 1);
			} else {
				power.get(rows - 1).set(col, diff);
			}
		}

		// Fill last column
		for (int row = rows - 2; row >= 0; row--) {
			int downVal = power.get(row + 1).get(cols - 1);
			int currVal = power.get(row).get(cols - 1);
			int diff = downVal - currVal;
			if (diff < 0) {
				power.get(row).set(cols - 1, 1);
			} else {
				power.get(row).set(cols - 1, diff);
			}
		}

		// Fill rest columns
		for (int row = rows - 2; row >= 0; row--) {
			for (int col = cols - 2; col >= 0; col--) {
				int currVal = power.get(row).get(col);
				int rightVal = power.get(row).get(col+1);
				int downVal = power.get(row+1).get(col);
				int diff = Math.min(rightVal, downVal) - currVal;
				if(diff < 0) {
					power.get(row).set(col, 1);
				} else {
					power.get(row).set(col, diff);
				}
			}
		}

		return power.get(0).get(0);
	}
}
