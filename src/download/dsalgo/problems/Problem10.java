package download.dsalgo.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * For example:
 * 
 * Given [1,3],[2,6],[8,10],[15,18],
 * 
 * return [1,6],[8,10],[15,18].
 * 
 * Make sure the returned intervals are sorted.
 * 
 * @author kaussark
 *
 */
public class Problem10 {
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
		// [1,3],[2,6],[8,10],[15,18] | [(1 , 6), (8 , 10), (15 , 18)]
		// 2 [17,19] [16,18] | [(16 , 19)]
		// 4 (3,7) (2,9) (8,19) (16,18) | [(2 , 19)]
		// 4 (3,7) (2,9) (8,16) (16,18) | (2, 18)
		// 3 (3,7) (2,9) (8,10) | [(2 , 10)]
		// 3 (3,7) (2,6) (8,10) | [(2 , 7), (8 , 10)]
		// 3 (3,1) (2,6) (8,10)
		// 3 (1,7) (2,6) (8,10) | [(1 , 7), (8 , 10)]
		// 4 (3,10) (1,6) (1,10) (3,9)

		// A : [(4,100), (48,94), (16,21), (58,71), (36, 53), (49, 68), (18,
		// 42),
		// (37, 90), (68, 75), (6, 57), (25, 78), (58, 79), (18, 29), (69, 94),
		// (5, 31), (10, 87), (21, 35), (1, 32), (7, 24), (17, 85), (30, 95),
		// (5, 63), (1, 17), (67, 100), (53, 55), (30, 63), (7, 76), (33, 51),
		// (62, 68), (78, 83), (12, 24), (31, 73), (64, 74), (33, 40), (51, 63),
		// (17, 31), (14, 29), (9, 15), (39, 70), (13, 67), (27, 100), (10, 71),
		// (18, 47), (48, 79), (70, 73), (44, 59), (68, 78), (24, 67), (32, 70),
		// (29, 94), (45, 90), (10, 76), (12, 28), (31, 78), (9, 44), (29, 83),
		// (21, 35), (46, 93), (66, 83), (21, 72), (29, 37), (6, 11), (56, 87),
		// (10, 26), (11, 12), (15, 88), (3, 13), (56, 70), (40, 73), (25, 62),
		// (63, 73), (47, 74), (8, 36)]

		// A : [ (32, 75), (18, 36), (11, 77), (67, 70), (27, 89), (19, 21), (4,
		// 66), (5, 55), (73, 99), (46, 70), (13, 94), (36, 94), (21, 22), (86,
		// 94), (33, 66), (81, 97), (16, 37), (89, 100), (27, 79), (18, 80),
		// (40, 48), (42, 48), (29, 49), (38, 53), (64, 80), (27, 91), (19, 87),
		// (6, 66), (19, 53), (57, 98), (20, 48), (19, 38), (46, 62), (19, 99),
		// (11, 69), (61, 88), (84, 95), (37, 79), (44, 65), (5, 15), (33, 52),
		// (27, 58), (18, 92), (14, 42), (60, 70), (36, 39), (6, 42), (26, 92),
		// (8, 14), (61, 65), (10, 37), (3, 89), (44, 67), (48, 89), (1, 47),
		// (41, 78), (39, 98), (31, 70), (69, 93), (5, 26), (21, 61), (22, 67),
		// (47, 86), (66, 70), (60, 85), (6, 26), (56, 82), (1, 5), (33, 56),
		// (53, 72), (15, 43), (86, 99), (20, 79), (10, 53), (50, 58), (42, 52),
		// (40, 78), (9, 29) ]
		Problem10 problem = new Problem10();
		ArrayList<Interval> merged = null;
		ArrayList<Interval> intervals = null;

		intervals = new ArrayList<>();
		intervals.add(problem.new Interval(3, 4));
		intervals.add(problem.new Interval(5, 6));
		 merged = problem.merge(intervals);
		System.out.println(merged);

		intervals = new ArrayList<>();
		intervals.add(problem.new Interval(3, 5));
		intervals.add(problem.new Interval(5, 6));
		 merged = problem.merge(intervals);
		System.out.println(merged);

		intervals = new ArrayList<>();
		intervals.add(problem.new Interval(2, 4));
		intervals.add(problem.new Interval(3, 5));
	merged = problem.merge(intervals);
		System.out.println(merged);

		intervals = new ArrayList<>();
		intervals.add(problem.new Interval(2, 6));
		intervals.add(problem.new Interval(3, 5));
		merged = problem.merge(intervals);
		System.out.println(merged);

		intervals = new ArrayList<>();
		intervals.add(problem.new Interval(2, 2));
		intervals.add(problem.new Interval(3, 5));
		merged = problem.merge(intervals);
		System.out.println(merged);

		intervals = new ArrayList<>();
		intervals.add(problem.new Interval(1, 5));
		intervals.add(problem.new Interval(5, 6));
		intervals.add(problem.new Interval(2, 7));
		merged = problem.merge(intervals);
		System.out.println(merged);

	}

	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		if (intervals == null || intervals.isEmpty() || intervals.size() == 1) {
			return intervals;
		}

		ArrayList<Interval> mergedList = new ArrayList<>();
		Interval next = null;
		Interval current = null;
		int counter = 0;

		Collections.sort(intervals, (a, b) -> {
			return Integer.valueOf(a.start).compareTo(b.start);
		});

		mergedList.add(intervals.get(counter));
		while (counter < intervals.size()-1) {
			current = mergedList.get(mergedList.size()-1);
			next = intervals.get(++counter);

			if (isOverlap(current, next)) {
				current.end = Math.max(current.end, next.end);
			} else {
				mergedList.add(next);
			}

		}
		
		return mergedList;
	}

	public boolean isOverlap(Interval curr, Interval next) {
		return (curr.start <= next.start && curr.end >= next.end)
				|| (curr.end >= next.start && curr.end < next.end);
	}

	public ArrayList<Interval> _merge(ArrayList<Interval> intervals) {
		ArrayList<Interval> mergedIntervals = null;
		Stack<Interval> stack = new Stack<>();
		Interval node = null;
		int length = intervals.size();
		int counter = length - 1;
		Interval currentInterval = null;
		Interval prevInterval = null;

		if (intervals == null || intervals.isEmpty() || intervals.size() == 1) {
			return intervals;
		}

		while (counter > 0) {
			if (node != null) {
				currentInterval = stack.pop();
				node = null;
			} else {
				currentInterval = intervals.get(counter);
			}
			prevInterval = intervals.get(--counter);

			// determine end value
			if (prevInterval.end >= currentInterval.start
					&& prevInterval.end <= currentInterval.end) {
				node = new Interval(0, currentInterval.end);
			} else if (prevInterval.end > currentInterval.end) {
				node = new Interval(0, prevInterval.end);
			}
			// determine start value
			if (prevInterval.start <= currentInterval.start) {
				node = node != null ? node
						: new Interval(prevInterval.start, currentInterval.end);
				node.start = prevInterval.start;
			} else if (node != null
					&& currentInterval.start < prevInterval.start) {
				node.start = currentInterval.start;
			} else if (node == null) {
				stack.push(currentInterval);
			}

			if (node != null) {
				stack.push(node);
			}

		}

		mergedIntervals = new ArrayList<>(stack.size());

		while (!stack.isEmpty()) {
			mergedIntervals.add(stack.pop());
		}

		return mergedIntervals;
	}
}
