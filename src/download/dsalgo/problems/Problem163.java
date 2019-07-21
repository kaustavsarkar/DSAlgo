package download.dsalgo.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree
 * 
 * struct TreeLinkNode { TreeLinkNode *left; TreeLinkNode *right; TreeLinkNode
 * *next; } Populate each next pointer to point to its next right node. If there
 * is no next right node, the next pointer should be set to NULL.
 * 
 * Initially, all next pointers are set to NULL.
 * 
 * Note: You may only use constant extra space. Example :
 * 
 * Given the following binary tree,
 * 
 * 1 / \ 2 3 / \ / \ 4 5 6 7 After calling your function, the tree should look
 * like:
 * 
 * 1 -> NULL / \ 2 -> 3 -> NULL / \ / \ 4->5->6->7 -> NULL Note 1: that using
 * recursion has memory overhea
 * 
 * @author kaussark
 *
 */
public class Problem163 {

	private static class TreeLinkNode {
		int val;
		TreeLinkNode left;
		TreeLinkNode right;
		TreeLinkNode next;

		TreeLinkNode(int x) {
			val = x;
		}

	}

	public static void main(String[] args) {

	}

	public void connect(TreeLinkNode root) {
		Queue<TreeLinkNode> nodeQueue = new LinkedList<>();
		Queue<Integer> levels = new LinkedList<>();

		TreeLinkNode current = root;
		nodeQueue.add(current);
		levels.add(1);

		while (!nodeQueue.isEmpty()) {
			current = nodeQueue.poll();
			int currentLevel = levels.poll();
			if (current != null) {
				if (!levels.isEmpty() && currentLevel == levels.peek()) {
					current.next = nodeQueue.peek();
				} else {
					current.next = null;
				}

				TreeLinkNode leftChild = current.left;
				TreeLinkNode rightChild = current.right;
				if (leftChild != null) {
					nodeQueue.add(leftChild);
					levels.add(currentLevel + 1);
				}

				if (rightChild != null) {
					nodeQueue.add(rightChild);
					levels.add(currentLevel + 1);
				}
			}
		}

	}
}
