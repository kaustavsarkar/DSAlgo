package download.dsalgo.problems;

/**
 * Given a positive integer which fits in a 32 bit signed integer, find if it
 * can be expressed as A^P where P > 1 and A > 0. A and P both should be
 * integers.
 * 
 * Example
 * 
 * Input : 4 Output : True as 2^2 = 4.
 * 
 * @author kaussark
 *
 */
public class Problem32 {

	public static void main(String[] args) {
		Problem32 problem = new Problem32();
		int is = problem.isPower(1000000000);
		System.out.println(is);
	}

	public int isPower(int A) {
		if(A==1) {
			return 1;
		}
		int limit = (int) Math.sqrt(A);
		int quo = 0;
		for (int i = 2; i <= limit; i++) {
			quo = A;
			while (quo != 1) {
				if (quo % i != 0) {
					break;
				}
				quo = quo / i;
			}
			if(quo ==1) {
				break;
			}
		}

		return quo == 1 ? quo : 0;
	}
}
