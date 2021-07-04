/*
   Find all Duplicates in an Array
   
   Given an array of integers, 1 <= a[i] <= n (n = size of array), some elements appear twice and others appear once.
   
   Find all elements that appear twice in this array.
   
   Could you do it without extra space and in O(n) runtime?
   
   Example:
   
   Input: [4, 3, 2, 7, 8, 2, 3 , 1]
   Output: [2, 3]
   
   --------
   
   Algorithm:
   
   Explained in detail on https://youtu.be/aMsSF1Il3IY
   
   1. We create our result arraylist
      
      To do in O(N) runtime, we can only loop through the elemnts in the array once
      
      Start our for loop
      
         From the problem description, we know that size of the array is the maximum element, we can have in this array.
         
         So on our above input, the array length is 8
         all the elements are either 8 or below.
         
         To get the index, We loop through the value in the for loop, and subtract by 1. Because our indices start from 0.         
         
         Then we convert the nums[index] = -nums[index]
         
         In between, we check if nums[index] < 0
            This means, we have already see the value of that nums[index], because we converted it negative
            
            If it is negative, we grab the index + 1, and add it to the result.
            
    -------
    
    Time-Complexity: O(N), N is the number of elements in the array
    Space-Complexity: O(1)        

*/

import java.util.List;
import java.util.ArrayList;

class FindDuplicatesInArray
{
   public static void main(String[] args)
   {
      System.out.println(findDuplicates(new int[] {4, 3, 2, 7, 8, 2, 3,1}));
   }
   
   public static List<Integer> findDuplicates(int[] nums)
   {
      List<Integer> result = new ArrayList<>();
      
      for(int i=0; i < nums.length; i++)
      {
         int index = Math.abs(nums[i]) - 1;
         
         if(nums[index] < 0)
         {
            result.add(index + 1);
         }
         
         nums[index] = -nums[index];
      }
      
      return result;
      
   }  
}