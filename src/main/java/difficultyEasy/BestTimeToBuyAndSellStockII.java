/**
 * Best Time to Buy and Sell Stock II
 *
 * Problem Source: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 *
 * Algorithm:
 *
 * 1. We are using sliding window, with windowLeft and windowRight
 * 2. windowLeft is pointing at index 0, windowRight is pointing at index 1, maxProfit is 0 at the beginning
 * 3. Calculate the price difference  = prices[windowRight] - prices[windowLeft] inside the for loop
 * 4. if the price difference is negative, move the windowLeft = windowRight
 * 5. If the price difference is positive, add it to the maxProfit
 * 6. windowLeft is representing buying,
 *    windowRight is representing selling
 *
 *    Since we can buy one and sell one share of stock multiple times
 *    we are adding the profit multiple times.
 * 7. At the end, return the maxProfit
 *
 * Time-Complexity: O(N), where N is the number of elements in the array
 * Space-Complexity: O(1)
 *
 */

public class BestTimeToBuyAndSellStockII {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[] {7, 1, 5, 3, 6, 4}));

        System.out.println(maxProfit(new int[] {1, 2, 3, 4, 5}));

        System.out.println(maxProfit(new int[] {7, 6, 4, 3, 1}));
    }

    public static int maxProfit(int[] prices) {
        int windowLeft = 0;
        int maxProfit = 0;

        for(int windowRight = 1; windowRight < prices.length; windowRight++) {

            int priceDifference = prices[windowRight] - prices[windowLeft];

            if(priceDifference < 1) {
                windowLeft = windowRight;
            }
            else if(priceDifference >= 1) {
                maxProfit += priceDifference;
                windowLeft = windowRight;
            }
        }

        return maxProfit;
    }
}
