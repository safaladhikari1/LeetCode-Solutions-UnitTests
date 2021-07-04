import java.util.HashSet;

/**
 * Longest Palindrome
 *
 * Problem Source: https://leetcode.com/problems/longest-palindrome/
 *
 * Algorithm
 *
 * 1. Make a HashSet of Characters, initialize count variable to 0
 * 2. Loop through every characters in the String
 * 3. Store the character in the HashSet,
 *    Before storing the character, check if the HashSet already has the character
 *      If it does, remove it
 *      Increment the count
 * 4. At the end,
 *      if the HashSet is not empty, return 2 * count + 1
 * 5. If it's empty, 2 * count
 *
 * Time-Complexity: O(N), where N is the number of characters in the String
 * Space-Complexity: O(N), N is to store the characters in our HashSet.
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abccccdd"));
        System.out.println(longestPalindrome("a"));
    }

    public static int longestPalindrome(String s) {
        int count = 0;
        HashSet<Character> letterSet = new HashSet<>();

        for(int i=0; i < s.length(); i++) {
            Character letter = s.charAt(i);
            if(letterSet.contains(letter)) {
                letterSet.remove(letter);
                count++;
            }
            else {
                letterSet.add(letter);
            }
        }

        if(!letterSet.isEmpty()) {
            return 2 * count + 1;
        }

        return 2 * count;
    }
}
