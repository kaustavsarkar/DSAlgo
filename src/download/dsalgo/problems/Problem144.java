package download.dsalgo.problems;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Design and implement a data structure for LRU (Least Recently Used) cache. It
 * should support the following operations: get and set.
 * 
 * get(key) - Get the value (will always be positive) of the key if the key
 * exists in the cache, otherwise return -1. set(key, value) - Set or insert the
 * value if the key is not already present. When the cache reaches its capacity,
 * it should invalidate the least recently used item before inserting the new
 * item. The LRU Cache will be initialized with an integer corresponding to its
 * capacity. Capacity indicates the maximum number of unique keys it can hold at
 * a time.
 * 
 * Definition of “least recently used” : An access to an item is defined as a
 * get or a set operation of the item. “Least recently used” item is the one
 * with the oldest access time.
 * 
 * NOTE: If you are using any global variables, make sure to clear them in the
 * constructor. Example :
 * 
 * Input : capacity = 2 set(1, 10) set(5, 12) get(5) returns 12 get(1) returns
 * 10 get(10) returns -1 set(6, 14) this pushes out key = 5 as LRU is full.
 * get(5) returns -1
 * 
 * @author kaussark
 *
 */
public class Problem144 {

	public static void main(String[] args) {
		// 32 4 S 5 13 S 9 6 S 4 1 G 4 S 6 1 S 8 11 G 13 G 1 S 12 12 G 10 S 15
		// 13 S 2 13 S 7 5 S 10 3 G 6 G 10 S 15 14 S 5 12 G 5 G 7 G 15 G 5 G 6 G
		// 10 S 7 13 G 14 S 8 9 G 4 S 6 11 G 9 S 6 12 G 3
		Problem144 problem = new Problem144(4);
		problem.set(5, 13);
		problem.set(9, 6);
		problem.set(4, 1);
		System.out.println(problem.get(4));
		problem.set(6, 1);
		problem.set(8, 11);
		System.out.println(problem.get(13));
		System.out.println(problem.get(1));
		problem.set(12, 12);
		System.out.println(problem.get(10));
		problem.set(15, 13);
		problem.set(2, 13);
		problem.set(7, 5);
		problem.set(10, 3);
		System.out.println(problem.get(6));
		System.out.println(problem.get(10));
		problem.set(15, 14);
		problem.set(5, 12);
		System.out.println(problem.get(5));
		System.out.println(problem.get(7));
		// 32 4 S 5 13 S 9 6 S 4 1 G 4 S 6 1 S 8 11 G 13 G 1 S 12 12 G 10 S 15
		// 13 S 2 13 S 7 5 S 10 3 G 6 G 10 S 15 14 S 5 12 G 5 G 7 G 15 G 5 G 6 G
		// 10 S 7 13 G 14 S 8 9 G 4 S 6 11 G 9 S 6 12 G 3

	}

	private static class Node {
		private int key;
		private int value;
		private Node next;
		private Node prev;

		public String toString() {
			return "<-[" + key + "|" + value + "]->";
		}

		public void print() {
			Node node = this;
			while (node != null) {
				System.out.print(node);
				node = node.next;
			}
			System.out.println();
		}
	}

	private Map<Integer, Node> lru = null;
	int maxCap = 0;
	int currCap = 0;
	Node head = null;
	Node tail = null;

	public Problem144(int capacity) {
		this.lru = new LinkedHashMap<>();
		this.maxCap = capacity;
		this.currCap = 0;

		head = new Node();
		tail = new Node();
		this.head.prev = null;
		this.tail.next = null;

		this.head.next = tail;
		this.tail.prev = head;
	}

	public int get(int key) {
		if (!lru.containsKey(key)) {
			return -1;
		}

		int val = lru.get(key).value;

		moveToHead(lru.get(key));
		return val;
	}

	private void moveToHead(Node node) {
		Node prev = node.prev;
		Node next = node.next;
		prev.next = next;
		next.prev = prev;
		node.next = head.next;
		node.prev = head;
		head.next.prev = node;
		head.next = node;
	}

	public void set(int key, int value) {
		Node node = lru.get(key);
		boolean isNodePresent = node != null;
		if (!isNodePresent) {
			node = new Node();
			node.value = value;
			node.key = key;
			lru.put(key, node);
			addNode(node);

			currCap++;
		} else {
			node.value = value;
			moveToHead(node);

		}
		if (currCap > maxCap) {
			removeLeastUsed();
		}
	}

	private void addNode(Node node) {
		node.next = head.next;
		node.prev = head;
		head.next = node;
		node.next.prev = node;
	}

	private void removeLeastUsed() {
		Node node = tail.prev;
		tail.prev = node.prev;
		node.prev.next = node.next;
		lru.remove(node.key);
		node = null;
		currCap--;
	}
}
