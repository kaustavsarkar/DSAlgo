package download.dsalgo.problems;

import java.util.*;


/**
 * Given a string s and a dictionary of words dict, add spaces in s to construct
 * a sentence where each word is a valid dictionary word.
 * 
 * Return all such possible sentences.
 * 
 * For example, given
 * 
 * s = "catsanddog", dict = ["cat", "cats", "and", "sand", "dog"]. A solution is
 * 
 * [ "cat sand dog", "cats and dog" ] Make sure the strings are sorted in your
 * result.
 * 
 * @author kaussark
 *
 */
public class Problem222 {

	public static void main(String[] args) {
		String input = "catsanddog";
		String[] dict = {"cat", "cats", "and", "sand", "dog"};
		System.out.println(new Problem222()._wordBreak(input, new ArrayList<>(Arrays.asList(dict))));
	}

	public ArrayList<String> _wordBreak(String a, ArrayList<String> b) {
		ArrayList<String> res = new ArrayList<>();

		if (a == null || b == null || a.length() == 0 || b.size() == 0) {
			return res;
		}

		ArrayList<String> curr = new ArrayList<>();

		wordBreakHelper(0, a, b, curr, res);

		return res;
	}

	private void wordBreakHelper(int start, String a, ArrayList<String> dict,
			ArrayList<String> curr, ArrayList<String> res) {
		if (start >= a.length()) {
			res.add(constructString(curr));
			return;
		}

		for (int i = start; i < a.length(); i++) {
			if (dict.contains(a.substring(start, i + 1))) {
				curr.add(a.substring(start, i + 1));
				wordBreakHelper(i + 1, a, dict, curr, res);
				curr.remove(curr.size() - 1);
			}
		}
	}

	private String constructString(ArrayList<String> list) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < list.size() - 1; i++) {
			sb.append(list.get(i)).append(" ");
		}

		sb.append(list.get(list.size() - 1));

		return sb.toString();
	}

	public ArrayList<String> wordBreak(String A, ArrayList<String> B) {
		ArrayList<String> result = new ArrayList<>();
		if (A == null || A.isEmpty()) {
			return result;
		}

		Map<Integer, List<Integer>> indexMap = new HashMap<>();

		Trie2 root = new Trie2();
		for (String word : B) {
			root.insert(word);
		}
		int totalString = 1;
		for (int index = 0; index < A.length();) {
			List<Integer> indexList = searchEndIndices(root, A.charAt(index),
					index);
			indexMap.put(index, indexList);
			totalString *= indexList.size();
			index = indexList.get(0);
		}

		while (totalString >= 0) {

		}

		int counter = 0;
		return result;

	}

	private List<Integer> searchEndIndices(Trie2 root, char charAt, int start) {
		List<Integer> indices = new ArrayList<>();

		Trie2 current = root.children.get(charAt);
		int counter = 1;
		while (current != null) {
			Trie2 node = current.children.get(charAt);
			if (node == null) {
				return indices;
			} else if (node.isEnd) {
				indices.add(start + counter + 1);
			}
			current = node;
			counter++;
		}

		return indices;
	}
}

class Trie2 {
	Map<Character, Trie2> children;
	boolean isEnd;
	int frequency;

	private Trie2 root;

	public Trie2() {
		children = new HashMap<Character, Trie2>();
		this.isEnd = false;
		this.frequency = 0;
	}

	public Trie2 getRoot() {
		return this.root;
	}

	public void insert(String word) {
		Trie2 curr = this.root;

		for (int index = 0; index < word.length(); index++) {
			char character = word.charAt(index);
			Trie2 node = curr.children.get(character);
			if (node == null) {
				node = new Trie2();
				curr.children.put(character, node);
			}
			curr.frequency++;
			curr = node;
		}
		curr.isEnd = true;
	}

	public boolean search(String word) {
		Trie2 curr = this.root;
		for (int index = 0; index < word.length(); index++) {
			char character = word.charAt(index);
			Trie2 node = curr.children.get(character);
			if (node == null) {
				return false;
			}
			curr = node;
		}
		return curr.isEnd;
	}

	public String getLongestCP() {

		StringBuilder result = new StringBuilder();
		Trie2 curr = this.root;
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