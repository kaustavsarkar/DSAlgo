package download.dsalgo.problems;

import java.util.Stack;

/**
 * You are given an array A containing N integers. The special product of each
 * ith integer in this array is defined as the product of the following:
 * <ul>
 * 
 * LeftSpecialValue: For an index i, it is defined as the index j such that
 * A[j]>A[i] (i>j). If multiple A[j]’s are present in multiple positions, the
 * LeftSpecialValue is the maximum value of j.
 * 
 * RightSpecialValue: For an index i, it is defined as the index j such that
 * A[j]>A[i] (j>i). If multiple A[j]s are present in multiple positions, the
 * RightSpecialValue is the minimum value of j.
 * 
 * Write a program to find the maximum special product of any integer in the
 * array.
 * 
 * Input: You will receive array of integers as argument to function.
 * 
 * Return: Maximum special product of any integer in the array modulo
 * 1000000007.
 * 
 * @author kaussark
 *
 */
public class Problem6 {

	public static void main(String[] args) {

		int[] array = { 6, 5, 4, 9, 9, 6, 5, 4, 5, 9, 9 };
		 //{ 5, 9, 6, 8, 6, 4, 6, 9, 5, 4, 9 };
		// { 6, 7, 9, 5, 5, 8 };
		Problem6 problem = new Problem6();
		int prod = problem.maxSpecialProduct(array);
		System.out.println(prod);
	}

	// [ 5, 9, 6, 8, 6, 4, 6, 9, 5, 4, 9 ]
	public int maxSpecialProduct(int[] array) {
		
		if(array.length < 3) {
			return 0;
		}
		
		Stack<Integer> leftStack = new Stack<>();
		Stack<Integer> rightStack = new Stack<>();
		int end = array.length - 1;
		int counter = 1;
		int leftVal = end;
		int rightVal = 0;
		int mod = 1000000007;
		while (counter < end) {
			// Check left val
			if (array[counter] < array[counter - 1]) {
				leftStack.push(counter - 1);
			}
			// check right val
			if (array[counter + 1] > array[counter]) {
				rightStack.push(counter + 1);
			}
			counter++;
		}
		System.out.println("LS : " + leftStack);
		System.out.println("RS : " + rightStack);
		leftVal = leftStack.pop();
		rightVal = rightStack.pop();

		System.out.println("LEFT : " + leftVal);
		System.out.println("RIGHT : " + rightVal);
		while(!rightStack.isEmpty()) {
			if(rightStack.peek() > leftVal) {
				rightVal = rightStack.pop();
			} else {
				break;
			}
		}
		
		if (leftVal == rightVal) {
			return 0;
		}

		return (leftVal * rightVal) % mod;
	}
}
