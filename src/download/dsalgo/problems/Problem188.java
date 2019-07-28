package download.dsalgo.problems;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and
 * describe its complexity.
 * 
 * Example:
 * 
 * Input: [ 1->4->5, 1->3->4, 2->6 ] Output: 1->1->2->3->4->4->5->6
 * 
 * @author kaussark
 *
 */
public class Problem188 {

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(1);
		ListNode node3 = new ListNode(2);
		node1.next = new ListNode(4);
		node1.next.next = new ListNode(5);
		node2.next = new ListNode(3);
		node2.next.next = new ListNode(4);
		node3.next = new ListNode(6);
		ListNode[] nodes = {node1, node2, node3};
		//System.out.println(new Problem188().mergeKLists(nodes));
		new Problem188().mergeKLists(nodes).print();
	}

	public ListNode mergeKLists(ListNode[] lists) {
		Queue<ListNode> listNodeQ = new PriorityQueue<>((l1,l2) -> {
			if(l1.val > l2.val) {
				return 1;
			}else if(l1.val < l2.val) {
				return -1;
			}
			return 0;
		});
		ListNode head = new ListNode(0);
		
		//populate queue
		for(ListNode list : lists) {
			listNodeQ.add(list);
		}
		ListNode list = head;
		while(!listNodeQ.isEmpty()) {
			ListNode temp = listNodeQ.poll();
			list.next = temp;
			temp = temp.next;
			if(temp != null) {
				listNodeQ.add(temp);
			}
			list.next.next = null;
			list = list.next;
		}
		
		return head.next;
	}
}
