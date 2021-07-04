/*
   Add to Array-Form of Integer
   
   For a non-negative integer x, the array-form of x is an array of its digits in left to right order.
   For example, if X = 1231, then the array form is [1, 2, 3, 1].
   
   Given the array-form A of a non-negative integer X, return the array-form of the integer X+K.
   
   Example:
   
   Input: A = [1, 2, 0, 0], K = 34
   Output: [1, 2, 3, 4]
   
   Explanation: 1200 + 34 = 1234
   
   -------------
   
   Algorithm:
   
   1. So we have our input array [1, 2, 0, 0], K = 34
   
      If we do it our school way:
      
         1 2 0 0
             3 4
         -------
         1 2 3 4
         
   2. To make this happen, we first create our myList, which is our ArrayList
   
      We loop the input array from the back, so our last index is nums.length - 1
      
      we have our sum, carry is 0 at first.
      
      while(we are not at the first index, and our K is greater than 0)
      {
         Here, we want to add 4 and 0
         
         We can get 4, which is our value, by 34 % 10
         
         Sometimes, we can have K more than nums
            sum = value + carry
            
         Otherwise,
            sum = carry + value + 0 (our last Index)
            
         If we have a carry for next iteration, we can get it by carry = sum / 10
         
         myList.add(sum % 10); this will add 4 to our result list
         
         Let's take 3 for our next iteration. K /= 10
         
         we will decrement the lastIndex         
      }
   
   
   3. Sometimes we can have carry == 1
         If that's the case, add 1 to myList
   
   4. Reverse the List.
   
         We could have made LinkedList as our datastructure, and added our numbers to the front of the list
         But LinkedList takes up more memory, so using ArrayList, adding the number to the end 
         and reversing the list is more efficient.         
   
   --------
   
   Time-Complexity: O(max(N, logK)) where N is the length of nums array
   Space-Complexity: O(max(N, logK)) 
   
   For more information: https://leetcode.com/problems/add-to-array-form-of-integer/solution/         

*/


import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class AddtoArrayFormOfInteger
{
   public static void main(String[] args)
   {
      System.out.println(addToArrayForm(new int[] {1, 2, 0, 0}, 34));
      System.out.println(addToArrayForm(new int[] {2, 7, 4}, 181));
      System.out.println(addToArrayForm(new int[] {2, 1, 5}, 806));
      System.out.println(addToArrayForm(new int[] {9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, 1));
   }
   
   public static List<Integer> addToArrayForm(int[] nums, int K)
   {
      List<Integer> myList = new ArrayList<>();
      
      int lastIndex = nums.length - 1;
      
      int sum;
      int carry = 0;
      
      while(lastIndex >= 0 || K > 0)
      {
         int value = K % 10;
         
         if(lastIndex < 0)
         {
            sum = value + carry;
         }
         else
         {
            sum = carry + value + nums[lastIndex];
         }
         
         carry = sum / 10;
         
         myList.add(sum % 10);
         
         K /= 10;
         
         lastIndex--;
      }
      
      if(carry == 1)
      {
         myList.add(carry);
      }
      
      Collections.reverse(myList);
      
      return myList;
   }
   
   /*
   public static List<Integer> addToArrayForm(int[] nums, int K)
   {
      List<Integer> myList = new LinkedList<Integer>();
      
      StringBuilder sb = new StringBuilder();
      
      for(int num : nums)
      {
         sb.append(num);
      }
      
      String numString = sb.toString();
      
      Integer intValue = Integer.parseInt(numString);
      
      int result = intValue + K;      
      int index = 0;
      
      while(result > 0)
      {
         int value = result % 10;
         result /= 10;
         
         myList.add(index, value);        
      }
      
      return myList; 
   }
   */
}