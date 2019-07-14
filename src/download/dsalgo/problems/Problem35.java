package download.dsalgo.problems;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 * 
 * A palindrome integer is an integer x for which reverse(x) = x where
 * reverse(x) is x with its digit reversed. Negative numbers are not
 * palindromic.
 * 
 * Example :
 * 
 * Input : 12121 Output : True
 * 
 * Input : 123 Output : False
 * 
 * @author kaussark
 *
 */
public class Problem35 {

	public static void main(String[] args) {
		Problem35 problem = new Problem35();
		int num = problem.isPalindrome(Integer.valueOf(""));
		System.out.println(num);
	}

	public int isPalindrome(int A) {
		if(A < 0) {
			return 0;
		}
		StringBuilder sb = new StringBuilder();
		int counter = 0;
		int temp = A;
		while (A != 0) {
			int num = (int) (A % Math.pow(10, counter + 1));
			sb.append((int)(num / Math.pow(10, counter)));
			A = A - num;
			counter++;
		}

		return temp - Long.valueOf(sb.toString()) == 0 ? 1 : 0;
	}

}
