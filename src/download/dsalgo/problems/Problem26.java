package download.dsalgo.problems;

import java.util.ArrayList;

/**
 * Given a positive integer n and a string s consisting only of letters D or I,
 * you have to find any permutation of first n positive integer that satisfy the
 * given input string.
 * 
 * D means the next number is smaller, while I means the next number is greater.
 * 
 * Notes
 * 
 * Length of given string s will always equal to n - 1 Your solution should run
 * in linear time and space. Example :
 * 
 * Input 1:
 * 
 * n = 3
 * 
 * s = ID
 * 
 * Return: [1, 3, 2]
 * 
 * @author kaussark
 *
 */
public class Problem26 {

	public static void main(String[] args) {
		Problem26 problem = new Problem26();
		
		ArrayList<Integer> perm = problem.findPerm("ID", 3);
		
		System.out.println(perm);
	}

	public ArrayList<Integer> findPerm(final String A, int B) {
		Integer[] array = new Integer[B];
		ArrayList<Integer> perm = new ArrayList<>();
		for (int i = 0; i < B; i++) {
			array[i] = i+1;
		}
		int counter = 0;
		int small = 0;
		int large = array.length-1;
		char[] chars = A.toCharArray();
		while (perm.size() != B) {
			if (chars[counter] == 'I') {
				perm.add(array[small++]);
				counter++;
			} else {
				perm.add(array[large--]);
				counter++;
			}
			
			if(counter == A.length() && chars[counter-1] == 'I') {
				perm.add(array[large]);
			} else if(counter == A.length() && chars[counter-1] == 'D' ) {
				perm.add(array[small]);
			}
			
		}

		return perm;
	}
}
