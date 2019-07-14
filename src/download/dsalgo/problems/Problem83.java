package download.dsalgo.problems;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given an array with n objects colored red, white or blue, sort them so that
 * objects of the same color are adjacent, with the colors in the order red,
 * white and blue.
 * 
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white,
 * and blue respectively.
 * 
 * Note: Using library sort function is not allowed.
 * 
 * Example :
 * 
 * Input : [0 1 2 0 1 2] Modify array so that it becomes : [0 0 1 1 2 2]
 * 
 * @author kaussark
 *
 */
public class Problem83 {

	public static void main(String[] args) {
		Integer[] array = {0, 1, 2, 0, 1, 2};
		ArrayList<Integer> input = new ArrayList<>(Arrays.asList(array));
		new Problem83().sortColors(input);
		System.out.println(input);
	}
	public void sortColors(ArrayList<Integer> a) {
		int[] count = new int[3];
		for(int i : a) {
			count[i]++;
		}
		
		int counter = 0;
		int acounter = 0;
		while(acounter < a.size()) {
			if(counter < 3 &&count[counter] > 0) {
				a.set(acounter, counter);
				count[counter]--;
				acounter++;
			} else {
				counter++;
			}
		}
    }
}
