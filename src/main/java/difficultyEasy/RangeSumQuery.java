/*
   LeetCode Problem: https://leetcode.com/problems/range-sum-query-immutable/
   
   ---
   
   Optimized Way (Caching): https://leetcode.com/problems/range-sum-query-immutable/solution/

*/

class RangeSumQuery
{  
   private class NumArray
   {
      private int[] data;
      
      public NumArray(int[] nums)
      {
         this.data = nums;
      }
      
      public int sumRange(int i, int j)
      {
         int startIndex = i;
         int endIndex = j;
         
         int sum = 0;
         
         for(int k = startIndex; k <= endIndex; k++)
         {
            sum += data[k];
         }
         
         return sum;
      }     
   }
}