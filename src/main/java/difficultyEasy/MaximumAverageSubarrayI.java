/*
   Maximum Average Subarray I
   
   Problem Source: https://leetcode.com/problems/maximum-average-subarray-i/
   
   ------
   
   Algorithm:
   
   1. We are using sliding window,
      
      initialize windowLeft to 0
      maxAverage to Integer.MIN_VALUE, because the elements in the array are negative as well [-10,000, 10,000], so the average might come out negative for some test cases.
      intialize currentSum to 0
      counter = 0
      
   2. for loop has windowRight
   
      increment the counter
      add nums[windowRight] to currentSum
      
      if(counter == k)
         get the average until now, store it in maxAverage
         subtract the nums[windowLeft] from the currentSum, because windowLeft is initially at 0
         Then increment windowLeft++
         Decrement the counter
         
   3. The above process continues, until windowRight is at the end of nums array
   
   ------
   
   Time-Complexity: O(N), we visit all elements in the array once.
   Space-Complexoty: O(1)

*/


class MaximumAverageSubarrayI
{
   public static void main(String[] args)
   {
      System.out.println(findMaxAverage(new int[] {1, 12, -5, -6, 50, 3}, 4)); 
      
      System.out.println(findMaxAverage(new int[] {-1}, 1));  
   }
   
   /*
   public static double findMaxAverage(int[] nums, int k)
   {
      int windowLeft = 0;
      double maxAverage = Integer.MIN_VALUE;
      double currentSum = 0;
      int counter = 0;
      
      for(int windowRight = 0; windowRight < nums.length; windowRight++)
      {
         counter++;
         currentSum += nums[windowRight];
         
         if(counter == k)
         {
            maxAverage = Math.max(maxAverage, (currentSum / k));
            currentSum -= nums[windowLeft];
            windowLeft++;
            counter--;
         }        
      }

      return maxAverage;     
   }
   */
   
   // Modified Sliding window, also works.
   public static double findMaxAverage(int[] nums, int k)
   {      
      
      double maxAverage = Integer.MIN_VALUE;
      double currentSum = 0;
      
      for(int windowRight = 0; windowRight < nums.length; windowRight++)
      {
         currentSum += nums[windowRight];
         
         if(windowRight >= (k - 1))
         {
            maxAverage = Math.max(maxAverage, currentSum);
            currentSum -= nums[windowRight - (k - 1)];
         }        
      }

      return maxAverage / k;      
   }
}