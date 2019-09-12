package download.dsalgo.green.dp;

import java.util.Arrays;

/**
 * @author: Kaustav Sarkar
 * @created: 9/9/2019
 */
public class MinOperations {
    public static void main(String[] agrs) {
        String string1 = "hrrdsycqhkle";
        String string2 = "ewhxtembaqwqwpqhsuebnvfgvjwdvjjafqzzxlcxdzncqgjlapopkvxfgvicetcmkbljop";

        System.out.println(new MinOperations().operations(string1, string2, string1.length(), string2.length()));
    }
    private int operations(String string1, String string2, int length1, int length2) {
        if(string1 == null || string1.isEmpty()) {
            return string2.length();
        }
        if(string2 == null || string2.isEmpty()) {
            return string1.length();
        }

        int[][] optMemo = new int[length1 + 1][length2 + 1];
        for(int index = 0; index <= length2; index++) {
            optMemo[0][index] = index;
        }

        for(int row = 1; row <= length1; row++) {
            optMemo[row][0] = row;
            for(int col = 1; col <= length2; col++) {
                if(string1.charAt(row - 1)==string2.charAt(col - 1) ) {
                    optMemo[row][col] = optMemo[row - 1][col - 1];
                } else {
                    optMemo[row][col] = 1 + Math.min(optMemo[row - 1][col - 1], Math.min(optMemo[row - 1][col],
                            optMemo[row][col - 1]));
                }
            }
        }
        for(int[] row : optMemo) {
            System.out.println(Arrays.toString(row));
        }
        return optMemo[length1][length2];
    }
}
