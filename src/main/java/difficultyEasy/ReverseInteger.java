/*
   Reverse Integer:
   
   Given a 32-bit signed integer, reverse digits of an integer.
   
   Input: 123
   Output: 321
   
   Input: -123
   Output: -321
   
   ---

   Approach 2:

   We are converting int to string, loop, swap the beginning and end, convert to long, convert to int, return.
   Time Complexity: 0(N), where N is the number of elements in xStringChar Char Array in the solution below

   Approach 1:

   1. Let's say our x is 123

      If we mod x by 10, x % 10, we get last digit = 3
      if we divide x by 10, x / 10, we remove last digit, and get 12

      The logic is, while x is not 0
         Retrieve the last digit
         multiply it by result (initially at 0) + last digit
         result = new result
         x is whatever is left, after ignoring the last digit.

   2. Since the question asks, while reversing if the value go outside of
      Integer.MAX_VALUE: 2 ^ 31 - 1
      Integer.MIN_VALUE: -2 ^ 31

      Then return 0

      We are storing the value in the result first.

   3. At the end, we will cast to result to int, if they are same value, there was no overflow, return (cast)result.
      Otherwise, we had a overflow, return 0.

   Time-Complexity: O(log(x)), log is in base 10. We are saying there are roughly log10(x) digits in x.
   Space-Complexity: O(1)

   More discussion on int overflow: https://leetcode.com/problems/reverse-integer/discuss/4060/My-accepted-15-lines-of-code-for-Java

*/

class ReverseInteger
{
   public static void main(String[] args)
   {
      int testCase1 = -123;
      System.out.println(reverse(testCase1));
   }

   // Approach 2: Using Math Operations to reverse the int.
   public static int reverse(int x) {

      long result = 0;
      while(x != 0) {
         int lastDigit = x % 10;
         long newResult = 10 * result + lastDigit;
         result = newResult;
         x = x/10;
      }

      if ((int)result == result) {
         return (int)result;
      }
      else {
         return 0;
      }
   }

   // Approach 1: Converting int to String and char array
   /*
   public static int reverse(int x)
   {
      // Converts the int x to String xString      
      String xString = String.valueOf(x);
      
      // If x is negative, ignore "-" and only take the remaining as xString.
      if(x < 0)
      {
         xString = xString.substring(1, xString.length());
      }
      
      // Converts xString to xStringChar array
      char[] xStringChar = xString.toCharArray();
      
      // Loops into the char array, and reverses the integer 
      for(int i=0; i<xStringChar.length / 2; i++)
      {
         int other = xStringChar.length - i - 1;
         char temp = xStringChar[i];
         
         xStringChar[i] = xStringChar[other];
         
         xStringChar[other] = temp;         
      }
      
      // Converts the output charArray to String
      xString = String.valueOf(xStringChar);
      
      // converts the result to Long value
      Long result = Long.valueOf(xString);     
      
      // If the result overflows the integer range, returns 0
      if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
      {
         return 0;
      }
      
      // If the x was negative, then converts the result to negative by multiplying with -1
      if(x < 0)
      {
         result *= (-1);   
      }
      
      // returns the result as intValues
      return result.intValue();
      
   }

    */
}  
