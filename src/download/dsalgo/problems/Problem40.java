package download.dsalgo.problems;

import java.util.HashSet;
import java.util.Set;

/**
 * You are given two positive numbers A and B. You need to find the maximum
 * valued integer X such that:
 * 
 * X divides A i.e. A % X = 0 X and B are co-prime i.e. gcd(X, B) = 1 For
 * example,
 * 
 * A = 30 B = 12 We return X = 5
 */
public class Problem40 {
	public static void main(String[] args) {
		Problem40 problem = new Problem40();
		int cpf = problem.cpFact(100, 98);
		System.out.println(cpf);

	}

	public int cpFact(int A, int B) {
		Set<Integer> fact = getFactors(A,B);
		for (int i = A; i > 0; i--) {
			if (fact.contains(i)) {
				continue;
			}
			int gcd = getGDC(i, B);
			if (A % i == 0 && gcd == 1) {
				return i;
			}
		}

		return 1;
	}

	private Set<Integer> getFactors(int a, int b) {
		Set<Integer> commFacts = new HashSet<>();
		for(int i =Math.min(a, b);i > 0; i-- ) {
			if(a%i == 0 && b%i==0) {
				commFacts.add(i);
			}
		}
		return commFacts;
	}

	public int getGDC(int num1, int num2) {

		int max = Math.max(num1, num2);
		int min = Math.min(num2, num1);
		int sub = max - min;
		while (min < max) {
			max = Math.max(min, sub);
			min = Math.min(min, sub);
			sub = max - min;
		}

		return max;
	}

}
