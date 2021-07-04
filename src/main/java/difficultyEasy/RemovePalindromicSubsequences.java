/*
   Remove Palindromic Subsequence
   
   Given a string s consisting only of letters 'a' and 'b'. In a single step you can remove one palindromic subsequence from s.
   
   Return the minimum number of steps to make the given string empty.
   
   A string is a subsequence of a given string, if it is generated by deleting some characters of a given string without changing its order.
   
   A string is called palindrome if is one that reads the same backward as well as forward.
   
   Examples:
   
   Input: s = "ababa"
   Output: 1
   Explanation: String is already palindrome
   
   Input: s = "baabb"
   Output: 2
   Explanation: "baabb" -> "b" -> "". 
   Remove palindromic subsequence "baab" then "b".
   
   --------
   
   Algorithm:
   
   1. This question is really asking:
   
      If the string is empty
         return 0
      
      If the entire string is palindrome
         return 1
      
      Otherwise, since the problem allows us to remove one palindromic subsequence of the string.
          If we just consider, the letter 'a' by itself, it is a palindromic subsequence of the string.
          Similary, the letter 'b' by itself, is a palindromic subsequence of the string
          
          So we can delete all characters 'a' in 1st operation
          delete all characters 'b' in 2nd operation,
          
          Which will return 2 for 2 operations.
          
    2. That's what we did on our code
       
       If the string's length is 0
         return 0
         
       If it's the entire string is a palindrome
         return 1
         we have a helper isPalindrome method, that will let us know if the string is palindrome or not.
       
       Otherwise,
         return 2.
         
    -------
    
    Time-Complexity: O(N), where N is the length of the string
    Space-Complexity: O(1), it's a constant space solution.                

*/

class RemovePalindromicSubsequences
{
   public static void main(String[] args)
   {
      System.out.println(removePalindromeSub("ababa"));
      System.out.println(removePalindromeSub("abb"));
      System.out.println(removePalindromeSub("baabb"));   
   }
   
   public static int removePalindromeSub(String s)
   {
      if(s.length() == 0)
      {
         return 0;
      }
      else if(isPalindrome(s))
      {
         return 1;
      }   
      else
      {
         return 2;
      }
   }
   
   private static boolean isPalindrome(String s)
   {
      int n = s.length();
      
      for(int i=0; i < n/2 ; i++)
      {
         if(s.charAt(i) != s.charAt(n - 1 - i))
         {
            return false;
         }
      }
      
      return true;
   }
}