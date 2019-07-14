package download.dsalgo.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * Given n non-negative integers representing the histogram’s bar height where
 * the width of each bar is 1, find the area of largest rectangle in the
 * histogram.
 * 
 * Largest Rectangle in Histogram: Example 1
 * 
 * Above is a histogram where width of each bar is 1, given height =
 * [2,1,5,6,2,3].
 * 
 * Largest Rectangle in Histogram: Example 2
 * 
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 * 
 * For example, Given height = [2,1,5,6,2,3], return 10.
 * 
 * @author kaussark
 *
 */
public class Problem109 {

	public static void main(String[] args) {
		Integer[] array = { 2, 1, 5, 6, 2, 3 };
		System.out.println(new Problem109()
				.largestRectangleArea(new ArrayList<>(Arrays.asList(array))));
	}

	// First solve it with n^2
	public int n2Solution(ArrayList<Integer> A) {
		int maxArea = 0;
		for (int i = 0; i < A.size(); i++) {
			int area = 0;
			int leftCounter = i - 1;
			int rightCounter = i + 1;
			while (leftCounter >= 0 || rightCounter < A.size()) {
				if (leftCounter >= 0 && A.get(leftCounter) >= A.get(i)) {
					leftCounter--;
				}
				if (rightCounter < A.size()
						&& A.get(rightCounter) >= A.get(i)) {
					rightCounter++;
				}
				if (leftCounter < 0) {
					leftCounter = 0;
				}
				if (rightCounter == A.size()) {
					rightCounter = -rightCounter;
				}
			}
			area = A.get(i) * (rightCounter - leftCounter);

			if (area > maxArea)
				maxArea = area;

		}

		return maxArea;
	}

	// Solution with O(n) time complexity
	public int largestRectangleArea(ArrayList<Integer> A) {
		int maxArea = 0;
		Stack<Integer> indices = new Stack<>();
		int anchor = 0;
		while (anchor < A.size()) {
			if (indices.isEmpty() || A.get(anchor) >= A.get(indices.peek())) {
				indices.push(anchor++);
			} else {
				int area = 0;
				int curr = indices.isEmpty() ? 0 : indices.pop();
				area = A.get(curr) * (anchor - 1
						- (indices.isEmpty() ? -1 : indices.peek()));
				if (area > maxArea) {
					maxArea = area;
				}
			}

		}

		while (!indices.isEmpty()) {
			int curr = indices.pop();
			int area = A.get(curr)
					* (anchor - 1 - (indices.isEmpty() ? -1 : indices.peek()));
			if (area > maxArea) {
				maxArea = area;
			}

		}

		return maxArea;
	}
}
