package download.dsalgo.problems;

import java.util.Arrays;

/**
 * You are given a binary string(i.e. with characters 0 and 1) S consisting of
 * characters S1, S2, …, SN. In a single operation, you can choose two indices L
 * and R such that 1 ≤ L ≤ R ≤ N and flip the characters SL, SL+1, …, SR. By
 * flipping, we mean change character 0 to 1 and vice-versa.
 * 
 * Your aim is to perform ATMOST one operation such that in final string number
 * of 1s is maximised. If you don’t want to perform the operation, return an
 * empty array. Else, return an array consisting of two elements denoting L and
 * R. If there are multiple solutions, return the lexicographically smallest
 * pair of L and R.
 * 
 * @author kaussark
 *
 */
public class Problem8 {

	public static void main(String[] args) {
		String array = "1101010001"; 
				//"1001"; 
				// "0111000100010";
				// "01010110";
				//"010";

		Problem8 problem = new Problem8();
		int[] indices = problem.flip(array);
		System.out.println(Arrays.toString(indices));
	}

	public int[] flip(String array) {
		char[] nums = array.toCharArray();
		int counter = 0;
		int localMax = 0, globalMax = 0, globalLeft = 0, left = 0,
				globalRight = 0, right = 0;

		while (counter < nums.length) {

			// Increase counter for 0 every time it is encoutnered
			if (nums[counter] == '0') {
				localMax++;

			} else { // Decrease count by one if there is 1 in between
				localMax--;
			}

			// If max becomes less than zero move local left to next element
			if (localMax < 0) {
				localMax = 0;
				left = counter + 1;
				right = counter + 1;
			}

			// iff local max is greater than greater then take
			// right as current counter
			if (localMax > globalMax) {
				globalMax = localMax;
				right = counter;
				globalRight = right;
				globalLeft = left;
			}
			counter++;
		}

		if(globalMax == 0) {
			return null;
		}
		return new int[] { globalLeft + 1, globalRight + 1 };
	}
}
