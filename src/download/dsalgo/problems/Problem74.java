package download.dsalgo.problems;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given an array of integers, every element appears thrice except for one which
 * occurs once.
 * 
 * Find that element which does not appear thrice.
 * 
 * Note: Your algorithm should have a linear runtime complexity.
 * 
 * Could you implement it without using extra memory?
 * 
 * Example :
 * 
 * Input : [1, 2, 4, 3, 3, 2, 2, 3, 1, 1] Output : 4
 * 
 * @author kaussark
 *
 */
public class Problem74 {

	public static void main(String[] args) {
		Integer[] array = { 1, 2, 4, 4, 4, 2, 2, 3, 1, 1 };
		System.out.println(new Problem74().singleNumber(Arrays.asList(array)));
	}

	public int singleNumber(final List<Integer> A) {

		if (A.size() < 3) {
			return A.get(0);
		}
		Collections.sort(A);
		int curr = 0;
		int xor = A.get(0);
		for (int i = 1; i < A.size(); i++) {
			int num2 = i;
			xor = xor ^ A.get(num2);
			if (xor == 0) {
				curr = A.get(num2);
			} else if (xor == curr && i < A.size() - 1) {
				i++;
				xor = A.get(i);
			} else {
				return xor ^ A.get(num2);
			}

			if (i == A.size() - 1 && (A.get(i) ^ A.get(i - 1)) != 0) {
				return A.get(i);
			}
		}

		return 0;
	}
}
