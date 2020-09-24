package leetcode;

import download.dsalgo.problems.Problem;

import java.util.*;

public class Problem1 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int sum = 9;
        Problem1 problem1 = new Problem1();
        String result = Arrays.toString(problem1.twoSum(nums, sum));
        System.out.println(result);

    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numberIndex = new HashMap<>();

        for (int index = 0; index < nums.length; index++) {
            int number = nums[index];
            int difference = target - number;
            if (numberIndex.containsKey(difference)) {
                return new int[]{numberIndex.get(difference), index};
            } else {
                numberIndex.put(number, index);
            }
        }
        return null;
    }
}
