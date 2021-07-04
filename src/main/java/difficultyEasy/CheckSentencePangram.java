/**
 * Check if the Sentence is Pangram
 * Problem Source: https://leetcode.com/problems/check-if-the-sentence-is-pangram/
 *
 * Algorithm:
 *
 * 1. Create counter letterTable of size 26 for 26 alphabets.
 * 2. If we have visited a letter, decrement the index
 * 3. At the end, check if all the index is greater than -1. If not return false.
 *    Otherwise we have all 26 letters, return true.
 *    Sometimes the there will be duplicates so it can more -2, -3 etc.
 *    But if we haven't seen the letter at all, index will be greater than -1
 *
 * Time-Complexity: O(N), N is the number of characters in the string.
 * Space-Complexity: O(1)
 */

public class CheckSentencePangram {
    public static void main(String[] args) {
        System.out.println(checkIfPangram("thequickbrownfoxjumpsoverthelazydog"));
        System.out.println(checkIfPangram("leetcode"));
    }

    /**
     * Returns if a given sentence has every letter of the English alphabet appears at least once.
     * @param sentence the input sentence.
     * @return true or false.
     */
    public static boolean checkIfPangram(String sentence) {
        int[] letterTable = new int[26];

        for(int i=0; i < sentence.length(); i++) {
            letterTable[sentence.charAt(i) - 'a']--;
        }

        for(int i=0; i < letterTable.length; i++) {
            if(letterTable[i] > -1) {
                return false;
            }
        }

        return true;
    }

    // Approach 2: Using boolean counts and checking the count at the end.
    /*
    public boolean checkIfPangram(String sentence) {
        boolean[] counts = new boolean[26];

        int count = 0;
        int index = 0;
        for (int i = 0; i < sentence.length(); i++) {
            index = sentence.charAt(i) - 'a';
            if (!counts[index]) {
                count++;
            }
            counts[index] = true;
        }

        return (count == 26);
    }

    */
}
