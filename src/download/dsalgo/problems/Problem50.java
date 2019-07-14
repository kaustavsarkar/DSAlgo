package download.dsalgo.problems;

/**
 * Implement pow(x, n) % d.
 * 
 * In other words, given x, n and d,
 * 
 * find (xn % d)
 * 
 * Note that remainders on division cannot be negative. In other words, make
 * sure the answer you return is non negative.
 * 
 * Input : x = 2, n = 3, d = 3 Output : 2
 * 
 * 2^3 % 3 = 8 % 3 = 2.
 * 
 * @author kaussark
 *
 */
public class Problem50 {

	public static void main(String[] args) {
		Problem50 problem = new Problem50();
		// System.out.println(Math.pow(64228540, 77622773));
		System.out.println(problem.pow(71045970, 41535484, 64735492));
	}

	public int pow1(int x, int n, int d) {
		long ans = 1;
		if (x == 0 && n == 0) {
			if (d != 1)
				return 1;
			else
				return 0;
		}
		if (x == 0)
			return 0;
		long a = x;
		int b = n;

		while (b > 0) {
			if ((b & 1) == 1)
				ans = (ans * a);
			if (ans < 0)
				ans = d - (-1 * x) % d;
			else
				ans = ans % d;

			b = b >> 1;
			a = (a * a) % d;
		}

		return (int) ans;
	}

	public int pow(int x, int n, int d) {
		if(x == 0) {
			return 0;
		}
		if (x == 0 && n == 0) {
			if (d != 1)
				return 1;
			else
				return 0;
		}
		long pow = 1;
		long a = x;
		for (long i = n; i > 0; i = i >> 1) {
			if ((i & 1) == 1)
				pow = pow * a;
			if (pow >= 0) {
				pow = pow % d;
			} else {
				pow = d - (-x % d);
			}
			a = a * a % d;
		}

		return (int) pow;
	}
}
