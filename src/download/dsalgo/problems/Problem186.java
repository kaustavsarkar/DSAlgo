package download.dsalgo.problems;

import java.util.*;

public class Problem186 {

	public static void main(String[] args) {
		int[] array= {-1, 0, 1, 2, -1, -4};
		System.out.println(new Problem186().threeSum(array));
	}
	public List<List<Integer>> threeSum(int[] nums) {
        Map<Integer,Integer> valueIndexMap = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length < 3) {
            return result;
        }
        //Sort my array
        Arrays.sort(nums);
        //fill map
        for(int index = 0; index < nums.length; index++) {
            valueIndexMap.put(nums[index],index);
        }
        //compute sums and check in map
        for(int first = 0; first < nums.length-1; first++) {
            for(int second = first+1; second < nums.length; second++) {
                int sum = -(nums[first]+nums[second]);
                if(valueIndexMap.containsKey(sum) && valueIndexMap.get(sum) > second) {
                    result.add(Arrays.asList(nums[first],nums[second],sum));
                    second = valueIndexMap.get(nums[second]);
                }
                first = valueIndexMap.get(nums[first]);
            }
        }
        return result;
    }
}
