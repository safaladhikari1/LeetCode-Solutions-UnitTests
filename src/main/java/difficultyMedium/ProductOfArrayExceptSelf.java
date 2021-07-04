import java.util.Arrays;

/**
 * @author Safal Adhikari
 * @version 1.0
 *
 * Product of Array Except Self
 * Problem Source: https://leetcode.com/problems/product-of-array-except-self/
 *
 * Algorithm:
 *
 * 1. The logic is, in the first for loop store the multiplication of the left side in result array
 *    in the second for loop, multiply the right side with the existing left side, to get the proper output result array
 *
 *    More explanation on:
 *
 *    https://leetcode.com/problems/product-of-array-except-self/discuss/65622/Simple-Java-solution-in-O(n)-without-extra-space/67603
 *
 *    https://leetcode.com/problems/product-of-array-except-self/discuss/65632/My-solution-beats-100-java-solutions
 *
 * 2. Store the array's length as new length
 *    Initialize result's array with new length
 *
 * 3. If the length is 0
 *    Return the result
 *
 * 4. Initialize the running product to 1
 *
 * 5. Go through the first loop,
 *
 *        Gets the multiplication values from left side and stores in result array
 *        result[i] = runningProduct;
 *        runningProduct *= nums[i];
 *
 * 6. Go through the second for loop from the end of array
 *
 *       Multiplies the left side and right side, and stores on result array
 *       result[i] *= runningProduct;
 *       runningProduct *= nums[i];
 *
 * 7. Return the result
 *
 * Time-Complexity: O(N), we loop through the array exactly 2 times.
 * Space-Complexity: O(1), if the output array does not count as extra space for space complexity analysis.
 *                   mentioned on the problem follow-up.
 *
 */
public class ProductOfArrayExceptSelf
{
    /**
     * main method that runs the program
     * @param args argument for the main method
     */
    public static void main(String[] args)
    {
        System.out.println(Arrays.toString(productExceptSelf(new int[] {1, 2, 3, 4})));

        System.out.println(Arrays.toString(productExceptSelf(new int[] {-1, 1, 0, -3, 3})));
    }

    /**
     * Given an integer array nums, returns an array such that answer[i] is equal to the product of all elements of
     * nums except nums[i]
     * @param nums integer array
     * @return result array
     */
    public static int[] productExceptSelf(int[] nums)
    {
        int length = nums.length;

        int[] result = new int[length];

        if(length == 0)
        {
            return result;
        }

        int runningProduct = 1;

        for(int i=0; i < length; i++)
        {
            result[i] = runningProduct;
            runningProduct *= nums[i];
        }

        runningProduct = 1;

        for(int i = length - 1; i >= 0; i--)
        {
            result[i] *= runningProduct;
            runningProduct *= nums[i];
        }

        return result;

    }

    // Bruteforce O(N^2) Solution
    /*
    public static int[] productExceptSelf(int[] nums)
    {
        int[] answer = new int[nums.length];

        int product = 1;

        for(int i=0; i < nums.length; i++)
        {
            for(int j=0; j < nums.length; j++)
            {
                if(i == j)
                {
                    continue;
                }
                else
                {
                    product *= nums[j];
                }
            }
            answer[i] = product;
            product = 1;
        }

        return answer;
    }
    */
}
