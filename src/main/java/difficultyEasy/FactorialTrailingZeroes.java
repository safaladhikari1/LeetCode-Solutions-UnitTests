/*
   Factorial Trailing Zeroes
   
   Given an integer n, return the number of trailing zeroes in n!.
   
   ------
   Explanation: https://youtu.be/3Hdmv_Ym8PI
   
   Algorithm:
   
   1. Factorial of 5! will look like this:
      
      1 x 2 x 3 x 4 x 5 = 120 (result)
      
      There is one 0 at the end, but how do we know that the answer is 1?
      
      We cannot count 10s in our result
      
      But we can count either 2 or 5. Counting 5 actually works.
      
      Because there is one 5 above, the answer is 1.
      
      ---
      
      Factorial of 10!
      
      1 x 2 x 3 x 4 x 5
      6 x 7 x 8 x 9 x 10(5 *2) = 3628800
      
      There are two 0s and two 5s, so counting 5 works.
      
      But it does not work on
      
      Factorial of 25!
      
      1 x 2 x 3 x 4 x 5 (5 * 1)
      6 x 7 x 8 x 9 x 10 (5 * 2)
      11 x 12 x 13 x 14 x 15 (5 * 3)
      16 x 17 x 18 x 19 x 20 (5 * 4)
      21 x 22 x 23 x 24 x 25 (5 * 5) = 15511210043330985984000000
      
      There are six 0s and four 5s.
      
      So not only need to count the 5s, (25 / 5) = 5
      
      We also need to divide the remaining (5 / 5) to get the 6th 5.
      
      So, that will give us 6 5s, which is our 6 zeroes.
      
  2.  For example: 25
  
      Inside our while loop
      we count the initial number of fives (n / 5), 25/5 = 5
      
      Then we get n = n / 5, which is 5.
      
      while (n >= 5)
         we add the remaining 5 in our count.
         
         which will be 1.
     
     The answer is 6.
     
     
   ---------
   
   Time-Complexity: O(1)
   Space-Complexity: O(1)          
*/

class FactorialTrailingZeroes
{
   public static void main(String[] args)
   {
      System.out.println(trailingZeroes(25));
   }
   
   public static int trailingZeroes(int n)
   {
      int numberOfFives = 0;
      
      while(n >= 5)
      {
         numberOfFives += (n / 5);
         n = (n / 5);
      }
      
      return numberOfFives;
   }
   
   /*
   public static int trailingZeroes(int n)
   {
      int factorial = calculateFactorial(n);
      
      int count = 0;
      
      while(factorial > 9 && factorial % 10 == 0)
      {
         int num = factorial / 10;
         count++;
         factorial = num;
      }
      
      return count;
   }
   
   public static int calculateFactorial(int n)
   {
      if(n == 0)
      {
         return 1;
      }
      else
      {
         return n * calculateFactorial(n-1);
      }
   }
   */     
}