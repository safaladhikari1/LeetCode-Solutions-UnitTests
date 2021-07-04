/*
   Minimum Flips to Make a OR b Equal to c
   
   Problem Source: https://leetcode.com/problems/minimum-flips-to-make-a-or-b-equal-to-c/
   
   ----------
   
   Algorithm:
   
   1. The problem says we have three ints
      
      a(2) -> 0 0 1 0
      b(6) -> 0 1 1 0
      c(5) -> 0 1 0 1
      
      We need to find the number of flips (conversion of bits from 1 to 0 or vice versa)
      So that 
      
      a OR b = c
      
      i.e.
      
      a(1) -> 0 0 0 1
      b(4) -> 0 1 0 0
      c(5) -> 0 1 0 1
      
      We did 3 flips above, so the output was 3.
      
  2.  Let's review the OR operator of Bitwise manipulation
      
      0 OR 0 = 0
      0 OR 1 = 1
      1 OR 0 = 1
      1 OR 1 = 1
      
      (Similar to addition, except 1 OR 1 is 1, not 2)
      
  3. Initialize flip to 0
  
  4. Create a while loop,
     
     // Bring all the a, b or c to 0
     while(a != 0 || b != 0 || c != 0)
     
     Get the lowest significant bit (lsb) of a, b and c
     
  5. Match the bit of lsbC
     
     by either lsbA OR lsbC, lsbB OR lsbC
   
  6. Check the 3 flipping conditions:
     
     Understand the logic of the 3 flipping conditions:
     
     - How to make a OR b = C or b OR a = C
       
       a = 1
       a = 0
       
       b = 1
       b = 0
       
       When C = 0
       
          a = 1 && b = 1
            flip += 2
            
          a = 1 || b = 1
            flip += 1
         
       When C = 1
       
          a = 0 && b = 0
            flip += 1
            
   7. Keep on shifting every bit of a, b and c to the right by 1. Every bit shifting to the right, divides the number by 2.      
            
   8. Return the flip
   
   ------
   
   Time-Complexity: O(1) // 32 bits is constant on int.
   Space-Complexity: O(1) 
   
   References: https://leetcode.com/problems/minimum-flips-to-make-a-or-b-equal-to-c/discuss/488292/THE-MOST-SIMPLE-SOLUTION(if-you-know-a-few-bitman-tricks)
               https://leetcode.com/problems/minimum-flips-to-make-a-or-b-equal-to-c/discuss/477662/Java-O(1)-time-and-O(1)-space/425818        

*/

class MinimumFlips
{
   public static void main(String[] args)
   {
      System.out.println(minFlips(2, 6, 5));   
   }
   
   public static int minFlips(int a, int b, int c)
   {
      int flip = 0;
      
      while(a != 0 || b != 0 || c != 0)
      {
         int lsbA = a & 1;
         int lsbB = b & 1;
         int lsbC = c & 1;
         
         if(lsbC == 0)
         {
            if(lsbA == 1 && lsbB == 1)
            {
               flip+=2;
            }
            else if(lsbA == 1 || lsbB == 1)
            {
               flip+=1;
            }
         }
         else if(lsbC == 1)
         {
            if(lsbA == 0 && lsbB == 0)
            {
               flip+=1;
            }
         }
         
         a = a >> 1;
         b = b >> 1;
         c = c >> 1;
      }
      
      return flip;
   }
}