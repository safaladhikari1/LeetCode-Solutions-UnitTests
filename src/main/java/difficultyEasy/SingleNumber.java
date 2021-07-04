/*
   Single Number
   
   Given a non-empty array of integers nums, every element appears twice except
   for one. Find that single one.
   
   Follow up: Could you implement a solution with a linear runtime complexity and 
   without using extra memory?
   
   Example 1:
   
   Input: nums = [2, 2, 1]
   Output: 1
   
   Example 2:
   
   Input: nums = [4, 1, 2, 1, 2]
   Output: 4
   
   Example 3:
   
   Input: nums = [1]
   Output: 1
   --------------------------------
   
   Algorithm:
   
   1. we create a hash table, using HashMap
   2. We loop through the elements in the array
      
      We put the array element as key, 1 as value
      as (key, value pairs)
   
   3. If we find that the array element is already in the hash map
      
      we increment, the value of that hash map by 1.
   4. We loop through the hash map one more time,
      
      This time we are checking, if any of the array element's value is 1.
      If it does, we know that it didn't contain duplictes
      
      So we return that array element.
      
   -------
   
   Time-Complexity:
   
   O(N), where N is the number of elements in the array, that we had to put in our hash table.
   
   Space-Complexity:
   
   O(N), where N is the number of elements we stored on our hash table. 
   
*/

import java.util.*;

class SingleNumber
{
   public static void main(String[] args)
   {
      int[] testArray1 = {2, 2, 1};
      int[] testArray2 = {4, 1, 2, 1, 2};
      
      System.out.println(singleNumber(testArray1));
   }
   
   public static int singleNumber(int[] nums)
   {
      HashMap<Integer, Integer> myMap = new HashMap<>();
      
      for(int i=0; i<nums.length; i++)
      {
         if(myMap.containsKey(nums[i]))
         {
            myMap.put(nums[i], myMap.get(nums[i]) + 1);
         }
         else
         {
            myMap.put(nums[i], 1);
         }
      }
      
      for(int i = 0; i < nums.length; i++)
      {
         if(myMap.get(nums[i]) == 1)
         {
            return nums[i];
         }
      }
           
      return 0;
   }
}