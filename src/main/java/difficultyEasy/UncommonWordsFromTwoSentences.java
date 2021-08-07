package difficultyEasy;

import java.util.*;

/**
 * Uncommon Words from Two Sentences
 *
 * Problem Source: https://leetcode.com/problems/uncommon-words-from-two-sentences/
 *
 * Algorithm: Same as explained in the article: https://leetcode.com/problems/uncommon-words-from-two-sentences/solution/
 *
 * Time-Complexity: O(M + N), M and N are the lengths of Strings A and B respectively
 * Space-Complexity: O(M + N), the space used by our HashMap.
 *
 */
public class UncommonWordsFromTwoSentences {

    public static void main(String[] args) {
        UncommonWordsFromTwoSentences solution = new UncommonWordsFromTwoSentences();
        System.out.println(Arrays.toString(solution.uncommonFromSentences("apple apple", "banana")));

        System.out.println(Arrays.toString(solution.uncommonFromSentences("this apple is sweet", "this apple is sour")));
    }

    public String[] uncommonFromSentences(String s1, String s2) {
        String[] s1Array = s1.split(" ");
        String[] s2Array = s2.split(" ");

        Map<String, Integer> wordsMap = new HashMap<>();
        for(String s1Word : s1Array) {
            wordsMap.put(s1Word, wordsMap.getOrDefault(s1Word, 0) + 1);
        }

        for(String s2Word : s2Array) {
            wordsMap.put(s2Word, wordsMap.getOrDefault(s2Word, 0) + 1);
        }

        List<String> uncommonList = new LinkedList<>();

        for(String word : wordsMap.keySet()) {
            if(wordsMap.get(word) == 1) {
                uncommonList.add(word);
            }
        }

        String[] resultList = new String[uncommonList.size()];

        for(int i=0; i < uncommonList.size(); i++) {
            resultList[i] = uncommonList.get(i);
        }

        return resultList;
    }
}
