package download.dsalgo.problems;

import java.util.*;

/**
 * Given a 2D binary matrix filled with 0’s and 1’s, find the largest rectangle
 * containing all ones and return its area.
 * 
 * Bonus if you can solve it in O(n^2) or less.
 * 
 * Example :
 * 
 * A : [ 1 1 1 0 1 1 1 0 0 ]
 * 
 * Output : 4
 * 
 * As the max area rectangle is created by the 2x2 rectangle created by (0,1),
 * (0,2), (1,1) and (1,2)
 * 
 * @author kaussark
 *
 */
public class Problem198 {

	public static void main(String[] args) {
		Integer[][] input = {{1}};
//			{ { 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
//				{ 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
//				{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
//				{ 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1 },
//				{ 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1 },
//				{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
//				{ 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1 },
//				{ 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0 },
//				{ 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 1, 0, 1 },
//				{ 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1 },
//				{ 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
//				{ 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
//				{ 1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1 },
//				{ 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
//				{ 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1 } };
		ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
		for(Integer[] i : input) {
			matrix.add(new ArrayList<>(Arrays.asList(i)));
		}
		
		System.out.println(new Problem198().maximalRectangle(matrix));
	}

	public int maximalRectangle(ArrayList<ArrayList<Integer>> A) {
		int maxArea = 0;
		int[] heights = new int[A.get(0).size()];

		for (int row = 0; row < A.size(); row++) {
			for (int col = 0; col < A.get(row).size(); col++) {

				int currVal = A.get(row).get(col);
				if (currVal == 0) {
					heights[col] = 0;
				} else {
					heights[col] += currVal;
				}

			}
			int area = findMaxArea(heights);
			maxArea = Math.max(maxArea, area);
		}
		return maxArea;
	}

	private int findMaxArea(int[] heights) {
		Stack<Integer> stackInd = new Stack<>();
		int maxArea = 0;
		int area = 0;
		int index = 0;
		while (index < heights.length) {
			if (stackInd.isEmpty()
					|| heights[index] >= heights[stackInd.peek()]) {
				stackInd.push(index++);
			} else {
				int hInd = stackInd.pop();

				if (stackInd.isEmpty()) {
					area = heights[hInd] * (index);
				} else {
					area = heights[hInd] * (index - stackInd.peek()-1);
				}
				maxArea = Math.max(area, maxArea);
			}
		}
		while (!stackInd.isEmpty()) {
			int hInd = stackInd.pop();

			if (stackInd.isEmpty()) {
				area = heights[hInd] * (index);
			} else {
				area = heights[hInd] * (index - stackInd.peek());
			}
			maxArea = Math.max(area, maxArea);
		}
		return maxArea;
	}
}
