package download.dsalgo.problems;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the
 * intervals (merge if necessary).
 * 
 * You may assume that the intervals were initially sorted according to their
 * start times.
 * 
 * Example 1:
 * 
 * Given intervals [1,3],[6,9] insert and merge [2,5] would result in
 * [1,5],[6,9].
 * 
 * Example 2:
 * 
 * Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] would result
 * in [1,2],[3,10],[12,16].
 * 
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 * 
 * @author kaussark
 *
 */
public class Problem9 {
	public class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}

		public String toString() {
			return "(" + start + " , " + end + ")";
		}
	}

	public static void main(String[] args) {
		Problem9 problem = new Problem9();
		// [1,3],[6,9] | [2,5] = [1,5],[6,9]

		
		  Interval interval1 = problem.new Interval(1, 3); Interval interval2 =
		  problem.new Interval(6, 9); Interval newInterval = problem.new
		  Interval(2, 5);
		  
		  ArrayList<Interval> intervals = new ArrayList<>();
		  intervals.add(interval1); intervals.add(interval2);
		 

		// [1,2],[3,5],[6,7],[8,10],[12,16] | [4,9] = [1,2],[3,10],[12,16]

		
		  /*Interval interval1 = problem.new Interval(1, 2); Interval interval2 =
		  problem.new Interval(3, 5); Interval interval3 = problem.new
		  Interval(6, 7); Interval interval4 = problem.new Interval(8, 10);
		  Interval interval5 = problem.new Interval(12, 16); Interval
		  newInterval = problem.new Interval(4, 9);
		  
		  ArrayList<Interval> intervals = new ArrayList<>();
		  intervals.add(interval1); intervals.add(interval2);
		  intervals.add(interval3); intervals.add(interval4);
		  intervals.add(interval5);*/
		 

		
		  /*Interval newInterval = problem.new Interval(4, 9);
		  
		  ArrayList<Interval> intervals = new ArrayList<>();*/
		 

		// A : [ (31935139, 38366404), (54099301, 76986474), (87248431,
		// 94675146) ]
		// B : (43262807, 68844111)

		
		 /* Interval interval1 = problem.new Interval(31935139, 38366404);
		  Interval interval2 = problem.new Interval(54099301, 76986474);
		  Interval interval3 = problem.new Interval(87248431, 94675146);
		  Interval newInterval = problem.new Interval(43262807, 68844111);
		  
		  ArrayList<Interval> intervals = new ArrayList<>();
		  intervals.add(interval1); intervals.add(interval2);
		  intervals.add(interval3);*/
		 

		// A : [ (1, 2), (8, 10) ]
		// B : (3, 6)
		
		  /*Interval interval1 = problem.new Interval(1, 2); 
		  Interval interval2 = problem.new Interval(8, 10); 
		  Interval newInterval = problem.new Interval(3, 6);
		  
		  ArrayList<Interval> intervals = new ArrayList<>();
		  intervals.add(interval1); intervals.add(interval2);*/
		 

		// A : [ (1, 2), (3, 6) ]
		// B : (10, 8)
		/*Interval interval1 = problem.new Interval(1, 2);
		Interval interval2 = problem.new Interval(3, 6);
		Interval newInterval = problem.new Interval(10, 8);

		ArrayList<Interval> intervals = new ArrayList<>();
		intervals.add(interval1);
		intervals.add(interval2);*/

		ArrayList<Interval> newIntervals = problem.insert(intervals,
				newInterval);
		System.out.println(newIntervals);
	}

	public ArrayList<Interval> insert(ArrayList<Interval> intervals,
			Interval newInterval) {
		ArrayList<Interval> newIntervals = null;
		int leftInterval = -1;
		int length = intervals.size();
		int rightInterval = length;
		int counter = 0;
		Interval node = null;

		// Sort newInterval
		if (newInterval.start > newInterval.end) {
			swapInterval(newInterval);
		}

		// If intervals is null return newInterval
		if (intervals == null || intervals.isEmpty()) {
			newIntervals = new ArrayList<>();
			newIntervals.add(newInterval);
			return newIntervals;
		}

		// finding intervals
		while (counter < length && leftInterval <= rightInterval) {

			// cehck for left interval
			if (intervals.get(counter).start <= newInterval.start) {
				leftInterval = counter;
				if (intervals.get(counter).end < newInterval.start) {
					leftInterval++;
				}
			}

			// check for right interval
			if (intervals.get(length - counter - 1).end >= newInterval.end) {
				rightInterval = length - counter - 1;
				if (intervals
						.get(length - counter - 1).start >= newInterval.end) {
					rightInterval--;
				}
			}

			counter++;
		}

		// Add in between
		if (rightInterval < leftInterval) {
			newIntervals = new ArrayList<>(length + 1);
			node = new Interval(newInterval.start, newInterval.end);
			newIntervals.addAll(intervals.subList(0, rightInterval + 1));
			newIntervals.add(node);
			newIntervals.addAll(intervals.subList(leftInterval, length));
			return newIntervals;
		}

		// Preceding node
		if (rightInterval < 0) {
			newIntervals = new ArrayList<>(length + 1);
			node = new Interval(newInterval.start, newInterval.end);
			newIntervals.add(node);
			newIntervals.addAll(intervals);
			return newIntervals;
		}

		// Succeeding node
		if (leftInterval == length) {
			newIntervals = new ArrayList<>(length + 1);
			node = new Interval(newInterval.start, newInterval.end);
			newIntervals.addAll(intervals);
			newIntervals.add(node);
			return newIntervals;
		}

		newIntervals = new ArrayList<>();
		// Covering all intervals
		if (leftInterval < 0) {
			leftInterval = 0;
		}
		if (rightInterval == length) {
			rightInterval = length - 1;
		}
		if(intervals.get(leftInterval).start > newInterval.start) {
			intervals.get(leftInterval).start = newInterval.start;
		}
		
		if(intervals.get(rightInterval).end < newInterval.end) {
			intervals.get(rightInterval).end = newInterval.end;
		}
		
		
		//merge left intervals
		counter =0;
			//merge left of leftinterval
		while(counter <= leftInterval) {
			newIntervals.add(intervals.get(counter));
			counter++;
		}
		
		//change end of left interval node
		newIntervals.get(leftInterval).end = intervals.get(rightInterval).end;
		
		counter = rightInterval+1;
		while(counter < length) {
			newIntervals.add(intervals.get(counter));
			counter++;
		}
		
		return newIntervals;
	}

	private void swapInterval(Interval newInterval) {
		newInterval.start = newInterval.start + newInterval.end;
		newInterval.end = newInterval.start - newInterval.end;
		newInterval.start = newInterval.start - newInterval.end;
	}

	public ArrayList<Interval> _insert(ArrayList<Interval> intervals,
			Interval newInterval) {

		ArrayList<Interval> mergedIntervals = null;

		if (intervals == null || intervals.isEmpty()) {
			mergedIntervals = new ArrayList<>();
			mergedIntervals.add(newInterval);
			return mergedIntervals;
		}

		Interval currentInterval = null;
		int leftInterval = -1;
		int rightInterval = intervals.size();

		// Find where start lies for newInterval
		for (int currInterval = 0; currInterval < intervals
				.size(); currInterval++) {
			currentInterval = intervals.get(currInterval);
			if (currentInterval.start <= newInterval.start
					&& currentInterval.end >= newInterval.start) {
				leftInterval = currInterval;
			}
			// Find where end lies of newInterval
			if (currentInterval.start <= newInterval.end
					&& currentInterval.end >= newInterval.end) {
				rightInterval = currInterval;
			}

		}

		// If there is a case where the interval lies in existing intervals
		if (leftInterval == rightInterval) {
			if (intervals.get(leftInterval).end < newInterval.end) {
				intervals.get(leftInterval).end = newInterval.end;
			}
			return intervals;
		}
		mergedIntervals = new ArrayList<>();

		if (leftInterval == -1 && rightInterval == intervals.size()) {
			if (intervals.get(0).start > newInterval.end) {
				mergedIntervals.add(newInterval);
			}

			mergedIntervals.addAll(intervals);

			if (intervals.get(intervals.size() - 1).end < newInterval.start) {
				mergedIntervals.add(newInterval);
			}
			return mergedIntervals;
		}

		// if start for new interval does not fit in any intervals
		if (leftInterval == -1) {
			intervals.get(rightInterval).start = newInterval.start;
			leftInterval = rightInterval;
		}
		// if end for new interval does not fit in any intervals
		if (rightInterval == intervals.size()) {
			intervals.get(leftInterval).end = newInterval.end;
			rightInterval = leftInterval;
		}

		// Merge previous digits
		int counter = 0;
		while (counter < leftInterval) {
			mergedIntervals.add(intervals.get(counter));
			counter++;
		}

		mergedIntervals.add(new Interval(intervals.get(leftInterval).start,
				intervals.get(rightInterval).end));
		counter = rightInterval + 1;
		while (counter < intervals.size()) {
			mergedIntervals.add(intervals.get(counter));
			counter++;
		}

		return mergedIntervals;
	}
}
