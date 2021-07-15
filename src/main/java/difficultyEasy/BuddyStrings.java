package difficultyEasy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Buddy Strings
 *
 * Problem Source: https://leetcode.com/problems/buddy-strings/
 *
 * Algorithm:
 *
 * 1. Check if s and goal's length are equal, if they are not, return false because we cannot swap two letters in s,
 *    to make it equal to goal.
 *
 * 2. Check if s is equal to goal
 *      If they are, we need to make sure there are no duplicates in s.
 *
 *      For example: s = ab, goal = ab
 *      In this case, if we swap ab -> ba, it won't be equal to goal. So No duplicates in s, results false.
 *
 *      If there are duplicates
 *
 *          s = aa , goal = aa, we can return true
 *
 * 3. Now, at this point, s and goal have equal length and are not equal
 *
 *    s =    aaaaaaabc
 *    goal = aaaaaaacb
 *
 *    Check if there are exactly to two index differences, then check if the characters on those indices
 *    for both s and goal, when swapped, the two strings: s and goal becomes equal
 *
 *    In above example, we get 2 index differences for the last 2.
 *    Then we check those two indices, when swapped, if the two string becomes equal.
 *
 * Time-Complexity: O(N), we loop through the String N times, where N is the length of string S
 * Space-Complexity: O(N) for HashSet and ArrayList.
 *
 */
public class BuddyStrings {

    public static void main(String[] args) {

        BuddyStrings solution = new BuddyStrings();
        System.out.println(solution.buddyStrings("ab", "ba"));

        System.out.println(solution.buddyStrings("ab", "ab"));

        System.out.println(solution.buddyStrings("aa", "aa"));

        System.out.println(solution.buddyStrings("aaaaaaabc", "aaaaaaacb"));

    }

    public boolean buddyStrings(String s, String goal) {
        if(s.length() != goal.length()) {
            return false;
        }

        if(s.equals(goal)) {
            Set<Character> lettersInS = new HashSet<>();
            for(Character letter: s.toCharArray()) {
                lettersInS.add(letter);
            }

            return lettersInS.size() < s.length();
        }
        else {
            List<Integer> indexCount = new ArrayList<>();

            for(int i=0; i < s.length(); i++) {
                if(s.charAt(i) != goal.charAt(i)) {
                    indexCount.add(i);
                }
            }

            return indexCount.size() == 2
                    && s.charAt(indexCount.get(0)) == goal.charAt(indexCount.get(1))
                    && s.charAt(indexCount.get(1)) == goal.charAt(indexCount.get(0));
        }
    }

    // Brute force solution, doesn't work
    /*
    public boolean buddyStrings(String s, String goal) {
        int[] letters = new int[26];

        if(s.length() != goal.length()) {
            return  false;
        }

        for(char letter : s.toCharArray()) {
            letters[letter - 'a']++;
        }

        for(char letter : goal.toCharArray()) {
            letters[letter - 'a']--;
        }

        for (int i=0; i < letters.length; i++) {
            if(letters[i] != 0){
                return false;
            }
        }

        return s.equals(goal) ? false : true;
    }

     */


}








