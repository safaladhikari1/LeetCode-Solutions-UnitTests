/*
   Power of Four
   
   Given an integer n, return true if it is a power of four.
   Otherwise, return false.
   
   An integer n is a power of four, if there exists an integer x
   such that n == 4^x.
   
   Examples:
   
   Input: n = 16
   Output: true
   
   Input: n = 5
   Output: false
   
   Input: n = 1
   Output: true
   
   ---------
   
   Algorithm:
   
   1. We know the Power of Four is:
   
      (4^0) 1, (4^1) 4,(4^2) 16,(4^3) 64
      
   2. Since the lowest number is 1,
   
      We check if n < 1
         return false
         
      Otherwise while(n % 4) == 0
         Keep dividing n /= by 4
         
      At the end, it should stop at 1.
      
   3. If n is 1, return true. This means we know it is the power of 4
      Otherwise return false.
      
   --------
   
   Time-Complexity: O(1)
   Space-Complexity: O(1)               
   
*/


class PowerOfFour
{
   public static void main(String[] args)
   {
      System.out.println(isPowerOfFour(16));
      System.out.println(isPowerOfFour(5));
      System.out.println(isPowerOfFour(1));
   }
   
   public static boolean isPowerOfFour(int n)
   {
      if(n < 1)
      {
         return false;
      }
      
      while(n % 4 == 0)
      {
         n /= 4;
      }
      
      return n == 1;
   }   
}