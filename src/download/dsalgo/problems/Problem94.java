package download.dsalgo.problems;

/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * 
 * For example: Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * 
 * return 1->4->3->2->5->NULL.
 * 
 * Note: Given m, n satisfy the following condition: 1 ≤ m ≤ n ≤ length of list.
 * Note 2: Usually the version often seen in the interviews is reversing the
 * whole linked list which is obviously an easier version of this question.
 * 
 * @author kaussark
 *
 */
public class Problem94 {

	public static void main(String[] args) {
		ListNode node = new ListNode(1);
		node.next = new ListNode(3);
		node.next.next = new ListNode(5);
		node.next.next.next = new ListNode(7);
		node.next.next.next.next = new ListNode(9);
		node.next.next.next.next.next = new ListNode(11);
		node.next.next.next.next.next.next = new ListNode(13);
		node.next.next.next.next.next.next.next = new ListNode(15);
		node.print();
		print(new Problem94().reverseBetween(node, 2, 6));
		
	}

	private static void print(ListNode node) {
		while (node != null) {
			System.out.print(node);
			node = node.next;
		}
		System.out.println();
	}

	public ListNode reverseBetween(ListNode A, int B, int C) {
		ListNode prev = null;
		ListNode curr = A;
		ListNode next = A;
		int counter = 1;
		// Reach prev node of start
		while (counter < B) {
			counter++;
			prev = curr;
			curr = curr.next;
		}
		// Assig next
		next = curr.next;
		//print(A);

		// Swap till counter reaches C
		while (next != null && counter < C) {
			curr.next = next.next;
			if (prev != null) {
				next.next = prev.next;
				prev.next = next;
			} else {
				next.next = A;
				A = next;
			}
			
			next = curr.next;
			counter++;
			//System.out.println(counter);
			//print(A);
		}

		return A;

	}

}
