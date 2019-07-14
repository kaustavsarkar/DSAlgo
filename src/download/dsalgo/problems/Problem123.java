package download.dsalgo.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 * 
 * By listing and labeling all of the permutations in order, We get the
 * following sequence (ie, for n = 3 ) :
 * 
 * 1. "123" 2. "132" 3. "213" 4. "231" 5. "312" 6. "321" Given n and k, return
 * the kth permutation sequence.
 * 
 * For example, given n = 3, k = 4, ans = "231"
 * 
 * Good questions to ask the interviewer : What if n is greater than 10. How
 * should multiple digit numbers be represented in string? In this case, just
 * concatenate the number to the answer. so if n = 11, k = 1, ans =
 * "1234567891011" Whats the maximum value of n and k? In this case, k will be a
 * positive integer thats less than INT_MAX.
 * 
 * @author kaussark
 *
 */
public class Problem123 {

	public static void main(String[] args) {
		//System.out.println(
				new Problem123().findPermutation(3, 4);
				//);
	}

	
	public void findPermutation(int n, int k)
	{
	    int[] numbers = new int[n];
	    int[] indices = new int[n];

	    // initialise the numbers 1, 2, 3...
	    for (int i = 0; i < n; i++)
	        numbers[i] = i + 1;

	    int divisor = 1;
	    for (int place = 1; place <= n; place++)
	    {
	        if((k / divisor) == 0)
	            break;  // all the remaining indices will be zero

	        // compute the index at that place:
	        indices[n-place] = ((k-1) / divisor) % place;
	        divisor *= place;
	    }

	    // print out the indices:
	    // System.out.println(Arrays.toString(indices));

	    // permute the numbers array according to the indices:
	    for (int i = 0; i < n; i++)
	    {
	        int index = indices[i] + i;

	        // take the element at index and place it at i, moving the rest up
	        if(index != i)
	        {
	            int temp = numbers[index];
	            for(int j = index; j > i; j--)
	               numbers[j] = numbers[j-1];
	            numbers[i] = temp;
	        }
	    }

	    // print out the permutation:
	    System.out.println(Arrays.toString(numbers));
	}
	public String getPermutation(int A, int B) {
		String perm = "";

		ArrayList<String> numbers = new ArrayList<>();
		for (Integer i = 1; i <= B; i++) {
			numbers.add(i.toString());
		}

		return perm;
	}

	private void runPerms(char[] currPerm, ArrayList<String> numbers,
			int counter, int B) {
		if (counter == B) {
			return;
		}

		for (int i = 0; i < B; i++) {
			char num = numbers.get(i).charAt(0);
		}
	}
}
