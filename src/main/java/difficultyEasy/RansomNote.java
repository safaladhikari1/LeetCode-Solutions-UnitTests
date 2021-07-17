package difficultyEasy;

/**
 * Ransom Note
 *
 * Source: https://leetcode.com/problems/ransom-note/
 *
 * Algorithm:
 *
 * 1. if ransom is longer than magazine
 *      false
 *
 * 2. Loop through all the characters of magazine
 *      Store the count of letters in the magazineLetter table as int[]
 *
 * 3. Loop through ransom
 *      if magazineLetter has ransom's character
 *          decrement from magazineLetter table
 *
 *      At any point, if an index of magazineLetter table goes negative
 *          That means, we have more characters or a different character than magazine has
 *          return false
 *
 * 4. If it passes all the above, return true
 *
 * Time-Complexity: O(M + N), M and N are the length of magazine and ransomNote
 * Space-Complexity: O(1), magazineLetters has fixed size length.
 *
 */
public class RansomNote {

    public static void main(String[] args) {
        RansomNote solution = new RansomNote();
        System.out.println(solution.canConstruct("aa", "ab"));

        System.out.println(solution.canConstruct("aa", "aab"));
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() > magazine.length()) {
            return false;
        }

        int[] magazineLetters = new int[26];

        for(char c : magazine.toCharArray()) {
            magazineLetters[c - 'a']++;
        }

        for (char c : ransomNote.toCharArray()) {
            int magazineLettersIndex = c - 'a';

            if (magazineLetters[magazineLettersIndex] >= 0) {
                magazineLetters[magazineLettersIndex]--;
            }

            if(magazineLetters[magazineLettersIndex] < 0) {
                return false;
            }
        }

        return true;
    }
}
