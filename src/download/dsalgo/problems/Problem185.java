package download.dsalgo.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Problem185 {

	public static void main(String[] args) {
		
		

	}

	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 0) {
			return "";
		}
		if (strs.length == 1) {
			return strs[0];
		}
		Trie trie = new Trie();
		for (String word : strs) {
			if (word.isEmpty()) {
				return "";
			}
			trie.insert(word);
		}

		return trie.getLongestCP();
	}

}

class Trie {
	private static class TrieNode {
		Map<Character, TrieNode> children;
		boolean isEnd;
		int frequency;

		public TrieNode() {
			this.children = new HashMap<>();
			this.isEnd = false;
			this.frequency = 0;
		}
	}

	private TrieNode root;

	public Trie() {
		this.root = new TrieNode();
	}
	

	public TrieNode getRoot() {
		return this.root;
	}

	public void insert(String word) {
		TrieNode curr = this.root;

		for (int index = 0; index < word.length(); index++) {
			char character = word.charAt(index);
			TrieNode node = curr.children.get(character);
			if (node == null) {
				node = new TrieNode();
				curr.children.put(character, node);
			}
			curr.frequency++;
			curr = node;
		}
		curr.isEnd = true;
	}

	public boolean search(String word) {
		TrieNode curr = this.root;
		for (int index = 0; index < word.length(); index++) {
			char character = word.charAt(index);
			TrieNode node = curr.children.get(character);
			if (node == null) {
				return false;
			}
			curr = node;
		}
		return curr.isEnd;
	}

	public String getLongestCP() {

		StringBuilder result = new StringBuilder();
		TrieNode curr = this.root;
		int maxFrequency = curr.frequency;

		while (curr != null && curr.children != null) {
			int freq = curr.frequency;
			if (freq < maxFrequency || curr.children.size() > 1) {
				break;
			}
			char character = new ArrayList<>(curr.children.keySet()).get(0);
			result.append(character);
			curr = curr.children.get(character);

		}

		return result.toString();
	}
}