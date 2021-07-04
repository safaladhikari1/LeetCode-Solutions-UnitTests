/**
 *
 * @author Safal Adhikari
 * @version 1.0
 *
 * Toeplitz Matrix
 *
 * Problem Source: https://leetcode.com/problems/toeplitz-matrix/
 *
 * Algorithm:
 *
 * 1. Based on checking whether each value is equal to the value of it's top-left neighbor
 *
 * 2. Let's say we have an input 2d array
 *
 *      1       2       3       4
 *      5       1       2       3
 *      9       5       1       2
 *
 * 3. We can just skip the first row and first column, then check the inner values, if it's equal to the top-left corner
 *    value
 *
 * -------
 *
 * Time-Complexity: O (M * N), where M is the length of the rows of the array, N is the length of the columns
 * Space-Complexity: O(1)
 *
 * Follow-up References:
 *
 * https://leetcode.com/problems/toeplitz-matrix/discuss/271388/Java-Solution-for-Follow-Up-1-and-2
 * https://leetcode.com/problems/toeplitz-matrix/discuss/147808/Java-Answers-to-the-follow-ups-(load-partial-rowcolumn-one-time)-the-3rd-one-beats-98
 */
public class ToeplitzMatrix
{
    public static void main(String[] args)
    {
        int[][] testMatrix1 = new int[][] { {1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}};

        int[][] testMatrix2 = new int[][] { {1, 2}, {2, 2}};

        System.out.println(isToeplitzMatrix(testMatrix2));
    }

    /** Returns whether a matrix is Toeplitz or not
     *
     * @param matrix m * n 2d array
     * @return true or false
     */
    public static boolean isToeplitzMatrix(int[][] matrix)
    {
        for(int row=1; row < matrix.length; row++)
        {
            for(int column=1; column < matrix[row].length; column++)
            {
                int topLeft = matrix[row - 1][column - 1];

                if(topLeft != matrix[row][column])
                {
                    return false;
                }
            }
        }

        return true;
    }
}
