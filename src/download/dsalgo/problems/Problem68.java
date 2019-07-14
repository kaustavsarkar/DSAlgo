package download.dsalgo.problems;

/**
 * ind if Given number is power of 2 or not. More specifically, find if given
 * number can be expressed as 2^k where k >= 1.
 * 
 * Input:
 * 
 * number length can be more than 64, which mean number can be greater than 2 ^
 * 64 (out of long long range) Output:
 * 
 * return 1 if the number is a power of 2 else return 0
 * 
 * Example:
 * 
 * Input : 128 Output : 1
 * 
 * @author kaussark
 *
 */
public class Problem68 {

	public static void main(String[] args) {
		Problem68 problem = new Problem68();
		System.out.println(problem.power("1"));
	}

	public int power(String A) {
		int rem = 0;
		int[] nums = getNumArray(A);
		int sentinel = 0;
		
		if(A.length() == 1 && nums[0]%2 != 0) {
			return 0;
		}

		while (sentinel < nums.length) {
			if (nums[nums.length - 1] != 1 && nums[nums.length - 1] % 2 != 0) {
				return 0;
			}
			for (int j = sentinel; j < nums.length; j++) {
				int num = (rem * 10) + nums[j];
				if (num < 2) {
					rem = nums[j];
					nums[j] = 0;

				} else {
					rem = num % 2;
					nums[j] = num / 2;
				}
			}
			while (sentinel < nums.length && nums[sentinel] == 0) {
				sentinel++;
			}
		}

		if (nums[nums.length - 1] != 0) {
			return 0;
		}

		return 1;
	}

	private int[] getNumArray(String a) {
		int[] array = new int[a.length()];
		for (int i = 0; i < a.length(); i++) {
			array[i] = Integer.valueOf(a.substring(i, i + 1));
		}

		return array;
	}
}
