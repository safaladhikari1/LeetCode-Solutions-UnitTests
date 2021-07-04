/*
   Valid Palindrome II
   
   Problem Source: https://leetcode.com/problems/valid-palindrome-ii/
   
   ------
   
   Algorithm:
   
   Based on the post: https://leetcode.com/problems/valid-palindrome-ii/discuss/209252/Java-Python-Two-Pointers-with-Thinking-Process
   
   1. We have two pointers left and right
      
      left is at 0
      right is at s.length() - 1;
      
   2. while(left < right)
   
      if s.charAt(left) is not equal to s.charAt(right)
         
         return:
         
         Call isPalindrome, pass in string, left + 1, right
            
            ||
         
         Call isPalindrome, pass in string, left, right - 1
         
      Since we the unequal character might be in left side or right side
      we will have to use OR operator and skip a character from left and right side above
      
      Using OR logic:
      
      true or false is true
      false or true is true
      false or false is false
      true or true is true
      
      Basically if any of the isPalidome returns true, it is true
      
      For example: "abca" the first isPalindrome() returns true, so it short circuits and doesn't go the next isPalindrome, because it returns true no matter what.
      
  3. Otherwise return true.
  
  -------
  
  Time-Complexity: O(N), where N is the number of characters in the string
  Space-Complexity: O(1)
  
*/

class ValidPalindromeII
{
   public static void main(String[] args)
   {
      // System.out.println(isPalindrome("racecar", 0, 6));
      
      System.out.println(validPalindrome("abca"));
   }
   
   public static boolean validPalindrome(String s)
   {
      int left = 0;
      int right = s.length() - 1;
      
      while(left < right)
      {
         if(s.charAt(left) != s.charAt(right))
         {
            return isPalindrome(s, left+1, right) || isPalindrome(s, left, right-1);
         }
         
         left++;
         right--;
      }
      
      return true;     
   }
   
   public static boolean isPalindrome(String s, int l, int r)
   {
      int left = l;
      int right = r;
      
      while(left < right)
      {
         if(s.charAt(left) != s.charAt(right))
         {
            return false;
         }
         
         left++;
         right--;
      }
      
      return true;    
   }
}