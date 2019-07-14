package download.dsalgo.problems;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Given two integers representing the numerator and denominator of a fraction,
 * return the fraction in string format.
 * 
 * If the fractional part is repeating, enclose the repeating part in
 * parentheses.
 * 
 * Example :
 * 
 * Given numerator = 1, denominator = 2, return "0.5" Given numerator = 2,
 * denominator = 1, return "2" Given numerator = 2, denominator = 3, return
 * "0.(6)"
 * 
 * @author kaussark
 *
 */
public class Problem127 {

	public static void main(String[] args) {

		System.out.println(new Problem127()._fractionToDecimal(3,7));
	}

	public String _fractionToDecimal(int numerator, int denominator) {
		long a = numerator, b = denominator;
		if (a % b == 0)
			return String.valueOf(a / b);
		Map<Long, Integer> map = new HashMap<>();
		StringBuilder res = new StringBuilder();
		if ((a > 0 && b < 0) || (a < 0 && b > 0))
			res.append("-");
		a = Math.abs(a);
		b = Math.abs(b);
		res.append(a / b + ".");
		a = (a % b) * 10;
		while (!map.containsKey(a)) {
			map.put(a, res.length());
			res.append(String.valueOf(a / b));
			a = (a % b) * 10;
			if (a == 0)
				return res.toString();
		}
		return res.insert(map.get(a), "(").append(")").toString();
	}

	public String fractionToDecimal(int A, int B) {
		if (A == 0) {
			return "0";
		}

		BigDecimal quo = BigDecimal.valueOf((double) A / B);

		String[] number = quo.toPlainString().split("\\.");
		String before = number[0];
		String deci = "";
		List<Character> rep = new ArrayList<>();
		boolean isRep = false;
		if (number.length > 1 && !number[1].equals("0")) {
			deci = number[1];
		}

		for (int i = 0; i < deci.length(); i++) {
			if (!rep.contains(deci.charAt(i))) {
				rep.add(deci.charAt(i));
			} else {
				int counter = 0;
				while (counter < rep.size() && i < deci.length()
						&& rep.contains(deci.charAt(i))) {
					i++;
					counter++;
				}

				if (counter == deci.length()) {
					isRep = true;
					break;
				} else {
					i -= counter;
				}
			}

		}

		StringBuilder builder = new StringBuilder(before);
		if (!rep.isEmpty()) {
			builder.append(".");
		}
		if (isRep) {
			builder.append("(");
		}

		for (char c : rep) {
			builder.append(c);
		}
		if (isRep) {
			builder.append(")");
		}
		return builder.toString();
	}
}
