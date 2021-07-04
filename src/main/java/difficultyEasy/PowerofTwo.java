/*
   Power of Two
   
   Given an integer n, return true if it is a power of two. Otherwise return false.
   
   An integer n is a power of two, if there exists an integer x such that n == 2^x.
   
   Example:
   
   Input: n = 1
   Output: true
   
   Input: n = 6
   Output: false
   
   ------
   
   Algorithm:
   
   Approach 1 (Iterative Approach):
   
   1. We know that 2^0 = 1, 2 ^1 = 2, and so on. So Power of two starts from 1.
      
      If n is less than or equal to 0
         return false.
         
      Check if n is divisible by 2 in while loop
         If yes, keep on dividing by 2 and check repeatedly
      
      At the end if it reaches 1, That means n is the result of power of two.
      
   Time-Complexity: O(logN), which is the number of times we must divide N to get down to 1. 
                    For more information: https://github.com/safaladhikari1/Java-Concepts/blob/master/Classes/SearchingAndSorting/BinarySearch.java
   Space-Complexity: O(1)          
   
   ---------------
   
   Approach 2 (Look-up table):
   
   1. Since there are only 31 numbers in total for an 32-bit integer,
      
      We create a fixed-size list of those 31 numbers using Arrays.asList()
      Then construct a new HashSet containing those elements from the list.
      And checking if it contains(n)
      
      Time-Complexity = O(1), but the approach 1 (iterative approach) is way faster than approach 2.

*/

import java.util.HashSet;
import java.util.Arrays;

class PowerofTwo
{
   public static void main(String[] args)
   {
      System.out.println(isPowerOfTwo(6));
   }
   
   // Approach 1
   public static boolean isPowerOfTwo(int n)
   {
      if(n <= 0)
      {
         return false;
      }
      
      while(n%2 == 0)
      {
         n /= 2;
      }
      
      return n == 1;
   }
   
   /*
   // Approach 2
   public static boolean isPowerOfTwo(int n)
   {
      return new HashSet<>(Arrays.asList(1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 131072, 262144, 524288, 1048576, 2097152, 4194304, 8388608,16777216, 33554432, 67108864, 134217728, 268435456, 536870912, 1073741824)).contains(n);
   }
   */
}