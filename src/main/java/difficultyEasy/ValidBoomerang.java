/**
 * @author Safal Adhikari
 * @version 1.0
 *
 * Valid Boomerang
 *
 * Problem Source: https://leetcode.com/problems/valid-boomerang/
 *
 * Algorithm:
 *
 * 1. Assuming three points are A, B and C
 * 2. Calculating the slope of A, B and C
 * 3. Instead of comparing the two slopes by division, we are cross multiplication to avoid the operation get divide by 0.
 *
 * Time-Complexity: O(1) if the rows of 2d array is fixed, otherwise O(N), where N is the length of 2d array
 * Space-Complexity: O(N)
 */
public class ValidBoomerang
{
    /**
     * main method to run the program
     * @param args for main
     */
    public static void main(String[] args)
    {
        System.out.println(isBoomerang(new int[][] { {1, 1}, {2, 3}, {3, 2} }));

        System.out.println(isBoomerang(new int[][] { {1, 1}, {2, 2}, {3, 3} }));
    }

    /**
     * Returns if all three points are all distinct and not in a straight line.
     * @param points 2d array of int points
     * @return boolean value
     */
    public static boolean isBoomerang(int[][] points)
    {
        //int yDiff = points[1][1] - points[0][1];
        //int xDiff = points[1][0] - points[0][0];

        //int slope = (yDiff / xDiff);

        for(int i=1; i < points.length - 1; i++)
        {
            if((points[i+1][1] - points[i][1]) * (points[1][0] - points[0][0]) == (points[1][1] - points[0][1]) *
                    (points[i+1][0] - points[i][0]))
            {
                return false;
            }
        }

        return true;
    }

}
