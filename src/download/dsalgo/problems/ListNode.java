package download.dsalgo.problems;

public // * Definition for singly-linked list.
class ListNode {
	public int val;
	public ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}

	@Override
	public String toString() {
		return "[" + val + "]->";
	}
	
	public void print() {
		ListNode node = this;
		while (node != null) {
			System.out.print(node);
			node = node.next;
		}
		System.out.println();
	}

}
