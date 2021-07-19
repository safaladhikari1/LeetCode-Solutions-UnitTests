package difficultyEasy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Shortest Distance to a Character
 *
 * Source: https://leetcode.com/problems/shortest-distance-to-a-character/
 *
 * Algorithm:
 *
 * 1. Make an int[] result array, initialize to the same size as String s
 *
 * 2. First we loop from the left,
 *      int pre = s.length()
 *
 *      We calculate the index distance from the character index
 *          Once we visit char, pre = index in the loop
 *
 *      Otherwise, result[index] = Math.abs(index - pre)
 *
 * 3. Reset pre to 0
 *
 *    Another for loop from the back
 *
 *    Once we visit char, pre = index
 *
 *    This time, result[index] = Math.min(result[index], Math.abs(pre - index))
 *
 * 4. Return the result array
 *
 * Time-Complexity: O(N), where N is the length of String
 * Space-Complexity: O(N), space for our result array
 *
 */
public class ShortestDistanceToACharacter {

    public static void main(String[] args) {
        ShortestDistanceToACharacter solution = new ShortestDistanceToACharacter();
        System.out.println(Arrays.toString(solution.shortestToChar("aaab",'b')));
    }

    public int[] shortestToChar(String s, char c) {
        int[] result = new int[s.length()];
        int pre = s.length();

        for(int i=0; i < s.length(); i++) {
            if(s.charAt(i) == c){
                pre = i;
            }
            result[i] = Math.abs(i - pre);
        }

        pre = 0;

        for(int i=s.length() - 1; i>=0; i--){
            if(s.charAt(i) == c){
                pre = i;
            }

            result[i] = Math.min(result[i], Math.abs(pre - i));
        }

        return result;
    }

    /*
    // Brutefore solution, it works
    public int[] shortestToChar(String s, char c) {
        int[] result = new int[s.length()];
        Set<Integer> cSet = new HashSet<>();

        for(int i=0; i < s.length(); i++) {
            if(s.charAt(i) == c) {
                cSet.add(i);
            }
        }

        int min = 0;
        int finalMin = s.length();
        int resultIndex = 0;

        for(int i=0; i < s.length(); i++) {
            for(int index : cSet) {
                min = Math.abs(i - index);
                if(min < finalMin) {
                    finalMin = min;
                }
            }

            result[resultIndex] = finalMin;
            resultIndex++;
            finalMin = s.length();
        }

        return result;
    }

     */
}
