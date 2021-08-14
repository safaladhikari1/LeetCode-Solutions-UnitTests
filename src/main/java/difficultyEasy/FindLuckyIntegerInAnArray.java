package difficultyEasy;

import java.util.HashMap;
import java.util.Map;

/**
 * Find Lucky Integer in an Array
 *
 * Problem Source: https://leetcode.com/problems/find-lucky-integer-in-an-array/
 *
 * Algorithm:
 *
 * 1. Create a map of num and it's count from the array using HashMap
 *    For example: In array, [1, 2, 2, 3, 3, 3]
 *    Map will be,
 *      1, 1
 *      2, 2
 *      3, 3
 *
 * 2. Then loop through the hashmap's keyset again
 *      if the num is equal to the hashmap's value
 *          keep track of the maxLuckyInt
 *
 * 3. Return the maxLuckyInt
 *
 * Time-Complexity: O(N), N is the number of elements in the array
 * Space-Complexity: O(N), N is the space for our hash map
 *
 * Another efficient solution without using HashMap: https://leetcode.com/problems/find-lucky-integer-in-an-array/discuss/557078/Java-100-time-100-space-O(n)
 *
 */
public class FindLuckyIntegerInAnArray {

    public static void main(String[] args) {
        FindLuckyIntegerInAnArray solution = new FindLuckyIntegerInAnArray();
        System.out.println(solution.findLucky( new int[] {2, 2, 3, 4}));
        System.out.println(solution.findLucky( new int[] {1, 2, 2, 3, 3, 3}));
        System.out.println(solution.findLucky( new int[] {2, 2, 2, 3, 3}));
    }

    public int findLucky(int[] arr) {
        int maxLuckyInt = -1;
        Map<Integer, Integer> tempMap = new HashMap<>();

        for(int i=0; i < arr.length; i++) {
            tempMap.put(arr[i], tempMap.getOrDefault(arr[i], 0) + 1);
        }

        for(int num : tempMap.keySet()) {
            if(num == tempMap.get(num)) {
                maxLuckyInt = Math.max(num, maxLuckyInt);
            }
        }

        return maxLuckyInt;
    }
}
