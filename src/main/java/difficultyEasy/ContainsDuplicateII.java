/*
   Contains Duplicate II
   
   Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that
   nums[i] = nums[j] and the absolute difference between i and j is at most k.
   
   Example 1:
   
   Input: nums = [1,2,3,1], k = 3
   Output: true
   
   Example 2:
   
   Input: nums = [1,0,1,1], k = 1
   Output: true
   
   --------------
   
   Algorithm:
   
   1. Let's say our input array, nums =  [1, 2, 3, 1]
   
      We will create a HashMap
      
      Then make a for loop
         Check if our map already contains the nums[i]
            
            If it does, check if (i - myMap.get(nums[i]) <= k)
            
            Here we are saying, if the first 1 is already put on our HashMap
            When we loop over the last 1, the map knows that we already have 1 from the first
            So, we just subtract (3 - 0) <= 3
               return true
               
            Otherwise myMap.put(nums[i], i) 
      
     We return false
     
   -------------
  
   Time-Complexity: O(N), N is the number of elements in the array. 
                    Worst case, we loop over every elements in the array without returning true.
                    
   Space-Complexity: O(N), Worst case, we store all the elements in the array on our HashMap.                 
      
*/

import java.util.HashMap;

class ContainsDuplicateII
{
   public static void main(String[] args)
   {
      System.out.println(containsNearbyDuplicate(new int[] {1, 2, 3, 1}, 3));
      
      System.out.println(containsNearbyDuplicate(new int[] {1, 0, 1, 1}, 1));
   }
   
   public static boolean containsNearbyDuplicate(int[] nums, int k)
   {
      HashMap<Integer, Integer> myMap = new HashMap<>();
           
      for(int i=0; i < nums.length; i++)
      {
         if(myMap.containsKey(nums[i]))
         {
            if(i - myMap.get(nums[i]) <= k)
            {
               return true;
            }
         }
         
         myMap.put(nums[i], i);
      }
      
      return false;
   }  
}