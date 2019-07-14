import java.util.HashSet;
import java.util.Set;

public class TwoSum {
	public static int[] findTwoSum(int[] list, int sum) {
		Set<Integer> set = new HashSet<>();
		int[] indices = new int[2];
		for (int num : list) {
			set.add(sum - num);
		}

		for (int i = 0; i < list.length; i++) {
			if(set.contains(list[i])) {
				indices[0] = i;
				break;
			}
		}

		for(int i=0; i < list.length; i++) {
			if(list[i]+list[indices[0]] == sum && i != indices[0]) {
				indices[1] = i;
				break;
			}
		}
		if(indices[0]==0 && indices[1] == 0 ) {
			return null;
		}
		return indices;
	}

	public static void main(String[] args) {
		int[] indices = findTwoSum(new int[] {3, 11, 5, 17, 5, 19}, 12);
		if (indices != null) {
			System.out.println(indices[0] + " " + indices[1]);
		}
	}
}