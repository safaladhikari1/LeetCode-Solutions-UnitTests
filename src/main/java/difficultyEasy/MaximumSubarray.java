/*
   Maximum Subarray
   
   Given an integer array nums, find the contiguous subarray (containing at least one number)
   which has the largest sum and return its sum.
   
   Follow up: If you have figured out the O(n) solution, try coding another solution using the divide
   and conquer approach, which is more subtle.
   
   Example 1:
   Input: nums = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
   Output: 6
   Explanation: [4, -1, 2, 1] has the largest sum = 6.
   
   Example 2:
   Input: nums = [1]
   Output: 1
   
   Example 3:
   Input: nums = [0]
   Output: 0
   
   Example 4:
   Input: nums = [-1]
   Output: -1
   
   ----
   
   Algorithm:
   
   1. Initialize two int variables
      maxCurrent = nums[0];
      maxResult = nums[0];
      
   2. Then loop through the nums array from index 1
      
      maxCurrent = Math.max(nums[i], maxCurrent + nums[i])
      
      if the maxCurrent is greater than maxResult
         maxResult = maxCurrent
      
   3. The above is tricky to understand but basically
      on testCase [-2, 1, -3, 4, -1, 2, 1, -5, 4]
      
      maxCurrent = -2 -> 1 -> -2 -> 4 -> 3 -> 5 -> 6 -> 1 -> 5
      maxResult = -2 -> 1 -> 4 -> 5 -> 6
      
      Explanation: https://youtu.be/gwUGDXO5gHU
      
      
      Intuition (Also explained on the above video):
      
      1. We will set the maxCurrent and maxResult to -2
      
         [-2, 1, -3, 4, -1, 2, 1, -5, 4]
         
      2. Now check, is 1 better by itself, or 1 + (-2)
         1 is better by itself, because 1-2 = -1
         
      3. Next, Is -3 better by itself, or -3 + (-1) "-1 comes from (-2 + 1 from above)"
         -2 is better
            
      4. So if you notice, we are moving asking, is 1 by itself is better or we also need to include -2?
         Is - 3 by itself better, or we also include 1 and -2 from the?
         And so on.
         
         1  ,  1 + (-2) = 1
         -3 ,  -3 + 1 = -2
         4  ,  4  - 2 = 4
         -1 ,  -1 + 4 = 3
         2  , 2 + 3 = 5
         5  , 5 + 1 = 6
         -5 , -5 + 6 = 1
         1  , 4 + 1 = 5
      
      5. And we keep track our highest sum, which will be 6 on the above example.    
          
   ----
   
   Time Complexity:
   
   O(N), where n is the number of elements in the array
   
   Space Complexity:
   
   O(1)      
   
*/

class MaximumSubarray
{
   public static void main(String[] args)
   {
      int[] testArray = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
      int[] testArray2 = {-1};
      
      System.out.println(maxSubArray(testArray));
   }
   
   public static int maxSubArray(int[] nums)
   {
      int maxCurrent = nums[0];
      int maxResult = nums[0];
      
      for(int i=1; i < nums.length; i++)
      {
         maxCurrent = Math.max(nums[i], maxCurrent + nums[i]);
         
         if(maxCurrent > maxResult)
         {
            maxResult = maxCurrent;
         }
      }
      
      return maxResult;  
   }  
}