/*
   Monotone Increasing Digits
   
   https://leetcode.com/problems/monotone-increasing-digits/
   
   ----
   
   Algorithm:
   
   1. Convert the N to charArray
   2. Loop from the last element in the array
      
      if charArray[lastElement - 1] > charArray[lastElement]
      {
         monoStop stops at that index (i-1)
         decrement the charArray[i-1]--
      }
      
      For example:
      
      "332"
      
      Since (index 1) 3 is greater than 2 (last index)
      
      It will be, 322
      
      On the next loop, same situations happens
      
      It will be, 222
      
      monostop will be 0 (1 - 1)
      
   3. Then we will convert everything to 9, after the first mono stop
   4. The result will be converted to int, 299
   
   Few explanations on the above approach:
   
   https://leetcode.com/problems/monotone-increasing-digits/solution/
   https://leetcode.com/problems/monotone-increasing-digits/discuss/150752/Clean-Code
   https://leetcode.com/problems/monotone-increasing-digits/discuss/128514/Simple-java-solution-with-clear-explanation.-Very-easy-to-understand.
   
   ------
   
   Time-Complexity: O(N), where N is the number of digits in the input N
   Space-Complexity: O(N), the size of the digits in the input N.
*/

class MonotoneIncreasingDigits
{
   public static void main(String[] args)
   {
      System.out.println(monotoneIncreasingDigits(332));
      
      System.out.println(monotoneIncreasingDigits(1234));   
   }
   
   public static int monotoneIncreasingDigits(int N)
   {
      char[] charArray = String.valueOf(N).toCharArray();
      int monoStop = charArray.length - 1;
      
      for(int i=charArray.length - 1; i > 0; i--)
      {
         if(charArray[i] < charArray[i-1])
         {
            monoStop = i-1;
            charArray[i-1]--;
         }
      }
      
      for(int i=monoStop; i < charArray.length - 1; i++)
      {
         charArray[i+1] = '9';
      }         
      
      return Integer.parseInt(String.valueOf(charArray));
   }
   
   // Bruteforce Solution, doesn't work
   /*
   public static int monotoneIncreasingDigits(int N)
   {
      String NString = String.valueOf(N);
      char[] NArray = NString.toCharArray();
      
      int size = Narray.length();
      
      while(index >= 0)
      {
         if(Character.compare)   
      }
      
   }
   */
}