import java.util.Arrays;
import java.util.Stack;

/**
 * Final Prices With a Special Discount in a Shop
 *
 * Problem Source: https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/
 *
 * Algorithm:
 *
 * Approach 1: Using Brute Force
 *
 * 1. Use a double for loop,
 *      i starts at 0
 *      j starts at i + 1
 *
 *      So, i needs to end at prices.length - 1
 *      j can go all the way to prices.length
 *
 * 2. Per condition,
 *
 *      j will always be greater than i
 *      if prices[i] >= prices[j]
 *          prices[i] -= prices[j], prices[i] will get the discount
 *
 *      We don't have to check the remaining of j, break in that particular j iteration of inner loop
 *
 * 3. Return the prices array.
 *
 * Time-Complexity: O(N^2), for double for loop
 * Space-Complexity: O(1)
 *
 * ------
 *
 * Approach 2: Using Monotone Stack
 *
 * 1. On approach 1, we had to use double for loop, to check
 *
 *      if prices[i] >= prices[j], when j is greater than i
 *
 * 2. Using monotone stack, we can do a one pass and check
 *
 *    if we have prices[i] >= prices[j], when j is greater than i
 *
 * 3. We create a stack and do our one pass for loop
 *
 *    this condition,
 *
 *        while (!monoStack.empty() && prices[monoStack.peek()] >= prices[i]){
 *            prices[monoStack.pop()] -= prices[i];
 *        }
 *        monoStack.push(i);
 *
 *    For example: [8, 4, 6, 2, 3]
 *
 *    When i = 0
 *    the stack is empty, we will store the index, 0
 *
 *    When i = 1
 *    the stack is not empty, and
 *    prices[monoStack.peek()] >= prices[i]
 *    prices[0] >= prices[1]
 *    8 >= 4
 *
 *    So, we
 *    prices[monoStack.pop()] -= prices[i];
 *    prices[0] -= prices[1]
 *    prices[0] = 8 - 4;
 *    prices[0] = 4
 *
 *    Then we store index 1, to our mono stack.
 *
 *    When i = 2,
 *
 *    Since prices[monoStack.peek()] >= prices[i]) is not true
 *    prices[1] >= prices[2] is not true
 *
 *    When i = 3,
 *    prices[monoStack.peek()] >= prices[i]) is true, and the same operation happens like above.
 *
 * 4. More info on mono stack: https://github.com/safaladhikari1/CodingProblems/blob/master/LeetCode/Medium/MonotoneStack/MonotoneStack.java
 *
 * Time-Complexity: O(N), N is the number of elements in the array
 * Space-Complexity: O(N), on worse case we may have to store all N elements in stack.
 *
 */
public class FinalPricesWithASpecialDiscountInAShop {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(finalPrices(new int[] {8, 4, 6, 2, 3})));
    }

    // Approach 2: Using Monotone increasing stack
    public static int[] finalPrices(int[] prices) {
        Stack<Integer> monoStack = new Stack<>();

        for(int i=0; i < prices.length; i++) {
            while (!monoStack.empty() && prices[monoStack.peek()] >= prices[i]){
                prices[monoStack.pop()] -= prices[i];
            }
            monoStack.push(i);
        }

        return prices;
    }

    // Approach 1: Using Brute force Approach
    /*
    public static int[] finalPrices(int[] prices) {
        for(int i=0; i < prices.length - 1; i++) {
            for(int j=i+1; j < prices.length; j++) {
                if(prices[i] >= prices[j]) {
                    prices[i] = prices[i] - prices[j];
                    break;
                }
            }
        }

        return prices;
    }

     */
}
