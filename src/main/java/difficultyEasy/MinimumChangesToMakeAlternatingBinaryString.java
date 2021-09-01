package difficultyEasy;

/**
 * Minimum Changes To Make Alternating Binary String
 *
 * Problem Source: https://leetcode.com/problems/minimum-changes-to-make-alternating-binary-string/
 *
 * Algorithm
 *
 * 1. There are only 2 patterns to make alternating binary string
 *
 *    0 1 0 1 0 1...
 *    1 0 1 0 1 0...
 *
 * 2. If we mod i % 2, i is index starting from 0, 1, 2, 3...
 *    We get
 *    0 1 0 1 0 1... pattern
 *
 * 3. So we loop every characters and check
 *    if i % 2 is 0
 *      if s.charAt i is 1
 *          increment count1, this means it's not following the pattern 0 1 0 1..
 *      Otherwise, s.charAt i is 0
 *          increment count2
 *   else, i % 2 is 1
 *      if s.charAt is is 0
 *          increment count1, this means it's not following the pattern 0 1 0 1..
 *      Otherwise, s.charAt is is 1
 *          increment count2
 *
 * 4. count1 + count 2 = length of string
 *
 * 5. We can return the minimum of count 1 and count 2 as a result.
 *
 * Time-Complexity: O(N), N is the length of the string
 * Space-Complexity: O(1)
 *
 */
public class MinimumChangesToMakeAlternatingBinaryString {

    public static void main(String[] args) {
        MinimumChangesToMakeAlternatingBinaryString solution = new MinimumChangesToMakeAlternatingBinaryString();
        System.out.println(solution.minOperations("0100"));
        System.out.println(solution.minOperations("1111"));
        System.out.println(solution.minOperations("10"));
    }

    public int minOperations(String s) {
        int count1 = 0;
        int count2 = 0;

        for(int i=0; i < s.length(); i++) {
            if(i % 2 == 0) {
                if(s.charAt(i) == '1') {
                    count1++;
                }
                else {
                    count2++;
                }
            }
            else {
                if(s.charAt(i) == '0') {
                    count1++;
                }
                else {
                    count2++;
                }
            }

        }

        return Math.min(count1, count2);
    }

}
