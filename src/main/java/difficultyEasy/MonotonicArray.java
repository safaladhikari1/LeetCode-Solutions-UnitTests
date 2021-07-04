import java.util.Stack;

/**
 * Monotonic Array
 *
 * Problem Source: https://leetcode.com/problems/monotonic-array/
 *
 * Algorithms:
 *
 * Approach 2
 *
 * 1. Initialize increasing, decreasing to true
 *
 * 2. Make 1 for loop, one pass up to nums.length - 1
 *
 *      check if the array is increasing
 *      if(nums[i] > nums[i+1])
 *          increasing is false
 *
 *      check if the array is decreasing
 *      if(nums[i] < nums[i+1])
 *          decreasing is false
 *
 * 3. return if either increasing or decreasing is false, return false or return true.
 *
 * Time-Complexity: O(N), where N is the length of the input array.
 * Space-Complexity: O(1)
 *
 * Approach 1:
 *
 * 1. This is a slow approach, but we are creating two stacks
 *
 * 2. monoIncrease stack and monoDecrease stack
 *
 * 3. Doing the for loop twice, to check if they have monoIncrease  and monoDecrease
 *
 * 4. At the end, if they are monoIncrease and monoDecrease, then we won't be doing any stack.pop, so
 *    the original input array size and stack size should equal.
 *          return true
 *    Otherwise
 *          return false
 *
 * Time-Complexity: O(N), where N is the number of elements in the array
 * Space-Complexity: O(N), where N is the space for our stacks.
 *
 */
public class MonotonicArray {
    public static void main(String[] args) {
        System.out.println(isMonotonic(new int[] {1, 2, 2, 3}));

        System.out.println(isMonotonic(new int[] {6, 5, 4, 4}));

        System.out.println(isMonotonic(new int[] {1, 3, 2}));
    }

    // Approach 2
    public static boolean isMonotonic(int[] nums) {
        boolean increasing = true, decreasing = true;

        for(int i=0; i < nums.length - 1; i++) {

            if(nums[i] > nums[i+1]) {
                increasing = false;
            }

            if(nums[i] < nums[i + 1]) {
                decreasing = false;
            }
        }

        return (increasing || decreasing) == false ? false : true;
    }

    // Approach 1
    /*
    public static boolean isMonotonic(int[] nums) {
        Stack<Integer> monoIncrease = new Stack<>();
        Stack<Integer> monoDecrease = new Stack<>();

        for(int i=0; i < nums.length; i++) {
            while(!monoIncrease.empty() && monoIncrease.peek() > nums[i]) {
                monoIncrease.pop();
            }
            monoIncrease.push(nums[i]);
        }

        for(int i=0; i < nums.length; i++) {
            while(!monoDecrease.empty() && monoDecrease.peek() < nums[i]) {
                monoDecrease.pop();
            }
            monoDecrease.push(nums[i]);
        }

        if(monoIncrease.size() == nums.length) {
            return true;
        }

        if(monoDecrease.size() == nums.length) {
            return true;
        }

        return false;
    }
    */
}
