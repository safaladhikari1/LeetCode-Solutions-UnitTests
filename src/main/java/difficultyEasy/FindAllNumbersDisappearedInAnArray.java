package difficultyEasy;

import java.util.LinkedList;
import java.util.List;

/**
 * Find All Numbers Disappeared in an Array
 *
 * Problem Source: https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
 *
 * Algorithm:
 *
 * 1. Get the nums array size
 * 2. Make a boolean array of same size as nums array, Initialize a resultList
 * 3. Loop through nums array
 *      flip respective indices of boolean array to true
 * 4. Loop through the boolean array, if an index is false, add it to arrayList
 *    add 1, because of 0 indices start
 * 5. Return the resultList
 *
 * Time-Complexity: O(N), where N is the number of elements in the input array
 * Space-Complexity: O(N), we use extra boolean[] array, same size as N
 *
 * Other techniques without using extra space:
 *
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/discuss/93007/Simple-Java-In-place-sort-solution
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/discuss/92957/2ms-O(n)-In-Space-Java
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/discuss/777978/Java-time-O(n)-space-O(1)
 *
 */
public class FindAllNumbersDisappearedInAnArray {

    public static void main(String[] args) {
        FindAllNumbersDisappearedInAnArray solution = new FindAllNumbersDisappearedInAnArray();
        System.out.println(solution.findDisappearedNumbers(new int[] {4, 3, 2, 7, 8, 2, 3, 1}));

        System.out.println(solution.findDisappearedNumbers(new int[] {1, 1}));
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int numsSize = nums.length;
        boolean[] tempArray = new boolean[numsSize];
        List<Integer> resultList = new LinkedList<>();

        for(int i=0; i < numsSize; i++) {
            tempArray[nums[i] - 1] = true;
        }

        for(int i=0; i < tempArray.length; i++) {
            if(!tempArray[i]) {
                resultList.add(i + 1);
            }
        }

        return resultList;
    }

}
