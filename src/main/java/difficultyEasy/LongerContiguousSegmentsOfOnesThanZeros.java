/**
 * Longer Contiguous Segments of Ones than Zeros
 *
 * Problem Source: https://leetcode.com/problems/longer-contiguous-segments-of-ones-than-zeros/
 *
 * Algorithm:
 *
 * 1. Create int[] counter array of size 2
 *    So we can keep track with:
 *    counter[0] for '1'
 *    counter[1] for '0'
 *
 * 2. Also create int max1 and max0 to keep track of the maximum counts for 1 and 0
 *
 * 3. Loop through the characters in s
 *    If it's 1,
 *      reset counter[1]
 *      increment counter[0]
 *      keep track of max of counter[0]
 *    else (it's guaranteed it's 0, because the string contains only 1 or 0)
 *      reset counter[0]
 *      increment counter[1]
 *      keep track of max of counter[1]
 *
 * 4. After the loop, return max1 > max0
 *
 * Time-Complexity: O(N), where N is the number of characters in String s
 * Space-Complexity: O(1)
 */
public class LongerContiguousSegmentsOfOnesThanZeros {
    public static void main(String[] args) {
        System.out.println(checkZeroOnes("1101"));
        System.out.println(checkZeroOnes("111000"));
    }

    public static boolean checkZeroOnes(String s) {
        int[] counter = new int[2];
        int max1 = 0, max0 = 0;

        for(int i=0; i < s.length(); i++) {
            if(s.charAt(i) == '1') {
                counter[1] = 0;
                counter[0]++;
                max1 = Math.max(max1, counter[0]);
            }
            else {
                counter[0] = 0;
                counter[1]++;
                max0 = Math.max(max0, counter[1]);
            }
        }

        return max1 > max0;
    }

}
