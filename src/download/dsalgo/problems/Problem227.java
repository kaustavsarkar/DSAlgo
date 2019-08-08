package download.dsalgo.problems;

import java.util.*;

/**
 * N light bulbs are connected by a wire. Each bulb has a switch associated with
 * it, however due to faulty wiring, a switch also changes the state of all the
 * bulbs to the right of current bulb. Given an initial state of all bulbs, find
 * the minimum number of switches you have to press to turn on all the bulbs.
 * You can press the same switch multiple times.
 * 
 * Note : 0 represents the bulb is off and 1 represents the bulb is on.
 * 
 * Example:
 * 
 * Input : [0 1 0 1] Return : 4
 * 
 * Explanation : press switch 0 : [1 0 1 0] press switch 1 : [1 1 0 1] press
 * switch 2 : [1 1 1 0] press switch 3 : [1 1 1 1]
 * 
 * @author kaussark
 *
 */
public class Problem227 {

	public static void main(String[] args) {
		Integer[] state = {1, 1, 0, 0, 1, 1, 0, 0, 1};
		System.out.println(new Problem227().bulbs(new ArrayList<>(Arrays.asList(state))));
	}
	public int bulbs(ArrayList<Integer> A) {
		if(A == null || A.isEmpty()) {
			return 0;
		}
		
		int steps = 0;
		int xor = 0;
		
		for(int index = 0; index < A.size(); index++) {
			if((A.get(index)^xor) == 0) {
				steps++;
				if(xor == 1) {
					xor = 0;
				} else {
					xor = 1;
				}
			}
		}
		return steps;
    }
}
