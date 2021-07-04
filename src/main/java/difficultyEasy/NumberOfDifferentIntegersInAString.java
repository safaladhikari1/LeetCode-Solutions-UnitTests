import java.util.HashSet;
import java.util.Set;

/**
 * Number of Different Integers in a String
 *
 * Problem Source: https://leetcode.com/problems/number-of-different-integers-in-a-string/
 *
 * Algorithm:
 *
 * Approach 2: Without using String Builder
 *
 * 1. The goal is to count the number of unique integers that are inside the string. Those integers cannot start with 0s
 *
 * 2. We create a Set, that will store the String version of those unique integers.
 *
 * 3. We will set the start to 0,
 *
 *    while(start < word.length)
 *
 *      We will check if the character is digit at the start index
 *          If it is digit, we have another variable, numStart that points to the starting index of the integer in a string
 *          numStart = start
 *
 *          while(numStart is less than word.length and Character is Digit at numStart index)
 *              numStart++
 *              numStart is keeping track of ending index of the integer in the string.
 *
 *          We need to check if that integer has leading 0s
 *          while(start < numStart and word.charAt(start) is 0)
 *              start++
 *
 *          Now we can add that integer string to our HashSet (word.substring(start, numStart))
 *          Since our start is still behind numStart,
 *          Reset the start to numStart
 *
 *     Otherwise, the character is not digit at the start index
 *          start++;
 *
 * 4. At the end, return the size of HashSet.
 *
 * Time-Complexity: O(N), where N is the number of characters in the String
 * Space-Complexity: O(N), the space utilized by our HashSet.
 *
 * ----
 *
 * Approach 1:
 *
 * Algorithm:
 *
 * 1. Same approach as above, but we are using StringBuilder to store the string Integers
 *    Also, an extra helper method to remove the leading zeros from the string Integer.
 *
 */
public class NumberOfDifferentIntegersInAString {
    public static void main(String[] args) {
        System.out.println(numDifferentIntegers("a123bc34d8ef34"));

        System.out.println(numDifferentIntegers("167278959591294"));
    }

    // Approach 2: Without using String Builder
    public static int numDifferentIntegers(String word) {
        Set<String> resultInts = new HashSet<>();
        int start = 0;

        while (start < word.length()) {
            if(Character.isDigit(word.charAt(start))) {
                int numStart = start;

                while(numStart < word.length() && Character.isDigit(word.charAt(numStart))) {
                    numStart++;
                }

                while(start < numStart && word.charAt(start) == '0') {
                    start++;
                }

                resultInts.add(word.substring(start, numStart));
                start = numStart;
            }
            else {
                start++;
            }
        }

        return resultInts.size();
    }


    // Approach 1: Using String Builder
    /*
    public static int numDifferentIntegers(String word) {
        Set<String> resultSet = new HashSet<>();
        int index = 0;

        while(index < word.length()) {
            if(Character.isDigit(word.charAt(index))) {
                StringBuilder numWord = new StringBuilder();
                while(index < word.length() && Character.isDigit(word.charAt(index))) {
                    numWord.append(word.charAt(index));
                    index++;
                }
                resultSet.add(removeLeadingZeroes(numWord));
            }
            else {
                index++;
            }
        }

        return resultSet.size();
    }

    private static String removeLeadingZeroes(StringBuilder numWord) {
        while(numWord.length() > 1 && numWord.charAt(0) == '0') {
            numWord.deleteCharAt(0);
        }

        return numWord.toString();
    }

     */
}
