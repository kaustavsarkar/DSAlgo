package download.dsalgo.problems;

import java.util.ArrayList;

/**
 * You are given with an array of 1s and 0s. And you are given with an integer
 * M, which signifies number of flips allowed. Find the position of zeros which
 * when flipped will produce maximum continuous series of 1s.
 * 
 * For this problem, return the indices of maximum continuous series of 1s in
 * order.
 * 
 * Example:
 * 
 * Input : Array = {1 1 0 1 1 0 0 1 1 1 } M = 1
 * 
 * Output : [0, 1, 2, 3, 4]
 * 
 * If there are multiple possible solutions, return the sequence which has the
 * minimum start index.
 * 
 * @author kaussark
 *
 */
public class Problem84 {

	public static void main(String[] args) {

	}
	 public ArrayList<Integer> maxone(ArrayList<Integer> A, int B) {
	        ArrayList<Integer> res = new ArrayList<>();
	        int n = A.size();
	        if(n == 0) {
	            res.add(0);
	            return res;
	        }
	        
	        int start = -1, end = -2;
	        for(int i = 0; i < n; i++) {
	            int flips = B;
	            if(A.get(i) == 0 && flips > 0) {
	                flips--;
	            } else if(A.get(i) == 0 && flips == 0) {
	                continue;
	            }
	            int j = i + 1;
	            while(j < n) {
	                if(A.get(j) == 0 && flips > 0) flips--;
	                else if(A.get(j) == 0 && flips == 0) break;
	                j++;
	            }
	            if(j - i > end - start) {
	                start = i;
	                end = j;
	            }
	        }
	        
	        for(int i = start; i < end; i++) {
	            res.add(i);
	        }
	        return res;
	    }

}
