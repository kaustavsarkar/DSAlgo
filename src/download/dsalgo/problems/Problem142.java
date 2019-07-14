package download.dsalgo.problems;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Merge k sorted linked lists and return it as one sorted list.
 * 
 * Example :
 * 
 * 1 -> 10 -> 20 4 -> 11 -> 13 3 -> 8 -> 9 will result in
 * 
 * 1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20
 * 
 * @author kaussark
 *
 */
public class Problem142 {

	public static void main(String[] args) {

	}

	public ListNode mergeKLists(ArrayList<ListNode> a) {
		PriorityQueue<Integer> queue = new PriorityQueue<>(
				(num1, num2) -> num1.compareTo(num2));
		ListNode head = null;

		for(ListNode temp : a) {
			while(temp != null) {
				head = temp.next;
				temp.next = null;
				queue.add(temp.val);
				temp = head;
			}
		}
		head = new ListNode(queue.poll());
		ListNode sentinel = head;
		while(!queue.isEmpty()) {
			sentinel.next = new ListNode(queue.poll());
			sentinel = sentinel.next;
		}
		
		return head;
	}
}
