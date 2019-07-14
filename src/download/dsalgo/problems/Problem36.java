package download.dsalgo.problems;

import java.util.Arrays;

/**
 * Reverse digits of an integer.
 * 
 * Example1:
 * 
 * x = 123,
 * 
 * return 321 Example2:
 * 
 * x = -123,
 * 
 * return -321
 * 
 * Return 0 if the result overflows and does not fit in a 32 bit signed integer
 * 
 * @author kaussark
 *
 */
public class Problem36 {

	public static void main(String[] args) {
		Problem36 problem = new Problem36();
		int rev = problem.reverse(-123456);
		System.out.println(rev);
	}

	public int reverse(int A) {
		int rev = 0;

		char[] nums = String.valueOf(Math.abs(A)).toCharArray();

		int counter = 0;
		while (counter < nums.length >> 1) {
			swap(nums, counter, nums.length - 1 - counter);
			counter++;
		}

		rev = Long.valueOf(String.valueOf(nums)) < Integer.MAX_VALUE
				? Integer.valueOf(String.valueOf(nums))
				: 0;
		rev = A > 0 ? rev : -rev;

		return rev;
	}

	private void swap(char[] nums, int i, int j) {
		nums[i] = (char) (nums[i] + nums[j]);
		nums[j] = (char) (nums[i] - nums[j]);
		nums[i] = (char) (nums[i] - nums[j]);
	}

}
