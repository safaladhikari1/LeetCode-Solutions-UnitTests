/*
   Palindrome Number:
   
   Determine whether an integer is a palindrome. An integer is a palindrome when it reads
   the same backward as forward.
   
   Example 1:
   
   Input: 1 2 1
   Output: True
   
   ---
   Bruteforce Solution: Approach 1 and Approach 2 (Self Explanatory)
   
   Time Complexity: O(N), where N is the number of elements in char array.
   
   -----
   
   Approach 3: Without converting the integer to a String
   Explanation: https://youtu.be/gnwFjlUXN1o
   
   Algorithm:
   
   1. If the two numbers look the same, when we reverse the original, it is palindrome.
      
      121 is same as when we reverse it, 121 
      
      12 is not the same as when we reverse it, 21       
   
      We know the two numbers are not palindrome, if one of them is negative.
      
      -121 is not the same as 121-
      
      121- is not even the valid number.
      
   2. First thing we do, if the number is negative, return false
   
      Then we will store the originalNum = x, because we will make changes to the x.
      
      Let's say we have a input number(x) = 49
      
      let initialize our reverseNum = 0
      
      while(x > 0)
      We will try to bring down the 49 to 0 using the while loop, when it's 0, it exists the loop
         
         reverseNum = (reverseNum * 10) + (x % 10);
         
         At first reverseNum will be 0, x % 10 gives us the last digit of 49, which is 9.
         reverseNum = 0 * 10 + 9 = 9
         
         Now we will have remove 9 from 49, using x = x/10; Then x = 4
         
         Since x is still greater than 0, it will go to the second loop
         
         reverseNum = 9 * 10 + 4 % 10; = 90 + 4 = 94
         
         x = x/10, then x = 0
         
         It exits the loop
         
   3. At the end, we check if our reverseNum, 94 == originalNum, 49. Which is not, so it will return false.
   
   --------
   
   Time-Complexity: O(1)
   Space-Complexity: O(1)       
      
*/

class PalindromeNumber
{
   public static void main(String[] args)
   {
      System.out.println(isPalindrome(49));   
   }
   
   // Approach 3, without converting the integer to a String
   public static boolean isPalindrome(int x)
   {
      if(x < 0)
      {
         return false;
      }
      
      int originalNum = x;
      int reverseNum = 0;
      int remainder = 0;
      
      while(x > 0)
      {
         remainder = x % 10;
         reverseNum = (reverseNum * 10) + remainder;
         x = x/10;
      }
      
      return originalNum == reverseNum;
   }  
   
   // Approach 2, using while loop
   /*
   public static boolean isPalindrome(int x)
   {
      String str = String.valueOf(x);
      
      char[] intChar = str.toCharArray();
      
      int first = 0;
      int last = intChar.length - 1;     
      
      while(first < last)
      {
         if(intChar[first] != intChar[last])
         {
            return false;
         }
         first++;
         last--;
      }
      
      return true;
   }
   */
   
      
   // Approach 1 using for loop, moving up to half of array's length.
   /*
   public static boolean isPalindrome(int x)
   {
      String xString = String.valueOf(x);
      char[] xArray = xString.toCharArray();
      
      for(int i=0; i<xArray.length/2; i++)
      {
         int other = xArray.length - i - 1;
         
         if(xArray[i] != xArray[other])
         {
            return false;
         }
      }
      
      return true;     
   }
   */     
}