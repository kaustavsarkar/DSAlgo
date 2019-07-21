package download.dsalgo.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of integers, find the length of longest subsequence which is
 * first increasing then decreasing.
 ** 
 * Example: **
 * 
 * For the given array [1 11 2 10 4 5 2 1]
 * 
 * Longest subsequence is [1 2 10 4 2 1]
 * 
 * Return value 6
 * 
 * @author kaussark
 *
 */
public class Problem173 {

	public static void main(String[] args) {
		Integer[] array = {1,11,2,10,4,5,2,1};
		System.out.println(new Problem173().longestSubsequenceLength(Arrays.asList(array)));
	}

	 public int longestSubsequenceLength(final List<Integer> A) {
	        List<Integer> leftLIS = new ArrayList<>();
	        List<Integer> rightLIS = new ArrayList<>();

	        if(A.isEmpty()) return 0;

	        for(int i = 0 ; i < A.size() ; i++) {
	            leftLIS.add(i,1);
	            rightLIS.add(i,1);
	        }

	        int max = 0;
	        for(int i = 0 ; i < A.size() ; i++) {
	            for(int j = 0 ; j < i ; j++) {
	                if(A.get(i) > A.get(j)) {
	                    leftLIS.set(i, Math.max(leftLIS.get(i), leftLIS.get(j) + 1));
	                }
	            }
	        }

	        for(int i = A.size() - 2 ; i >=0 ;i -- ){
	            for(int j = A.size() - 1 ; j >i ; j--) {
	                if(A.get(i) > A.get(j)) {
	                    rightLIS.set(i, Math.max(rightLIS.get(i), rightLIS.get(j)+1));
	                }
	            }
	        }

	        for(int i = 0 ; i < A.size() ; i++) {
	            if(max < (leftLIS.get(i) + rightLIS.get(i)) - 1) {
	                max = (leftLIS.get(i) + rightLIS.get(i)) - 1;
	            }
	        }
	        return max;
	    }
}
