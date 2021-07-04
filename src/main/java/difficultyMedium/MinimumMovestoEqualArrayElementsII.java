/*
   Minimum Moves to Equal Array Elements II
   
   Given a non-empty integer array, find the minimum number of moves required to make all array
   elements equal, where a move is incrementing a selected element by 1 or decrementing a selected
   element by 1.
   
   You may assume the array's length is at most 10,000.
   
   Example:
   
   Input: [1, 2, 3]
   Output: 2
   
   [1, 2, 3] -> [2, 2, 3] -> [2, 2, 2], Only two moves are needed (each move increments or decrements one element)
   
   ---------
   Algorithm:
   
   Approach 1: 
   
   1. Explanation on:
   
      https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/discuss/94937/Java(just-like-meeting-point-problem)
      
      https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/discuss/348513/faster-than-98-memory-less-than-100-java-solution-with-explanation
   
   Approach 2:
   
   1. Using quickselect
   
      https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/discuss/964504/1ms-and-beating-100-Quickselect-detailed-solution-with-Hoare-partition-and-median-of-3   
   
*/



import java.util.Arrays;

class MinimumMovestoEqualArrayElementsII
{
   public static void main(String[] args)
   {
      System.out.println(minMoves2(new int[] {1, 2, 3}));
   }
   
   public static int minMoves2(int[] nums)
   {
      int result = 0;
      
      Arrays.sort(nums);
      
      int left = 0, right = nums.length - 1;
      
      while(left < right)
      {
         result += nums[right] - nums[left];
         
         left++;
         right--;
      }
      
      return result;     
   }
   
   /*
   public static int minMoves2(int[] nums)
   {
      int result = 0;
      
      int sum = nums[0];
      
      for(int i=1; i<nums.length; i++)
      {
         sum += nums[i];
      }
      
      int median = sum/nums.length;
      
      for(int n : nums)
      {
         result += Math.abs(n - median);
      }
           
      return result;
           
   }
   */
}