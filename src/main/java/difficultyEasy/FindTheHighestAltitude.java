package difficultyEasy;

/**
 * Find the Highest Altitude
 *
 * Problem Source: https://leetcode.com/problems/find-the-highest-altitude/
 *
 * Algorithm:
 *
 * 1. Initiate altitude and maxAltitude to 0
 *    Inside the for loop
 *      Keep track of altitude by adding gain[i] to altitude
 *      Store the highest altitude in maxAltitude
 * 2. Return maxAltitude
 *
 * Time-Complexity: O(N), N is the number of elements in gain array
 * Space-Complexity: O(1)
 */
public class FindTheHighestAltitude {

    public static void main(String[] args) {
        FindTheHighestAltitude solution = new FindTheHighestAltitude();
        System.out.println(solution.largestAltitude(new int[] {-5, 1, 5, 0, -7}));

        System.out.println(solution.largestAltitude(new int[] {-4, -3, -2, -1, 4, 3, 2}));
    }

    public int largestAltitude(int[] gain) {
        int altitude = 0, maxAltitude = 0;

        for(int i=0; i < gain.length; i++) {
            altitude += gain[i];
            maxAltitude = Math.max(altitude, maxAltitude);
        }

        return maxAltitude;
    }
}
