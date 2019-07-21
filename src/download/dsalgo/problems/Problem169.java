package download.dsalgo.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Find shortest unique prefix to represent each word in the list.
 * 
 * Example:
 * 
 * Input: [zebra, dog, duck, dove] Output: {z, dog, du, dov} where we can see
 * that zebra = z dog = dog duck = du dove = dov NOTE : Assume that no word is
 * prefix of another. In other words, the representation is always possible.
 * 
 * @author kaussark
 *
 */
public class Problem169 {

	public static void main(String[] args) {
		String[] input = //{ "bearcat", "bert" };
		 { "zebra", "dog", "duck", "dove" };
		System.out.println(
				new Problem169().prefix(new ArrayList<>(Arrays.asList(input))));
	}

	private static class Trie {
		Map<Character, Trie> children;
		boolean isWordEnd;
		int frequency;

		Trie() {
			this.children = new HashMap<>();
			isWordEnd = false;
			frequency = 0;
		}

		public void insert(String word) {
			Trie current = this;
			for (Character character : word.toCharArray()) {
				Trie node = current.children.get(character);
				if (node == null) {
					node = new Trie();
					current.children.put(character, node);
				}
				current.frequency++;
				current = node;
			}
			current.isWordEnd = true;
		}

		public String toString() {
			return "[" + children.keySet() + "]" + frequency + ":" + isWordEnd;
		}
	}

	public ArrayList<String> prefix(ArrayList<String> A) {
		// Create a Trie and insert words
		Trie dictionary = new Trie();
		ArrayList<String> prefixes = new ArrayList<>();
		for (String word : A) {
			dictionary.insert(word);
		}

		// Search till children is one
		for (String word : A) {
			String prefix = searchForOneChild(dictionary, word);
			prefixes.add(prefix);
		}
		return prefixes;
	}

	private String searchForOneChild(Trie dictionary, String word) {
		StringBuilder prefix = new StringBuilder();
		Trie current = dictionary;
		for (Character ch : word.toCharArray()) {
			if (current != null) {
				int children = current.children.size();
				int frequency = current.frequency;
				if (children != 1 || frequency > 1) {
					prefix.append(ch);
				} else if (children == 1 && frequency < 2) {
					// prefix.append(ch);
					return prefix.toString();
				}
				current = current.children.get(ch);
			}
		}

		if (current.isWordEnd) {
			return prefix.toString();
		}

		return null;
	}
}
