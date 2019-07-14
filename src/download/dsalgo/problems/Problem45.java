package download.dsalgo.problems;

import java.util.ArrayList;

/**
 * You have to paint N boards of length {A0, A1, A2, A3 … AN-1}. There are K
 * painters available and you are also given how much time a painter takes to
 * paint 1 unit of board. You have to get this job done as soon as possible
 * under the constraints that any painter will only paint contiguous sections of
 * board.
 * 
 * 2 painters cannot share a board to paint. That is to say, a board cannot be
 * painted partially by one painter, and partially by another. A painter will
 * only paint contiguous boards. Which means a configuration where painter 1
 * paints board 1 and 3 but not 2 is invalid. Return the ans % 10000003
 * 
 * Input : K : Number of painters T : Time taken by painter to paint 1 unit of
 * board L : A List which will represent length of each board
 * 
 * Output: return minimum time to paint all boards % 10000003 Example
 * 
 * Input : K : 2 T : 5 L : [1, 10] Output : 50
 * 
 * @author kaussark
 *
 */
public class Problem45 {

	public static void main(String[] args) {

	}

	public int paint(int A, int B, ArrayList<Integer> C) {
        long total = 0, max = Long.MIN_VALUE;
        for(Integer c : C){
            total += c;
            max = Math.max(max,c);
        }
        long l = max, h = total;
        while(l<h){
            long mid = (l + (h-l)/2);
            long reqPainters = getRequiredPainters(C,mid);
            if(reqPainters <= A) h = mid;
            else l = mid + 1;
        }
        long ans = ((l%10000003)*(B%10000003))%10000003;
        return (int)ans;
    }
    public long getRequiredPainters(ArrayList<Integer> A , long k){
        long total = 0, reqPainters = 1;
        for(Integer a : A){
            total += a;
            if(total > k){
                total = a;
                reqPainters++;
            }
        }
        return reqPainters;
    }
}
