package difficultyMedium;

import java.util.LinkedList;
import java.util.List;

/**
 * Permutations
 *
 * Problem Source: https://leetcode.com/problems/permutations/
 *
 * Algorithm:
 *
 * 1. The goal is to find all the possible permutations of unique integers that are in nums array
 * 2. This can be solved recursively using DFS + backtracking
 * 3. It's best explained using the tree visualization on video: https://youtu.be/KukNnoN-SoY
 */
public class Permutations {

    public static void main(String[] args) {
        Permutations solution = new Permutations();
        System.out.println(solution.permute(new int[] {1, 2, 3}));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> masterList = new LinkedList<>();

         backtrack(masterList, new LinkedList<>(), nums);

        return masterList;
    }

    private void backtrack(List<List<Integer>> masterListA, List<Integer> tempList, int[] nums) {
        if(nums.length == tempList.size()) {
            masterListA.add(new LinkedList<>(tempList));
        }
        else {
            for(int i=0; i < nums.length; i++) {
                if(tempList.contains(nums[i])) {
                    continue;
                }
                tempList.add(nums[i]);
                backtrack(masterListA, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}



































