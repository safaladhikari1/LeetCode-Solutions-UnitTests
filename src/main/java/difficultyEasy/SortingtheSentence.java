/**
 * Sorting the Sentence
 *
 * Problem Source: https://leetcode.com/problems/sorting-the-sentence/
 *
 * Algorithm:
 *
 * 1. Create a string builder
 * 2. Get an array of words using String.split(" ")
 * 3. Make another resultString array, same size as array of words
 * 4. Loop through the words array, visit each word
 *      Get the numeric value, which is the last character of that word
 *
 *      Then, pass that numeric value in resultString array
 *
 *      resultString[numericValue] = word.substring(0, word.length() - 1)
 *
 *      word.substring will have word, excluding the last character which is a number
 *
 * 5. At the end of the loop, our resultString array will have all the words, excluding number
 *    in correct index, in the right order
 *
 *    Now we need to convert that to string
 *
 * 6. visit each word on resultString array
 *
 *     if it is not first, don't add empty space " "
 *
 *     append each word to string builder
 *     change first to false
 *
 *     ["This", "is", "a", "sentence"]
 *
 *     will look like for boolean first
 *
 *     true, false, false, false
 *     This_is_a_sentence
 *
 *     By the time we reach sentence, it will be end of loop and we won't go up to add another empty space.
 *
 *  7. Return the string builder to string
 *
 *  Time-Complexity: O(N), where N is the number of characters in the String
 *  Space-Complexity: O(N), we are temporarily creating two String arrays for this algorithm
 *
 */

public class SortingtheSentence {
    public static void main(String[] args) {
        System.out.println(sortSentence("is2 sentence4 This1 a3"));
    }

    public static String sortSentence(String s) {
        StringBuilder sb = new StringBuilder();
        String[] sArr = s.split(" ");
        String[] result = new String[sArr.length];

        boolean first = true;

        for(int i=0; i < sArr.length; i++) {
            String word = sArr[i];
            result[Character.getNumericValue(word.charAt(word.length() - 1)) - 1] =
                    word.substring(0, word.length() - 1);
        }

        for(int i=0; i < result.length; i++) {
            if(!first) {
                sb.append(" ");
            }
            sb.append(result[i]);
            first = false;
        }

        return sb.toString();
    }

    // Approach 1
    /*
    public static String sortSentence(String s) {
        StringBuilder result = new StringBuilder(s.length());

        String[] sArr = s.split(" ");
        int count = 1;
        int resultCapacity = result.capacity();

        while(resultCapacity > 0) {
            for(int i=0; i < sArr.length; i++) {
                String word = sArr[i];
                if(Character.getNumericValue(word.charAt(word.length() - 1)) == count) {
                    result.append(word.substring(0, word.length() - 1));
                    result.append(" ");
                    count++;
                }
            }

            resultCapacity = result.capacity();
        }

        return result.toString();
    }

     */
}
