/*
   Minimum Size Subarray Sum
   
   Problem Source: https://leetcode.com/problems/minimum-size-subarray-sum/
   
   ------
   Algorithm:
   
   1. Instantiate resultSize to Integer.MAX_VALUE;
   
   2. currentSum = 0, windowLeft = 0
      windowRight is in the for loop
   
   3. Loop through the elements in the array
         Keep track of the sum in currentSum
         while(sum >= target)
            decrement the element at first index
            decrement and store the minimum size in resultSize
            
   4. Return the minimum size.
   
   Explanation: https://youtu.be/MK-NZ4hN7rs?t=1490 
   
   Time-Complexity: O(N), where N is the number of elements in the array
   Space-Complexity: O(1)

*/

class MinimumSizeSubarraySum
{
   public static void main(String[] args)
   {
      System.out.println(minSubArrayLen(7, new int[] {2, 3, 1, 2, 4, 3}));
   }
   
   public static int minSubArrayLen(int target, int[] nums)
   {
      int resultSize = Integer.MAX_VALUE;
      int currentSum = 0;
      int windowLeft = 0;
      
      for(int windowRight = 0; windowRight < nums.length; windowRight++)
      {
         currentSum += nums[windowRight];
         
         while(currentSum >= target)
         {
            resultSize = Math.min(resultSize, windowRight - windowLeft + 1);
            
            currentSum -= nums[windowLeft];
            windowLeft++;
         }
      }
      
      return (resultSize != Integer.MAX_VALUE) ? resultSize : 0;      
   }
}