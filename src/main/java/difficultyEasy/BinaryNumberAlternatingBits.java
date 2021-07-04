/*
   Binary Number with Alternating Bits
   
   Problem Source: https://leetcode.com/problems/binary-number-with-alternating-bits/
   
   -----
   
   Algorithm:
   
   1. Let's say our n is 5
      
      In binary it is, 1 0 1
      
      Since the binary has alternating bits, it returns true.
      
   2. First, let's create n to binary, using int[] binaryArray of size 32
      
      this trick converts 5 to 101 (29 0's at the end)
      
      int index = 0;
      
      while(n > 0)
      {
         binaryArray[index] = n % 2;
         n /= 2;
         
         index++;
      }
      
   3. index is pointing at 3, after the while loop ends
      
      0 1 2 3
      1 0 1
      
   4. Then we do a for loop from i = 2 (index - 1), until i >= 0  
      
      At any point, if binaryArray[i] == binaryArray[i + 1]
         return false
   
   5. Otherwise at the end, return true
   
   -------
   
   Time-Complexity: O(1), for any n, we do O(w) work, where w is the number of bits in n, and is always going to be w <= 32, regardless of the size of n.
   Space-Complexity: O(1), the size of binaryArray is constant (32) regardless of the size of n.            

*/

class BinaryNumberAlternatingBits
{
   public static void main(String[] args)
   {
      System.out.println(hasAlternatingBits(7));
   }
   
   public static boolean hasAlternatingBits(int n)
   {
      int[] binaryArray = new int[32];
      
      int index = 0;
      
      while(n > 0)
      {
         binaryArray[index] = n % 2;
         n /= 2;
         
         index++;
      }     
      
      for(int i = index - 1; i >= 0; i--)
      {
         if(binaryArray[i] == binaryArray[i + 1])
         {
            return false;
         }
      }
      
      return true;     
   }
}