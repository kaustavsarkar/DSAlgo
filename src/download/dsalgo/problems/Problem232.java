package download.dsalgo.problems;

import java.util.*;

/**
 * Given two integer arrays A and B of size N. There are N gas stations along a
 * circular route, where the amount of gas at station i is A[i].
 * 
 * You have a car with an unlimited gas tank and it costs B[i] of gas to travel
 * from station i to its next station (i+1). You begin the journey with an empty
 * tank at one of the gas stations.
 * 
 * Return the minimum starting gas station’s index if you can travel around the
 * circuit once, otherwise return -1.
 * 
 * You can only travel in one direction. i to i+1, i+2, … n-1, 0, 1, 2..
 * Completing the circuit means starting at i and ending up at i again.
 * 
 * 
 * 
 * Input Format
 * 
 * The first argument given is the integer array A. The second argument given is
 * the integer array B. Output Format
 * 
 * Return the minimum starting gas station's index if you can travel around the
 * circuit once, otherwise return -1. For Example
 * 
 * Input 1: A = [1, 2] B = [2, 1] Output 1: 1 Explanation 1: If you start from
 * index 0, you can fill in A[0] = 1 amount of gas. Now your tank has 1 unit of
 * gas. But you need B[0] = 2 gas to travel to station 1. If you start from
 * index 1, you can fill in A[1] = 2 amount of gas. Now your tank has 2 units of
 * gas. You need B[1] = 1 gas to get to station 0. So, you travel to station 0
 * and still have 1 unit of gas left over. You fill in A[0] = 1 unit of
 * additional gas, making your current gas = 2. It costs you B[0] = 2 to get to
 * station 1, which you do and complete the circuit. Seen this question in a
 * real interview beforeYesNo Share this NotesAll Notes
 * 
 * @author kaussark
 *
 */
public class Problem232 {

	public static void main(String[] args) {
		Integer[] station = { 959, 329, 987, 951, 942, 410, 282, 376, 581, 507,
				546, 299, 564, 114, 474, 163, 953, 481, 337, 395, 679, 21, 335,
				846, 878, 961, 663, 413, 610, 937, 32, 831, 239, 899, 659, 718,
				738, 7, 209 };
		// {0};
		Integer[] gasSpent = { 862, 783, 134, 441, 177, 416, 329, 43, 997, 920,
				289, 117, 573, 672, 574, 797, 512, 887, 571, 657, 420, 686, 411,
				817, 185, 326, 891, 122, 496, 905, 910, 810, 226, 462, 759, 637,
				517, 237, 884 };
		// { 0 };
		System.out.println(new Problem232().canCompleteCircuit(
				Arrays.asList(station), Arrays.asList(gasSpent)));
	}
	public int canCompleteCircuit(final List<Integer> gas, final List<Integer> cost) {
	    int currentFuel = 0;
	    int remaining = 0;
	    int total = 0;
	    int start = 0;
	    for(int i = 0; i < gas.size(); i++){
	        remaining = gas.get(i) - cost.get(i);
	        if(currentFuel >= 0)
	            currentFuel += remaining;
	        else{
	            currentFuel = remaining;
	            start = i;
	        }
	        total += remaining;
	    }
	    return total >= 0 ? start : -1;
	}
	public int _canCompleteCircuit(final List<Integer> A,
			final List<Integer> B) {
		// find start
		int currentVolume = Integer.MIN_VALUE;
		int startStation = 0;
		for (int station = 0; station < A.size(); station++) {
			int vol = A.get(station);
			if (station == A.size() - 1) {
				if (vol >= B.get(0)) {
					currentVolume = vol;
					startStation = station;
					break;
				}
			} else if (vol >= B.get(station + 1)) {
				currentVolume = vol;
				startStation = station;
				break;
			}
		}

		if (currentVolume == Integer.MIN_VALUE) {
			return -1;
		} else {
			return startStation;
		}

	}
}
