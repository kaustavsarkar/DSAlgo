package download.dsalgo.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem20 {

	public static void main(String[] args) {
		Integer[] array = { 3, 5, 4, 2 };

		List<Integer> a = new ArrayList<>(Arrays.asList(array));
		Problem20 problem = new Problem20();
		System.out.println(problem.maximumGap(a));
	}

	public int maximumGap(final List<Integer> a) {
		int maxGap = -1;
		int length = a.size();
		if (a.isEmpty()) {
			return maxGap;
		}

		int maxCounter = 0;
		int minCounter = 0;

		int[] maxArray = new int[length];
		int[] minArray = new int[length];

		minArray[0] = a.get(0);
		for (minCounter = 1; minCounter < length; minCounter++) {
			minArray[minCounter] = Math.min(a.get(minCounter), minArray[minCounter-1]);
		}
		
		maxArray[length-1] = a.get(length-1);
		for(maxCounter = length-2; maxCounter>=0; maxCounter--) {
			maxArray[maxCounter] = Math.max(a.get(maxCounter), maxArray[maxCounter+1]);
		}
		
		maxCounter = 0;
		minCounter = 0;
		
		while(minCounter < length && maxCounter < length) {
			
			if(minArray[minCounter] <= maxArray[maxCounter]) {
				maxGap = Math.max(maxGap, maxCounter-minCounter);
				maxCounter++;
			} else {
				minCounter++;
			}
			
		}

		return maxGap;
	}

	public int __maximumGap(final List<Integer> a) {

		int maxDiff;
		int i, j;
		int n = a.size();

		int[] LMin = new int[n];
		int[] RMax = new int[n];

		/*
		 * Construct LMin[] such that LMin[i] stores the minimum value from
		 * (arr[0], arr[1], ... arr[i])
		 */
		LMin[0] = a.get(0);
		for (i = 1; i < n; ++i)
			LMin[i] = Math.min(a.get(i), LMin[i - 1]);

		/*
		 * Construct RMax[] such that RMax[j] stores the maximum value from
		 * (arr[j], arr[j+1], ..arr[n-1])
		 */
		RMax[n - 1] = a.get(n - 1);
		for (j = n - 2; j >= 0; --j)
			RMax[j] = Math.max(a.get(j), RMax[j + 1]);

		/*
		 * Traverse both arrays from left to right to find optimum j - i This
		 * process is similar to merge() of MergeSort
		 */
		i = 0;
		j = 0;
		maxDiff = 0;
		while (j < n && i < n) {
			if (LMin[i] <= RMax[j]) {
				maxDiff = Math.max(maxDiff, j - i);
				j = j + 1;
			} else
				i = i + 1;
		}

		return maxDiff;

	}

	public int _maximumGap(final List<Integer> A) {
		List<Integer> sorted = new ArrayList<>(A);

		sorted.sort((a, b) -> -a.compareTo(b));

		int diff = -1;
		int maxDiff = -1;

		for (int i = 0; i < A.size(); i++) {
			for (int j = i; j < A.size(); j++) {
				if (A.get(i) <= A.get(j)) {
					diff = j - i;
				}

				if (diff > maxDiff) {
					diff = maxDiff;
				}
			}
		}

		return maxDiff;
	}
}
