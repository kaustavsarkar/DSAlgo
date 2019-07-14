package download.dsalgo.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * The gray code is a binary numeral system where two successive values differ
 * in only one bit.
 * 
 * Given a non-negative integer n representing the total number of bits in the
 * code, print the sequence of gray code. A gray code sequence must begin with
 * 0.
 * 
 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 * 
 * 00 - 0 01 - 1 11 - 3 10 - 2 There might be multiple gray code sequences
 * possible for a given n. Return any such sequence.
 * 
 * @author kaussark
 *
 */
public class Problem114 {

	public static void main(String[] args) {
		System.out.println(new Problem114().grayCode(3));
	}

	public ArrayList<Integer> _grayCode(int a) {
		ArrayList<Integer> sol = new ArrayList<>();
		if (a == 0)
			return sol;

		sol.add(0);
		sol.add(1);
		for (int i = 1; i < a; i++)
			for (int j = sol.size() - 1; j >= 0; j--)
				sol.add(sol.get(j) | (1 << i));

		return sol;
	}

	public ArrayList<Integer> grayCode(int a) {
		Set<Integer> grayCodes = new LinkedHashSet<>();
		if (a == 0) {
			grayCodes.add(0);
			return new ArrayList<>(grayCodes);
		}
		grayCodes.add(0);
		genGrayCodes(grayCodes, a, 0);

		return new ArrayList<>(grayCodes);
	}

	private void genGrayCodes(Set<Integer> grayCodes, int maxShift, int code) {
		if (maxShift == 0) {
			grayCodes.add(code);
			return;
		}

		genGrayCodes(grayCodes, maxShift - 1, code);
		code = code ^ (1 << (maxShift - 1));
		genGrayCodes(grayCodes, maxShift - 1, code);
	}
}
