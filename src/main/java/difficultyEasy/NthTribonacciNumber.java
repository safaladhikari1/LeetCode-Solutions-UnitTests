/**
 * N-th Tribonacci Number
 *
 * Problem Source: https://leetcode.com/problems/n-th-tribonacci-number/
 *
 * Algorithm:
 *
 * 1. This is similar to finding the Fibonacci Sequence,
 *
 *    Recursive way of Fibonacci: https://www.geeksforgeeks.org/different-ways-to-print-fibonacci-series-in-java/
 *    https://www.guru99.com/fibonacci-series-java.html
 *
 * 2. In fibonacci, we have
 *    0, 1, 1, 2, 3, 5, 8, 13
 *
 *    Where we are adding the last two numbers for our next number
 *
 *    We knew that
 *    if n is 0, return 0
 *    if n is 1, return 1
 *    if n is 2, return 2
 *    that's our base cases
 *
 *    Then just bring the n down in the recursion, and
 *    add the sum of last two numbers for our next number
 *    return f(n-2) + f(n-1)
 *
 * 3. Similarly, in tribonacci we know our base cases:
 *
 *    0, 1, 1, 2, 4, 7
 *
 *    if n is 0, return 0
 *    if n is 1, return 1
 *    if n is 2 return 1
 *
 *    instead of adding the sum of last two numbers, we add last three numbers
 *    return f(n-3) + f(n-2) + f(n-1);
 *
 * 4. Then we do memoization, so we are not calculating the same results again again for the same n
 *    See here for memoization with pictures: https://github.com/safaladhikari1/CodingProblems/tree/master/LeetCode/Easy/ClimbingStairs
 *
 *    Our memo table has n + 1 size,
 *    because we are bringing the n down to 0, 1 and 2
 *    We also have to account for the result, when n is 0 and store it in our memo table.
 *
 * Time-Complexity: O(N), N is the input size
 * Space-Complexity: O(N), for the space used in memo array to store the result of our sub problem.
 */

public class NthTribonacciNumber {
    public static void main(String[] args) {
        System.out.println(tribonacci(4));
    }

    /**
     * Returns the value of T(n), in Tribonacci sequence.
     * @param n the input N.
     * @return the result of the T(n)
     */
    public static int tribonacci(int n) {
        int[] memo = new int[n + 1];
        return  tribonacciHelper(memo, n);
    }

    private static int tribonacciHelper(int[] memo, int n) {
        if(n == 0) {
            return 0;
        }
        else if(n == 1) {
            return 1;
        }
        else if(n == 2) {
            return 1;
        }else if(memo[n] > 0) {
            return memo[n];
        }

        memo[n] =  tribonacciHelper(memo, n - 3) + tribonacciHelper(memo, n - 2) + tribonacciHelper(memo,n - 1);

        return memo[n];
    }
}
