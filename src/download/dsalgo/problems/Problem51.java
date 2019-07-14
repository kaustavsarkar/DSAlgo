package download.dsalgo.problems;

import java.util.List;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2 ).
 * 
 * You are given a target value to search. If found in the array, return its
 * index, otherwise return -1.
 * 
 * You may assume no duplicate exists in the array.
 * 
 * Input : [4 5 6 7 0 1 2] and target = 4 Output : 0
 * 
 * NOTE : Think about the case when there are duplicates. Does your current
 * solution work? How does the time complexity change?*
 * 
 * @author kaussark
 *
 */
public class Problem51 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int search(final List<Integer> a, int b) {
		int length = a.size() - 1;
		int start = 0;
		int end = length;

		// Check for before/after pivot
		while (start <= end) {
			int mid = (start + end) / 2;
			if (a.get(mid) == b) {
				return mid;
			}
			if (a.get(mid) >= a.get(start)) {
				if (a.get(start) <= b && a.get(mid) > b) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			} else {
				if (b > a.get(mid) && b <= a.get(end)) {
					start = mid + 1;

				} else {
					end = mid - 1;
				}
			}

		}

		return -1;
	}

}
