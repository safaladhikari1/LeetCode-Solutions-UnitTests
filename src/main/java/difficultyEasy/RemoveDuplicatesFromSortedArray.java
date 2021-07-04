/*
   Given a sorted array nums, remove the duplicates in-place such that each element appear only
   once and return the new length.
   
   Do not allocate extra space for another array, you must do this by modifying the input array
   in-place with O(1) extra memory.
   
   Example 1:
   Given nums = [1, 1, 2]
   
   Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively
   
   It does not matter what you leave beyond the returned length.
   
   Example 2:
   
   nums = [0, 0, 1, 1, 1, 2, 2, 3, 3, 4]
   function length = 5 [0, 1, 2, 3, 4]
   ----
   
   Algorithm: 
   
   1. Look at the array: [0, 0, 1, 1, 1, 2, 2, 3, 3, 4], since it is sorted
      think of "0, 0" , "1, 1, 1" as each index.
   2. We need two pointers, where the previous pointer stores the non duplicate int value,
      current pointer loops through the array
   3. If previous is not equal to current
      Then we simply replace the next index with current int value
      We keep the count on our indexes, in this process.
   4. We will return the count + 1; as the new length.
   
   Time Complexity:
   
   O(N), where N is the number of elements in the array(or length of an array)
   
   Space Complexity:
   
   O(1)
*/

class RemoveDuplicatesFromSortedArray
{
   public static void main(String[] args)
   {
      int[] testArray = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
      int[] testArray2 = {};
      
      System.out.println(removeDuplicates(testArray2));
   }
   
   // Tried the problem again on 03/26/2021, more efficient
   public static int removeDuplicates(int[] nums)
   {
      int slowP = 0;
      
      for(int fastP = 0; fastP < nums.length; fastP++)
      {
         if(nums[fastP] > nums[slowP])
         {
            slowP++;
            nums[slowP] = nums[fastP];
         }
      }
      
      return slowP + 1;
   }
   
   // Same as the first solution, tried again on 03/01/2021
   /*   
   public static int removeDuplicates(int[] nums)
   {
      if(nums.length == 0)
      {
         return 0;
      }
      
      int count = 0;
      int previous = nums[0];
      
      int current = 0;
      
      for(int i=1; i < nums.length; i++)
      {
         current = nums[i];
         
         if(current != previous)
         {
            previous = current;
            count++;
            nums[count] = previous;
         }
      }
      
      return count+1; 
   }
   */
   
   // More Optimized Solution
   /*
   public static int removeDuplicates(int[] nums)
   {
      if(nums.length == 0)
      {
         return 0;
      }
      
      int count = 0;
      
      for(int i=0; i<nums.length; i++)
      {        
         if(nums[i] != nums[count])
         {            
            count++;
            nums[count] = nums[i];          
         }
      }
      
      return count+1;
   }
   */ 
   
   /*
   public static int removeDuplicates(int[] nums)
   {
      if(nums.length == 0)
      {
         return 0;
      }
      
      int count = 0;
      int previous = nums[count];
      
      for(int i=0; i<nums.length; i++)
      {
         int current = nums[i];
         
         if(current != previous)
         {
            previous = current;
            
            nums[count + 1] = previous;
            count++;
         }
      }
      
      return count+1;
   }
   */   
}