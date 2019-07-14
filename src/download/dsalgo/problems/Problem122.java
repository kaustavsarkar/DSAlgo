package download.dsalgo.problems;

import java.util.ArrayList;

/**
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses of length 2*n.
 * 
 * For example, given n = 3, a solution set is:
 * 
 * "((()))", "(()())", "(())()", "()(())", "()()()" Make sure the returned list
 * of strings are sorted.
 * 
 * @author kaussark
 *
 */
public class Problem122 {

	public static void main(String[] args) {
		System.out.println(new Problem122().generateParenthesis(2));
	}

	public ArrayList<String> generateParenthesis(int A) {
		ArrayList<String> parenth = new ArrayList<>();
		createParenth(parenth, new char[2 * A], 0, 0, A);

		return parenth;
	}

	private void createParenth(ArrayList<String> parenth, char[] subPar,
			int open, int close, int A) {

		int position = open + close;
		if (position == 2 * A) {
			parenth.add(new String(subPar));
			return;
		}

		if (open < A) {
			subPar[position] = '(';
			createParenth(parenth, subPar, open + 1, close, A);
		}
		if (open > close) {
			subPar[position] = ')';
			createParenth(parenth, subPar, open, close + 1, A);
		}
		
	}
}
