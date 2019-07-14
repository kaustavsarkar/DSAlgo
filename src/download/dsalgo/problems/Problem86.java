package download.dsalgo.problems;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point
 * at coordinate (i, ai). 'n' vertical lines are drawn such that the two
 * endpoints of line i is at (i, ai) and (i, 0).
 * 
 * Find two lines, which together with x-axis forms a container, such that the
 * container contains the most water.
 * 
 * Your program should return an integer which corresponds to the maximum area
 * of water that can be contained ( Yes, we know maximum area instead of maximum
 * volume sounds weird. But this is 2D plane we are working with for simplicity
 * ).
 * 
 * Note: You may not slant the container. Example :
 * 
 * Input : [1, 5, 4, 3] Output : 6
 * 
 * Explanation : 5 and 3 are distance 2 apart. So size of the base = 2. Height
 * of container = min(5, 3) = 3. So total area = 3 * 2 = 6
 * 
 * @author kaussark
 *
 */
public class Problem86 {

	public static void main(String[] args) {
		Integer[] array = { 1, 5, 4, 3 };
		System.out.println(
				new Problem86().maxArea(new ArrayList<>(Arrays.asList(array))));
	}
	public int _maxArea(ArrayList<Integer> A) {
        long max = Integer.MIN_VALUE;
        if (A == null || A.size()<2) return 0;
        
        int start = 0;
        int end = A.size()-1;
        
        while (start<end){
            long water = (end-start)*Math.min(A.get(start), A.get(end));
            max = Math.max (water,max);
            if (A.get(start)<A.get(end)) start++;
            else end--;
        }
        return (int) max;
    }
	public int maxArea(ArrayList<Integer> A) {
		int start = 0;
		int maxArea = 0;
		for (int i = 0; i < A.size(); i++) {
			int num1 = A.get(i);
			for (int j = i + 1; j < A.size(); j++) {
				int num2 = A.get(j);
				maxArea = Math.max(maxArea, (j - i) * Math.min(num1, num2));
			}
		}

		return maxArea;
	}
}
