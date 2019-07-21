package download.dsalgo.problems;
import java.util.*;
/**
 * Find longest Arithmetic Progression in an integer array and return its
 * length. More formally, find longest sequence of indeces, 0 < i1 < i2 < … < ik
 * < ArraySize(0-indexed) such that sequence A[i1], A[i2], …, A[ik] is an
 * Arithmetic Progression. Arithmetic Progression is a sequence in which all the
 * differences between consecutive pairs are the same, i.e sequence B[0], B[1],
 * B[2], …, B[m - 1] of length m is an Arithmetic Progression if and only if
 * B[1] - B[0] == B[2] - B[1] == B[3] - B[2] == … == B[m - 1] - B[m - 2].
 * Examples 1) 1, 2, 3(All differences are equal to 1) 2) 7, 7, 7(All
 * differences are equal to 0) 3) 8, 5, 2(Yes, difference can be negative too)
 * 
 * Samples 1) Input: 3, 6, 9, 12 Output: 4
 * 
 * 2) Input: 9, 4, 7, 2, 10 Output: 3(If we choose elements in positions 1, 2
 * and 4(0-indexed))
 * 
 * @author kaussark
 *
 */
public class Problem181 {

	public static void main(String[] args) {

	}
	 public int solve(final List<Integer> A) {
	        if(A.size()<=2) return A.size();
	        int max =2 ;
	        for(int i=0 ; i<A.size()-2 ; i++){
	            for(int j=i+1 ; j<A.size()-1;j++){
	                int currMax = 2 ;
	                for(int k=j+1 ; k<A.size() ; k++){
	                    if(((currMax-1)*(A.get(i)-A.get(j)))==(A.get(j)-A.get(k)))
	                        currMax++;
	                }
	                if(currMax>max) max = currMax;
	            }
	        }
	        return max ;
	    }
}
