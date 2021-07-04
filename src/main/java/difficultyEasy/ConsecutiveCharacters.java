/**
 * Consecutive Characters
 * Problem Source: https://leetcode.com/problems/consecutive-characters/
 *
 * Algorithm:
 *
 * 1. Use two pointers, windowEnd and windowStart
 * 2. length is the running count, maxLength only stores the max length
 * 3. Inside for loop
 *      if s.charAt(end) == s.charSt(start)
 *          we have same chars, length++
 *      else
 *          we have different chars,
 *          move the start to end
 *          reset the length to 1, because we always start the count at 1 for the first unique letter or char.
 *    At the end of for loop, store the maxLength of the running length.
 * 4. Return max length
 *
 * Time-Complexity: O(N), where N is the number of characters in the string.
 * Space-Complexity: O(1)
 */
public class ConsecutiveCharacters {
    public static void main(String[] args) {
        System.out.println(maxPower("hooraaaaaaaaaaay"));
    }

    /**
     * Returns the maximum length of the unique consecutive characters.
     * @param s input string
     * @return maximum length
     */
    public static int maxPower(String s) {
        int length = 0;
        int windowStart = 0;
        int maxLength = Integer.MIN_VALUE;

        for(int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            if(s.charAt(windowEnd) == s.charAt(windowStart)) {
                length++;
            } else {
                windowStart = windowEnd;
                length = 1;
            }

            if(length > maxLength) {
                maxLength = length;
            }
        }

        return maxLength;
    }
}
