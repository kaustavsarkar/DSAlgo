package download.dsalgo.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a N cross M matrix in which each row is sorted, find the overall median
 * of the matrix. Assume N*M is odd.
 * 
 * For example,
 * 
 * Matrix= [1, 3, 5] [2, 6, 9] [3, 6, 9]
 * 
 * A = [1, 2, 3, 3, 5, 6, 6, 9, 9]
 * 
 * Median is 5. So, we return 5. Note: No extra memory is allowed.
 * 
 * @author kaussark
 *
 */
public class Problem43 {

	public static void main(String[] args) {
		Integer matrix[][] = { { 1, 3, 5 }, { 2, 6, 9 }, { 3, 6, 9 } };
		 //{ { 1, 3, 5 }, { 2, 6, 9 }, { 3, 6, 9 } };
		ArrayList<ArrayList<Integer>> A = new ArrayList<>();
		for (Integer[] m : matrix) {
			A.add(new ArrayList<>(Arrays.asList(m)));
		}

		Integer[] bs = { 1, 2, 4, 5 };

		Problem43 problem = new Problem43();

		// System.out.println(problem.binarySearch(Arrays.asList(bs), 3));

		int med = problem.findMedian(A);
		System.out.println(med);

	}
	private int countSmaller(final List<Integer> A, int B) {
        int left = 0, right = A.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (B <= A.get(mid))
                right = mid - 1;
            else // if B > A.get(mid)
                left = mid + 1;
        }
        return left;
    }

    private int countSmaller(ArrayList<ArrayList<Integer>> A, int B) {
        int smaller = 0;
        for (int i = 0; i < A.size(); i++) {
            smaller += countSmaller(A.get(i), B);
        }
        return smaller;
    }

    public int findMedian(ArrayList<ArrayList<Integer>> A) {
        int left = Integer.MIN_VALUE;
        int right = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = (int) (left + ((long) right - left) / 2);
            int total = A.size() * A.get(0).size();
            int smaller = countSmaller(A, mid);
            if (smaller > total / 2)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return right;
    }

	public int _findMedian(ArrayList<ArrayList<Integer>> A) {
		int rowCount = A.size();
		int colCount = A.get(0).size();
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int specMed = ((rowCount * colCount) ) / 2;
		int mid = 0;
		int ins = 0;
		int smaller = 0;

		// find min
		for (int i = 0; i < rowCount; i++) {
			min = Math.min(A.get(i).get(0), min);
		}
		for (int i = 0; i < colCount; i++) {
			max = Math.max(A.get(i).get(colCount - 1), max);
		}

		while (min < max) {
			smaller = 0;
			ins = 0;
			mid = (min + max) >> 1;
			for (int i = 0; i < rowCount; i++) {
				ins = binarySearch(A.get(i), mid);

				if (ins < 0) {
					ins = -ins;
				}
				smaller += ins;
			}

			if (smaller <= specMed) {
				min = mid + 1;
			} else {
				max = mid;
			}
		}

		return min + 1;
	}

	private int binarySearch(List<Integer> array, int num) {
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
		if (end == 0) {
			return -1;
		}
		if (start == array.size()) {
			return -(array.size());
		}

		return array.get(start) == num ? start : -start;
	}

}
