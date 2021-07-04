/*
   Two Sum
   
   Given an array of integers (nums) and an integer (target), return indices of the two numbers
   such that they add up to target.
   
   You may assume that each input would have exactly one solution, and you may not use the same
   element twice.
   
   You can return the answer in any order.
   
   Example 1:
   
   Input: nums = [2, 7, 11, 15]
          target = 9
   Output: [0, 1]
   
   Input: nums = [3, 2, 4]
          target = 6
   Output: [1, 2] 
   
   ----
   
   Resources on HashMap: https://www.geeksforgeeks.org/internal-working-of-hashmap-java/
                         https://medium.com/@mr.anmolsehgal/java-hashmap-internal-implementation-21597e1efec3  
*/

import java.util.HashMap;
import java.util.Arrays;

class TwoSum
{
   public static void main(String[] args)
   {
      int[] testArray = {2, 7, 11, 15};
      int target = 9;
      
      System.out.println(Arrays.toString(twoSum(testArray, target)));    
   }
   
   /*
      Time Complexity: O(N), where N is the number of elements in the Array
                       Lookup of "difference" is O(1), because GET and PUT in hashmap is O(1)
      
      Space Complexity: O(N), where N is the number of elements stored in the Hashtable. We had to trade off
                       with space, to get O(N) run time.                                         
   */ 
   public static int[] twoSum(int[] nums, int target)
   {     
      
      HashMap<Integer, Integer> myMap = new HashMap<Integer, Integer>();
      
      for(int i=0; i<nums.length; i++)
      {
         myMap.put(nums[i], i);
      }
      
      for(int j=0; j<nums.length; j++)
      {
         int difference = target - nums[j];
         
         if(myMap.containsKey(difference) && myMap.get(difference) != j)
         {
            return new int[] {j, myMap.get(difference)};
         }
      }
      
      throw new IllegalArgumentException("No two sum solution");       
   }
}
