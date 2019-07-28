package download.dsalgo.problems;

/**
 * Given a singly linked list and an integer K, reverses the nodes of the
 * 
 * list K at a time and returns modified linked list.
 * 
 * NOTE : The length of the list is divisible by K Example :
 * 
 * Given linked list 1 -> 2 -> 3 -> 4 -> 5 -> 6 and K=2,
 * 
 * You should return 2 -> 1 -> 4 -> 3 -> 6 -> 5
 * 
 * Try to solve the problem using constant extra space.
 * 
 * @author kaussark
 *
 */
public class Problem102 {

	public static void main(String[] args) {
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(3);
		node.next.next.next = new ListNode(4);
		node.next.next.next.next = new ListNode(5);
		//node.next.next.next.next.next = new ListNode(6);
		//node.next.next.next.next.next.next = new ListNode(7);
		node.print();
		ListNode newNode = new Problem102()._reverseList(node, 3);
		newNode.print();
	}

	public ListNode __reverseList(ListNode A, int B) {
		ListNode lastprev = null;
		ListNode lastcurr = A;
		ListNode curr = A;
		while (curr != null) {
			ListNode prev = null;
			int k = B;
			while (k > 0 && curr != null) {
				ListNode next = curr.next;
				curr.next = prev;
				prev = curr;
				curr = next;
				k--;
			}
			if (lastprev == null) {
				A = prev;
			} else {
				lastprev.next = prev;
			}
			lastprev = lastcurr;
			lastcurr = curr;
		}
		return A;
	}

	public ListNode _reverseList(ListNode node, int B) {
		if(node == null || node.next == null) return node;
		ListNode current = node;
		ListNode previous = null;
		ListNode next = null;

		int count = B;
		while (count-- > 0 && current != null) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}

		if (current != null) {
			node.next = _reverseList(current, B);
		}

		return previous;
	}

	public ListNode reverseList(ListNode A, int B) {
		ListNode head = new ListNode(0);
		ListNode start = A;
		head.next = A;
		ListNode prev = head;
		ListNode end = A;

		while (end != null && A != null) {
			for (int i = 1; i < B && end != null; i++) {
				end = end.next;
			}
			ListNode next = end.next;
			ListNode reversed = reverseTillEnd(prev, end);
			start = next;
			end = start;

		}

		return head.next;
	}

	private ListNode reverseTillEnd(ListNode start, ListNode end) {
		ListNode curr = start.next;
		ListNode prev = end.next;
		ListNode next = null;

		while (curr != end.next) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		start.next = prev;
		return start;
	}
}
