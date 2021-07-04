/*
   Two Sum II - Input array is sorted
   
   Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
   
   The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
   
   Example:
   
   Input: numbers = [2,7,11,15], target = 9
   Output: [1,2]
   Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
   
   -------------
   
   Algorithm:
   
   1. We do it via using HashMap, with <Integer, Integer> key value pairs.
   
      For example on our array [2,7,11,15]
      
         We loop over each elements in the array, store on our HashMap, with key as the array element, value as 1 (incrementing for each element)
      
   2. Then we loop over the array again,
         This time, we check the difference.
         
         If our map contains the difference, and if the index of that difference is greater than our array element in the loop.
            We return by creating a new array with, index of the loop + 1, index of the difference by using the get method on the map.
            
       Otherwise return the empty array.
       
    -------------- 
    
    Time-Complexity: O(N), N is the number of elements in the array at least once. In worst case, we loop every elements in the array twice.
    Space-Complexity: O(N), We store all the N number of elements in our HashMap.            
       
*/


import java.util.HashMap;
import java.util.Arrays;

class TwoSum2InputArraySorted
{
   public static void main(String[] args)
   {
      System.out.println(Arrays.toString(twoSum(new int[] {2, 7, 11, 15}, 9)));
      System.out.println(Arrays.toString(twoSum(new int[] {0, 0, 3, 4}, 0)));
   }
   
   public static int[] twoSum(int[] nums, int target)
   {     
      HashMap<Integer, Integer> myMap = new HashMap<>();
      
      for(int i=0; i < nums.length; i++)
      {
         myMap.put(nums[i], i+1);
      }
      
      for(int i=0; i < nums.length; i++)
      {
         int difference = target - nums[i];
         
         if(myMap.containsKey(difference) && myMap.get(difference) > i+1)
         {
            return new int[] {i+1, myMap.get(difference)};
         }
      }
      
      return new int[] {};
   }
}