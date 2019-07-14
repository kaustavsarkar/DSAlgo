package download.dsalgo.problems;

import java.util.Stack;


public class Problem90 {

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(1);
		
		node1.next = node2;
		node2.next = node3;
		
		System.out.println(new Problem90().lPalin(node1));
				
		
		
	}

	public int lPalin(ListNode A) {
		ListNode temp = A;
		Stack<Integer> nodes = new Stack<>();
		nodes.push(temp.val);
		while (temp.next != null) {
			nodes.push(temp.next.val);
			temp = temp.next;
		}
		temp = A;
		while (!nodes.isEmpty()) {
			if (nodes.pop() != temp.val) {
				return 0;
			}
			temp = temp.next;
		}

		return 1;
	}
}
