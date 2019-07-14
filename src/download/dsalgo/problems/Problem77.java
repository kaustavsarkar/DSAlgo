package download.dsalgo.problems;

import java.util.ArrayList;

/**
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * 
 * Note: You have to modify the array A to contain the merge of A and B. Do not
 * output anything in your code. TIP: C users, please malloc the result into a
 * new array and return the result. If the number of elements initialized in A
 * and B are m and n respectively, the resulting size of array A after your code
 * is executed should be m + n
 * 
 * Example :
 * 
 * Input : A : [1 5 8] B : [6 9]
 * 
 * Modified A : [1 5 6 8 9]
 * 
 * @author kaussark
 *
 */
public class Problem77 {

	public static void main(String[] args) {

	}
	public void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
		int acounter = 0;
		int bcounter = 0;
		
		while(acounter < a.size() && bcounter < b.size()) {
			if(a.get(acounter) < b.get(bcounter)) {
				acounter++;
			} else {
				a.add(acounter, b.get(bcounter));
				bcounter++;
				acounter++;
			}
		}
		
		while(bcounter < b.size()) {
			a.add(b.get(bcounter));
			bcounter++;
		}
    }
}
