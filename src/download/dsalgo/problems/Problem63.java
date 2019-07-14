package download.dsalgo.problems;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space
 * characters ' ', return the length of last word in the string.
 * 
 * If the last word does not exist, return 0.
 * 
 * Note: A word is defined as a character sequence consists of non-space
 * characters only.
 * 
 * Example:
 * 
 * Given s = "Hello World",
 * 
 * return 5 as length("World") = 5.
 * 
 * Please make sure you try to solve this problem without using library
 * functions. Make sure you only traverse the string once.
 * 
 * @author kaussark
 *
 */
public class Problem63 {

	public static void main(String[] args) {
		Problem63 problem = new Problem63();
		System.out.println(problem.lengthOfLastWord("Hello World  "));
	}

	public int lengthOfLastWord(final String A) {
		int length = 0;
		int start = 0;
		while(start < A.length()) {
			if(A.charAt(start) != ' ') {
				length++;
				start++;
			} else  {
				while(start  < A.length() && A.charAt(start) == ' ') {
					start++;
				}
				if(start == A.length()) {
					return length;
				} else {
					length = 0;
				}
			}
		}
		
		return length;
	}
}
