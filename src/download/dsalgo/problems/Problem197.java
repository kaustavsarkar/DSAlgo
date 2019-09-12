package download.dsalgo.problems;

import java.util.*;

/**
 * Given a grid of size m * n, lets assume you are starting at (1,1) and your goal is to reach (m,n). At any instance,
 * if you are on (x,y), you can either go to (x, y + 1) or (x + 1, y).
 * <p>
 * Now consider if some obstacles are added to the grids. How many unique paths would there be? An obstacle and empty
 * space is marked as 1 and 0 respectively in the grid.
 * <p>
 * Example : There is one obstacle in the middle of a 3x3 grid as illustrated below.
 * <p>
 * [ [0,0,0], [0,1,0], [0,0,0] ] The total number of unique paths is 2.
 * <p>
 * Note: m and n will be at most 100.
 *
 * @author kaussark
 */
public class Problem197 {

    int currPaths = 0;

    public static void main(String[] args) {
        int[][] input = {{0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {1, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {1, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 1}, {0, 0}, {0, 0}, {1, 0}, {0, 0}, {0, 0}, {0, 1}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 1}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {1, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}};
        System.out.println(new Problem197().uniquePathsWithObstacles(input));
    }

    public int uniquePathsWithObstacles(ArrayList<ArrayList<Integer>> A) {
        uniquePathsWithObstacles(A, 0, 0);
        return currPaths;
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0) {
            return 0;
        }

        int rowLength = obstacleGrid.length;
        int colLength = obstacleGrid[0].length;
        if (obstacleGrid[rowLength - 1][colLength - 1] == 1) {
            return 0;
        }
        if (obstacleGrid[0][0] != 1) {
            obstacleGrid[0][0] = 1;
        } else {
            return 0;
        }


        for (int col = 1; col < obstacleGrid[0].length; col++) {
            if (obstacleGrid[0][col] == 1) {
                obstacleGrid[0][col] = 0;
                break;
            } else {
                obstacleGrid[0][col] = 1;
            }

        }
        for (int row = 1; row < obstacleGrid.length; row++) {
            if (obstacleGrid[row][0] == 1) {
                obstacleGrid[row][0] = 0;
                break;
            } else {
                obstacleGrid[row][0] = 1;
            }
        }
        for (int row = 1; row < obstacleGrid.length; row++) {
            for (int col = 1; col < obstacleGrid[row].length; col++) {
                if (obstacleGrid[row][col] == 1) {
                    obstacleGrid[row][col] = 0;
                } else {
                    obstacleGrid[row][col] = obstacleGrid[row][col - 1] + obstacleGrid[row - 1][col];
                }
            }
        }
        return obstacleGrid[rowLength - 1][colLength - 1];
    }

    private void uniquePathsWithObstacles(ArrayList<ArrayList<Integer>> a,
                                          int row, int col) {
        if (row > a.size() || col > a.get(row).size()
                || a.get(row).get(col) == 1) {
            return;
        }

        if (row == a.size() - 1 && col == a.get(row).size() - 1) {
            currPaths++;
        }

        uniquePathsWithObstacles(a, row + 1, col);
        uniquePathsWithObstacles(a, row, col + 1);

    }
}
