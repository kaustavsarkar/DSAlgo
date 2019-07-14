package download.dsalgo.problems;

/**
 * You are given a string. The only operation allowed is to insert characters in
 * the beginning of the string. How many minimum characters are needed to be
 * inserted to make the string a palindrome string
 * 
 * Example: Input: ABC Output: 2 Input: AACECAAAA Output: 2
 * 
 * @author kaussark
 *
 */
public class Problem58 {

	public static void main(String[] args) {
		String input = "AACECAAAA";
		Problem58 problem = new Problem58();
		System.out.println(problem.solve(input));
	}
	public int _solve(String A) {
        int n = A.length();
        int ans = n;
        while(n>1 && !isPalindrome(A, n)) {
            n--;
        }
        return ans-n;
    }
    public boolean isPalindrome(String A, int len) {
        int i=0, j=len-1;
        while(i<=j && (A.charAt(i) == A.charAt(j))) {
            i++;j--;
        }
        if(i>j) {
            return true;
        }
        return false;
    }
	public int solve(String A) {
		int num = 0;
		int len = A.length();
		//Find till pallindrome
		for(int i = 0; i < len >>1; i++) {
			if(A.charAt(i) == A.charAt(len -i -1)) {
				num++;
			} else {
				break;
			}
		}
		
		if(num == len >> 1) {
			return 0;
		} else if(num == 0) {
			return len - 1;
		}
		
		
		return len - num;
    }

}
