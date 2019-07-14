package download.dsalgo.problems;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given a sorted array and a target value, return the index if the target is
 * found. If not, return the index where it would be if it were inserted in
 * order.
 * 
 * You may assume no duplicates in the array.
 * 
 * Here are few examples.
 * 
 * [1,3,5,6], 5 → 2 [1,3,5,6], 2 → 1 [1,3,5,6], 7 → 4 [1,3,5,6], 0 → 0
 * 
 * @author kaussark
 *
 */
public class Problem49 {

	public static void main(String[] args) {
		Integer[] array = {11, 106, 143, 222, 247, 248, 310, 311, 399, 415, 450, 495, 575, 658, 813, 818, 855, 986};
		Problem49 problem = new Problem49();
		System.out.println(problem.searchInsert(new ArrayList<>(Arrays.asList(array)), 77));

	}
	public int searchInsert(ArrayList<Integer> array, int num) {
        int start = 0;
        int end = array.size() - 1;
        int mid = array.size() >> 1;
        while (start <= end) {
            if (array.get(mid) == num) {
                return mid;
            }
            if (array.get(mid) < num) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            mid = (start + end) >> 1;
        }
        if (start == array.size()) {
            return (array.size());
        }

        return start;
    }
}
