package difficultyEasy;

/**
 * Check If All 1's Are at Least Length K Places Away
 *
 * Problem Source: https://leetcode.com/problems/check-if-all-1s-are-at-least-length-k-places-away/
 *
 * Algorithm:
 *
 * 1. Initialize a separateCount = k, to pass if the nums array has the first element = 1
 *
 * 2. Loop in every characters of the array
 *      if it is 1
 *          if separateCount is less than k
 *              return false
 *          Otherwise
 *              reset separateCount to 0
 *      else
 *          increment the separateCount
 *
 *  3. If it passes the above test, return true
 *
 *  Time-Complexity: O(N), where N is the number of elements in the array
 *  Space-Complexity: O(1)
 */
public class CheckIfAll1sAreAtLeastLengthKPlacesAway {

    public boolean kLengthApart(int[] nums, int k) {

        int separateCount = k;

        for(int i=0; i < nums.length; i++) {
            if(nums[i] == 1) {
                if(separateCount < k) {
                    return false;
                }
                else {
                    separateCount = 0;
                }
            }
            else {
                separateCount++;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        CheckIfAll1sAreAtLeastLengthKPlacesAway solution = new CheckIfAll1sAreAtLeastLengthKPlacesAway();
        System.out.println(solution.kLengthApart(new int[] {1, 0, 0, 0, 1, 0, 0, 1}, 2));

        System.out.println(solution.kLengthApart(new int[] {1, 1, 1, 0}, 3));
    }

}
