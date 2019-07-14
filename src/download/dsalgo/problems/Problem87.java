package download.dsalgo.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a +
 * b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * 
 * Note:
 * 
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤
 * c) The solution set must not contain duplicate triplets. For example, given
 * array S = {-1 0 1 2 -1 -4}, A solution set is: (-1, 0, 1) (-1, -1, 2)
 * 
 * @author kaussark
 *
 */
public class Problem87 {

	public static void main(String[] args) {
		Integer[] array = //{-5,-4,-3,9,8,7};
			{ -1, 0, 1, 2, -1, -4 };
		System.out.println(new Problem87()
				.threeSum(new ArrayList<>(Arrays.asList(array))));

	}
	public ArrayList<ArrayList<Integer>> _threeSum(ArrayList<Integer> A) {
        int n = A.size();
        Collections.sort(A);
        HashSet<ArrayList<Integer>> res = new HashSet<>();
        
        
        for(int i=0; i<n-2; i++) {
            int l = i+1;
            int r = n-1;
            
            // System.out.println("i " + i);
            
            while(l < r) {
                int curr = A.get(i) + A.get(l) + A.get(r);
                
                // System.out.println("l " + l + " r " + r);
                
                if(curr == 0) {
                    ArrayList<Integer> ls = new ArrayList<>();
                    ls.add(A.get(i));
                    ls.add(A.get(l));
                    ls.add(A.get(r));
                    if(!res.contains(ls)) res.add(ls);
                    l++;
                }
                
                else if(curr > 0) r--;
                
                else l++;
            }
        }
        
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        
        for(ArrayList<Integer> il : res) {
            ans.add(il);
        }
        
        return ans;
    }
	public ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> A) {
		Collections.sort(A);
		ArrayList<ArrayList<Integer>> set = new ArrayList<>();
		if (!(A.get(0) < 0)) {
			return set;
		}

		int start = 0;
		int hook = 1;

		while (hook < A.size() && A.get(start) < 0) {
			int counter = hook + 1;
			ArrayList<Integer> tuple = new ArrayList<>();
			while (counter < A.size() && hook < counter) {
				if (A.get(start) + A.get(hook) + A.get(counter) != 0) {
					counter++;
				} else {
					tuple.add(A.get(start));
					tuple.add(A.get(hook));
					tuple.add(A.get(counter));
					set.add(tuple);
					tuple = new ArrayList<>();
					hook++;
					counter--;
				}
				if (counter == A.size() && hook < counter - 2 && (A.get(start)
						+ A.get(hook) + A.get(counter - 1) < 0)) {
					counter--;
					hook++;
				}
			}
			if (A.get(start++) < 0) {
				if(A.get(start).compareTo(A.get(start-1)) == 0) {
					start = start+1;
				}
				hook = start + 1;
			}

		}

		return set;
	}
}
