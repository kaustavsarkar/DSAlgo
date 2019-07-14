package download.dsalgo.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an unsorted array, find the maximum difference between the successive
 * elements in its sorted form.
 * 
 * Try to solve it in linear time/space.
 * 
 * Example :
 * 
 * Input : [1, 10, 5] Output : 5 Return 0 if the array contains less than 2
 * elements.
 * 
 * You may assume that all the elements in the array are non-negative integers
 * and fit in the 32-bit signed integer range. You may also assume that the
 * difference will not overflow.
 * 
 * @author kaussark
 *
 */
public class Problem23 {
	public static void main(String[] args) {
		Integer[] array = { 1, 10, 5 };

		List<Integer> A = new ArrayList<>(Arrays.asList(array));
		Problem23 problem = new Problem23();
		int gap = problem.maximumGap(A);
		System.out.println(gap);
	}

	public int maximumGap(final List<Integer> A) {
		int current = 0;
		int max = 0;
		int min = 0;
		List<Integer> list = new ArrayList<>();
		for (int num : A) {
			if (num > max) {
				max = num;
			}
			if (num < min) {
				min = num;
			}
		}
		list.add(min);
		list.add(max);

		for (int num : A) {
			while (num > min) {

			}
		}
		return 0;
	}

	public int _maximumGap(final List<Integer> A) {
		int maxSize = 0;
		for (int num : A) {
			if (num > maxSize) {
				maxSize = num;
			}
		}

		int start = -1;
		int end = -1;
		int diff = 0;
		int[] index = new int[maxSize];
		for (int i = 0; i < A.size(); i++) {
			index[A.get(i) - 1] = A.get(i);
		}

		for (int i = 0; i < index.length; i++) {
			while (index[i] == 0)
				i++;
			if (start == -1) {
				start = i;
			} else if (end <= start) {
				end = i;
			}

			if (end > start) {
				diff = Math.max(diff, index[end] - index[start]);
				start = end;
			}

		}

		return diff;
	}
}
