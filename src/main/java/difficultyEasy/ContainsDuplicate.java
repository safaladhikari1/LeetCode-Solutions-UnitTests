/*
   Contains Duplicate
   
   Given an array of integers, find if the array contains any duplicates.

   Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
   
   Example 1:
   Input: [1, 2, 3, 1]
   Output: true
   
   Example 2:
   Input: [1, 2, 3, 4]
   Output: false
   
   Example 3:
   Input: [1, 1, 1, 3, 3, 4, 3, 2, 4, 2]
   Output: true
   
   -------
   
   Algorithm:
   
   1. Simple, just create a HashSet same as length as the nums array
   2. loop through the nums array
      
      add the nums[i] to the hash set
      if hashset already contains nums[i], that it means it contains duplicates, return true
   3. Otherwise, return false.
   
   --------
   
   Time-Complexity: O(N), where N is the number of elements in the array. Worst case we loop through all the elements in the array and add to HashSet.
   Space-Complexity: O(N), where N is the number of elements in the array, the space used by hash set is linear with the number of elements in the array.   
   
*/

import java.util.HashSet;

class ContainsDuplicate
{
   public static void main(String[] args)
   {
      int[] testArray1 = {1, 2, 3, 1};
      
      int[] testArray2 = {1, 2, 3, 4};
      
      int[] testArray3 = {0};
      
      int[] testArray4 = {3, 3};
      
      System.out.println(containsDuplicate(testArray4));
   }
   
   
   public static boolean containsDuplicate(int[] nums)
   {
      HashSet<Integer> mySet = new HashSet<>(nums.length);
      
      for(int i=0; i<nums.length; i++)
      {
         if(mySet.contains(Integer.valueOf(nums[i])))
         {
            return true;
         }
         
         mySet.add(Integer.valueOf(nums[i]));
      }
      
      return false;
   }
}