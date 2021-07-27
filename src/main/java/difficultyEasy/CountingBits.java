package difficultyEasy;

import java.util.Arrays;

/**
 * Counting Bits
 *
 * Problem Source: https://leetcode.com/problems/counting-bits/
 *
 * Approach 1:
 *
 * 1.  Create a result int[] array of size n + 1
 *     initialize bitCount = 0, mask = 1
 *     array[0] = 0
 *
 * 2. for loop starting at 1 up to n, because array[0] will always be 0
 *
 *      Numbers:                              0, 1, 2, 3, 4, 5
 *      No of 1's in binary in those numbers: 0, 1, 1, 2, 1, 2
 *
 *      for each i, we can check how many 1's are there using bit manipulation
 *      Algorithm explained on:
 *      https://github.com/safaladhikari1/LeetCode-Solutions-UnitTests/blob/main/src/main/java/difficultyEasy/NumberOf1Bits.java
 *
 *      Then assign the bitCount to result[i]
 *      reset bitCount to 0, mask to 1
 *
 * 3. At the end, return result array
 *
 * Time-Complexity: O(N), where N is the input number
 * Space-Complexity: O(1)
 *
 * Approach 2:
 *
 * Same Algorithm as above, but we use an efficient approach to count the number of 1's using
 * bit manipulation.
 *
 * Algorithm explained on, Approach 2 of the article: https://leetcode.com/problems/number-of-1-bits/solution/
 *
 */
public class CountingBits {

    public static void main(String[] args) {
        CountingBits solution = new CountingBits();
        System.out.println(Arrays.toString(solution.countBits(5)));
    }

    // Approach 2: Bruteforce solution
    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        result[0] = 0;

        for(int i=1; i <= n; i++) {
            result[i] = getBits(i);
        }

        return result;
    }

    private int getBits(int n) {
        int bitCount = 0;
        while(n != 0) {
            bitCount++;
            n = n & (n - 1);
        }

        return bitCount;
    }

    // Approach 1: Bruteforce Solution
    /*
    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        int bitCount = 0;
        int mask = 1;
        result[0] = 0;

        for(int i=1; i <= n; i++) {
            for(int j= 0; j < 32; j++) {
                if((i & mask) != 0) {
                    bitCount++;
                }

                mask <<= 1;
            }

            result[i] = bitCount;
            bitCount = 0;
            mask = 1;
        }

        return result;
    }

     */
}










