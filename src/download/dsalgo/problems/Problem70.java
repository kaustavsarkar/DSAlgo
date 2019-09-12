package download.dsalgo.problems;

import java.util.ArrayList;

/**
 * Given an array of words and a length L, format the text such that each line
 * has exactly L characters and is fully (left and right) justified. You should
 * pack your words in a greedy approach; that is, pack as many words as you can
 * in each line.
 * 
 * Pad extra spaces � � when necessary so that each line has exactly L
 * characters. Extra spaces between words should be distributed as evenly as
 * possible. If the number of spaces on a line do not divide evenly between
 * words, the empty slots on the left will be assigned more spaces than the
 * slots on the right. For the last line of text, it should be left justified
 * and no extra space is inserted between words.
 * 
 * Your program should return a list of strings, where each string represents a
 * single line.
 * 
 * Example:
 * 
 * words: ["This", "is", "an", "example", "of", "text", "justification."]
 * 
 * L: 16.
 * 
 * Return the formatted lines as:
 * 
 * [ "This is an", "example of text", "justification. " ] Note: Each word is
 * guaranteed not to exceed L in length.
 * 
 * @author kaussark
 *
 */
public class Problem70 {

	public static void main(String[] args) {
		StringBuilder builder = new StringBuilder();
		//builder.ins
	}

	public ArrayList<String> fullJustify(ArrayList<String> A, int B) {
		ArrayList<String> just = new ArrayList<>();
		ArrayList<String> lengths = new ArrayList<>(); 
				//getLengths(A);

		for(int i =0;i < A.size();i++) {
			int totalLength = 0;
			while(totalLength < B) {
				if(totalLength + A.get(i).length() <= B) {
					lengths.add(A.get(i));
					totalLength += A.get(i++).length()+1;
				}
			}
			--i;
			int diff = B - totalLength;
			StringBuilder string = new StringBuilder();
			
			for(String s : lengths) {
				string.append(s);
				if(diff > lengths.size()) {
					
				}
				
			}
			
		}

		return just;
	}

	private ArrayList<Integer> getLengths(ArrayList<String> a) {
		ArrayList<Integer> lengths = new ArrayList<>();
		for (String s : a) {
			lengths.add(s.length());
		}
		return lengths;
	}
}
