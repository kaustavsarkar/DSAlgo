package download.dsalgo.problems;

import java.util.Arrays;

/**
 * Given an array nums of n integers and an integer target, find three integers
 * in nums such that the sum is closest to target. Return the sum of the three
 * integers. You may assume that each input would have exactly one solution.
 * 
 * Example:
 * 
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 * 
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 * @author kaussark
 *
 */
public class Problem187 {

	public static void main(String[] args) {
		int[] input = { 1, 1, -1, -1, 3 };
		System.out.println(new Problem187().threeSumClosest(input, -1));
	}

	public int threeSumClosest(int[] nums, int target) {
		int minDiff = Integer.MAX_VALUE;
		int total = 0;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			if (i > 0 && nums[i] == nums[i - 1])
				continue;
			for (int j = i + 1, k = nums.length - 1; j < k;) {

				int sum = nums[i] + nums[j] + nums[k];
				int diff = sum - target;
				if (diff == 0) {
					return sum;
				}
				if (Math.abs(diff) < Math.abs(minDiff)) {
					minDiff = diff;
					total = sum;
				}

				if (diff < 0) {
					j++;
				} else {
					k--;
				}
				while (j > i + 1 && j < k && nums[j] == nums[j - 1])
					j++;
				while (k < nums.length - 1 && k > j && nums[k] == nums[k + 1])
					k--;
			}

		}
		return total;
	}
}
