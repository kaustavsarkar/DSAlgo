package download.dsalgo.problems;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given an array and a value, remove all the instances of that value in the
 * array. Also return the number of elements left in the array after the
 * operation. It does not matter what is left beyond the expected length.
 * 
 * Example: If array A is [4, 1, 1, 2, 1, 3] and value elem is 1, then new
 * length is 3, and A is now [4, 2, 3] Try to do it in less than linear
 * additional space complexity.
 * 
 * @author kaussark
 *
 */
public class Problem82 {

	public static void main(String[] args) {
		Integer[] array = {4, 1, 1, 2, 1, 3};
		ArrayList<Integer> input = new ArrayList<>(Arrays.asList(array));
		
		System.out.println(new Problem82()._removeElement(input, 1));
		System.out.println(input);

	}
	
	public int _removeElement(ArrayList<Integer> a, int b)
	{
	    int n = a.size();
	    int i, j;
	    
	    for (i=0, j=0; j<n; j++)
	    {
	        if (a.get(j) != b)
	        {
	            a.set(i, a.get(j));
	            i++;
	        }
	    }
	    
	    return i;
	}
	public int removeElement(ArrayList<Integer> a, int b) {
		int counter =0;
		while(counter < a.size()) {
			if(a.get(counter).compareTo(b) == 0) {
				a.remove(counter);
			} else {
				counter++;
			}
		}
		
		return a.size();
    }
}
