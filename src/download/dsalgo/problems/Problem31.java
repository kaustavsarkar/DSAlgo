package download.dsalgo.problems;

import java.util.ArrayList;

/**
 * Given a positive integer A, return an array of strings with all the integers
 * from 1 to N. But for multiples of 3 the array should have �Fizz� instead of
 * the number. For the multiples of 5, the array should have �Buzz� instead of
 * the number. For numbers which are multiple of 3 and 5 both, the array should
 * have �FizzBuzz� instead of the number.
 * 
 * Look at the example for more details.
 * 
 * Example
 * 
 * A = 5 Return: [1 2 Fizz 4 Buzz]
 * 
 * @author kaussark
 *
 */
public class Problem31 {

	public static void main(String[] args) {
		Problem31 problem = new Problem31();
		System.out.println(problem.fizzBuzz(5));
	}

	public ArrayList<String> fizzBuzz(int A) {
		ArrayList<String> fb = new ArrayList<>();

		for (int i = 1; i <= A; i++) {
			if (i % 15 == 0) {
				fb.add("FizzBuzz");
			} else if (i % 5 == 0) {
				fb.add("Buzz");
			} else if (i % 3 == 0) {
				fb.add("Fizz");
			} else {
				fb.add(String.valueOf(i));
			}
		}
		return fb;
	}
}
