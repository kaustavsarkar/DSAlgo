package download.dsalgo.problems;

import java.util.ArrayList;

/**
 * Given an even number ( greater than 2 ), return two prime numbers whose sum
 * will be equal to given number.
 * 
 * NOTE A solution will always exist. read Goldbach’s conjecture
 * 
 * Example:
 * 
 * 
 * Input : 4 Output: 2 + 2 = 4
 * 
 * If there are more than one solutions possible, return the lexicographically
 * smaller solution.
 * 
 * If [a, b] is one solution with a <= b, and [c,d] is another solution with c
 * <= d, then
 * 
 * [a, b] < [c, d]
 * 
 * If a < c OR a==c AND b < d.
 * 
 * @author kaussark
 *
 */
public class Problem29 {

	public static void main(String[] args) {
		Problem29 problem = new Problem29();
		System.out.println(problem.primesum(50));
		
		//System.out.println(problem.isPrime(6));
		
	}

	public ArrayList<Integer> primesum(int A) {
		
		if(A < 4) {
			return new ArrayList<>();
		}
		
		ArrayList<Integer> primes = new ArrayList<>();
		for(int i = 2; i <A; i++) {
			if(isPrime(i) && isPrime(A-i)) {
				primes.add(i);
				primes.add(A-i);
				break;
			}
		}
		return primes;
	}

	private boolean isPrime(int num) {
		int sq = (int) Math.sqrt(num);
		for (int i = 2; i <= sq; i++) {
			if (num % i == 0)
				return false;
		}

		return true;
	}
}
