package download.dsalgo.problems;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Given an unsorted array A of size N of non-negative integers, find a
 * continuous sub-array which adds to a given number S.
 * 
 * Input: The first line of input contains an integer T denoting the number of
 * test cases. Then T test cases follow. Each test case consists of two lines.
 * The first line of each test case is N and S, where N is the size of array and
 * S is the sum. The second line of each test case contains N space separated
 * integers denoting the array elements.
 * 
 * Output: For each testcase, in a new line, print the starting and ending
 * positions(1 indexing) of first such occuring subarray from the left if sum
 * equals to subarray, else print -1.
 * 
 * @author kaussark
 *
 */

public class Problem2 {

	public static void main(String[] args) {
		Scanner testNumSc = new Scanner(System.in);
		Integer testNum = new Integer(testNumSc.nextLine());
		
		for(int i = 0; i < testNum; i++) {
			Scanner sizeSumSc = new Scanner(System.in);
			String[] sizeSum =  sizeSumSc.nextLine().split(" ");
		}
		

		

		int sum = 12;
		int[] array = { 1, 2, 3, 7, 5 };
		Problem2 problem = new Problem2();
		problem.findSumArray(array, sum);
	}

	public void findSumArray(int[] array, int summation) {
		int length = array.length;
		boolean found = false;
		for (int i = 0; i < length; i++) {
			int sum = array[i]; // Since numbers are +ve Z
			for (int j = i + 1; j < length; j++) {
				sum += array[j];
				if (sum == summation) {
					System.out.println(i + " " + j);
					found = true;
					break;
				}
			}

			if (found) {
				break;
			}
		}

	}

}
