package difficultyEasy;

/**
 * Number of Segments in a String
 *
 * Problem source: https://leetcode.com/problems/number-of-segments-in-a-string/
 *
 * Algorithm:
 *
 * 1. For example in,
 *
 *      "Hello, my name is John"
 *
 *    We are looping through every characters in the String, and checking
 *    if the character at i is not whitespace, and if the character at i-1 is the whitespace
 *      count++
 *
 *    It works starting from second word (segment), so we also have to put in i==0, to include the first word
 *
 * 2. At the end, return the count
 *
 * Time-Complexity: O(N), N is the number of characters in the string
 * Space-Complexity: O(1)
 *
 * Another Approach using String's built in split method: https://leetcode.com/problems/number-of-segments-in-a-string/solution/
 *
 */
public class NumberOfSegmentsInAString {

    public static void main(String[] args) {
        NumberOfSegmentsInAString solution = new NumberOfSegmentsInAString();
        System.out.println(solution.countSegments("Hello, my name is John"));
        System.out.println(solution.countSegments(""));

        System.out.println(solution.countSegments(", , , ,        a, eaefa"));
    }

    public int countSegments(String s) {
        int count = 0;

        for(int i = 0 ; i < s.length(); i++) {
            if(s.charAt(i) != ' ' && (i == 0 || s.charAt(i - 1) == ' ')) {
                count++;
            }
        }

        return count;
    }

    /*
    public int countSegments(String s) {

        if(s.length() == 0) {
            return 0;
        }

        return s.split(" ").length;
    }

     */
}
