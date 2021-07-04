/**
 * Hamming Distance
 *
 * Problem Source: https://leetcode.com/problems/hamming-distance/
 *
 * Algorithm:
 *
 * 1. Create a maskX = 1, maskY = 1 for each x and y.
 * 2. Create a count = 0
 * 3. Since x and y are both ints,
 *
 *    We can make a loop for up to 32 bits
 *    and check if ith bit is set
 *
 *    For example:
 *
 *    x = 1
 *
 *          0 0 0 1
 *        & 0 0 0 1 (maskX)
 *          0 0 0 1 (Set)
 *
 *    y = 4
 *
 *          0 1 0 0
 *        & 0 0 0 1 (maskY)
 *          0 0 0 0 (Not Set)
 *
 *     It means the bit of x and bit of y are different, so increment the count
 *
 *     Now, do a left shift for both maskX and maskY <<= 1, so we can check the 2nd bit from the right
 *
 *    x = 1
 *
 *          0 0 0 1
 *        & 0 0 1 0 (maskX)
 *          0 0 0 0 (Not Set)
 *
 *    y = 4
 *
 *          0 1 0 0
 *        & 0 0 1 0 (maskY)
 *          0 0 0 0 (Not Set)
 *
 *     It means the bit of x and bit of y are equal, so no need to increment the count
 *
 *    x = 1
 *
 *          0 0 0 1
 *        & 0 1 0 0 (maskX)
 *          0 0 0 0 (Not Set)
 *
 *    y = 4
 *
 *          0 1 0 0
 *        & 0 1 0 0 (maskY)
 *          0 1 0 0 (Set)
 *
 *     It means the bit of x and bit of y are not equal, so increment the count
 *
 *    x = 1
 *
 *          0 0 0 1
 *        & 1 0 0 0 (maskX)
 *          0 0 0 0 (Not Set)
 *
 *    y = 4
 *
 *          0 1 0 0
 *        & 1 0 0 0 (maskY)
 *          0 0 0 0 (Not Set)
 *
 *     It means the bit of x and bit of y are equal, so no need to increment the count
 *
 *  4. Our count is 2, and we return it
 *
 *  Time-Complexity: O(1), regardless of how big the number, since it's an integer we only loop up to 32 times.
 *  Space-Complexity: O(1)
 *
 *  More explanation on Bit-Masking: https://github.com/safaladhikari1/CodingProblems/blob/master/LeetCode/Easy/NumberOf1Bits.java
 *
 */
public class HammingDistance {
    public static void main(String[] args) {
        System.out.println(hammingDistance(1, 4));

        System.out.println(hammingDistance(3, 1));
    }

    public static int hammingDistance(int x, int y) {
        int maskX = 1, maskY = 1;
        int count = 0;

        for(int i=0; i < 32; i++) {
            if((x & maskX) != (y & maskY)) {
                count++;
            }
            maskX <<= 1;
            maskY <<= 1;
        }

        return count;
    }
}
