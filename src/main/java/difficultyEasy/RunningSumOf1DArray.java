package difficultyEasy;

import java.util.Arrays;

/**
 * Running Sum of 1d Array
 *
 * Problem Source: https://leetcode.com/problems/running-sum-of-1d-array/
 *
 * Algorithm:
 *
 * 1. Initialize sum to 0
 * 2. Loop through every int in the array
 *    Keep adding nums[i] += sum
 *    replace nums[i] = sum
 *    [1, 2, 3, 4] -> [1, 3, 6, 10]
 * 3. Return the array
 *
 * Time-Complexity: O(N), where N is the number of elements in the array
 * Space-Complexity: O(1)
 *
 */
public class RunningSumOf1DArray {

    public static void main(String[] args) {
        RunningSumOf1DArray solution = new RunningSumOf1DArray();
        System.out.println(Arrays.toString(solution.runningSum(new int[] {1, 2, 3, 4})));
    }

    public int[] runningSum(int[] nums) {
        int sum = 0;

        for(int i=0; i < nums.length; i++) {
            sum += nums[i];
            nums[i] = sum;
        }

        return nums;
    }

}
