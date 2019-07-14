package download.dsalgo.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given an m x n matrix of 0s and 1s, if an element is 0, set its entire row
 * and column to 0.
 * 
 * Do it in place.
 * 
 * Example
 * 
 * Given array A as
 * 
 * 1 0 1 1 1 1 1 1 1 On returning, the array A should be :
 * 
 * 0 0 0 1 0 1 1 0 1
 * 
 * @author kaussark
 *
 */
public class Problem27 {

	public static void main(String[] args) {
		Problem27 problem = new Problem27();
		Integer[][] array = { { 0, 0 }, { 1, 0 } };
		ArrayList<ArrayList<Integer>> a = new ArrayList<>();

		for (Integer[] arr : array) {
			a.add(new ArrayList<>(Arrays.asList(arr)));
		}

		problem.setZeroes(a);

		System.out.println(a);

	}
	 public void setZeroes(ArrayList<ArrayList<Integer>> a) {
	        
	        int m=a.size(),n=0;
	        boolean[] x = new boolean[m];
	        if (m == 0) n = 0;
	        else n = a.get(0).size();
	        boolean[] y = new boolean[n];
	        
	        for(int i=0;i<m;i++) {
	            for(int j=0;j<n;j++){
	                if (a.get(i).get(j)==0) {
	                    x[i]=true;
	                    y[j]=true;
	                }
	            }
	        }
	        for(int i=0;i<m;i++) {
	            for(int j=0;j<n;j++){
	                if (x[i] || y[j]) a.get(i).set(j, 0); 
	            }
	        }
	        
	    }

	public void _setZeroes(ArrayList<ArrayList<Integer>> a) {
		Set<Integer> cols = new HashSet<>();
		Set<Integer> rows = new HashSet<>();

		// Find Zero rows and Columns
		for (int x = 0; x < a.size(); x++) {
			for (int y = 0; y < a.get(x).size(); y++) {
				if (a.get(x).get(y) == 0) {
					cols.add(y);
					rows.add(x);
				}
			}
		}

		for (int col : cols) {
			int counter = 0;
			while (counter < a.size()) {
				a.get(counter).add(col, 0);
				a.get(counter).remove(col + 1);
				counter++;
			}
			
		}
		for(int row : rows) {
			int counter = 0;
			while(counter < a.get(row).size()) {
				a.get(row).add(counter,0);
				a.get(row).remove(counter+1);
				counter++;
			}
		}

	}

}
