/*
   Find Pivot Index
   
   Problem Source: https://leetcode.com/problems/find-pivot-index/
   
   --------
   
   Algorithm:
   
   1. 
   
   Pivot means sum of its left side equals sum of its right side. It is equivalent to sum of left side * 2 == total - value of the pivot, as implemented in the code.
   
   This is true because: total = sum of left + sum of right + value of the pivot. 
   
   Then we need sum of left == sum of right, so we have total = 2 * sum of left + value of the pivot. In the code, it is written as sum * 2 == total - nums[i].
   
   2. Do the first for loop, get the total Sum of the array
   
   3. On second for loop,
   
         if(2 * leftSum == totalSum - nums[i])
         {
            return i;
         }
         
         leftSum += nums[i];
         
      i is the index.
      
   4. Otherwise, return -1.
   
   ----------
   
   Time-Complexity: O(N), where N is the length of nums array
   Space-Complexity: O(1)     
   
*/


class FindPivotIndex
{
   public static void main(String[] args)
   {
      System.out.println(pivotIndex(new int[] {1, 7, 3, 6, 5, 6}));   
   }
   
   public static int pivotIndex(int[] nums)
   {
      int totalSum = 0;
      int leftSum = 0;
      
      for(int i=0; i < nums.length; i++)
      {
         totalSum += nums[i];
      }
      
      for(int i=0; i < nums.length; i++)
      {
         if(2 * leftSum == totalSum - nums[i])
         {
            return i;
         }
         
         leftSum += nums[i];
      }
      
      return -1;
      
   }
}