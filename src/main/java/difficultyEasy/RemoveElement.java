/*
   Given an array nums and a value val, remove all instances of that value in-place and return
   the new length.
   
   In-place means: the input is usually overwritten by the output as the algorithm executes.
   
   Do not allocate extra memory, you must do this by modifying the input array in-place with
   O(1) extra memory.
   
   The order of elements can be changed. It doesn't matter what you leave beyond the new length.
   
   Example 1:
   nums = [3, 2, 2, 3], val = 3
   Returned length = 2
   
   doesn't matter what you leave beyond the returned length.
   
   Example 2:
   nums = [0, 1, 2, 2, 3, 0, 4, 2], val = 2
   Returned length = 5
   
   ----
   
   Algorithm 1:
   
   1. Two Pointers Approach, one is slowRunner and another is fastRunner
   2. if nums[fastRunner] = value, the skip that index in the array
   3. if nums[fastRunner] != value, then copy nums[slowRunner] = nums[fastPointer], increment the slowRunner by 1
   4. Repeat until the fastRunner reaches the end of array.
   5. Return the value of slowRunner, incrementer.
   
   Time Complexity: O(N), where N is the number of elements in the nums array
   
   Space Complexity: O(1) 
   
   ------
   
   Algorithm 2:
   
   1. The above algorithm will not be effective if we have
      
      nums = [1, 2, 3, 5, 4]
      value to remove is 4
      
      Because 4 is at the end, and we will be making unnecessary copy operation of the first four elements, to get the new length as 4.
      
   2. Instead, when we encounter 
      
      nums[i] == val
      
      we will swap the current element with the last element, 
      nums[i] = nums[n-1];
      
      and ignore the last element, 
      n--;
      
      On example: 
      
      nums = [3, 2, 2, 3], val = 3
      
      the last element swapped could be the value we want to remove, but since we didn't increment the i
      
      After the swap it will be
      
      [3, 2, 2, 3]
      
      But our n will be 3
      
      On next iteration, our array will be
      
      [2, 2, 3, 3] and n will be 2
      
   3. We will return the n, n is basically the count of how many nums.length - how many elements we removed so far.
      So the number of operations is equal to the number of elements to remove.    
      
    Time-Complexity: O(N)
    Space-Complexity: O(1)  
      
*/

class RemoveElement
{
   public static void main(String[] args)
   {
      int[] testArray1 = {0, 1, 2, 2, 3, 0, 4, 2};
      int[] testArray2 = {3, 2, 2, 3};
      
      System.out.println(removeElement(testArray2, 3));
   }
   
   // Algorithm 2: Efficient Two Pointer Solution, when we have the fewer elements to remove
   public static int removeElement(int[] nums, int val)
   {
      int i = 0;
      int n = nums.length;
      
      while(i < n)
      {
         if(nums[i] == val)
         {
            nums[i] = nums[n-1];
            n--;
         }
         else
         {
            i++;
         }
      }
      
      return n;     
   }
   
   // Algorithm 1: Two Pointer Solution, copies the elements that are not equal to the values.
   /*
   public static int removeElement(int[] nums, int value)
   {
      int slowRunner = 0;
      
      for(int fastRunner = 0; fastRunner < nums.length; fastRunner++)
      {
         if(nums[fastRunner] != value)
         {
            nums[slowRunner] = nums[fastRunner];
            slowRunner++;
         }
      }
      
      return slowRunner;
   }
   */
   
   // Same approach as above, the above is the efficient version of the brute force solution below
   /*
   public static int removeElement(int[] nums, int val)
   {
      int slowPointer = 0;
      int fastPointer = 0;
      
      for(int i=0; i < nums.length; i++)
      {
         if(nums[i] != val)
         {
            int temp = nums[slowPointer];
            nums[slowPointer] = nums[fastPointer];
            nums[fastPointer] = temp;
            slowPointer++;
         }
         
         fastPointer++;
      }
      
      return slowPointer;
   }
   */   
}