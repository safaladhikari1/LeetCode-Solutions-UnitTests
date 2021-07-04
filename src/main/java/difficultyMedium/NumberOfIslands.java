/**
 * Number of Islands
 * Problem Source: https://leetcode.com/problems/number-of-islands/
 *
 * Algorithm:
 *
 * 1. The island can only be formed if we have connected '1' horizontally and vertically. Not diagonally
 *
 * 2. Loop through the 2D Array,
 *    if arr[i][j] is '1'
 *      go the sink operation
 *      count++
 * 3. Return count
 *
 * 4. On Sink operation
 *
 *    We are passing 2d array, i an j
 *
 *    if i and j are less than array edges, this means if we have negative row and negative column
 *      return
 *
 *    if i and j are more than array edges, this means if row goes out of bound or column goes out of bound
 *
 *    For example on the testArray1:
 *
 *    row's length is 4, i >= array length (row length), return. Cannot be equal because we start our row with 0 indices.
 *                                                               Same with Column as well.
 *    column's length is 5, j >= array[i] length (column length), return
 *
 *    if we have already marked array[i][j] as visited,
 *      return
 *
 *    Otherwise mark array[i][j] as visited, by marking it as water 'O' i.e. sink it. So next time we can just return it
 *    if we see that spot on our recursion.
 *
 * 5. Then recursively check adjacent lands vertically and horizontally
 *
 *    Go down, sink (array, i+1, j)
 *
 *    Go up, sink (array, i-1, j)
 *
 *    Go right, sink (array, i, j+1)
 *
 *    Go left, sink (array, i, j-1)
 *
 *
 * 6. It is also best explained on:
 *
 *    https://leetcode.com/problems/number-of-islands/discuss/56359/Very-concise-Java-AC-solution/187789
 *
 * ------
 *
 * Time-Complexity: O(M * N), where M is the rows of the 2d array, N is the columns of the 2d array.
 * Space-Complexity: O(1)
 *
 */
public class NumberOfIslands {
    public static void main(String[] args) {
        char[][] testArray1 = new char[][] {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        System.out.println(numIslands(testArray1));
    }

    public static int numIslands(char[][] grid) {
        int count = 0;

        for(int i=0; i < grid.length; i++) {
            for(int j=0; j < grid[i].length; j++) {
                if(grid[i][j] == '1') {
                    sink(grid, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    public static void sink(char[][] grid, int i, int j) {
        if(i < 0 || j < 0) {
            return;
        }

        if(i >= grid.length || j >= grid[i].length) {
            return;
        }

        if(grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';

        sink(grid, i + 1, j);
        sink(grid, i - 1, j);
        sink(grid, i, j + 1);
        sink(grid, i , j - 1);
    }
}









