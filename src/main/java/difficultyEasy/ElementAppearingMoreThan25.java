/*
   Element Appearing More Than 25% In Sorted Array
   
   Given an integer array sorted in non-decreasing order, there is exactly one integer in the array
   that occurs more than 25% of the time.
   
   Return that integer.
   
   Example 1:
   
   Input: arr = [1,2,2,6,6,6,6,7,10]
   Output: 6
   
   -----
   
   Algorithm 1 (Using Sliding Window, Linear Search):
   
   1. Since the array is in sorted order, we can take advantage of this.
      If there is any element in the sorted array, that appears more than 25% of the array's length,
      that is our output element.
      
      On our for loop, we can check 
      if the current element at nums[i] is equal to the element at nums[i + 25% of array's length]
      
      If it's equal, it means that element exists in that nums array more than 25% of the time.
      
   2. First we find the oneFourth number = nums.length / 4
      loopEnd number = nums.length - oneFourth number (we don't have to loop all the way to the end of the array, we can just loop up to 3/4 of the array's length)
       
      On our for loop, we do the check,  
      
      if(nums[i] == nums[i + oneFourth])
         return nums[i]
         
   3. Otherwise, we didn't find anything, so return -1.
   
   Time-Complexity: O(N), where N is the number of elements in the array
   Space-Complexity: O(1)
   
   ------------------
   
   Approach 2 (Using HashMap)
   
   1. This is the naive approach,
      We put all the elements on our hashmap like element as "key", and element's frequency in the array as "value"
      
      On our for each loop,
      
      we check if the element's frequency is more than 25% of the array's length
         If it is, we will return that element as result.
         
   Time-Complexity: O(N), where N is the elements in the array. We visit every elements in the array once.
   Space-Complexity: O(N), we store key-value pairs for every element in the array on our HashMap.      
*/



import java.util.Map;
import java.util.HashMap;

class ElementAppearingMoreThan25
{
   public static void main(String[] args)
   {
      System.out.println(findSpecialInteger(new int[] {1, 2, 2, 6, 6, 6, 6, 7, 10}));
   }
   
   // Approach 2 (Using Sliding Window, Linear Search)
   public static int findSpecialInteger(int[] nums)
   {
      int oneFourth = nums.length / 4;
      int loopEnd = nums.length - oneFourth;
      
      for(int i=0; i < loopEnd; i++)
      {
         if(nums[i] == nums[i + oneFourth])
         {
            return nums[i];
         }
      }
      
      return -1;      
   }
   
   
   // Approach 1 (Using HashMap)
   /*
   public static int findSpecialInteger(int[] nums)
   {
      double percent = 0.25 * nums.length;
      int result = 0;
      
      Map<Integer, Double> myMap = new HashMap<>();
      
      for(int num : nums)
      {
         if(myMap.containsKey(num))
         {
            myMap.put(num, myMap.get(num) + 1.00);
         }
         else
         {
            myMap.put(num, 1.00);
         }
         
         if(myMap.get(num) > percent)
         {
            result = num;
         }  
      }
          
      return result;      
   }
   */
}