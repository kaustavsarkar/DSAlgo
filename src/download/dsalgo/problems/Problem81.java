package download.dsalgo.problems;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Remove Duplicates from Sorted Array
 * 
 * Given a sorted array, remove the duplicates in place such that each element
 * can appear atmost twice and return the new length.
 * 
 * Do not allocate extra space for another array, you must do this in place with
 * constant memory.
 * 
 * Note that even though we want you to return the new length, make sure to
 * change the original array as well in place
 * 
 * For example, Given input array A = [1,1,1,2],
 * 
 * Your function should return length = 3, and A is now [1,1,2].
 * 
 * @author kaussark
 *
 */
public class Problem81 {

	public static void main(String[] args) {
		Integer[] array = {0}; 
				//{ 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3 };
//		 { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
//		 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2,
//		 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
//		 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3 };
		ArrayList<Integer> input = new ArrayList<>(Arrays.asList(array));
		System.out.println(new Problem81().removeDuplicates(input));
		System.out.println(input);
	}

	public int removeDuplicates(ArrayList<Integer> a) {
		int dup = 0;
		int counter = 1;
		while (counter < a.size()) {
			if ((a.get(counter) ^ a.get(counter - 1)) == 0) {
				dup++;
				if (dup > 1) {
					a.remove(counter);
				} else {
					counter++;;
				}
			} else {
				counter++;
				dup = 0;
			}
		}

		return a.size();
	}
}
