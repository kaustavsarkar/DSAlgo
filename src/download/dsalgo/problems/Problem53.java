package download.dsalgo.problems;

/**
 * Given a string, determine if it is a palindrome, considering only
 * alphanumeric characters and ignoring cases.
 * 
 * Example:
 * 
 * "A man, a plan, a canal: Panama" is a palindrome.
 * 
 * "race a car" is not a palindrome.
 * 
 * Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 * 
 * @author kaussark
 *
 */
public class Problem53 {

	public static void main(String[] args) {
		Problem53 problem = new Problem53();
		// 97 65 90 122
		System.out.println(problem.isPalindrome("A man, a plan, a canal: Panama"));
	}
	 public int isPalindrome1(String A) {
		    if (A.isEmpty()) {
		        	return 1;
		        }
		        int head = 0, tail = A.length() - 1;
		        char cHead, cTail;
		        while(head <= tail) {
		        	cHead = A.charAt(head);
		        	cTail = A.charAt(tail);
		        	if (!Character.isLetterOrDigit(cHead)) {
		        		head++;
		        	} else if(!Character.isLetterOrDigit(cTail)) {
		        		tail--;
		        	} else {
		        		if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
		        			return 0;
		        		}
		        		head++;
		        		tail--;
		        	}
		        }
		        
		        return 1;
		    }
	public int isPalindrome(String A) {

		int start = 0;
		int end = A.length() - 1;
		while (start <= end) {
			if (A.charAt(start) == ' ' || A.charAt(start) == ','
					|| A.charAt(start) == ':' || A.charAt(start)=='"') {
				start++;
				continue;
			}

			if (A.charAt(end) == ' ' || A.charAt(end) == ','
					|| A.charAt(end) == ':' || A.charAt(end)=='"') {
				end--;
				continue;
			}

			if (A.charAt(start) - A.charAt(end) != 0
					&& Math.abs(A.charAt(start) - A.charAt(end)) != 32) {
				return 0;
			}

			start++;
			end--;
		}

		return 1;
	}

}
