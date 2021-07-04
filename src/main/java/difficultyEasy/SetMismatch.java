import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Set Mismatch
 *
 * Problem Source: https://leetcode.com/problems/set-mismatch/
 *
 * Algorithm:
 *
 * 1. Initialize duplicate and missing number to 0 and 0
 *
 * 2. Make a Map of Integer and Integer
 *    Loop through the nums array
 *    Keep a count of each element of the nums array
 *
 *    For example:
 *
 *    nums = [1, 2, 2, 4]
 *
 *    will be: (1, 1), (2, 2), (4, 1) in the map
 *
 * 3. Then loop through the elements from 1 to the length of the array inclusive, because
 *    per problem description, set of integers contain numbers from 1 to n.
 *
 *    if map contains key i
 *      Then check if the map.get(i) is 2
 *          If it is, we have duplicate
 *    Else, that means if our map does not have i
 *      That's the missing number. On our map we don't have 3.
 *
 * 4. At the end, return the array of duplicate and missing.
 *
 * Time-Complexity: O(N), where N is the number of elements in the array
 * Space-Complexity: O(N), where our map takes N space for each elements in the array.
 */
public class SetMismatch {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findErrorNums(new int[] {1, 2, 2, 4})));

        System.out.println(Arrays.toString(findErrorNums(new int[] {1, 1})));
    }

    public static int[] findErrorNums(int[] nums) {
        int duplicate = 0;
        int missing = 0;

        Map<Integer, Integer> numsMap = new HashMap<>();

        for(int i=0; i < nums.length; i++) {
            numsMap.put(nums[i], numsMap.getOrDefault(nums[i], 0) + 1);
        }

        for(int i=1; i <= nums.length; i++) {
            if(numsMap.containsKey(i)) {
                if(numsMap.get(i) == 2) {
                    duplicate = i;
                }
            } else {
                missing = i;
            }
        }

        return new int[] {duplicate, missing};
    }

    // Bruteforce Solution does not work
    /*
    public static int[] findErrorNums(int[] nums) {
        int i = 0;

        for(int j=nums.length - 1; j >= 1; j--) {
            i = j - 1;
            int back = nums[j];
            int front = nums[i];

            if(front == back) {
                return new int[] {nums[i], nums[i] + 1};
            }
        }

        return new int[] {};
    }

     */
}
