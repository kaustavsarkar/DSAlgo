package download.dsalgo.problems;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * 
 * Valid operators are +, -, *, /. Each operand may be an integer or another
 * expression.
 * 
 * Examples:
 * 
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9 ["4", "13", "5", "/", "+"] ->
 * (4 + (13 / 5)) -> 6
 * 
 * @author kaussark
 *
 */
public class Problem106 {

	public static void main(String[] args) {

	}

	public int evalRPN(ArrayList<String> A) {
		if(A == null || A.size() == 0) {
			return 0;
		}
		if(A.size() == 1) {
			return Integer.parseInt(A.get(0));
		}
		int result = Integer.MIN_VALUE;
		Stack<Integer> operands = new Stack<>();
		for (String op : A) {
			if (!checkOperator(op)) {
				operands.push(Integer.parseInt(op));
			} else {
				int num1 = operands.pop();
				int num2 = operands.pop();
				if (op.equals("+")) {
					result = num2 + num1;
				} else if (op.equals("-")) {
					result = num2 - num1;
				} else if (op.equals("*")) {
					result = num2 * num1;
				} else if (op.equals("/")) {
					result = num2 / num1;
				}
				operands.push(result);
			}
		}

		return result;
	}

	private boolean checkOperator(String c) {
		switch (c) {
		case "+":
			return true;
		case "*":
			return true;
		case "-":
			return true;
		case "/":
			return true;
		default:
			return false;
		}
	}
}
