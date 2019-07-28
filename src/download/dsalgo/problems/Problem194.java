package download.dsalgo.problems;

import java.util.*;

/**
 * Two kingdoms are on a war right now, kingdom X and kingdom Y. As a war
 * specialist of kingdom X, you scouted kingdom Y area.
 * 
 * A kingdom area is defined as a N x M grid with each cell denoting a village.
 * Each cell has a value which denotes the strength of each corresponding
 * village. The strength can also be negative, representing those warriors of
 * your kingdom who were held hostages.
 * 
 * There’s also another thing to be noticed.
 * 
 * The strength of any village on row larger than one (2<=r<=N) is stronger or
 * equal to the strength of village which is exactly above it. The strength of
 * any village on column larger than one (2<=c<=M) is stronger or equal to the
 * strength of vilage which is exactly to its left. (stronger means having
 * higher value as defined above). So your task is, find the largest sum of
 * strength that you can erase by bombing one sub-matrix in the grid.
 * 
 * Input format:
 * 
 * First line consists of 2 integers N and M denoting the number of rows and
 * columns in the grid respectively. The next N lines, consists of M integers
 * each denoting the strength of each cell.
 * 
 * 1 <= N <= 1500 1 <= M <= 1500 -200 <= Cell Strength <= 200 Output:
 * 
 * The largest sum of strength that you can get by choosing one sub-matrix.
 * Example:
 * 
 * Input: 3 3 -5 -4 -1 -3 2 4 2 5 8
 * 
 * Output: 19
 * 
 * Explanation: Bomb the sub-matrix from (2,2) to (3,3): 2 + 4 + 5 + 8 = 19
 * 
 * @author kaussark
 *
 */
public class Problem194 {

	public static void main(String[] args) {
		Integer[][] input = {{-200}};
		ArrayList<ArrayList<Integer>> strength = new ArrayList<>();
		
		for(Integer[] s : input) {
			strength.add(new ArrayList<>(Arrays.asList(s)));
		}
		
		System.out.println(new Problem194().solve(strength));
	}

	public int solve(ArrayList<ArrayList<Integer>> A) {
		List<List<Integer>> maxArea = (List<List<Integer>>) A.clone();
		maxArea.get(0).set(0, A.get(0).get(0));
		int area = maxArea.get(0).get(0);
		// fill 1st Row
		for (int col = 1; col < A.get(0).size(); col++) {
			maxArea.get(0).set(col, Math.max(A.get(0).get(col),
					A.get(0).get(col - 1) + A.get(0).get(col)));
		}

		// Fill first Column
		for (int row = 1; row < maxArea.size(); row++) {
			maxArea.get(row).set(0, Math.max(A.get(row).get(0),
					A.get(row).get(0) + A.get(row - 1).get(0)));
		}

		// Fill rest coords
		for (int row = 1; row < maxArea.size(); row++) {
			for (int col = 1; col < maxArea.get(row).size(); col++) {
				int currStrength = A.get(row).get(col);
				int left = A.get(row).get(col - 1);
				int up = A.get(row - 1).get(col);
				int adj = A.get(row - 1).get(col - 1) + up + left;
				maxArea.get(row).set(col, Math.max(currStrength, currStrength + adj));
				
				if(maxArea.get(row).get(col) > area) {
					area = maxArea.get(row).get(col);
				}
			}
		}
		return area;
	}
}
