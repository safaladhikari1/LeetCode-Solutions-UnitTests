/*
   Valid Palindrome
   
   Given a string, determine if it is a palindrome, considering only alphanumeric characters and
   ignoring cases.
   
   Note: For the purpose of this problem, we define empty string as valid palindrome.
   
   Example 1:
   Input: "A man, a plan, a canal: Panama"
   Output: True
   
   Example 2:
   Input: "race a car"
   Output: False
   
   Constraints:
   - s consists only of printable ASCII characters
   
   ----
   
   Algorithm:
   
   1. If we put two pointers, at the front of the string, pointing at letter 0
      At the end of the string, pointing at letter end
      
      A string is a valid palindrome, if both pointers have the same letters,
      when we increment the pointer at the front of the string
      and decrement the pointer at the end of the string.
      
   2. On our algorithm, we just have compare the string for the same letters and numbers.
   
   3. So we first convert the string to lower case.
   
   4. Then, two pointers:
      pointerStart at 0
      pointerEnd at End
      
      while(pointerStart < pointerEnd)
      this means, if pointerStart cross path with pointerEnd,
      which means we went through all the characters in the String, exit the loop
   
      Inside the while loop
      
         check if pointerStart < pointer End, and if the char is not number or lowercase alphabet (other characters)
            increment pointerStart
         
         check if pointerStart < pointer End, and if the char is not number or lowercase alphabet (other characters)
            decrement pointerEnd
         
         At this point we know, that char on both pointerStart and pointerEnd, are either a number or lower case alphabet
            if they are not equal, return false, they are not palindrome.
         
         increment pointerStart
         increment pointerEnd
    
    5. return true, which means char on pointerStart and pointerEnd are equal, since they passed all the above tests.
    
    6. isValidChar() a helper method, that returns boolean
        
       it checks if(value >= 97 && value <= 122 || value >= 48 && value <=57)      
         if value is a lowercase letter or a digit, return true 
         
       Or return false.  
       
       Source: https://www.utf8-chartable.de/unicode-utf8-table.pl?utf8=dec&addlinks=1&unicodeinhtml=dec&htmlent=1
               has the decimals values, that String class's charAt returns.    
            
    ----
    
    The above concept is also explained on: https://youtu.be/3jjptAxlivQ
    
    -----
    
    Time-Complexity: O(N), where N is the chars in the String, the worst case, we check every single char in the string
    
    Space-Complexity: O(1), we didn't really store anything.         

*/

class ValidPalindrome
{
   public static void main(String[] args)
   {
      String testString = "A man, a plan, a canal: Panama";
      String testString2 = ".,";
      String testString3 = "0P";
      System.out.println(isPalindrome(testString3));
   }
   
   public static boolean isPalindrome(String str)
   {
      String strLower = str.toLowerCase();
      
      int pointerStart = 0;
      int pointerEnd = strLower.length() - 1;
      
      while(pointerStart < pointerEnd)
      {
         while(pointerStart < pointerEnd && !(isValidChar(strLower.charAt(pointerStart))))
         {
            pointerStart++;
         }
         
         while(pointerStart < pointerEnd && !(isValidChar(strLower.charAt(pointerEnd))))
         {
            pointerEnd--;
         }
         
         if(strLower.charAt(pointerStart) != strLower.charAt(pointerEnd))
         {
            return false;
         }
         
         pointerStart++;
         pointerEnd--;
      }
      
      return true;
   }
   
   private static boolean isValidChar(int value)
   {
      if(value >= 97 && value <= 122 || value >= 48 && value <=57)
      {
         return true;
      }
      
      else
      {
         return false;
      }
   }
   
   // Second Try, after few months
   /*
   public static boolean isPalindrome(String s)
   {
      int startPoint = 0;
      int endPoint = s.length() - 1;
      
      String sLower = s.toLowerCase();
      
      while(startPoint < endPoint)
      {
         while(startPoint < endPoint && !isValidCharacter(sLower.charAt(startPoint)))
         {
            startPoint++;
         }
         
         while(startPoint < endPoint && !isValidCharacter(sLower.charAt(endPoint)))
         {
            endPoint--;
         }
         
         if(sLower.charAt(startPoint) != sLower.charAt(endPoint))
         {
            return false;
         }
         
         startPoint++;
         endPoint--;
      }
      
      return true;
         
   }
   
   public static boolean isValidCharacter(char c)
   {
      if(c >= 'a' && c <= 'z')
      {
         return true;
      }
      else if(c >= '0' && c <= '9')
      {
         return true;
      }
      else
      {
         return false;
      }
   }
   */
}