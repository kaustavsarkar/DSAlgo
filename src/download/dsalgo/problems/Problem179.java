package download.dsalgo.problems;

import java.util.*;

/**
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Determine if you are able to reach the last index.
 * 
 * For example: A = [2,3,1,1,4], return 1 ( true ).
 * 
 * A = [3,2,1,0,4], return 0 ( false ).
 * 
 * Return 0/1 for this problem
 * 
 * @author kaussark
 *
 */
public class Problem179 {

	public static void main(String[] args) {
		Integer[] input = { 22, 0, 0, 3, 6, 0, 0, 0, 0, 0, 0, 4, 0, 5, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 22, 12, 0, 12, 0, 9, 11,
				0, 0, 21, 0, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0,
				23, 0, 19, 0, 19, 0, 0, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 19, 0, 0,
				0, 0, 0, 0, 0, 26, 0, 28, 3, 0, 0, 0, 19, 0, 0, 15, 0, 0, 14, 0,
				0, 0, 0, 0, 7, 0, 14, 0, 16, 0, 19, 2, 16, 0, 29, 12, 0, 0, 0,
				0, 29, 12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 21, 9, 9, 0, 0, 0, 5, 3,
				0, 0, 0, 0, 0, 0, 30, 0, 25, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 0,
				20, 30, 29, 0, 23, 17, 0, 0, 20, 0, 0, 0, 3, 17, 10, 0, 0, 0, 0,
				0, 0, 15, 0, 0, 6, 0, 0, 0, 0, 0, 11, 2, 27, 0, 22, 0, 8, 16, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 29, 0, 0, 0, 0, 0, 0, 30, 25, 0, 0,
				0, 0, 9, 29, 0, 0, 0, 0, 0, 1, 0, 16, 27, 0, 22, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 5, 0, 1, 0, 6, 0, 0, 0, 16, 0, 3, 0, 20, 10, 12,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 0, 0, 0, 0, 0, 3, 0, 17, 0, 0,
				4, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 29, 0, 10, 0, 0, 0, 5, 21,
				15, 0, 0, 0, 23, 0, 17, 0, 0, 24, 0, 0, 7, 11, 1, 27, 0, 9, 20,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, 28,
				0, 0, 0, 23, 0, 0, 0, 22, 0, 0, 3, 0, 17, 1, 19, 0, 0, 18, 0,
				23, 0, 0, 0, 0, 13, 19, 24, 13, 0, 0, 0, 0, 0, 0, 3, 28, 0, 0,
				5, 21, 0, 0, 0, 0, 0, 6, 0, 0, 0, 19, 0, 0, 0, 11, 5, 0, 0, 0,
				24, 21, 0, 0, 0, 19, 0, 0, 0, 0, 10, 0, 17, 0, 0, 0, 2, 0, 24,
				13, 1, 22, 0, 0, 15, 0, 21, 0, 21, 0, 0, 7, 0, 0, 0, 23, 6, 0,
				0, 20, 24, 23, 0, 0, 0, 0, 28, 0, 8, 0, 0, 30, 23, 22, 11, 0, 0,
				0, 1, 20, 0, 0, 5, 0, 0, 0, 24, 0, 0, 20, 0, 0, 0, 0, 0, 0, 17,
				0, 0, 12, 0, 0, 18, 0, 0, 0, 0, 0, 17, 2, 7, 0, 0, 0, 0, 0, 5,
				16, 0, 0, 0, 0, 16, 0, 0, 8, 0, 0, 1, 25, 14, 1, 24, 19, 0, 0,
				0, 0, 0, 24, 7, 0, 0, 0, 0, 21, 0, 0, 0, 0, 17, 0, 0, 0, 0, 8,
				0, 0, 15, 0, 0, 9, 0, 0, 8, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 13,
				20, 0, 26, 0, 0, 0, 2, 0, 28, 0, 0, 0, 0, 0, 11, 0, 27, 0, 0,
				10, 19, 0, 0, 0, 0, 13, 25, 30, 28, 28, 0, 21, 0, 0, 0, 26, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 22, 0, 1, 0, 0, 0, 0, 0,
				9, 0, 0, 4, 0, 2, 0, 0, 0, 0, 0, 0, 14, 29, 0, 4, 0, 12, 0, 0,
				0, 0, 25, 0, 0, 29, 0, 21, 8, 0, 0, 0, 0, 0, 0, 0, 0, 28, 7, 5,
				0, 0, 6, 0, 24, 11, 0, 11, 20, 6, 30, 21, 0, 8, 0, 0, 28, 28, 4,
				0, 17, 0, 6, 22, 0, 27, 0, 0, 0, 0, 29, 26, 0, 6, 0, 8, 5, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, 0, 5, 0, 0, 0,
				0, 20, 0, 0, 0, 5, 21, 2, 0, 0, 0, 28, 0, 0, 20, 0, 0, 7, 0, 0,
				25, 0, 0 };
		// { 0, 10, 0, 0, 25, 0, 18, 0, 26, 7, 0, 0, 0, 19, 16,
		// 0, 0, 0, 18, 7, 15, 2, 0, 23, 0, 1, 0, 19, 0, 0, 0, 0, 0, 6, 0,
		// 0, 0, 0, 0, 20, 25, 0, 26, 0, 0, 0, 0, 25, 0, 0, 15, 16, 29, 0,
		// 0, 24, 0, 0, 17, 0, 0, 22, 30, 6, 0, 0, 0, 21, 24, 0, 12, 0, 0,
		// 0, 0, 0, 1, 0, 0, 0, 18, 16, 0, 0, 20, 0, 0, 0, 0, 14, 7, 0, 0,
		// 8, 0, 19, 0, 0, 22, 20, 18, 0, 26, 0, 0, 0, 0, 0, 28, 0, 0, 8,
		// 0, 9, 28, 30, 0, 10, 0, 0, 0, 0, 23, 0, 0, 0, 0, 0, 4, 0, 0, 13,
		// 29, 0, 9, 0, 3, 6, 22, 0, 0, 0, 29, 0, 0, 0, 0, 0, 0, 0, 0, 0,
		// 26, 0, 0, 17, 0, 0, 0, 0, 29, 0, 0, 27, 0, 0, 0, 0, 29, 22, 0,
		// 8, 0, 0, 2, 0, 13, 8, 0, 2, 0, 0, 0, 0, 1, 13, 3, 0, 0, 18, 0,
		// 5, 23, 0, 0, 3, 24, 0, 0, 10, 0, 0, 0, 0, 0, 0, 0, 0, 6, 0, 2,
		// 2, 0, 0, 0, 14, 24, 0, 17, 0, 0, 0, 0, 0, 0, 17, 2, 0, 10, 6, 5,
		// 0, 0, 20, 21, 26, 16, 0, 0, 0, 21, 9, 0, 0, 0, 0, 0, 11, 0, 25,
		// 0, 0, 0, 9, 0, 6, 20, 0, 0, 0, 0, 0, 0, 0, 26, 25, 0, 14, 0, 0,
		// 0, 7, 0, 0, 1, 0, 0, 5, 0, 0, 0, 1, 0, 29, 0, 0, 0, 9, 9, 0, 0,
		// 0, 0, 0, 24, 0, 0, 0, 0, 25, 16, 0, 0, 0, 0, 16, 23, 0, 0, 11,
		// 0, 26, 0, 0, 0, 0, 11, 0, 0, 0, 0, 0, 0, 0, 0, 0, 27, 0, 0, 0,
		// 17, 0, 0, 0, 0, 0, 22, 0, 0, 23, 0, 0, 0, 0, 0, 0, 13, 0, 8, 0,
		// 0, 5, 0, 17, 0, 14, 0, 0, 14, 0, 0, 0, 0, 0, 0, 0, 15, 25, 26,
		// 17, 0, 11, 6, 0, 0, 9, 3, 0, 0, 0, 0, 7, 0, 26, 0, 0, 0, 28, 0,
		// 0, 0, 0, 0, 28, 0, 0, 14, 0, 0, 0, 0, 18, 25, 0, 0, 0, 0, 0, 0,
		// 6, 14, 12, 27, 12, 21, 11, 15, 0, 6, 9, 25, 0, 0, 0, 0, 18, 0,
		// 3, 0, 5, 0, 0, 8, 9, 17, 6, 28, 26, 0, 12, 0, 0, 0, 0, 22, 0, 0,
		// 0, 0, 9, 0, 0, 0, 0, 14, 16, 8, 19, 0, 0, 0, 0, 6, 0, 0, 0, 0,
		// 0, 0, 0, 0, 0, 0, 0, 30, 0, 9, 0, 0, 23, 0, 0, 0, 0, 9, 0, 0,
		// 13, 7, 0, 22, 0, 0, 0, 14, 26, 0, 27, 0, 0, 4, 0, 0, 0, 0, 0,
		// 17, 0, 0, 9, 0, 2, 0, 12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 27, 10,
		// 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 8, 0, 0, 0, 4, 0, 0, 0, 0, 21,
		// 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, 19, 0, 0, 0, 21, 0, 14, 0, 23, 0,
		// 18, 0, 0, 0, 0, 0, 0, 0, 10, 0, 7, 0, 0, 0, 0, 0, 0, 0, 10, 16,
		// 0, 16, 0, 0, 30, 0, 0, 4, 0, 0, 0, 0, 0, 0, 3, 0, 25, 0, 0, 0,
		// 0, 20, 0, 0, 0, 5, 0, 0, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 18,
		// 27, 18, 7, 0, 4, 0, 30, 18, 26, 17, 0, 0, 0, 8, 16, 0, 0, 0, 0,
		// 0, 0, 27, 0, 0, 0, 0, 0, 9, 0, 0, 28, 0, 17, 0, 2, 0, 27, 0, 21,
		// 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 17, 0, 6, 0, 19, 23, 0, 0, 0, 20,
		// 0, 0, 16, 0, 0, 0, 0, 0, 16, 0, 0, 0, 4, 0, 0, 0, 0, 24, 8, 0,
		// 0, 25, 12, 0, 3, 0, 5, 21, 0, 0, 3, 0, 18, 25, 10, 30, 24, 0,
		// 14, 0, 0, 18, 0, 0, 0, 0, 0, 0, 18, 0, 15, 0, 27, 0, 0, 22, 0,
		// 0, 0, 0, 14, 0, 17, 0, 18, 29, 0, 0, 23, 0, 2, 0, 0, 0, 0, 23,
		// 0, 25, 0, 0, 0, 2, 0, 2, 0, 0, 5, 28, 0, 0, 18, 0, 0, 0, 0, 0,
		// 0, 17, 19, 0, 0, 0, 26, 0, 0, 0, 0, 3, 0, 0, 29, 11, 0, 0, 4, 0,
		// 27, 11, 0, 3, 0, 0, 18, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 20,
		// 0, 18, 0, 0, 0, 0, 16, 0, 0, 0, 0, 0, 0, 0, 0, 13, 0, 0, 0, 0,
		// 0, 30, 0, 0, 1, 0, 0, 0, 0, 27, 0, 0, 0, 1, 0, 10, 0, 0 };
		// { 3, 3, 1, 0, 4 };
		// { 3, 2, 1, 0, 4 };
		// {10, 0, 1, 1, 0};
		System.out.println(new Problem179()
				.canJump(new ArrayList<>(Arrays.asList(input))));
	}

	public int _canJump(ArrayList<Integer> a) {
	    int currJump= 0;
	    for (int i=0; i<a.size(); i++){
	        if (currJump<0) return 0;
	        currJump= Math.max(a.get(i),currJump);
	        currJump--;
	    }
	    return 1;
	}
	
	public int canJump(ArrayList<Integer> A) {
		if (A.isEmpty()) {
			return 0;
		}
		if (A.size() == 1) {
			return 1;
		}
		if (A.get(0).compareTo(0) == 0) {
			return 0;
		}
		int length = A.size();
		int[] jumpsRem = new int[A.size()];
		jumpsRem[0] = A.get(0);
		jumpsRem[length - 1] = -1;

		for (int i = 1; i < length; i++) {
			if (i == length - 1) {
				jumpsRem[i] = jumpsRem[i - 1];
			} else {
				jumpsRem[i] = Math.max(A.get(i), jumpsRem[i - 1] - 1);
			}
			if (jumpsRem[i] == 0) {
				return 0;
			}
		}

		return jumpsRem[A.size() - 1] > 0 ? 1 : 0;
	}
}