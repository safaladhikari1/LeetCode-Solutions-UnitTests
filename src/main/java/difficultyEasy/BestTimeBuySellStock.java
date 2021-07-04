/*
   Best Time to Buy and Sell Stock
   
   Problem source: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
   
   ---
   
   Algorithm (Approach 1):
   
   1. Let's say we have an array of prices:
   
      [7, 1, 5, 3, 6, 4]
      
      The best profit is when the buying price is low, and selling price is all time high after the buying price.
      
      So, when buying price is 1
          the all time high selling price is 6
          
          6 - 1 = 5, which is the maximum profit
          
   2. So we can treat this as a sliding window approach:
   
      At first,
      
      we will initialize maxProfit to 0
      
      our windowStart will point at 7
      our windowEnd will point at 1
      
      We will first check if prices[windowEnd] - prices[windowStart] > maxProfit
         If that's the case, we will store the maxProfit
         
      On this case, it's not, 1 - 7 is -6
      
   3. Then inside while loop, we will check if the buying price (prices[windowStart]) is greater than selling price (prices[windowEnd])
         On that case, we will need to increment windowStart++
         
         because we want our buying price to be low
         And selling price to be high

         This will make sure that, windowStart is always pointing at prices[windowStart] that is less than prices[windowEnd]
         
   4. At the end return the maxProfit. 
   
   -----
   
   Approach 2:
   
   1. We can modify approach 1 
      
      where instead of windowStart, we can have currentPrice that tracks the price of prices[windowStart]
      
   2. When the selling price, prices[windowEnd] is less than the currentPrice
      We will assign the selling price to the currentPrice
      
      We could say, currentPrice is the buying price, because we are trying to keep currentPrice low, selling price, sellingprice[windowEnd] high
      
                     
   ------
   
   Time-Complexity: O(N), where N is the number of elements in the array
   Space-Complexity: O(1)   
         

*/

class BestTimeBuySellStock
{
   public static void main(String[] args)
   {
      System.out.println(maxProfit(new int[] {7, 1, 5, 3, 6, 4}));
      
      System.out.println(maxProfit(new int[] {7, 6, 4, 3, 1}));
      
      System.out.println(maxProfit(new int[] {2, 1, 2, 1, 0, 1, 2}));
   }
   
   // Approach 2
   public static int maxProfit(int[] prices)
   {
      int currentPrice = prices[0];
      int maxProfit = 0;
      
      for(int windowEnd = 1; windowEnd < prices.length; windowEnd++)
      {
         if(prices[windowEnd] - currentPrice > maxProfit)
         {
            maxProfit = prices[windowEnd] - currentPrice;
         }
         
         else if(currentPrice > prices[windowEnd])
         {
            currentPrice = prices[windowEnd];
         }         
      }
      
      return maxProfit;      
   }
   
   // Approach 1
   /*
   public static int maxProfit(int[] prices)
   {
      int windowStart = 0;
      int maxProfit = 0;
      
      for(int windowEnd = 1; windowEnd < prices.length; windowEnd++)
      {
         if(prices[windowEnd] - prices[windowStart] > maxProfit)
         {
            maxProfit = prices[windowEnd] - prices[windowStart];
         }
         
         while(prices[windowStart] > prices[windowEnd])
         {
            windowStart++;
         }         
      }
      
      return maxProfit;      
   }
   */
}