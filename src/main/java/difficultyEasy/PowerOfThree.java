/*
   Power of Three
   
   Given an integer n, return true if it is a power of three. Otherwise, return false.
   
   An integer n is a power of three, if there exists an integer x such that n == 3x.
   
   Examples:
   
   Input: n = 27
   Output: true
   
   Input: n = 0
   Output: false
   
   ------
   
   Approach 1 (Iterative Approach)
   
   Algorithm
   
   1. We know that the Power of 3 starts as follows:
   
      3^0, 3^1, 3^2, 3^3
      1  , 3  , 9  , 27 ....
      
      We can first say that, if n is less than 1
         return false
      
      If you notice, if n is divisible by 3 (n % 3 == 0), if we keep dividing by 3, eventually it has to end up as 1.
      
      So we do:
      
      while(n % 3 == 0)
      {
         n /= 3;
      }
      
      Then check if n is 1, if it is, return true or return false.
      
   
   Time-Complexity: O(log3N), which is the number of divisions to get N down to 1.
   Space-Complexity: O(1). No additional memory is used.
   
   --------
   
   Approach: 2 (Integer Limitations)
   
   Explanation on "Approach 4: Integer Limitations" section of the article: https://leetcode.com/problems/power-of-three/solution/
   
   Time complexity: O(1), we are only doing one operation
   Space complexity: O(1), no additional memory is used.    
      
*/


class PowerOfThree
{
   public static void main(String[] args)
   {
      System.out.println(isPowerOfThree(0));
   }
   
   // Approach 1
   public static boolean isPowerOfThree(int n)
   {
      if(n < 1)
      {
         return false;
      } 
      
      while(n % 3 == 0)
      {
         n /= 3;
      }
      
      return n == 1;
   }
   
   // Approach 2
   /*
   public static boolean isPowerOfThree(int n)
   {
      return n > 0 && 1162261467 % n == 0;
   }
   */
}