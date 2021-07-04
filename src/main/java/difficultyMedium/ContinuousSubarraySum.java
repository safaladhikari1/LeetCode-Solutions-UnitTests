/*
   Continuous Subarray Sum
   
   Problem: https://leetcode.com/problems/continuous-subarray-sum/
   
   The problems wants us to return true/false if the input array and int target meets the following conditions:
   
   - If the input array has a Continuous Subarray, with a minimum of size 2.
   - The sum of the elements of the sub array is a multiple of target.
   
   ------
   
   Approach 1 (BruteForce Solution)
   
   Algorithm:
   
   1. For every element of the array, we can loop through the rest of the elements of the array
      (Double For Loop, O(N^2))
      
      for(int i=0; i < nums.length; i++)
      {
         sum = nums[i];
         
         for(int j = i+1; j < nums.length; j++)
         {
            sum += nums[j];
            
   2. Before the inner for loop, we will keep track of the sum
      Then pass it to next round of inner for loop
      
      At this point, we know array has a minimum of size 2,
      
      At anypoint
          
      k is 0 and sum is also 0, which is divisible by k
      if(k == 0 && sum == 0)
         return true
         
      Or
      
      k cannot be 0 (anything divided by 0 is error) and sum is divisible by k   
      (k != 0 && sum % k == 0)
         return true.
         
   3. At the end, it returns false.
   
   Time-Complexity: O(N^2), where N is the number of elements in the array
   Space-Complexity: O(1) 
   
 ---------------
 
 Approach 2 (Using Remainder Theorem)
 
 Explanation: https://leetcode.com/problems/continuous-subarray-sum/discuss/99499/Java-O(n)-time-O(k)-space/103582
                      
*/

import java.util.Map;
import java.util.HashMap;

class ContinuousSubarraySum
{
   public static void main(String[] args)
   {
      System.out.println(checkSubarraySum(new int[] {23, 2, 4, 6, 7}, 6));
      //System.out.println(checkSubarraySum(new int[] {23, 2, 6, 4, 7}, 0));
      
      //System.out.println(checkSubarraySum(new int[] {0, 0}, 0));
      //System.out.println(checkSubarraySum(new int[] {5, 0, 0}, 0));
   }
   
   public static boolean checkSubarraySum(int[] nums, int k)
   {
      int sum = 0;
      
      Map<Integer, Integer> myMap = new HashMap<>();
      
      myMap.put(0, -1);
      
      for(int i=0; i < nums.length; i++)
      {
         sum += nums[i];
         
         if(k != 0)
         {
            sum = sum % k;
         }
         
         if(myMap.containsKey(sum))
         {
            if(i - myMap.get(sum) > 1)
            {
               return true;
            }
         }
         else
         {
            myMap.put(sum, i);
         }
      }
      
      return false;
   }
   
   
   // Approach 1 (Brute force Solution)
   /*
   public static boolean checkSubarraySum(int[] nums, int k)
   {
      int sum = 0;
      
      for(int i=0; i < nums.length - 1; i++)
      {
         sum = nums[i];
         
         for(int j = i+1; j < nums.length; j++)
         {
            sum += nums[j];
            
            if((k == 0 && sum == 0)|| (k != 0 && sum % k == 0))
            {
               return true;
            }
         }
      }
      
      return false;         
   }
   */
}  