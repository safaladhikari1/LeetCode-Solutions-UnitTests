package difficultyEasy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * Find Words That Can Be Formed by Characters
 *
 * Problem Source: https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/
 *
 * Algorithm:
 *
 * 1. Explained in the post: https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/discuss/361004/Easy-Explained-Simple-Java-Check-all-char-count
 *
 * Time-Complexity: O(N), where N is the number of words in words array
 * Space-Complexity: O(N), where N copies for every word in words array
 *
 */
public class FindWordsThatCanBeFormedByCharacters {

    // Efficient Approach
    public static int countCharacters(String[] words, String chars) {
        int sum = 0;
        int count = 0;
        int[] charsMap = new int[26];
        for(Character letter : chars.toCharArray()) {
            charsMap[letter - 'a']++;
        }

        for(int i=0; i < words.length; i++) {
            String word = words[i];
            int[] charsMapCopy = Arrays.copyOf(charsMap, charsMap.length);

            for(Character letter : word.toCharArray()) {
                if(charsMapCopy[letter - 'a'] > 0) {
                    count++;
                    charsMapCopy[letter - 'a']--;
                }
                else {
                    continue;
                }
            }

            if(count == word.length()) {
                sum += word.length();
            }

            count = 0;
        }

        return sum;
    }

    // Bruteforce Approach
    /*
    public int countCharacters(String[] words, String chars) {
        int sum = 0;
        boolean flag = true;

        Map<Character, Integer> charsMap = new HashMap<>();

        for(Character letter : chars.toCharArray()) {
            charsMap.put(letter, charsMap.getOrDefault(letter, 0) + 1);
        }

        for(int i=0; i < words.length; i++) {
            String word = words[i];
            for(Character wordLetter : word.toCharArray()) {
                if(charsMap.containsKey(wordLetter) && charsMap.get(wordLetter) > 0) {
                    charsMap.put(wordLetter, charsMap.get(wordLetter) - 1);
                }
                else {
                    flag = false;
                    continue;
                }
            }

            if(flag) {
                sum += word.length();
            }

            charsMap.clear();
            flag = true;

            for(Character letter : chars.toCharArray()) {
                charsMap.put(letter, charsMap.getOrDefault(letter, 0) + 1);
            }

        }

        return sum;

    }

     */

    public static void main(String[] args) {
        FindWordsThatCanBeFormedByCharacters solution = new FindWordsThatCanBeFormedByCharacters();
        System.out.println(solution.countCharacters(new String[] {"cat", "bt", "hat", "tree"}, "atach"));
    }


}
