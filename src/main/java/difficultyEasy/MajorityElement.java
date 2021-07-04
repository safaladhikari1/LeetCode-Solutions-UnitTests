/*
   Majority Element
   
   Given an array of size n, find the majority element. The majority element is the
   element that appears more than [n/2] times.
   
   You may assume that the array is non-empty and the majority element always exist in the array.
   
   Example 1:
   Input: [3, 2, 3]
   
   Example 2:
   Input: [2, 2, 1, 1, 1, 2, 2]
   Output: 2
     
   -----  
  
   Algorithm (Approach 1):
   
   Using HashMap
   
   1. Calculate the threshold first, using nums.length / 2
   
   2. Use a for each loop, and put all the elements in the array in the map using key, value pairs. Element is the key. Initially value is the 1.
      If the element appears more than once, increment the value by 1.
      
   3. Then, check the map again for any values which is more than threshold
      If there is, return the key, of that value, which is our majority element.
      
      Otherwise return -1.
      
   ---------
   
   Time-Complexity: O(N), where N is the number of elements in the array because we make a constant time HashMap insertion on each iteration on for each loop.
   Space-Complexity: O(N), where N is the number of elements in the array, because Hashmap occupies O(N) space       
   
   -------
   Approach 2: https://leetcode.com/problems/majority-element/solution/
   
   Check out other approaches, that does not use HashMap.
   
*/

import java.util.HashMap;

class MajorityElement
{
   public static void main(String[] args)
   {
      int[] testArray1 = {3, 2, 3};
      int[] testArray2 = {2, 2, 1, 1, 1, 2, 2};
      
      System.out.println(majorityElement(testArray2));
   }
   
   public static int majorityElement(int[] nums)
   {
      int threshold = nums.length/2;
      
      HashMap<Integer, Integer> myMap = new HashMap<>();
      
      for(int num : nums)
      {
         if(!myMap.containsKey(num))
         {
            myMap.put(num, 1);
         }
         else
         {
            myMap.put(num, myMap.get(num) + 1);
         }              
      }
           
      for(int num : nums)
      {
         if(myMap.get(num) > threshold)
         {
            return num;
         }
      } 
      
      return -1;  
   }   
}