package download.dsalgo.problems;

import java.util.Stack;

/**
 * Write a program to validate if the input string has redundant braces? Return
 * 0/1
 * 
 * 0 -> NO 1 -> YES Input will be always a valid expression
 * 
 * and operators allowed are only + , * , - , /
 * 
 * Example:
 * 
 * ((a + b)) has redundant braces so answer will be 1 (a + (a + b)) doesn't have
 * have any redundant braces so answer will be 0
 * 
 * @author kaussark
 *
 */
public class Problem105 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int braces(String A) {
		Stack<Character> bracesOps = new Stack<>();

		char[] expression = A.toCharArray();

		for (int i = 0; i < expression.length; i++) {
			if (expression[i] == '(') {
				bracesOps.push(expression[i]);
			} else if (checkOperator(expression[i])) {
				bracesOps.push(expression[i]);
			} else if (expression[i] == ')') {
				if (bracesOps.peek() == '(') {
					return 1;
				} else if (checkOperator(bracesOps.peek())) {
					while (checkOperator(bracesOps.peek())) {
						bracesOps.pop();
					}
					if (bracesOps.isEmpty()) {
						return 1;
					} else if (bracesOps.peek() == '(') {
						bracesOps.pop();
					}
				}
			}
		}

		return 0;
	}

	private boolean checkOperator(char c) {
		switch (c) {
		case '+':
			return true;
		case '*':
			return true;
		case '-':
			return true;
		case '/':
			return true;
		default:
			return false;
		}
	}
}
