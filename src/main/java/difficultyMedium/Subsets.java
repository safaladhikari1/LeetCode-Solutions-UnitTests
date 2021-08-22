package difficultyMedium;

import java.util.LinkedList;
import java.util.List;

/**
 * Subsets
 *
 * Problem Source: https://leetcode.com/problems/subsets/
 *
 * Algorithm:
 *
 * 1. Make a masterList of List<List<Integer>>. For example of input: [1, 2, 3]
 *
 * 2. private backtrack method where we pass in masterList, tempList = new LinkedList<>(), input int[] nums, index 0
 *
 *    Add the empty tempList[] to masterList
 *
 *    In the for loop
 *      add 1 to tempList
 *      recurse backtrack again, with index + 1
 *      tempList is added in the masterList in the same order as below:
 *
 *      When index =
 *
 *      0 -> tempList[1]
 *                          1 -> tempList[1, 2]
 *                                                  2 -> tempList [1, 2, 3]
 *
 *                                                  It hits the base case, that means start = 3
 *                                                  Now we remove 3 from the tempList
 *
 *                                                  tempList[1, 2]
 *
 *                                                  The for loop ends, we go back to the recursive call stack
 *                                                  when 1 -> tempList[1, 2]
 *
 *                                                  tempList.remove()
 *                                                  We remove 2, now the tempList[1]
 *
 *                                                  start = 2, in the for loop, which means nums[2] = 3
 *                                                  tempList will become [1, 3]
 *
 *                                                  backtrack, it hits the same base again
 *
 *                                                  We remove 3, tempList is [1]
 *
 *                                                  Now we go the recursive call stack 0 -> tempList[1]
 *                                                  We remove 1, tempList is []
 *
 *                                                  In the for loop, start is 1
 *
 *                                                  Which means tempList.add(nums[1]) = tempList[2]
 *
 *                                                  ... And so on
 *
 *                                                  The order of tempList in masterList is
 *
 *                                                  [[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3]]
 *
 * 3. Return the masterList
 *
 * Time-Complexity: O(N * 2^N)
 * Space-Complexity: O(N)
 *
 * More information on:
 *
 * Approach 2 of https://leetcode.com/problems/subsets/solution/
 *
 * https://leetcode.com/problems/subsets/discuss/27281/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)
 *
 */
public class Subsets {

    public static void main(String[] args) {
        Subsets solution = new Subsets();
        System.out.println(solution.subsets(new int[] {1, 2, 3}));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> masterList = new LinkedList<>();
        backtrack(masterList, new LinkedList<>(), nums, 0);
        return masterList;
    }

    private void backtrack(List<List<Integer>> masterListA, List<Integer> tempList, int[] nums, int start) {
        masterListA.add(new LinkedList<>(tempList));

        for(int i=start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(masterListA, tempList, nums, i+1);
            tempList.remove(tempList.size() - 1);
        }
    }

}
