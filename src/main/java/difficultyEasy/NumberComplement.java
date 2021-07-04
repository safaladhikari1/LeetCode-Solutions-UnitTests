/*
   Number Complement
   
   Problem Source: https://leetcode.com/problems/number-complement/
   
   ------
   
   Algorithm:
   
   Exactly same as the problem:
   
   https://leetcode.com/problems/complement-of-base-10-integer/
   https://github.com/safaladhikari1/CodingProblems/blob/master/LeetCode/Easy/ComplementOfBase10Integer.java
   
   1. Convert the int number to binary in int[32] array.
   
      For example: 5 in binary is
         
         1 0 1 0   
   
   2. Grab the index of int[32] array
      - loop backwards
      - if it's a 0, calculate (2 to the power of that index)
      - Add to the result
      
      Start loop from index 2 and if it's a 0, calculate 2 to the power of that index
      
      1 0 1 0
      
      0 is on index 1, 2 to the power of 1 is 2.
      
      add 2 to our result.
      
   3. Return the result
   
   -----
   
   Time-Complexity: O(logN), where N is the input integer
   Space-Complexity: O(1)   
   
*/

class NumberComplement
{
   public static void main(String[] args)
   {
      System.out.println(findComplement(5));
      
      System.out.println(findComplement(1));
   }
   
   public static int findComplement(int n)
   {
      int result = 0;
      
      int[] binaryArray = new int[32];
      
      int index = 0;
      
      while(n > 0)
      {
         binaryArray[index] = n % 2;
         n /= 2;
         
         index++;
      }
      
      for(int i = index - 1; i >=0; i--)
      {
         if(binaryArray[i] == 0)
         {
            result += (int)(Math.pow(2, i));
         }
      }
      
      return result;
   }
}