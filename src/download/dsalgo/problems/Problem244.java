package download.dsalgo.problems;

import java.util.*;

/**
 * How many minimum numbers from fibonacci series are required such that sum of
 * numbers should be equal to a given Number N? Note : repetition of number is
 * allowed.
 * 
 * Example:
 * 
 * N = 4 Fibonacci numbers : 1 1 2 3 5 .... so on here 2 + 2 = 4 so minimum
 * numbers will be 2
 * 
 * @author kaussark
 *
 */
public class Problem244 {

	public static void main(String[] args) {

	}

	public void calcfib(ArrayList<Integer> a, int k) {
		a.add(0);
		a.add(1);
		for (int i = 2; true; i++) {
			int next = a.get(i - 1) + a.get(i - 2);
			if (next > k) {
				return;
			}
			a.add(next);
		}
	}

	public int fibsum(int A) {
		ArrayList<Integer> fibolist = new ArrayList<>();
		calcfib(fibolist, A);
		int ans = 0;
		int j = fibolist.size() - 1;
		while (A > 0) {
			ans += A / fibolist.get(j);
			A = A % fibolist.get(j);
			j--;
		}
		return ans;
	}
}
