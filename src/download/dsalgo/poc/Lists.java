package download.dsalgo.poc;

import java.util.ArrayList;
import java.util.List;

public class Lists {

	public static void main(String[] args) {
		List<Integer> nums = new ArrayList<>();
		
		nums.add(1);
		nums.add(null);
		nums.remove(1);
		System.out.println(nums);
		System.out.println(nums.size());
		nums.add(1, 2);
		System.out.println(nums);
	}
}
