package download.dsalgo.problems;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Remove duplicates from Sorted Array Given a sorted array, remove the
 * duplicates in place such that each element appears only once and return the
 * new length.
 * 
 * Note that even though we want you to return the new length, make sure to
 * change the original array as well in place
 * 
 * Do not allocate extra space for another array, you must do this in place with
 * constant memory.
 * 
 * Example: Given input array A = [1,1,2], Your function should return length =
 * 2, and A is now [1,2].
 * 
 * @author kaussark
 *
 */
public class Problem80 {

	public static void main(String[] args) {
		Integer[] array = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2,
				2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
				3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3 };
		// { 1, 1, 2 };
		System.out.println(new Problem80()
				.removeDuplicates(new ArrayList<>(Arrays.asList(array))));
	}

	public int removeDuplicates(ArrayList<Integer> a) {
		if (a.size() == 1) {
			return 1;
		}
		int counter = 1;
		while (counter < a.size()) {
			if ((a.get(counter) ^ a.get(counter - 1)) == 0) {
				a.remove(a.get(counter));
			} else {
				counter++;
			}
		}

		return a.size();
	}
}
