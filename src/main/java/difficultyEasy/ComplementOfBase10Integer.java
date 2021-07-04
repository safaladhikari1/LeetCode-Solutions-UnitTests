/*
   Complement of Base 10 Integer
   
   For a given number N in base-10, return the complement
   of it's binary representation as a base-10 integer.
   
   Problem Source: https://leetcode.com/problems/complement-of-base-10-integer/
   
   Example 1:
   
   Input: 5
   Output: 2
   
   Explanation: 5 is "101" in binary, with complement "010" in binary, which is 2 in base-10
   
   Example 2:
   
   Input: 7
   Output: 0
   
   Explanation: 7 is "111" in binary, with complement "000" in binary, which is 0 in base-10.
   
   --------
   
   Algorithm:
   
   1. If we look at our first input:
   
      5, the binary of 5 is 101
      
      1(4)   0(2)   1 (1)
      
      4 + 1 = 5
      
      If we can convert an int to it's binary (https://www.geeksforgeeks.org/java-program-for-decimal-to-binary-conversion/)
      Then we can easily check if it's 1 or 0, and add the value to our result.
      
   2. We will first convert an int to it's binary
   
      int[] nBinary = new int[32]; In Java, int has max of 32 bits
      int i = 0;
      
      while(n > 0)
      {
         nBinary[i] = n % 2;
         n /= 2;
         i++;
      }
      
      At this point for 5, we will have have array of [1, 0, 1, 0...]
      
      Since we know our number in i, which is 3
      
      We can only loop from the nums[2] i,e. 3rd index of the array and come backwards.
      
   3. int result = 0;
      
      for(int index=i-1; index >=0; index--)
      {         
         if(nBinary[index] == 0)
         {
            result += (int)(Math.pow(2, index));   
         }
      }
      
      return result;
      
      We will use the Math.pow method
      Since we have to compute the value of the complement
      We will check if nBinary[index] is 0
         If it is, add the Math.pow to our result.
         It returns double, so we cast it to int.
         
   4. Then return result. After running the solution, there is one edge case
      if (n == 0), then we returned 0,
      So I caught it at the beginning, returning 1.
      
   ----------
   
   Time-Complexity: O(logN), we continuously divide N by 2, until it's 0
                    to convert N to binary on our solution.
   Space-Complexity: O(1), the fixed size int[] of 32 does not count.                                     
      

*/

class ComplementOfBase10Integer
{
   public static void main(String[] args)
   {
      System.out.println(bitwiseComplement(5));
      
      System.out.println(bitwiseComplement(7));
      
      System.out.println(bitwiseComplement(0));
   }
   
   public static int bitwiseComplement(int n)
   {
      if(n == 0)
      {
         return 1;
      }
      
      int[] nBinary = new int[32];
      int i = 0;
      
      while(n > 0)
      {
         nBinary[i] = n % 2;
         n /= 2;
         i++;
      }
      
      int result = 0;
      
      for(int index=i-1; index >=0; index--)
      {         
         if(nBinary[index] == 0)
         {
            result += (int)(Math.pow(2, index));   
         }
      }
      
      return result;     
   }
}