package difficultyEasy;

/**
 * Detect Capital
 *
 * Problem Description: https://leetcode.com/problems/detect-capital/
 *
 * Algorithm:
 *
 * 1. We are first initializing boolean variable to true
 * 2. Then looping each characters in the string, 3 times checking the following cases:
 *
 *    All letters in this word are capitals,
 *    All letters in this word are not capitals
 *    Only the first letter in this word is capital
 *
 * 3. After every case, we check if satifies the case, if it does, return true, otherwise check the other case and so on.
 *
 * Time-Complexity: O(N), where N is the length of the word, and we check every char at most 3 times.
 * Space-Complexity: O(1)
 *
 * Other efficient solutions:
 *
 * https://leetcode.com/problems/detect-capital/solution/
 * https://leetcode.com/problems/detect-capital/discuss/99274/Simple-Java-Solution-O(n)-time-O(1)-space
 */
public class DetectCapital {

    public static void main(String[] args) {
        DetectCapital solution = new DetectCapital();
        System.out.println(solution.detectCapitalUse("USA"));

        System.out.println(solution.detectCapitalUse("FlaG"));
        System.out.println(solution.detectCapitalUse("g"));

        System.out.println(solution.detectCapitalUse("Leetcode"));
    }

    public boolean detectCapitalUse(String word) {
        boolean match = true;
        int wordSize = word.length();

        // All letters in the word are uppercase
        for(int i=0; i < wordSize; i++) {
            if(!(word.charAt(i) >= 'A' && word.charAt(i) <= 'Z')) {
                match = false;
            }
        }

        if(match) {
            return true;
        }

        match = true;
        // All letters in the word are lowercase
        for(int i=0; i < wordSize; i++) {
            if(!(word.charAt(i) >= 'a' && word.charAt(i) <= 'z')) {
                match = false;
            }
        }

        if(match) {
            return true;
        }

        match = true;
        // Only the first letter in the word is capital
        if(!(word.charAt(0) >= 'A' &&  word.charAt(0) <= 'Z')) {
            match = false;
        }

        if(match) {
            for(int i=1; i < wordSize; i++) {
                if(!(word.charAt(i) >= 'a' && word.charAt(i) <= 'z')){
                    match = false;
                }
            }
        }

        if(match) {
            return true;
        }

        return false;
    }
}
