package download.dsalgo.problems;

/**
 * Given an integer n, return the number of trailing zeroes in n!.
 * 
 * Note: Your solution should be in logarithmic time complexity.
 * 
 * Example :
 * 
 * n = 5 n! = 120 Number of trailing zeros = 1 So, return 1
 * 
 * @author kaussark
 *
 */
public class Problem38 {

	public static void main(String[] args) {
		Problem38 problem = new Problem38();
		int z = problem.trailingZeroes(10);
		System.out.println(z);

	}

	public int trailingZeroes(int A) {
		int fives = 0;
		int twos = A >> 1;
		for (int i = 1; i <= A; i++) {
			int num = i;
			while (num % 5 == 0) {
				num = num / 5;
				fives++;
			}

		}

		return Math.min(fives, twos);
	}
}
