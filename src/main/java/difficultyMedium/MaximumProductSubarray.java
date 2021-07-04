/*
   Problem Source: https://leetcode.com/problems/maximum-product-subarray/
   
   --------
   
   Algorithm:
   
   1. Sweep from left, track the running product and get the maximum running product
      from left side.
      
   2. Sweep from right, do the same as above and get the maximum running product from
      right side.
      
   3. The maximum running product from left and right side is our answer.
      
      Logic: https://leetcode.com/problems/maximum-product-subarray/discuss/126428/1ms-beats-100-java-solns-O(n)t-O(1)m-just-loop-once-in-each-direction-no-need-of-complex-indices
   
   -------   
   Time-Complexity: O(N), N is the number of elements in the array
   Space-Complexity: O(1)         
*/


class MaximumProductSubarray
{
   public static void main(String[] args)
   {
      System.out.println(maxProduct(new int[] {2, 3, -2, 4}));
   }
   
   public static int maxProduct(int[] nums)
   {
      if(nums.length == 1)
      {
         return nums[0];
      }
      
      int runningProduct = 0;
      int leftMax = 0;
      int rightMax = 0;
      
      // sweep from left
      for(int i=0; i < nums.length; i++)
      {
         if(runningProduct == 0)
         {
            runningProduct = nums[i];
         }
         else
         {
            runningProduct *= nums[i];
         }
         
         leftMax = Math.max(runningProduct, leftMax);
      }
      
      // reset runningProduct
      runningProduct = 0;
      
      // sweep from right      
      for(int i = nums.length - 1; i >=0; i--)
      {
         if(runningProduct == 0)
         {
            runningProduct = nums[i];
         }
         else
         {
            runningProduct *= nums[i];
         }
         
         rightMax = Math.max(runningProduct, rightMax);
      }
      
      return Math.max(leftMax, rightMax);       
   }
}