/*
   Write an algorithm to determine if a number n is "happy."
   
   A happy number is a number defined by the following process:
   
   Starting with any positive integer, replace the number by the sum of the squares
   of its digits, and repeat the process until the number equals 1(where it will stay),
   
   or it loops endlessly in a cycle which does not include 1. Those numbers for which this 
   process ends in 1 are happy numbers.
   
   Return true if n is a happy number, and false if not.
   
   Example:
   
   Input: 19
   Output: true
   
   Explanation:
   
   1^2 + 9^2 = 82
   8^2 + 2^2 = 68
   6^2 + 8^2 = 100
   1^2 + 0^2 + 0^2 = 1
   
   ----
   
   Algorithm:
   
   1. Build one HashSet inLoop
      We will add sum to this HashSet
      
      1^2 + 9^2 = 82, we will add 82 to this HashSet
   
   2. We start the while loop with while(inLoop.add(n))
      This means, the HashSet has a sum to add, and it's not duplicate sum
   
   3. Under While loop
   
      if(n > 0)
         remain = we get the last digit of n (19) i.e. 9 (n % 10)
         we add the remain * remain to SquareSum
         
      n/=10
         we get the first digit of n (19), which is 1, because on Java int, whatever after decimal gets truncated
             
      After we are done with this one cycle:
      
      1^2 + 9^2 = 82 (squareSum)
      
      Check if squareSum == 1
         return true   
      
      else
         n = squareSum
     
      Repeat the while Loop
   4. Outside the while loop, we say return false;
   
   TimeComplexity:
   
   O(n), where n is the number of elements (squareSum) added to inloop HashSet
        
*/

import java.util.HashSet;

class HappyNumber
{
   public static void main(String[] args)
   {
      System.out.println(isHappy(19));
   }
   
   public static boolean isHappy(int n)
   {   
      HashSet<Integer> inLoop = new HashSet<Integer>();
      
      int squareSum, remain;
      
      while(inLoop.add(n))
      {
         squareSum = 0;
         
         while(n > 0)
         {
            remain = n % 10;
            
            squareSum += remain * remain;
            
            n /= 10;
         }
         
         if(squareSum == 1)
         {
            return true;
         }
         else
         {
            n = squareSum;
         }
      }
      
      return false;
   }   
}