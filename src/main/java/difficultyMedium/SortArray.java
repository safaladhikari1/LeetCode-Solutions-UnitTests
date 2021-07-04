/*
   Sort an Array
   
   Given an array of integers nums, sort the array in ascending order.
   
   Example:
   
   Input: nums = [5,2,3,1]
   Output: [1,2,3,5]
   
   -------
   
   We are using Merge Sort Algorithm
   
   1. Intuition:
   
                        [5, 2, 3, 1]
             [5, 2]                    [3, 1]
             
  (split)  [5] [2]                         [3] [1]
  
  (merge)   [2, 5]                           [1, 3]
                        [1, 2, 3, 5]
                        
                        
   2. More information on:  
      
      https://github.com/safaladhikari1/Java-Concepts/blob/master/Classes/SearchingAndSorting/BinarySearchObject.java
      
   --------
   
   Time-Complexity: O(N log N), 
                    At each level of the tree, we merge N elements
                    There are log(N) levels in the tree, because the N number of elements are reduced by half, until a single element remains.
                    N * log(N) is a general way to talk about how many operations are performed. 
  
  Space-Complexity: O(N), we are temporarily storing N elements in our left and right array.            
   
  More information on: https://github.com/safaladhikari1/Java-Concepts/blob/master/Classes/SearchingAndSorting/BinarySearch.java 

*/

import java.util.Arrays;

class SortArray
{
   public static void main(String[] args)
   {
      int[] testArray = {5, 2, 3, 1};
      
      sortArray(testArray);
      
      System.out.println(Arrays.toString(testArray));
   }
   
   public static int[] sortArray(int[] nums)
   {
      if(nums == null || nums.length == 0)
      {
         return nums;
      }
      
      helper(nums, nums.length);
      
      return nums;
   }
   
   public static void helper(int[] nums, int length)
   {
      if(length < 2)
      {
         return;
      }
           
      int mid = nums.length / 2;
      
      int[] left = new int[mid];
      int[] right = new int[length - mid];
      
      for(int i = 0; i < mid; i++)
      {
         left[i] = nums[i];
      }
      
      for(int i = mid; i < length; i++)
      {
         right[i - mid] = nums[i];
      }
      
      helper(left, left.length);
      helper(right, right.length);
      
      mergeSort(nums, left, right, left.length, right.length);         
   }
 
   public static void mergeSort(int[] nums, int[] left, int[] right, int leftLength, int rightLength)
   {
      int i = 0, j = 0, k = 0;
      
      while(i < leftLength && j < rightLength)
      {
         if(left[i] <= right[j])
         {
            nums[k] = left[i];
            i++;
            k++;
         }
         else
         {
            nums[k] = right[j];
            j++;
            k++;
         }
      }
      
      while(leftLength > i)
      {
         nums[k] = left[i];
         i++;
         k++;
      }
      
      while(rightLength > j)
      {
         nums[k] = right[j];
         j++;
         k++;
      }    
   }
}