package download.dsalgo.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * A linked list is given such that each node contains an additional random
 * pointer which could point to any node in the list or NULL.
 * 
 * Return a deep copy of the list.
 * 
 * Example
 * 
 * Given list
 * 
 * 1 -> 2 -> 3 with random pointers going from
 * 
 * 1 -> 3 2 -> 1 3 -> 1 You should return a deep copy of the list. The returned
 * answer should not contain the same node as the original list, but a copy of
 * them. The pointers in the returned list should not link to any node in the
 * original input list.
 * 
 * @author kaussark
 *
 */
public class Problem135 {

	public static void main(String[] args) {

	}

	public RandomListNode _copyRandomList(RandomListNode head) {
		if (head == null) {
			return null;
		}
		RandomListNode list1 = head;
		Map<RandomListNode, RandomListNode> copyMap = new HashMap<>();
		while (list1 != null) {
			RandomListNode node = new RandomListNode(list1.label);
			copyMap.put(list1, node);
			list1 = list1.next;
		}
		// heart of the code.
		for (RandomListNode node : copyMap.keySet()) {
			RandomListNode copy = copyMap.get(node);
			copy.next = copyMap.get(node.next);
			copy.random = copyMap.get(node.random);
			// copyMap.put(node, copy);
		}
		return copyMap.get(head);
	}

	RandomListNode copyRandomList(RandomListNode head) {
		RandomListNode random = null;
		if (head == null) {
			return random;
		}
		Set<Integer> visitedNodes = new HashSet<>();
		Stack<RandomListNode> tracker = new Stack<>();
		tracker.push(head);
		visitedNodes.add(head.label);
		RandomListNode currentNode = null;
		RandomListNode currNext = null;
		RandomListNode currRand = null;
		while (!tracker.isEmpty()) {
			currentNode = tracker.pop();
			currNext = currentNode.next;
			currRand = currentNode.random;
			if (currNext != null && !visitedNodes.contains(currNext.label)) {
				visitedNodes.add(currNext.label);
				tracker.push(currNext);
			}

			if (currRand != null && !visitedNodes.contains(currRand.label)) {
				visitedNodes.add(currRand.label);
				tracker.push(currRand);
			}
		}

		RandomListNode curr = null;
		for (Integer label : visitedNodes) {
			if (curr != null) {
				curr.next = new RandomListNode(label);
				curr = curr.next;
			} else {
				random = new RandomListNode(label);
				curr = random;
			}
		}

		return random;
	}
}
