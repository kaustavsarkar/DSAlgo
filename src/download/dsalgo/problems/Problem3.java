package download.dsalgo.problems;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Given a non-negative number represented as an array of digits, add 1 to the
 * number ( increment the number represented by the digits ). The digits are
 * stored such that the most significant digit is at the head of the list.
 * 
 * Example: If the vector has [1, 2, 3] the returned vector should be [1, 2, 4]
 * as 123 + 1 = 124.
 * 
 * @author kaussark
 *
 */
public class Problem3 {

	public static void main(String[] args) {
		ArrayList<Integer> num = new ArrayList<>();
		num.add(9);
		num.add(9);
		num.add(9);
		num.add(9);
		num.add(9);

		Problem3 problem = new Problem3();
		ArrayList<Integer> sum = problem.plus999(num);

		System.out.println(sum);
	}

	public ArrayList<Integer> plus999(ArrayList<Integer> A) {
		addQuotientIt(A, 999);
		return A;
	}

	public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
		addQuotientIt(A, 1);

		ArrayList<Integer> sum = removeTrailing0(A);

		return sum;
	}

	public ArrayList<Integer> removeTrailing0(ArrayList<Integer> a) {
		int counter = 0;
		while (counter < a.size() && a.get(counter).compareTo(0) == 0) {
			a.set(counter++, null);
		}

		a = (ArrayList<Integer>) a.stream().filter(val -> val != null)
				.collect(Collectors.toList());
		return a;
	}

	public void addQuotientIt(ArrayList<Integer> a, int quotient) {
		int place = a.size() - 1;
		int remainder = 0;
		int sum = 0;
		while (quotient > 0) {
			
			if(place < 0) {
				a.add(null);
				for (int counter = a.size() - 1; counter > 0; counter--) {
					int prev = a.get(counter - 1);
					a.set(counter, prev);
				}
				place = 0;
			}
			
			int num = a.get(place);
			sum = num + quotient;
			if(sum > 9) {
				quotient = sum/10;
				remainder = sum%10;
				a.set(place--, remainder);
			} else {
				a.set(place--, sum);
				quotient = -1;
			}
			
		}

	}

	public void addQuotient(ArrayList<Integer> a, int quotient, int place) {
		if (place < 0) {
			a.add(null);
			for (int counter = a.size() - 1; counter > 0; counter--) {
				int prev = a.get(counter - 1);
				a.set(counter, prev);
			}
			place = 0;
		}
		int sum = 0;
		if (a.get(place) != null) {
			sum = a.get(place) + quotient;
		}
		if (sum > 9) {
			int quot = sum / 10;
			int remainder = sum % 10;
			a.set(place, remainder);
			addQuotient(a, quot, place - 1);
		} else {
			a.set(place, sum);
		}

	}

}
