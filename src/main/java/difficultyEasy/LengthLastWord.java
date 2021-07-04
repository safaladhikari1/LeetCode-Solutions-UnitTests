/*
   Length of Last Word
   
   Given a string s consists of upper/lower case alphabets and empty space characters ' ',
   return the length of last word.
   
   (last word means the last appearing word if we loop from left to right) in the string.
   
   If the last word does not exist, return 0.
   
   Note: A word is defined as a maximal substring consisting of non-space characters only.
   
   Example:
   
   Input: "Hello World"
   Output: 5
   
   ---
   
   Algorithm:
   
   1. Loop through the String from the back, and get the s.CharAt(i)
   2. Make a int count variable and set it to 0
   3. If the s.CharAt(i) is not ' ', increment the count
   4. If the s.CharAt(i) is ' ' and if the count > 0
      
      It means, we got the count of the last word of the string, Return the count.
   5. Return the count at the end
   
   Time Complexity: O(N), where N is the number of characters in the string
   Space Complexity: O(1)  
*/

class LengthLastWord
{
   public static void main(String[] args)
   {
      String testWord = "Hello World";
      String testWord2 = "Hello silly Cat";
      String testWord3 = "a ";
      
      System.out.println(lengthOfLastWord(testWord3));
   }
   
   public static int lengthOfLastWord(String s)
   {
      int count = 0;
      
      int lastStringCount = s.length() - 1;
      
      for(int i=lastStringCount; i >= 0; i--)
      {
         if(s.charAt(i) == ' ' && count > 0)
         {
            return count;
         }
         else if(s.charAt(i) != ' ')
         {
            count++;
         }
      }
      
      return count;
   }   
}