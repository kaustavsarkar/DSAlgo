package download.dsalgo.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * You are given an array of N integers, A1, A2 ,…, AN and an integer K. Return
 * the of count of distinct numbers in all windows of size K.
 * 
 * Formally, return an array of size N-K+1 where i’th element in this array
 * contains number of distinct elements in sequence Ai, Ai+1 ,…, Ai+k-1.
 * 
 * Note:
 * 
 * If K > N, return empty array. For example,
 * 
 * A=[1, 2, 1, 3, 4, 3] and K = 3
 * 
 * All windows of size K are
 * 
 * [1, 2, 1] [2, 1, 3] [1, 3, 4] [3, 4, 3]
 * 
 * So, we return an array [2, 3, 3, 2].
 * 
 * @author kaussark
 *
 */
public class Problem143 {

	public static void main(String[] args) {
		Integer[] array = { 1, 2, 1, 3, 4, 3 };
		System.out.println(new Problem143()
				.dNums(new ArrayList<>(Arrays.asList(array)), 3));
	}

	public ArrayList<Integer> _dNums(ArrayList<Integer> A, int B) {
		ArrayList<Integer> count = new ArrayList<>();

		int counter = 0;
		while (counter < A.size() - B + 1) {
			count.add(new HashSet<>(A.subList(counter, counter + B)).size());
			counter++;
		}
		return count;
	}

	public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        if(B>A.size()) {
            return answer;
        }
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int k=B;
        for(int i=0; i<k;i++) {
            int elem = A.get(i);
            addToMap(map, elem);
        }
        answer.add(map.keySet().size());
        int lastIndexAllowed = A.size() - k;
        for(int i=1; i<=lastIndexAllowed;i++) {
            int departing = A.get(i-1);
            int arriving = A.get(i+k-1);
            removeFromMap(map, departing);
            addToMap(map, arriving);
            answer.add(map.keySet().size());
        }
        
        return answer;
    }
    private void addToMap(HashMap<Integer, Integer> map, int elem) {
        if(map.containsKey(elem)) {
            int oldValue = map.get(elem);
            map.put(elem, oldValue+1);
        }
        else {
            map.put(elem, 1);
        }
    }
    private void removeFromMap(HashMap<Integer, Integer> map, int elem) {
        int count = map.get(elem);
        if(count > 1) {
            map.put(elem, count-1);
        }
        else {
            map.remove(elem);
        }
    }
}
