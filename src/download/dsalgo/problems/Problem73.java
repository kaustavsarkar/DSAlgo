package download.dsalgo.problems;

/**
 * Write a function that takes an unsigned integer and returns the number of 1
 * bits it has.
 * 
 * Example:
 * 
 * The 32-bit integer 11 has binary representation
 * 
 * 00000000000000000000000000001011 so the function should return 3.
 * 
 * Note that since Java does not have unsigned int, use long for Java
 * 
 * @author kaussark
 *
 */
public class Problem73 {

	public static void main(String[] args) {
		Problem73 problem = new Problem73();
		System.out.println(problem.numSetBits(7));
	}

	public int numSetBits(long a) {
		int count = 0;
		int hash = 0;
		while ((a >> hash) > 0) {
			long num = a >> hash++;
			count += num & 1;
		}

		return count;
	}
}
