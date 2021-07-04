import java.util.Arrays;

/**
 * Check if One String Swap Can Make Strings Equal
 *
 * Problem Source: https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal/
 *
 * Algorithm:
 *
 * 1. Make an int[] letterTables of 26 for both strings
 * 2. Set a counter to 0
 * 3. Make a for loop
 *      get each character from both strings
 *
 *      if the characters are not equal
 *          counter++
 *
 *      If the counter is greater than 2
 *          return false, because we know we have to make more than 1 swap
 *
 *      increment the letterTable[index]++
 *4. Return if the two letterTable arrays are equal.
 *
 * Time-Complexity: O(N), N is the length of any string. Since both strings have equal length.
 * Space-Complexity: O(1), our tables are fixed size of 26, for 26 letters.
 *
 */
public class CheckIfOneStringSwapCanMakeStringsEqual {
    public static void main(String[] args) {
        System.out.println(areAlmostEqual("abcd", "dcba"));
        System.out.println(areAlmostEqual("bank", "kanb"));
    }

    public static boolean areAlmostEqual(String s1, String s2) {
        int[] tableS1 = new int[26];
        int[] tableS2 = new int[26];

        int counter = 0;

        for(int i=0; i < s1.length(); i++) {
            char letterS1 = s1.charAt(i);
            char letterS2 = s2.charAt(i);

            if(letterS1 != letterS2) {
                counter++;
            }

            if(counter > 2) {
                return false;
            }

            tableS1[letterS1 - 'a']++;
            tableS2[letterS2 - 'a']++;
        }

        return Arrays.equals(tableS1, tableS2);
    }


    // Brute force solution does not work
    /*
    public static boolean areAlmostEqual(String s1, String s2) {

        int l1 = 0, l2 = 0;
        int r1 = s1.length() - 1, r2 = s1.length() - 1;
        boolean flag = false;

        char[] s2Chars = s2.toCharArray();

        while(l1 < r1 && l2 < r2) {
            if( flag == false && s1.charAt(l1) != s2Chars[l2]) {
                char temp = s2Chars[l2];
                s2Chars[l2] = s2Chars[r2];
                s2Chars[r2] = temp;
                flag = true;
            }

            l1++;
            r1--;
            l2++;
            r2--;
        }

        return s1.equals(String.valueOf(s2Chars));
    }

     */
}
