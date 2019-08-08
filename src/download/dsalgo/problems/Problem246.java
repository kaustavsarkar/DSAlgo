package download.dsalgo.problems;

import java.util.*;

/**
 * Given two words (start and end), and a dictionary, find the length of
 * shortest transformation sequence from start to end, such that:
 * 
 * You must change exactly one character in every transformation Each
 * intermediate word must exist in the dictionary Example :
 * 
 * Given:
 * 
 * start = "hit" end = "cog" dict = ["hot","dot","dog","lot","log"] As one
 * shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog", return
 * its length 5.
 * 
 * Note that we account for the length of the transformation path instead of the
 * number of transformation itself.
 * 
 * Note: Return 0 if there is no such transformation sequence. All words have
 * the same length. All words contain only lowercase alphabetic characters.
 * 
 * @author kaussark
 *
 */
public class Problem246 {

	public static void main(String[] args) {

	}

	private static class Ladder {
		String word;
		int length;
	}

	public int ladderLength(String start, String end, ArrayList<String> dictV) {
		Ladder source = new Ladder();
		source.word = start;
		source.length = 1;

		Queue<Ladder> ladderQ = new LinkedList<>();
		ladderQ.offer(source);

		while (!ladderQ.isEmpty()) {

			Ladder ladder = ladderQ.poll();

			if (ladder.word.equals(end)) {
				return ladder.length;
			}

			for (int index = 0; index < dictV.size(); index++) {
				String word = dictV.get(index);
				if (word.length() == ladder.word.length()
						&& isAdjacent(word, ladder.word)) {
					Ladder tempLadder = new Ladder();
					tempLadder.word = word;
					tempLadder.length = ladder.length + 1;
					ladderQ.offer(tempLadder);
					dictV.set(index, "");
				}
			}

		}
		return 0;
	}

	private boolean isAdjacent(String word, String word2) {
		int diffCount = 0;
		
		for(int index = 0; index < word.length(); index++) {
			if(word.charAt(index)!=word2.charAt(index)) {
				diffCount++;
			}
		}
		
		return diffCount == 1 ? true : false;
	}
}
