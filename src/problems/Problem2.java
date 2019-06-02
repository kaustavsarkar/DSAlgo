package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

//Pythagorean Triplet in an array
public class Problem2 {

    public static void main(String[] args) {
        int arr[] = { 3, 1, 4, 6, 5 };
        Problem2 problem = new Problem2();
        List<int[]> squares =  problem.getSquares(arr);
        
        squares.forEach(sq -> {
            System.out.println(Arrays.toString(sq));
        });
        
    }

    public List<int[]> getSquares(int[] arr) {
        int length = arr.length;
        Set<Integer> intSet = getSqSet(arr);
        List<int[]> sqSets = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            for(int j=0; j< length; j++) {
                if(intSet.contains(getSquareSum(arr[i], arr[j]))) {
                    sqSets.add(new  int[]{arr[i],arr[j],getSquareSum(arr[i], arr[j])});
                }
            }
        }
        return sqSets;

    }

    public Set<Integer> getSqSet(int[] arr) {
        List<Integer> ints = Arrays
                .stream(arr)
                .boxed()
                .map(a -> a * a)
                .collect(Collectors.toList());
        Set<Integer> intSet = new HashSet<>(ints);
        return intSet;

    }

    private int getSquareSum(int a, int b) {
        return (a * a) + (b * b);
    }
}
