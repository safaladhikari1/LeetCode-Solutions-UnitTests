/*
   Convert a Number to Hexadecimal
   
   Given an integer, write an algorithm to convert it to hexadecimal. For negative integer, two’s complement method is used.
   
   Problem Source: https://leetcode.com/problems/convert-a-number-to-hexadecimal/
   
   ---------
   
   Algorithm:
   
   1. The algorithm on the solution below is briefly explained in: https://leetcode.com/problems/convert-a-number-to-hexadecimal/discuss/824192/Java-100-Time-with-Detailed-Explanation
   
   2. The idea is:
      
      If we do a bit wise operator, by num & 15 (0000 0000 ... 1111), it will give us the last 4 binary of the num.
      
      Then we can compare that last 4 binary, on our hexMap char Array. Which will give us the binary for that last 4.
      It's same process, when we convert decimal to hex, with pen and paper.
  
   3. Then we do num = num >>> 4. This is unsigned bit shift right.
      It will drop the last 4 in the binary
      
      Then we go to the top of the loop, and evaluate num & 15 again. It's a 32 bit signed integer.
      num = num >>> 4, will eventually make the binary of num 0
      
      At that point loop stops.
      
   4. Since we were appending the chars from our hexMap to our string builder, we will need to reverse it and return it as a string.
   
   -------
   
   Time-Complexity: O(1), we know the range is always going to be 32 bit signed integer. We are always evaluating 4 bits at a time, for up to 32 bits.
   Space-Complexity: O(1), space is always constant with char[] array     
  
*/


class ConvertNumberToHex
{
   public static void main(String[] args)
   {
      System.out.println(toHex(26));
      System.out.println(toHex(-1));
   }
   
   public static String toHex(int num)
   {
      char[] hexMap = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
      
      StringBuilder result = new StringBuilder();
      
      if(num == 0)
      {
         return "0";
      }
      
      while(num != 0)
      {
         result.append(hexMap[(num & 15)]);
         num = (num >>> 4);
      }
            
      return result.reverse().toString();
   }
}