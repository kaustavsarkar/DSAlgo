package download.dsalgo.poc;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Stacks {

	public static void main(String[] args) {
		List<Integer> nums = new ArrayList<>();
		nums.add(1);
		nums.add(0);
		
		Stack<Integer> stack = new Stack<>();
		stack.addAll(nums);
		System.out.println(stack.pop());
	}
}
