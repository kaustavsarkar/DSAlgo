package download.dsalgo.problems;

import java.util.*;

/**
 * Given a singly linked list where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 * 
 * A height balanced BST : a height-balanced binary tree is defined as a binary
 * tree in which the depth of the two subtrees of every node never differ by
 * more than 1. Example :
 * 
 * 
 * Given A : 1 -> 2 -> 3 A height balanced BST :
 * 
 * 2 / \ 1 3
 * 
 * @author kaussark
 *
 */
public class Problem243 {

	public static void main(String[] args) {
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		System.out.println(new Problem243().sortedListToBST(node));
	}

	public TreeNode sortedListToBST(ListNode a) {
		if (a == null) {
			return null;
		}
		if (a.next == null) {
			return new TreeNode(a.val);
		}
		List<Integer> nodeList = new ArrayList<>();
		ListNode current = a;
		while (current != null) {
			nodeList.add(current.val);
			current = current.next;
		}

		TreeNode root = null;
		root = buildTree(root, nodeList, 0, nodeList.size() - 1);
		return root;
	}

	private TreeNode buildTree(TreeNode root, List<Integer> nodeList, int start,
			int end) {
		if (start > end) {
			return null;
		}
		
		
		int mid = start + ((end - start) / 2);
		TreeNode node = new TreeNode(mid);
		root = node;
		root.val = nodeList.get(mid);
		root.left = buildTree(root.left, nodeList, start, mid-1);
		root.right = buildTree(root.right, nodeList, mid+1, end);
		return root;
	}
}
