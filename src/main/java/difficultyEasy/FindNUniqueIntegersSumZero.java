/*
   Find N Unique Integers Sum up to Zero
   
   Given an integer n, return any array containing n unique integers such that they add up to 0.
   
   Example 1:
   
   Input: n = 5
   Output: [-7,-1,1,3,4]
   Explanation: These arrays also are accepted [-5,-1,1,2,3] , [-3,-1,2,-2,4].
   
   --------
   
   Algorithm:
   
   1. Basically, this question wants us to return an array of size n,
      such that n contains unique elements and they add up to 0.
      
      For example:
      
      If n is 3
      
      [1, 0, -1] is the result array
      
      because it has size 3, and when we add 1 + 0 + (-1), it is 0.
      
  2.  So we can first instantiate our array for size n
      
      Then we can have two points from left and right side of the array
      
      On the left, we will put the number 1
      On the right, we will put the same number, but -1
      
      we will increment the number
      increment the left,
      decrement the right
      
  3.  We will do the above while (left < right)
      
      if n is odd:
      
         it stops when left == right
         At that point, both pointer will be around the middle of the array
         We will leave that spot as 0, because in Java's arrays when instantiated, values defaults to 0.
      
      if n is even:
         left becomes greater than right, and the while loop stops.   
  
  4.  Return the result.
  
  ---------
  
  Time-Complexity: O(N), where N is the number of elements in the array
  Space-Complexity: O(1)
             
*/

import java.util.Arrays;

class FindNUniqueIntegersSumZero
{
   public static void main(String[] args)
   {
      System.out.println(Arrays.toString(sumZero(5)));
   }
   
   public static int[] sumZero(int n)
   {
      int[] result = new int[n];
      int num = 1;
      
      int left = 0;
      int right = result.length - 1;      
      
      while(left < right)
      {
         result[left] = num;
         result[right] = -num;
         
         left++;
         right--;
         
         num++;
      }
      
      return result;     
   }
   
   // Bruteforce Approach.
   /*
   public static int[] sumZero(int n)
   {
      int num = 1;
      int[] result = new int[n];
      
      if(n % 2 == 0)
      {
         int left = 0;
         int right = result.length - 1;
         
         while(left < right)
         {
            result[left] = num;
            result[right] = -num;
            
            left++;
            right--;
            
            num++;
         }
      }
      else
      {
         result[0] = 0;
         int left = 1;
         int right = result.length - 1;
         
         while(left < right)
         {
            result[left] = num;
            result[right] = -num;
            
            left++;
            right--;
            
            num++;
         }
      }
      
      return result;     
   }
   */
}