/**
 * Count Negative Numbers in a Sorted Matrix
 *
 * Problem Source: https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/
 *
 * Algorithm:
 *
 * Approach 1 (Brute Force Solution)
 *
 * 1. Instantiate Count
 * 2. Loop through 2D array, if it is less than 0, increment count
 * 3. Return count.
 *
 * Time-Complexity: O(M * N), M and N are rows and columns of the input 2d array respectively.
 * Space-Complexity: O(1)
 *
 * Approach 2: Using Binary Search
 *
 * Explained in the post below:
 *
 * https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/discuss/510249/JavaPython-3-2-similar-O(m-%2B-n)-codes-w-brief-explanation-and-analysis.
 *
 * https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/discuss/510247/Java-O(M-%2B-N)-Solution
 *
 * https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/discuss/512165/Java-binary-search-beats-100-explained
 *
 */
public class CountNegativeNumbersInSortedMatrix {
    public static void main(String[] args) {
        int[][] testArray = new int[][] { {4, 3, 2, -1}, {3, 2, 1, -1}, {1, 1, -1, -2}, {-1, -1, -2, -3}};

        System.out.println(countNegatives(testArray));
    }

    // Approach 1
    public static int countNegatives(int[][] grid) {
        int count = 0;

        for(int i=0; i < grid.length; i++) {
            for (int j=0; j < grid[i].length; j++) {
                if(grid[i][j] < 0) {
                    count++;
                }
            }
        }

        return count;
    }
}
