package difficultyEasy;

/**
 * Three Divisors
 *
 * Problem source: https://leetcode.com/problems/three-divisors/
 *
 * Algorithm:
 *
 * 1. Initialize m = 1, count to 0
 * 2. Count the number of divisors, up to n
 * 3. Check if count is 3, if it is return true, else false.
 *
 * Time-Complexity: O(N), where N is the input int.
 * Space-Complexity = O(1)
 *
 * Another efficient approach:
 *
 * https://leetcode.com/problems/three-divisors/discuss/1377575/Easy-JAVA-100-solution
 * https://leetcode.com/problems/three-divisors/discuss/1375566/Square-of-Prime-O(1)
 */
public class ThreeDivisors {

    public static void main(String[] args) {
        ThreeDivisors solution = new ThreeDivisors();
        System.out.println(solution.isThree(2));
        System.out.println(solution.isThree(4));
    }

    public boolean isThree(int n) {
        int m = 1;
        int count = 0;

        while(m <= n) {
            if(n % m == 0) {
                count++;
            }
            m++;
        }

        return count == 3;
    }

}
