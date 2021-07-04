/**
 * Count Odd Numbers in an Interval Range
 *
 * Problem Source: https://leetcode.com/problems/count-odd-numbers-in-an-interval-range/
 *
 * Algorithm:
 *
 * Approach 2: Math Logic
 *
 * 1. Given the range of low and high, half of elements from the range low to high is odd
 *
 *    For example:
 *
 *    low = 3
 *    high = 7
 *
 *    3, 4, 5, 6, 7
 *
 *    7 - 3 / 2 = 2
 *
 * 2. If either low or high is odd, or both are odd, we will have 1 more odd number
 *
 *    More explanation:
 *
 *    https://leetcode.com/problems/count-odd-numbers-in-an-interval-range/discuss/754762/C%2B%2B-or-Easy-to-understand-or-O(1)
 *
 *    https://leetcode.com/problems/count-odd-numbers-in-an-interval-range/discuss/755066/Java-%3A-Easy-to-understand-with-comments
 *
 * 3. At the end return the final count of odd numbers.
 *
 * Time-Complexity: O(1)
 * Space-Complexity: O(1)
 *
 * Approach 2:
 *
 * 1. We are visiting elements from low to high (inclusive), and checking if they are odd or not.
 *
 * Time-Complexity: O(N), where N is the number of elements between low and high (inclusive)
 * Space-Complexity: O(1)
 *
 */
public class CountOddNumbersInAnIntervalRange {
    public static void main(String[] args) {
        System.out.println(countOdds(3, 7));
    }

    // Approach 2: Math Logic
    public static int countOdds(int low, int high) {

        int count = (high - low) / 2;

        if(low % 2 != 0 || high % 2 != 0) {
            count++;
        }

        return count;
    }

    // Approach 1: Linear scan of all elements between low and high
    /*
    public static int countOdds(int low, int high) {
        int count = 0;

        for(int i = low; i <= high; i++) {
            if(i % 2 != 0) {
                count++;
            }
        }

        return count;
    }

     */
}
