package download.dsalgo.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * A long array A[] is given to you. There is a sliding window of size w which
 * is moving from the very left of the array to the very right. You can only see
 * the w numbers in the window. Each time the sliding window moves rightwards by
 * one position. You have to find the maximum for each window. The following
 * example will give you more clarity.
 * 
 * Example :
 * 
 * The array is [1 3 -1 -3 5 3 6 7], and w is 3.
 * 
 * Window position Max
 * 
 * [1 3 -1] -3 5 3 6 7 3 1 [3 -1 -3] 5 3 6 7 3 1 3 [-1 -3 5] 3 6 7 5 1 3 -1 [-3
 * 5 3] 6 7 5 1 3 -1 -3 [5 3 6] 7 6 1 3 -1 -3 5 [3 6 7] 7 Input: A long array
 * A[], and a window width w Output: An array B[], B[i] is the maximum value of
 * from A[i] to A[i+w-1] Requirement: Find a good optimal way to get B[i]
 * 
 * @author kaussark
 *
 */
public class Problem110 {

	public static void main(String[] args) {
		Integer[] array = { 648, 614, 490, 138, 657, 544, 745, 582, 738, 229,
				775, 665, 876, 448, 4, 81, 807, 578, 712, 951, 867, 328, 308,
				440, 542, 178, 637, 446, 882, 760, 354, 523, 935, 277, 158, 698,
				536, 165, 892, 327, 574, 516, 36, 705, 900, 482, 558, 937, 207,
				368 };
		// { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		System.out.println(Arrays.toString(array));
		System.out.println(
				new Problem110().slidingMaximum(Arrays.asList(array), 9));
	}

	public ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
		ArrayList<Integer> maxNum = new ArrayList<>();
		int max = Integer.MIN_VALUE;
		if (A.size() <= B) {
			for (int num : A) {
				max = Math.max(max, num);
			}
			maxNum.add(max);
			return maxNum;
		}
		Deque<Integer> maxWinIndices = new LinkedList<>();

		for (int i = 0; i < B; i++) {
			if (maxWinIndices.isEmpty()
					|| A.get(i) < A.get(maxWinIndices.peekLast())) {
				maxWinIndices.add(i);
			} else {
				while (!maxWinIndices.isEmpty()
						&& A.get(maxWinIndices.peekLast()) <= A.get(i)) {
					maxWinIndices.pollLast();
				}
				maxWinIndices.add(i);
			}
		}

		for (int i = B; i < A.size(); i++) {

			maxNum.add(A.get(maxWinIndices.peekFirst()));

			if (i - maxWinIndices.peekFirst() + 1 > B) {
				maxWinIndices.poll();
			}

			if (maxWinIndices.isEmpty()
					|| A.get(i) < A.get(maxWinIndices.peekLast())) {
				maxWinIndices.add(i);
			} else {
				while (!maxWinIndices.isEmpty()
						&& A.get(maxWinIndices.peekLast()) <= A.get(i)) {
					maxWinIndices.pollLast();
				}
				maxWinIndices.add(i);
			}

		}

		maxNum.add(A.get(maxWinIndices.peekFirst()));

		return maxNum;
	}

}
