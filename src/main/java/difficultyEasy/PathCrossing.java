import java.util.HashSet;
import java.util.Set;

/**
 * Path Crossing
 * Problem Source: https://leetcode.com/problems/path-crossing/
 *
 * Algorithm:
 *
 * Source: https://leetcode.com/problems/path-crossing/discuss/709216/JavaPython-3-Using-Set-to-check-duplicate-w-brief-explanation-and-analysis./596645
 *
 * 1. The key to solving the problem is how to check the coordinate repeat.
 * 2. We do that by creating a HashSet that stores String coordinates in the form (x + "," + y)
 *    And we add, Set.add(x + "," + y)
 *
 * 3. Just like how it's on the graph paper with x axis and y axis
 *    As we are looping through the characters in the string
 *
 *    We are incrementing and decrementing our x and y.
 *
 * 4. At any point if we can't add a coordinate i.e. (x + "," + y)
 *    Since Set can't have duplicates
 *    That means we have visited that point, return true.
 *
 *    Otherwise return false.
 *
 * Time-Complexity: O(N), where N is the characters in the string
 * Space-Complexity: O(N), we use N space for our HashSet to store the string coordinates.
 *
 */

public class PathCrossing {
    public static void main(String[] args) {
        System.out.println(isPathCrossing("NES"));
    }

    /**
     * Returns true/false if the path crosses itself at any point
     *
     * @param path String of the path
     * @return true/false
     */
    public static boolean isPathCrossing(String path) {
        Set<String> letterSet = new HashSet<>();
        int x = 0;
        int y = 0;
        letterSet.add(x + "," + y);

        for(int i=0; i < path.length(); i++){
            if(path.charAt(i) == 'N') {
                y++;
            }
            else if(path.charAt(i) == 'S') {
                y--;
            }
            else if(path.charAt(i) == 'E') {
                x++;
            }
            else if(path.charAt(i) == 'W') {
                x--;
            }

            if(!letterSet.add(x + "," + y)) {
                return true;
            }
        }

        return false;
    }
}
