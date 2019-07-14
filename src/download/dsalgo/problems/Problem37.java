package download.dsalgo.problems;

/**
 * Given 2 non negative integers m and n, find gcd(m, n)
 * 
 * GCD of 2 integers m and n is defined as the greatest integer g such that g is
 * a divisor of both m and n. Both m and n fit in a 32 bit signed integer.
 * 
 * Example
 * 
 * m : 6 n : 9
 * 
 * GCD(m, n) : 3
 * 
 * @author kaussark
 *
 */
public class Problem37 {

	public static void main(String[] args) {
		Problem37 problem = new Problem37();
		System.out.println(problem.gcd(1,0));
	}

	public int gcd(int A, int B) {
		
		if(A == 0|| B==0) {
			return Math.max(A, B);
		}
		
		int max = Math.max(A, B);
		int min = Math.min(A, B);
		int sub = max - min;
		while (min < max) {
			max = Math.max(min, sub);
			min = Math.min(min, sub);
			sub = max - min;
		}

		return max;
	}

}
