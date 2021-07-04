/**
 * Is Subsequence
 *
 * Problem Source: https://leetcode.com/problems/is-subsequence/
 *
 * Algorithm:
 *
 * 1. Make two pointers
 *
 *    sPointer and tPointer
 *
 *    Initialize both to 0, pointing at Strings s and t
 *
 *  2. For loop with tPointer
 *
 *         When t.charAt(tPointer) == s.charAt(sPointer)
 *              sPointer++;
 *
 *          We also need to make sure that sPointer is less than s.length, so we are checking if sPointer is valid and
 *          pointing at a character
 *          in s.charAt(sPointer)
 *
 *  3. At the end, return if sPointer == s.length()
 *
 *  Time-Complexity: O(N), N is the number of characters in String t
 *  Space-Complexity: O(1)
 *
 */
public class IsSubsequence {
    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "ahbgdc"));
        System.out.println(isSubsequence("axc", "ahbgdc"));

        System.out.println(isSubsequence("", "ahbgdc"));
    }

    public static boolean isSubsequence(String s, String t) {

        if(s.length() == 0) {
            return true;
        }

        int sPointer = 0;

        for(int tPointer = 0; tPointer < t.length(); tPointer++) {
            if(sPointer < s.length() && t.charAt(tPointer) == s.charAt(sPointer)) {
                sPointer++;
            }
        }

        return sPointer == s.length();
    }
}
