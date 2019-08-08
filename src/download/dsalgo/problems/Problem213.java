package download.dsalgo.problems;

import java.util.*;

/**
 * Find the longest increasing subsequence of a given sequence / array.
 * 
 * In other words, find a subsequence of array in which the subsequence’s
 * elements are in strictly increasing order, and in which the subsequence is as
 * long as possible. This subsequence is not necessarily contiguous, or unique.
 * In this case, we only care about the length of the longest increasing
 * subsequence.
 * 
 * Example :
 * 
 * Input : [0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15] Output : 6 The
 * sequence : [0, 2, 6, 9, 13, 15] or [0, 4, 6, 9, 11, 15] or [0, 4, 6, 9, 13,
 * 15]
 * 
 * @author kaussark
 *
 */
public class Problem213 {

	public static void main(String[] args) {
		Integer[] input = { 30, 92, 22, 48, 52, 64, 92, 50, 85, 38, 97, 15, 14,
				75, 59, 46, 74, 6, 95, 67, 86, 88, 25, 49, 67, 69, 50, 99, 83,
				49, 60, 6, 90, 1, 50, 41, 57, 18, 36, 5, 44, 100, 23, 33, 52,
				11, 46, 49, 34, 27, 77, 57, 93, 82, 38, 95, 6, 51, 100, 32, 11,
				26, 50, 3, 55, 39, 84, 54, 44, 75, 76, 51, 21, 40, 28, 50, 30,
				6, 84, 58, 76, 42, 35, 49, 98, 49, 13, 101, 3, 1, 60, 48, 99,
				70 };
		// { 69, 54, 19, 51, 16, 54, 64, 89, 72, 40, 31, 43, 1,
		// 11, 82, 65, 75, 67, 25, 98, 31, 77, 55, 88, 85, 76, 35, 101, 44,
		// 74, 29, 94, 72, 39, 20, 24, 23, 66, 16, 95, 5, 17, 54, 89, 93,
		// 10, 7, 88, 68, 10, 11, 22, 25, 50, 18, 59, 79, 87, 7, 49, 26,
		// 96, 27, 19, 67, 35, 50, 10, 6, 48, 38, 28, 66, 94, 60, 27, 76,
		// 4, 43, 66, 14, 8, 78, 72, 21, 56, 34, 90, 89 };
		// { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7,
		// 15 };
		System.out.println(new Problem213().lis(Arrays.asList(input)));
	}

	public int lis(final List<Integer> A) {
		if (A == null || A.isEmpty()) {
			return 0;
		}

		if (A.size() == 1) {
			return 1;
		}
		List<Integer> subSeq = new ArrayList<>();
		int[] indexMap = new int[A.size()];
		int length = 0;

		// Initialize indexMap with -1
		for (int index = 0; index < A.size(); index++) {
			indexMap[index] = -1;
		}
		subSeq.add(0);
		for (int counter = 1; counter < A.size(); counter++) {
			if (A.get(counter) > A.get(subSeq.get(length))) {
				subSeq.add(counter);
				length++;
				indexMap[subSeq.get(length)] = subSeq.get(length - 1);
			} else if (A.get(counter) < A.get(subSeq.get(0))) {
				subSeq.set(0, counter);
			} else {
				// Do a binary search on subSeq
				int index = binarySearch(A, subSeq, A.get(counter));
				if (index > 0) {
					subSeq.set(index, counter);
					indexMap[subSeq.get(index)] = subSeq.get(index - 1);
				}
			}
		}
		return length + 1;
	}

	private int binarySearch(List<Integer> input, List<Integer> subSeq,
			Integer element) {
		int start = 0;
		int middle = 0;
		int end = subSeq.size() - 1;

		while (start <= end) {
			middle = start + (end - start) / 2;
			if (middle < subSeq.size() - 1
					&& input.get(subSeq.get(middle)) < element
					&& input.get(subSeq.get(middle + 1)) >= element) {
				return middle + 1;
			} else if (input.get(subSeq.get(middle)) < element) {
				start = middle + 1;
			} else {
				end = middle - 1;
			}
		}
		return -1;
	}

	public int _lis(final List<Integer> A) {
		if (A == null || A.isEmpty()) {
			return 0;
		}

		if (A.size() == 1) {
			return 1;
		}
		int[] memo = new int[A.size()];
		int maxLength = 0;
		memo[0] = 1;
		for (int right = 1; right < A.size(); right++) {
			for (int left = 0; left < right; left++) {
				if (A.get(right) > A.get(left)) {
					memo[right] = Math.max(memo[right], memo[left] + 1);
					maxLength = Math.max(maxLength, memo[right]);
				}
			}
		}
		return maxLength;
	}

	private int findSmallestNum(List<Integer> a, int start, int end) {
		int globalMin = Integer.MAX_VALUE;
		int index = 0;
		for (int i = start; i < end; i++) {
			if (a.get(i) < globalMin) {
				globalMin = a.get(i);
				index = i;
			}
		}
		return index;
	}
}
