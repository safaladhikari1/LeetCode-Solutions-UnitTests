package difficultyMedium;

import java.util.ArrayList;
import java.util.List;

/**
 * Letter Combinations of a Phone Number
 *
 * Problem Source: https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 *
 * Algorithm:
 *
 * 1. Make a result ArrayList
 * 2. Check if the input digits is not null or make sure it's more than 0
 *      Make a string map for every digit to letters
 *      For example,
 *      index 2 -> "abc"
 *      index 3 -> "def"
 *      and so on.
 * 3. Recurse with String digit, map, resultList, new StringBuilder, 0 (initial index in the recursion)
 *
 *      3.5 Base case of recursion is if the index is same as digits.length, or index is at the end of digits
 *              add the current sb.toString() in our resultList, return.
 *          For example: if we have ad, ae, af on our recursion tree
 *
 *            2              a       b       c
 *            3            def     def     def
 *
 *      3.6 Get the current digit, 2,
 *      3.7 Get the letters for that digit from our map, abc, explore the letters under a, under b, under c using dfs
 *      3.8 First we explore a
 *              append 'a' to tempStringBuilder
 *              Make another recursive call to explore what's under a
 *
 *              Then we are back at 3.6 on a separate recursive call stack
 *              current digit is 3 this time
 *              mapWord for 3 is "def"
 *              for loop for "def"
 *                  append d, which makes our tempBuilder "ad"
 *                  do another recursion, but this time it hits the base case, because index is 2, digitsA.length is 2
 *                  add the word to our resultList
 *
 *                  Now we need to back track, come above d, which is a by itself
 *                  That's why we remove the last character 'd'
 *
 *                  Do the same for "ae", "af", add them to resultList
 *                  Then, remove "a"
 *                  append b and so on..
 *
 * Time-Complexity: O(N * M), where is the N is the length of the digits, M is the maximum length of the String letters
 *                  representating that digits
 * Space-Complexity: O(N), N is the length of the digits, the recursive call stack goes as deep as the length of digits.
 *
 * More information: https://youtu.be/nNGSZdx6F3M?t=167
 *
 *
 */
public class LetterCombinationsOfAPhoneNumber {

    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber solution = new LetterCombinationsOfAPhoneNumber();
        System.out.println(solution.letterCombinations("23"));
    }

    public List<String> letterCombinations(String digits) {

        List<String> answerList = new ArrayList<>();
        if(digits != null && digits.length() > 0) {
            String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno",
            "pqrs", "tuv", "wxyz"};

            dfs(digits, map, answerList, new StringBuilder(), 0);

        }

        return answerList;
    }

    private void dfs(String digitsA, String[] mapA, List<String> answerListA,
                     StringBuilder tempBuilder, int index) {
        if(index == digitsA.length()) {
            answerListA.add(tempBuilder.toString());
            return;
        }

        int digit = Character.getNumericValue(digitsA.charAt(index));

        String mapWord = mapA[digit];

        for(int i=0; i < mapWord.length(); i++) {
            tempBuilder.append(mapWord.charAt(i));
            dfs(digitsA, mapA, answerListA, tempBuilder, index + 1);
            tempBuilder.deleteCharAt(tempBuilder.length() - 1);
        }
    }
}
