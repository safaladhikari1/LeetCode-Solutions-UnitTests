/**
 * Check If a Word Occurs As a Prefix of Any Word in a Sentence
 *
 * Problem Source: https://leetcode.com/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence/
 *
 * Algorithm:
 *
 * 1. Split the sentence into various words
 *
 * 2. Loop through every word
 *
 * 3. Check if the search word is the substring using substring(startIndex, lastIndex)
 *      If it is, return index + 1
 *
 * 4. Otherwise, return -1
 *
 * Time-Complexity: O(N * M), N is the number of words in a sentence, M is the length of the search word
 * Space-Complexity: O(N), N is the number of words in a sentence.
 */
public class CheckIfWordOccursAsPrefix {
    public static void main(String[] args) {
        System.out.println(isPrefixOfWord("i love eating burger", "burg"));

        isPrefixOfWord("love errichto jonathan dumb", "dumb");
    }

    public static int isPrefixOfWord(String sentence, String searchWord) {

        String[] sentenceWords = sentence.split(" ");

        for(int i=0; i < sentenceWords.length; i++) {
            String word = sentenceWords[i];

            for(int j=word.length(); j >= 0; j--) {
                String tempWord = word.substring(0, j);
                if(searchWord.equals(tempWord)) {
                    return i + 1;
                }
            }
        }

        return -1;
    }
}
