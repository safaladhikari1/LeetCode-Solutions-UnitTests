package difficultyMedium;

import java.util.Arrays;

/**
 * Rotate Array
 *
 * Problem Source: https://leetcode.com/problems/rotate-array/
 *
 * Algorithm:
 *
 * 1. while k is greater than 0
 *      Store the last int of the array as temp
 *
 *      for loop
 *          Shift all the elements to the right, from index 1
 *      store temp in index 0
 *      decrement k
 *
 *  Time-Complexity: O(N * K), all the numbers are shifted by one step (O(N)), k times.
 *  Space-Complexity: O(1)
 *
 *  More efficient approaches: https://leetcode.com/problems/rotate-array/solution/
 *
 */
public class RotateArray {

    public void rotate(int[] nums, int k) {
        while(k > 0) {
            int temp = nums[nums.length - 1];
            for(int i = nums.length - 1; i >= 1; i--) {
                nums[i] = nums[i - 1];
            }
            nums[0] = temp;
            k--;
        }
    }

    public static void main(String[] args) {
        RotateArray solution = new RotateArray();
        int[] nums = new int[] {1, 2, 3, 4, 5, 6, 7};
        solution.rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }
}
