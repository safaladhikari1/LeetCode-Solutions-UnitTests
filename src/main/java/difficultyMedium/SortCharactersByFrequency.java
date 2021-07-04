import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Sort Characters by Frequency
 *
 * Problem Source: https://leetcode.com/problems/sort-characters-by-frequency/
 *
 * Algorithm:
 *
 * 1. Loop through the characters of the String, and add it to the Hash Map
 *    Map<Character, Integer>
 *
 * 2. Store the count of every character, (t, 1), (r, 1), (e, 2)
 *
 * 3. Make a Priority Queue; with a constructor that lets us prioritize entity, based on entity value in decreasing order
 *
 *     PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
 *
 *     a.getValue = b.getValue, would have given us increasing order.
 *
 * 4. Add all the Map's entity to Priority Queue
 *
 * 5. While the priority queue is not empty
 *      remove the entity
 *      Loop up to the value of that entity
 *          Append the character to the string builder
 *
 * 6. Return the String
 *
 * -----
 * Time-Complexity: O(N), where N is the characters of the String
 * Space-Complexity: O(N) for the space used by our HashMap and Priority Queue.
 *
 */
public class SortCharactersByFrequency {

    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));
        System.out.println(frequencySort("Aabb"));
    }

    public static String frequencySort(String s) {
        Map<Character, Integer> characterCount = new HashMap<>();
        StringBuilder result = new StringBuilder();

        for(int i=0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            characterCount.put(ch, characterCount.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        pq.addAll(characterCount.entrySet());

        while(!pq.isEmpty()) {
            Map.Entry<Character, Integer> entity = pq.remove();
            for(int i=0; i < entity.getValue(); i++) {
                result.append(entity.getKey());
            }
        }

        return result.toString();
    }

    // Brute force solution, does not work
    /*
    public static String frequencySort(String s) {
        Map<Character, Integer> characterCount = new TreeMap<>();
        StringBuilder result = new StringBuilder();

        for(int i=0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            characterCount.put(ch, characterCount.getOrDefault(ch, 0) + 1);
        }

        for(Map.Entry<Character, Integer> entry : characterCount.entrySet()) {
            for(Integer count : characterCount.values()) {
                result.append(entry.getKey());
            }
        }

        return result.toString();
    }

     */
}
