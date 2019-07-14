package download.dsalgo.problems;

import java.util.Stack;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum
 * element in constant time.
 * 
 * push(x) – Push element x onto stack. pop() – Removes the element on top of
 * the stack. top() – Get the top element. getMin() – Retrieve the minimum
 * element in the stack. Note that all the operations have to be constant time
 * operations.
 * 
 * Questions to ask the interviewer :
 * 
 * Q: What should getMin() do on empty stack? A: In this case, return -1.
 * 
 * Q: What should pop do on empty stack? A: In this case, nothing.
 * 
 * Q: What should top() do on empty stack? A: In this case, return -1 NOTE : If
 * 
 * @author kaussark
 *
 */
public class Problem111 {

	public static void main(String[] args) {

	}

	private Stack<Integer> stack;
	private Stack<Integer> minStack;

	public void push(int x) {
		stack.push(x);
		if (minStack.isEmpty() || x <= minStack.peek()) {
			minStack.push(x);
		}

	}

	public void pop() {
		if (!minStack.isEmpty() && minStack.peek() >= stack.pop()) {
			minStack.pop();
		}
	}

	public int top() {
		if (!stack.isEmpty()) {
			return stack.peek();
		} else
			return -1;
	}

	public int getMin() {
		if (!minStack.isEmpty()) {
			return minStack.peek();
		} else
			return -1;
	}
}
