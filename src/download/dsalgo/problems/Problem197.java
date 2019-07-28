package download.dsalgo.problems;

import java.util.*;

/**
 * Given a grid of size m * n, lets assume you are starting at (1,1) and your
 * goal is to reach (m,n). At any instance, if you are on (x,y), you can either
 * go to (x, y + 1) or (x + 1, y).
 * 
 * Now consider if some obstacles are added to the grids. How many unique paths
 * would there be? An obstacle and empty space is marked as 1 and 0 respectively
 * in the grid.
 * 
 * Example : There is one obstacle in the middle of a 3x3 grid as illustrated
 * below.
 * 
 * [ [0,0,0], [0,1,0], [0,0,0] ] The total number of unique paths is 2.
 * 
 * Note: m and n will be at most 100.
 * 
 * @author kaussark
 *
 */
public class Problem197 {

	public static void main(String[] args) {

	}

	int currPaths = 0;

	public int uniquePathsWithObstacles(ArrayList<ArrayList<Integer>> A) {
		uniquePathsWithObstacles(A, 0, 0);
		return currPaths;
	}

	private void uniquePathsWithObstacles(ArrayList<ArrayList<Integer>> a,
			int row, int col) {
		if (row > a.size() || col > a.get(row).size()
				|| a.get(row).get(col) == 1) {
			return;
		}

		if (row == a.size() - 1 && col == a.get(row).size() - 1) {
			currPaths++;
		}
		
		uniquePathsWithObstacles(a, row+1, col);
		uniquePathsWithObstacles(a, row, col+1);

	}
}
