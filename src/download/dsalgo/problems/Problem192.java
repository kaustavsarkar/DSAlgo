package download.dsalgo.problems;

import java.util.Stack;

public class Problem192 {

	public static void main(String[] args) {
		String input = ")()))(())((()))"
				+ ")))())()(((((())())((()())(())((((())))())((()()))(()(((()()(()((()()))(())()))(((";
		System.out.println(new Problem192().longestValidParentheses(input));
	}

	public int longestValidParentheses(String A) {
		if (A == null || A.isEmpty() || A.length() == 1) {
			return 0;
		}
		Stack<Integer> brackStack = new Stack<>();
		brackStack.push(-1);
		int maxSize = 0;
		for(int i = 0; i < A.length(); i++) {
			if(A.charAt(i) == '(') {
				brackStack.push(i);
			} else if(A.charAt(i) == ')') {
				
				if(brackStack.peek() != -1 &&
						A.charAt(brackStack.peek()) == '(') {
					brackStack.pop();
					maxSize = Math.max(maxSize, i - brackStack.peek());
				} else {
					brackStack.push(i);
				}
				
			}
		}
		
		
		return maxSize;
	}

}
