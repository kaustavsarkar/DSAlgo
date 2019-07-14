package download.dsalgo.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a sorted array of integers, find the starting and ending position of a
 * given target value.
 * 
 * Your algorithm’s runtime complexity must be in the order of O(log n).
 * 
 * If the target is not found in the array, return [-1, -1].
 * 
 * Example:
 * 
 * Given [5, 7, 7, 8, 8, 10]
 * 
 * and target valu
 * 
 * @author kaussark
 *
 */
public class Problem48 {

	public static void main(String[] args) {
		Problem48 problem = new Problem48();
		Integer[] array = { 5, 7, 7, 8, 8, 10 };
		List<Integer> input = new ArrayList<>(Arrays.asList(array));
		System.out.println(problem.searchRange(input, 6));
	}
	static int startIndex(final List<Integer> a,int b)
    {
        int start=0,end=a.size()-1,mid=0;
        while(start<=end)
        {
            mid=(start+end)/2;
            if(a.get(mid)==b &&((mid==0)||(a.get(mid-1)<b)))
            return mid;
            else if(b<=a.get(mid))
            end=mid-1;
            else
            start=mid+1;
        }
        return -1;
    }
    static int endIndex(final List<Integer> a,int b)
    {
        int start=0,end=a.size()-1,mid=0;
        while(start<=end)
        {
            mid=(start+end)/2;
            if(a.get(mid)==b &&((mid==a.size()-1)||(a.get(mid+1)>b)))
            return mid;
            else if(b>=a.get(mid))
            start=mid+1;
            else
            end=mid-1;
        }
        return -1;
    }
    public ArrayList<Integer> _searchRange(final List<Integer> a, int b) {
        int start=startIndex(a,b);
        int end=endIndex(a,b);
        ArrayList<Integer> ans=new ArrayList<>();
        ans.add(start);ans.add(end);
        return ans;
    }
	public ArrayList<Integer> searchRange(final List<Integer> a, int b) {
		ArrayList<Integer> indices = new ArrayList<>();
		if (a == null || a.isEmpty()) {
			indices.add(-1);
			indices.add(-1);
			return indices;
		}

		int index = binarySearch(a, b);
		int start = 0;
		int end = index;
		if (index < 0) {
			indices.add(index);
			indices.add(index);
			return indices;
		}

		while (start <= end) {
			int mid = start + ((end - start) / 2);
			if (a.get(mid) == a.get(index)) {
				end = mid-1;
			} else {
				start = mid+1;
			}
		}

		indices.add(start);
		start = index;
		end = a.size()-1;
		while (start <= end) {
			int mid = start + ((end - start) / 2);
			if (a.get(mid) == a.get(index)) {
				start = mid+1;
			} else {
				end = mid-1;
			}
		}
		indices.add(end);
		return indices;
	}

	public int binarySearch(List<Integer> a, int b) {
		int min = 0;
		int max = a.size();

		while (min <= max) {
			int mid = min + ((max - min) / 2);
			if (b > a.get(mid)) {
				min = mid + 1;
			} else if (b < a.get(mid)) {
				max = mid - 1;
			} else {
				return mid;
			}
		}

		return -1;
	}
}
