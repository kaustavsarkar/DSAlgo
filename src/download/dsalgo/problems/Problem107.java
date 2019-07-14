package download.dsalgo.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it is able to trap after raining.
 * 
 * Example :
 * 
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 * 
 * Rain water trapped: Example 1
 * 
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In
 * this case, 6 units of rain water (blue section) are being trapped.
 * 
 * @author kaussark
 *
 */
public class Problem107 {

	public static void main(String[] args) {
		Integer[] array = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };

		System.out.println(
				new Problem107()._trap(new ArrayList<>(Arrays.asList(array))));
	}

	public int _trap(final List<Integer> A) 
    {
        if(A == null || A.size() == 0)
        {
            return 0;
        }
        
        int n = A.size();
        
        int[] arr = new int[n];
        
        Integer[] temp = A.toArray(new Integer[n]);
        
        for(int i=0;i<n;i++)
        {
            arr[i] = temp[i];
        }
        
        int left[] = new int[n];
        
        int rigth[] = new int[n];
        
        int water = 0;
        
        left[0] = arr[0];
        for(int i=1;i<n;i++)
        {
            left[i] = Math.max(left[i-1],arr[i]);
        }
        
        rigth[n-1] = arr[n-1];
        for(int i=n-2;i>=0;i--)
        {
            rigth[i] = Math.max(rigth[i+1],arr[i]);
        }
        
        for(int i=0;i<n;i++)
        {
            water += Math.min(left[i],rigth[i])-arr[i];
        }
        
        return water;
    }
	public int trap(final List<Integer> A) {
		if (A.size() == 0 || A.size() == 1) {
			return 0;
		}
		Queue<Integer> walls = new LinkedList<>();
		int trap = 0;
		int sentinel = A.get(0);
		for (int i = 1; i < A.size(); i++) {
			int nextWall = A.get(i);
			if (walls.size() == 0 && sentinel <= nextWall) {
				sentinel = nextWall;
			} else if (sentinel > nextWall) {
				walls.add(nextWall);
			} else if (sentinel <= nextWall) {
				while (!walls.isEmpty()) {
					trap += sentinel - walls.poll();
				}

				sentinel = A.get(i);
			}

		}

		if (!walls.isEmpty()) {// There is no smaller thing for sentinel
			trap += trap(new ArrayList<>(walls));
		}

		return trap;
	}
}
