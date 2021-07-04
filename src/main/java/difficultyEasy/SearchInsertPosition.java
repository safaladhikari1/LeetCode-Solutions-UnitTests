/*
   Search Insert Position
   
   Given a sorted array and a target value, return the index if the target is found.
   If not, return the index where it would be, if it were inserted in order.
   
   You may assume no duplicates in the array.
   
   Example 1:
   
   Input: [1, 3, 5, 6], 5
   Output: 2
   
   Example 2:
   
   Input: [1, 3, 5, 6], 2
   Output: 1
   
   Example 3:
   
   Input: [1, 3, 5, 6], 7
   Output: 4
   
   Example 4:
   
   Input: [1, 3, 5, 6], 0
   Output: 0
   
   ---
   
   Algorithm 1 (Linear Search):
   
   1. Loop through the nums[] array:
      
   2. Handle the edge cases first:
      
      if the target is less than nums[0]
      return index = 0;
      
      if the target is more than nums[nums.length - 1]
      return nums.length;
      
   3. Then enter the loop, make two pointers, current and next
      
      if(target >= current && target <= next)
         this means the target is between current and next (including)
         
         if the current is target
            return the i; the index
      
         otherwise, return the i + 1 (target can next or less than next)
      
   4. End of problem.
      
   Time Complexity, O(N), where N is the number of elements in the array. We are doing this in one sweep

   --------

   Algorithm 2: Binary Search Tree

   Nicely explained in article: https://leetcode.com/problems/search-insert-position/discuss/15226/Java-solution-using-Binary-Search-with-explanation-of-why-it-works

   1. We have left and right, and keep doing the regular binary search with the target. If we find the element
      in the array, we return the index.

   2. When we can't find the element in the array,

      Left also represents the lower bound of the potential positions where we can insert the elements.
      Meaning the the position (index) must be at least low or greater.

      Since low and high are already crossed each other. In this scenario:

      nums = [1, 3, 5, 6]
      target = 2

      We cannot insert at high. So we return low.

      ------

      Time-Complexity: O(Log N), where N is the number of elements in the array
      Space-Complexity: O(1)

*/

class SearchInsertPosition
{
   public static void main(String[] args)
   {
      int[] testArray = {1, 3, 5 ,6};
      int target = 2;
      
      System.out.println(searchInsert(testArray, target));
   }

   // Algorithm 2: Binary Search tree Approach
   public static int searchInsert(int[] nums, int target)
   {
      int left = 0;
      int right = nums.length - 1;

      while(left <= right)
      {
         int mid = left + (right - left)/2;

         if(target > nums[mid])
         {
            left = mid + 1;
         }
         else if(target < nums[mid])
         {
            right = mid - 1;
         }
         else
         {
            return mid;
         }
      }

      return left;

   }

   /*
   // Algorithm 1: Linear Search
   public static int searchInsert(int[] nums, int target)
   {
      int index = 0;

      if(target < nums[0])
      {
         return index;
      }

      if(target > nums[nums.length - 1])
      {
         return nums.length;
      }

      for(int i=0; i<nums.length - 1; i++)
      {
         int current = nums[i];
         int next = nums[i+1];

         if(target >= current && target <= next)
         {
            if(current == target)
            {
               return i;
            }
            else
            {
               return i+1;
            }
         }
      }

      return index;
   }
    */
}