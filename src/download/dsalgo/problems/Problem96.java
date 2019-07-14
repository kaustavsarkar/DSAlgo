package download.dsalgo.problems;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 * 
 * For example, Given 1->2->3->3->4->4->5, return 1->2->5. Given 1->1->1->2->3,
 * return 2->3.
 * 
 * @author kaussark
 *
 */
public class Problem96 {

	public static void main(String[] args) {
		ListNode node = new ListNode(1);
		node.next = new ListNode(1);
		node.next.next = new ListNode(2);
		node.next.next.next = new ListNode(2);
		node.next.next.next.next = new ListNode(3);
		node.next.next.next.next.next = new ListNode(4);
		node.next.next.next.next.next.next = new ListNode(5);
		node.next.next.next.next.next.next.next = new ListNode(5);
		node.next.next.next.next.next.next.next.next = new ListNode(6);
		node.next.next.next.next.next.next.next.next.next = new ListNode(6);

		ListNode fin = new Problem96().deleteDuplicates(node);
		fin.print();

	}

	public ListNode deleteDuplicates(ListNode A) {
		if (A == null)
			return A;
		ListNode curr = A, prev = null, next;
		ListNode newList = new ListNode(-1), new_head = newList;
		while (curr != null) {
			next = curr.next;
			if (!((prev != null && curr.val == prev.val)
					|| (next != null && curr.val == next.val))) {
				ListNode n = new ListNode(curr.val);
				newList.next = n;
				newList = n;
			}
			prev = curr;
			curr = next;
		}
		return new_head.next;
	}
}
