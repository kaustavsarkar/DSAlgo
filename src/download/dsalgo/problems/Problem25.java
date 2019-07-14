package download.dsalgo.problems;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Implement the next permutation, which rearranges numbers into the numerically
 * next greater permutation of numbers.
 * 
 * If such arrangement is not possible, it must be rearranged as the lowest
 * possible order ie, sorted in an ascending order.
 * 
 * The replacement must be in-place, do not allocate extra memory.
 * 
 * Examples:
 * 
 * 1,2,3 → 1,3,2
 * 
 * 3,2,1 → 1,2,3
 * 
 * 1,1,5 → 1,5,1
 * 
 * 20, 50, 113 → 20, 113, 50 Inputs are in the left-hand column and its
 * corresponding outputs are in the right-hand column.
 * 
 * @author kaussark
 *
 */
public class Problem25 {

	public static void main(String[] args) {
		Integer[] array = { 444, 994, 508, 72, 125, 299, 181, 238, 354, 223,
				691, 249, 838, 890, 758, 675, 424, 199, 201, 788, 609, 582, 979,
				259, 901, 371, 766, 759, 983, 728, 220, 16, 158, 822, 515, 488,
				846, 321, 908, 469, 84, 460, 961, 285, 417, 142, 952, 626, 916,
				247, 116, 975, 202, 734, 128, 312, 499, 274, 213, 208, 472, 265,
				315, 335, 205, 784, 708, 681, 160, 448, 365, 165, 190, 693, 606,
				226, 351, 241, 526, 311, 164, 98, 422, 363, 103, 747, 507, 669,
				153, 856, 701, 319, 695, 52 };
		// { 300, 259, 359, 639, 268, 271, 565, 113, 322, 293,
		// 994, 357, 178, 986, 101, 70, 554, 119, 508, 671, 111, 120,
		// 169,
		// 505, 709, 206, 625, 933, 865, 536, 647, 150, 412, 481, 796,
		// 365,
		// 721, 334, 221, 339, 544, 136, 332, 672, 781, 317, 529, 729,
		// 874,
		// 983, 296, 973, 563, 244, 802, 104, 179, 556, 782, 315, 278,
		// 542,
		// 252, 369, 917, 233, 58, 245, 627, 833, 424, 444, 658, 373,
		// 859,
		// 985, 471, 846, 511, 521, 673, 20, 299, 476 };
		// { 20, 50, 113 };
		// {1,1,5};
		// { 3, 2, 1 };
		// { 1, 2, 3 };
		ArrayList<Integer> perm = new ArrayList<>(Arrays.asList(array));
		Problem25 problem = new Problem25();
		problem.nextPermutation(perm);

		System.out.println(perm);
	}

	public void nextPermutation(ArrayList<Integer> a) {
		int max = 0;
		int counter = a.size() - 1;

		while (counter >= 2) {
			// find max in latest 3 elements
			max = Math.max(Math.max(a.get(counter), a.get(counter - 1)),
					a.get(counter - 2));
			if (a.get(counter).compareTo(max) == 0) {
				a.add(counter - 1, max);
				a.remove(counter + 1);
				break;
			} else if (a.get(counter - 1).compareTo(max) == 0) {
				if (a.get(counter - 2) > a.get(counter)) {
					a.add(a.get(counter - 2));
					a.remove(counter - 2);
				} else {
					a.add(counter - 2, a.get(counter));
					a.remove(counter + 1);
				}
				break;

			} else if (a.get(counter - 2).compareTo(max) == 0) {
				if (a.get(counter) > a.get(counter - 1)) {
					a.add(counter - 1, a.get(counter));
					a.remove(counter + 1);
					break;
				} else {
					a.add(counter - 2, a.get(counter));
					a.remove(counter + 1);
					a.add(counter - 1, a.get(counter));
					a.remove(counter + 1);
				}
			}
			counter -= 2;

		}
	}
}
