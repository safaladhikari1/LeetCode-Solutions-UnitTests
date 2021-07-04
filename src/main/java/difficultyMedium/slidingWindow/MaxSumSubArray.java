/*
   Find the max sum subarray of a fixed size K
   
   Example:
   
   Input: [4, 2, 1, 7, 8, 1, 2, 8, 1, 0], K = 3
   
   Output: 16
   
   ---
   
   Algorithm:
   
   1. Keep the currentSum for the first 3 elements
   2. Then, store the largest
   3. Drop the 1st element, go after the next three elements.
   
   Explanation: https://youtu.be/MK-NZ4hN7rs
   
   Time-Complexity: O(N), where N is the number of elements in the array
   Space-Complexity: O(1)

*/

class MaxSumSubArray
{
   public static void main(String[] args)
   {
      System.out.println(findMaxSubArray(new int[] {4, 2, 1, 7, 8, 1, 2, 8, 1, 0}, 3));   
   }
   
   public static int findMaxSubArray(int[] nums, int k)
   {
      int currentSum = 0;
      int maxSum = Integer.MIN_VALUE;
      
      for(int i = 0; i < nums.length; i++)
      {
         currentSum += nums[i];
         
         if(i >= (k - 1))
         {
            maxSum = Math.max(maxSum, currentSum);
            
            currentSum -= nums[i - (k - 1)];
         }
      }
      
      return maxSum;
   }
}