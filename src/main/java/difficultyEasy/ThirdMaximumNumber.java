import java.util.TreeSet;

/**
 * Third Maximum Number
 *
 * Problem Source: https://leetcode.com/problems/third-maximum-number/
 *
 * Algorithm:
 *
 * 1. Loop through the elements in the array
 * 2. Add them to a tree set
 * 3. If the tree set size is less than 3
 *      return the highest element in that tree using pollLast()
 * 4. Otherwise, do pollLast() twice, it removes the highest element in the tree set
 * 5. Return the third highest using pollLast() third time.
 *
 * Time-Complexity: O(N), we visit every elements in the tree at least once.
 * Space-Complexity: O(N), we use N space for our TreeSet.
 */
public class ThirdMaximumNumber {
    public static void main(String[] args) {
        System.out.println(thirdMax(new int[] {2, 2, 3, 1}));
    }

    public static int thirdMax(int[] nums) {
        TreeSet<Integer> numsSet = new TreeSet<>();

        for(int i=0; i < nums.length; i++) {
            numsSet.add(nums[i]);
        }

        if(numsSet.size() < 3) {
            return numsSet.pollLast();
        }

        numsSet.pollLast();
        numsSet.pollLast();

        return numsSet.pollLast();
    }
}
