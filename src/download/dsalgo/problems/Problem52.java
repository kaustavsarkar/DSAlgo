package download.dsalgo.problems;

import java.util.List;

/**
 * There are two sorted arrays A and B of size m and n respectively.
 * 
 * Find the median of the two sorted arrays ( The median of the array formed by
 * merging both the arrays ).
 * 
 * The overall run time complexity should be O(log (m+n)).
 * 
 * Sample Input
 * 
 * A : [1 4 5] B : [2 3]
 * 
 * Sample Output
 * 
 * 3 NOTE: IF the number of elements in the merged array is even, then the
 * median is the average of n / 2 th and n/2 + 1th element. For example, if the
 * array is [1 2 3 4], the median is (2 + 3) / 2.0 = 2.5
 * 
 * @author kaussark
 *
 */
public class Problem52 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
		double median = 0;
		
		int m1 = a.get(a.size() >> 2);
		if((m1&1)!=1) {
			
		}
		
		return median;
    }
}
