/**
 * Binary Search
 *
 * Problem Source: https://leetcode.com/problems/binary-search/solution/
 *
 * Algorithm:
 *
 * 1. Set the low to 0, high to nums.length - 1
 * 2. Enter the while loop (low <= high)
 *      get the mid = (high - low)/2 + low
 *
 *      if target is smaller than mid
 *          search on the left
 *      if target is larger than mid
 *          search on the right
 *      Otherwise,
 *          we found the target. Return mid, which is our index.
 *
 * Time-Complexity: O(log N), time complexity of Binary Search on a sorted array
 * Space-Complexity: O(1)
 *
 */

public class BinarySearch {
    public static void main(String[] args) {
        System.out.println(search(new int[] {-1, 0, 3, 5, 9, 12}, 9));
    }

    public static int search(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;
        int mid;

        while(low <= high) {
            mid = ((high - low) / 2) + low;
            if(target < nums[mid]) {
                high = mid - 1;
            }
            else if(target > nums[mid]) {
                low = mid + 1;
            }
            else {
                return mid;
            }
        }

        return -1;
    }
}
