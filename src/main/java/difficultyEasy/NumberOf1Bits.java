/*
   Number of 1 Bits
   
   Write a function that takes an unsigned integer and returns the number of '1' bits it has.
   
   Constraint: The input must be a binary string of length 32
   
   -----
   
   Unsigned integer is an integer that cannot be negative, it has higher range of positive values
   Signed integer is an integer that can be negative but has a lower positive range.
   
   More explanation: https://stackoverflow.com/questions/5739888/what-is-the-difference-between-signed-and-unsigned-int
   
   ----
   
   Algorithm
   
   1. For simplicy let's say our binary string has length 4
   
      So, n = 13 will be 1 1 0 1
      
      We check each of the bits of the number, from right.
      If the bit is 1, we add it to our bits counter.
      
      We can check if the ith bit of a number is set, using a bit mask.
      
   2. At first loop,
      
      if((n & mask) != 0)
      
      n = 1 1 0 1
      m = 0 0 0 1
      & = 0 0 0 1
      
      Since it's not equal to 0, bits++
      
      mask <<=1
      m will be bit shift left by 1, 0 0 1 0
      
   3. At second loop,
      
      n = 1 1 0 1
      m = 0 0 1 0
      & = 0 0 0 0
      
      Since it's equal to 0, we won't increment bits
      
      mask <<=1
      m will be 0 1 0 0
      
   4. At third loop,
   
      n = 1 1 0 1
      m = 0 1 0 0
      & = 0 1 0 0
      
      Since it's not equal to 0, bits++
      
      mask <<=1
      m will be 1 0 0 0 
      
  5. At fourth loop,
   
      n = 1 1 0 1
      m = 1 0 0 0
      & = 1 0 0 0
      
      Since it's not equal to 0, bits++
      
      mask <<=1
      m will be 1 0 0 0
      
      
      -----
      
      Our for loop stops if we say i < 4
      
      we return bits = 3.
      
   -----------
  
   Time-Complexity:  O(1), the run time depends on the number of bits in n. Since n in our code is 32 bits integer, the time complexity is constant.
   Space-Complexity: O(1)             
*/

class NumberOf1Bits
{
   public static void main(String[] args)
   {
      System.out.println(hammingWeight(11));
   }
   
   public static int hammingWeight(int n)
   {
      int bits = 0;
      int mask = 1;
      
      for(int i=0; i < 32; i++)
      {
         if((n & mask) != 0)
         {
            bits++;
         }
         
         mask <<=1;
      }
      
      return bits;
   }
}