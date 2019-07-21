package download.dsalgo.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.SortedMap;
import java.util.Stack;
import java.util.TreeMap;

/**
 * ou are given the following :
 * 
 * A positive number N Heights : A list of heights of N persons standing in a
 * queue Infronts : A list of numbers corresponding to each person (P) that
 * gives the number of persons who are taller than P and standing in front of P
 * You need to return list of actual order of persons’s height
 * 
 * Consider that heights will be unique
 * 
 * Example
 * 
 * Input : Heights: 5 3 2 6 1 4 InFronts: 0 1 2 0 3 2 Output : actual order is:
 * 5 3 2 1 6 4 So, you can see that for the person with height 5, there is no
 * one taller than him who is in front of him, and hence Infronts has 0 for him.
 * 
 * For person with height 3, there is 1 person ( Height : 5 ) in front of him
 * who is taller than him.
 * 
 * You can do similar inference for other people in the list.
 * 
 * @author kaussark
 *
 */
public class Problem172 {

	public static void main(String[] args) {
		Integer[] height = { 86, 77 };
		Integer[] inFronts = { 0, 1 };
		System.out.println(
				new Problem172().order(new ArrayList<>(Arrays.asList(height)),
						new ArrayList<>(Arrays.asList(inFronts))));
	}

	private static class HeightPos implements Comparable<HeightPos> {
		Integer height;
		Integer position;

		public HeightPos(int height, int position) {
			this.height = height;
			this.position = position;
		}

		public String toString() {
			return "H:" + height + "|Pos:" + position;
		}

		@Override
		public int compareTo(HeightPos o) {
			HeightPos object = (HeightPos) o;
			if (this.position.compareTo(object.position) < 0) {
				return -1;
			}

			if (this.position.compareTo(object.position) < 0) {
				return 1;
			}
			if (this.position.compareTo(object.position) == 0) {
				if (this.height < object.height) {
					return -1;
				}
			}
			return 0;
		}
	}

	public ArrayList<Integer> order(ArrayList<Integer> A,
			ArrayList<Integer> B) {

		// Create List of HeighPos
		List<HeightPos> heightPositionList = createHeightPosition(A, B);

		// Create a stack of heights from map
		Queue<Integer> heightStack = new LinkedList<>();
		for (HeightPos heightPos : heightPositionList) {
			heightStack.add(heightPos.height);
		}

		ArrayList<Integer> result = new ArrayList<>();
		while (!heightStack.isEmpty()) {
			result.add(heightStack.poll());
		}
		return result;
	}

	private List<HeightPos> createHeightPosition(ArrayList<Integer> heights,
			ArrayList<Integer> inFronts) {
		List<HeightPos> heightPos = new ArrayList<>();
		for (int i = 0; i < heights.size(); i++) {
			heightPos.add(new HeightPos(heights.get(i), inFronts.get(i)));
		}
		Collections.sort(heightPos);
		return heightPos;
	}

	private SortedMap<Integer, List<Integer>> createPosVsHeightMap(
			ArrayList<Integer> heights, ArrayList<Integer> positions) {
		SortedMap<Integer, List<Integer>> positionVsHeight = new TreeMap<>();

		for (int i = 0; i < heights.size(); i++) {
			List<Integer> posHeights = positionVsHeight.get(positions.get(i));
			if (posHeights == null) {
				posHeights = new ArrayList<>();
				posHeights.add(heights.get(i));
				positionVsHeight.put(positions.get(i), posHeights);
			} else {
				positionVsHeight.get(positions.get(i)).add(heights.get(i));
			}
		}

		return positionVsHeight;
	}
}
