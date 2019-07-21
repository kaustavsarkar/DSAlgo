package download.dsalgo.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

/**
 * Given a binary grid i.e. a 2D grid only consisting of 0’s and 1’s, find the
 * area of the largest rectangle inside the grid such that all the cells inside
 * the chosen rectangle should have 1 in them. You are allowed to permutate the
 * columns matrix i.e. you can arrange each of the column in any order in the
 * final grid. Please follow the below example for more clarity.
 * 
 * Lets say we are given a binary grid of 3 * 3 size.
 * 
 * 1 0 1
 * 
 * 0 1 0
 * 
 * 1 0 0
 * 
 * At present we can see that max rectangle satisfying the criteria mentioned in
 * the problem is of 1 * 1 = 1 area i.e either of the 4 cells which contain 1 in
 * it. Now since we are allowed to permutate the columns of the given matrix, we
 * can take column 1 and column 3 and make them neighbours. One of the possible
 * configuration of the grid can be:
 * 
 * 1 1 0
 * 
 * 0 0 1
 * 
 * 1 0 0
 * 
 * Now In this grid, first column is column 1, second column is column 3 and
 * third column is column 2 from the original given grid. Now, we can see that
 * if we calculate the max area rectangle, we get max area as 1 * 2 = 2 which is
 * bigger than the earlier case. Hence 2 will be the answer in this case.
 * 
 * @author kaussark
 *
 */
public class Problem174 {

	public static void main(String[] args) {
		Integer[][] array = { { 1, 0, 1 }, { 1, 0, 1 }, { 1, 0, 1 } };
		ArrayList<ArrayList<Integer>> input = new ArrayList<>();

		for (Integer[] row : array) {
			input.add(new ArrayList<>(Arrays.asList(row)));
		}

		System.out.println(new Problem174().solve(input));
	}
	public int solve(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> hist = new ArrayList<>();

        for (int i = 0; i < A.size(); i++) {
            ArrayList<Integer> row = A.get(i);
            ArrayList<Integer> histRow = new ArrayList<>();
            for (int j = 0; j < row.size(); j++) {
                int count = 0;
                if (row.get(j) == 1) {
                    count = 1;
                    if (i != 0) {
                        count += hist.get(i - 1).get(j);
                    }
                }
                histRow.add(count);
            }
            hist.add(histRow);
        }

        for(ArrayList<Integer> row: hist){
            row.sort(Collections.reverseOrder());
        }

        int maxArea = 0;
        for(ArrayList<Integer> row: hist){
            for(int j=0; j<row.size(); j++){
                maxArea = Math.max(maxArea,(j+1) * row.get(j));
            }
        }

        //System.out.println(maxArea);
        return maxArea;
    }
	public int _solve(ArrayList<ArrayList<Integer>> A) {
		int[] colHigh = new int[A.get(0).size()];
		int maxArea = 0;
		for (int row = 0; row < A.size(); row++) {
			
			for (int col = 0; col < A.get(row).size(); col++) {
				int entry = A.get(row).get(col);
				if (entry == 0) {
					colHigh[col] = 0;
				} else {
					colHigh[col] += entry;
				}
			}

			maxArea = Math.max(maxArea, getMaxArea(colHigh));
		}
		return maxArea;
	}

	private int getMaxArea(int[] colHigh) {
		Stack<Integer> highIndices = new Stack<>();
		int indexCounter = 0;
		int maxArea = 0;
		while (indexCounter < colHigh.length) {
			if (highIndices.isEmpty()
					|| colHigh[indexCounter] > colHigh[highIndices.peek()]) {
				highIndices.push(indexCounter++);
			} else {
				int index = highIndices.pop();
				int area = colHigh[index]
						* (highIndices.isEmpty() ? indexCounter - 1
								: indexCounter - 1 - highIndices.peek());
				maxArea = Math.max(maxArea, area);
			}
		}

		while (!highIndices.isEmpty()) {
			int currindex = highIndices.pop();
			int area = colHigh[currindex]
					* (highIndices.isEmpty() ? indexCounter - 1
							: indexCounter - 1 - highIndices.peek());
			maxArea = Math.max(maxArea, area);
		}
		return maxArea;
	}
}
