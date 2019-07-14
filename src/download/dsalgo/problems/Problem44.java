package download.dsalgo.problems;

/**
 * Implement int sqrt(int x).
 * 
 * Compute and return the square root of x.
 * 
 * If x is not a perfect square, return floor(sqrt(x))
 * 
 * Example :
 * 
 * Input : 11 Output : 3 DO NOT USE SQRT FUNCTION FROM STANDARD LIBRARY
 * 
 * @author kaussark
 *
 */
public class Problem44 {

	public static void main(String[] args) {
		Problem44 problem = new Problem44();
		int sqrt = problem.sqrt(4);
		System.out.println(sqrt);
	}

	public int sqrt(int a) {
		
		if(a==0 || a==1) {
			return a;
		}
		
		long mid = 0;
		long min = 1;
		long max = a;
		int sqrt = 1;
		
		
		while (min <= max) {
			mid = min + (max - min) / 2;
			if (mid * mid == a) {
				return (int)mid;
			}
			if (mid * mid > a) {
				max = mid-1;
			} else {
				min = mid+1;
				sqrt = (int) mid;
			}
		}

		return sqrt;
	}

}
