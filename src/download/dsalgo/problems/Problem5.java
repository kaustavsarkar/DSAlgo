package download.dsalgo.problems;

import java.util.Arrays;

/**
 * Find out the maximum sub-array of non negative numbers from an array. The
 * sub-array should be continuous. That is, a sub-array created by choosing the
 * second and fourth element and skipping the third element is invalid.
 * 
 * Maximum sub-array is defined in terms of the sum of the elements in the
 * sub-array. Sub-array A is greater than sub-array B if sum(A) > sum(B).
 * 
 * @author kaussark
 *
 */
public class Problem5 {

	public static void main(String[] args) {
		int[] array =
			{ 1967513926, 1540383426, -1303455736, -521595368 };
			//{ -1, -1, -1 };
		 //{ 1, 2, 5, -7, 2, 5 };
		Problem5 problem = new Problem5();
		int[] sunArr = problem.maxset(array);
		System.out.println(Arrays.toString(sunArr));
	}

	public int[] maxset(int[] array) {
		int counter = 0;
		int start = 0;
		int resultStart = -1;
		int end = 0;
		int resultEnd = -1;
		int sum = 0;
		int maxSum = 0;
		int[] subArray = null;
		while (counter < array.length) {
			if (array[counter] >= 0) {
				sum += array[counter];
				end = counter++;
			} else {
				sum = 0;
				start = ++counter;
				end = counter;
			}
			if (sum > maxSum) {
				maxSum = sum;
				resultStart = start;
				resultEnd = end;
			} else if (sum == maxSum) {
				int length = (end - start) - (resultEnd - resultStart);
				if (length > 0) {
					resultEnd = end;
					resultStart = start;
				} else if (length == 0) {
					resultEnd = end > resultEnd ? resultEnd : end;
					resultStart = start > resultStart ? resultStart : start;
				}
			}
		}
		if(resultEnd < 0 || resultStart < 0) {
			return new int[0];
		}
		subArray = new int[resultEnd - resultStart + 1];
		for (int i = 0; i < subArray.length; i++) {
			subArray[i] = array[resultStart + i];
		}
		return subArray;
	}
}
