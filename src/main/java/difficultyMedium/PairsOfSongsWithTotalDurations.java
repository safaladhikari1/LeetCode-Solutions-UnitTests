/**
 * Pairs of Songs With Total Durations Divisible by 60
 *
 * Problem Source: https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/
 *
 * Algorithm:
 *
 * Approach 1 (Bruteforce Approach):
 *
 * 1. Iterating through the entire array twice, such that for each item in time, we iterative through the
 *    the rest of the array, to check time[i] + time[j]) % 60 == 0
 *
 * Time-Complexity: O(N^2), where N is the length of the input array
 * Space-Complexity: O(1)
 *
 * Approach 2: Another Efficient Approach using an array to store frequencies
 *
 * Explained on https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/solution/
 *
 */

public class PairsOfSongsWithTotalDurations {
    public static void main(String[] args) {
        System.out.println(numPairsDivisibleBy60(new int[] {30, 20, 150, 100, 40}));
    }

    // Approach 1: Bruteforce Approach
    public static int numPairsDivisibleBy60(int[] time) {
        int count = 0;

        for(int i=0; i < time.length; i++) {
            for(int j=i+1; j < time.length; j++) {
                if((time[i] + time[j]) % 60 == 0) {
                    count++;
                }
            }
        }

        return count;
    }
}
