package download.dsalgo;

import java.util.HashMap;
import java.util.Map;

public class Trie {

	public static void main(String[] args) {

	}

	private static class TrieNode {
		Map<Character, TrieNode> children;
		boolean isWordEnd;

		public TrieNode() {
			this.children = new HashMap<>();
			isWordEnd = false;
		}
	}

	private final TrieNode root;

	public Trie() {
		this.root = new TrieNode();
	}

	/**
	 * Iterative approach to add a word
	 * 
	 * @param word
	 */
	public void insert(String word) {
		TrieNode current = root;

		for (int i = 0; i < word.length(); i++) {
			char character = word.charAt(i);
			TrieNode node = current.children.get(character);
			if (node == null) {
				node = new TrieNode();
				current.children.put(character, node);
			}
			current = node;
		}
		current.isWordEnd = true;
	}

	/**
	 * Recursive insert
	 * 
	 * @param word
	 */
	public void recurInsert(String word) {
		TrieNode current = root;
		insertHelper(current, word, 0);
	}

	private void insertHelper(TrieNode current, String word, int index) {
		if (index >= word.length()) {
			current.isWordEnd = true;
			return;
		}

		char character = word.charAt(index);
		TrieNode node = current.children.get(character);

		if (node == null) {
			node = new TrieNode();
			current.children.put(character, node);
		}
		insertHelper(node, word, index + 1);
	}

	/**
	 * Iterative word search
	 * 
	 * @param word
	 * @return
	 */
	public boolean search(String word) {
		TrieNode current = root;
		for (int i = 0; i < word.length(); i++) {

			char character = word.charAt(i);
			TrieNode node = current.children.get(character);
			if (node == null) {
				return false;
			}
			current = node;

		}
		return current.isWordEnd;
	}

	public boolean searchRecur(String word) {
		return searchRecurHelper(root, word, 0);
	}

	private boolean searchRecurHelper(TrieNode current, String word,
			int index) {
		if (index == word.length()) {
			return current.isWordEnd;
		}

		char character = word.charAt(index);
		TrieNode node = current.children.get(character);

		if (node == null) {
			return false;
		}

		return searchRecurHelper(node, word, index + 1);
	}

	public boolean delete(String word) {
		return deleteHelper(root, word, 0);
	}

	private boolean deleteHelper(TrieNode current, String word, int index) {
		if (index == word.length()) {
			if (!current.isWordEnd) {
				return false;
			}
			current.isWordEnd = false;
			return current.children.size() == 0;
		}
		
		char character = word.charAt(index);
		TrieNode node = current.children.get(character);
		
		if(node == null) {
			return false;
		}
		
		boolean shouldDelete = deleteHelper(node, word, index+1);
		
		if(shouldDelete) {
			current.children.remove(character);
			return current.children.size() == 0;
		}
		return false;

	}
}
