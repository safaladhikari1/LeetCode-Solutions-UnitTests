/*
   Minimum Moves to Equal Array Elements
   
   Given a non-empty integer array of size n, find the minimum number of moves required to make all
   array elements equal, where a move is incrementing n-1 elements by 1.
   
   Example:
   
   Input: [1, 2, 3]
   Output: 3
   
   [1, 2, 3] -> [2, 3, 3] -> [3, 4, 3] -> [4, 4, 4], only three moves are needed.
   Since n is 3, each move only increments two elements.
   
   -------
   
   Algorithm:
   
   1. Based on vegito2002's post on https://leetcode.com/problems/minimum-moves-to-equal-array-elements/discuss/93815/Java-O(n)-solution.-Short.   
      
      My understanding is:
      
      "To equalize all elements with minimum number of moves (incrementing n-1 elements by 1)
      
      is equivalent to
      
      decrementing all elements to be equal to the min value."
      
   2. With the above understanding, we have 
      
      result = 0
      min = nums[0]
      
      The first for loop, will give us the minimum element in the entire array
      
      for(int i=1; i < nums.length; i++)
      {
         min = Math.min(nums[i], min);
      }
      
      The second for loop, will keep track of the number of times result has to increment
      To make all the elements in the array, equal to minimum element.
      
   3. Return result
   
   ------------
   
   Time-Complexity: O(N), we only loop through the elements in the array twice. N is the number of elements in the array.
   Space-Complexity: O(1), no additional space is needed.              

*/

class MinimumMovesToEqualArrayElements
{
   public static void main(String[] args)
   {
      System.out.println(minMoves(new int[] {1, 2, 3}));
   }
   
   public static int minMoves(int[] nums)
   {
      int result = 0;
      
      int min = nums[0];
      
      for(int i=1; i < nums.length; i++)
      {
         min = Math.min(nums[i], min);
      }
      
      for(int n : nums)
      {
         result += (n - min);   
      }
      
      return result;
   }
}