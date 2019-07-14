package download.dsalgo.problems;

import java.math.BigDecimal;

/**
 * Implement atoi to convert a string to an integer.
 * 
 * Example :
 * 
 * Input : "9 2704" Output : 9 Note: There might be multiple corner cases here.
 * Clarify all your doubts using “See Expected Output”.
 * 
 * Questions: Q1. Does string contain whitespace characters before the number?
 * A. Yes Q2. Can the string have garbage characters after the number? A. Yes.
 * Ignore it. Q3. If no numeric character is found before encountering garbage
 * characters, what should I do? A. Return 0. Q4. What if the integer overflows?
 * A. Return INT_MAX if the number is positive, INT_MIN otherwise.
 * 
 * @author kaussark
 *
 */
public class Problem62 {

	public static void main(String[] args) {
		Problem62 problem = new Problem62();
		System.out.println(problem.atoi("+ 1"));
	}

	public int atoi(final String A) {
		if(A.isEmpty()) {
			return 0;
		}
		int counter = 0;
		BigDecimal num = 0l;
		StringBuilder string = new StringBuilder();
		while (counter < A.length()) {
			if (string.length() == 0 && A.charAt(counter) == ' ') {
				counter++;
			} else if (string.length() == 0
					&& (A.charAt(counter) == '-' || A.charAt(counter) == '+')) {
				string.append(A.charAt(counter));
				counter++;
			} else if (Character.isDigit(A.charAt(counter))) {
				string.append(A.charAt(counter));
				counter++;
			} else {
				break;
			}
		}

		if (string.length() == 0) {
			return 0;
		}

		if (string.substring(0, 1).equals("+")) {
			num =  string.length() > 1 ? Long.valueOf(string.substring(1, string.length())) : 0;
		}
		if (string.substring(0, 1).equals("-") && string.length() > 1) {
			num = string.length() > 1 ? -Long.valueOf(string.substring(1, string.length())) : 0;
		}

		if (Long.valueOf(num).compareTo((long) Integer.MAX_VALUE) == 1) {
			return Integer.MAX_VALUE;
		}

		if (Long.valueOf(num).compareTo((long) Integer.MIN_VALUE) == -1) {
			return Integer.MIN_VALUE;
		}

		return (int) num;
	}
}
