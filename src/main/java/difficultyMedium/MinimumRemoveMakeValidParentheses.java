/*
   Problem Source: https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
   
   Algorithm Explained in: https://youtu.be/TCGtdeYUfOY
   
   -------
   
   Time-Complexity: O(N), where N is the number of characters in the string
   Space-Complexity: O(N), where N is the number of characters used in the stack.
*/

import java.util.Stack;

class MinimumRemoveMakeValidParentheses
{
   public static void main(String[] args)
   {
      System.out.println(minRemoveToMakeValid("lee(t(c)o)de)"));
      
      System.out.println(minRemoveToMakeValid("(a(b(c)d)"));
      
      System.out.println(minRemoveToMakeValid("))(("));
   }
   
   public static String minRemoveToMakeValid(String s)
   {
      StringBuilder sb = new StringBuilder();
      Stack<Integer> tempStack = new Stack<>();
      
      int closingBrace = 0;
      
      for(int i=0; i < s.length(); i++)
      {
         char letter = s.charAt(i);
         
         if(letter == '(')
         {
            sb.append(letter);
            tempStack.push(i);
         }
         else if(letter == ')')
         {
            if(!tempStack.isEmpty())
            {
               sb.append(letter);
               tempStack.pop();
            }
            else
            {
               closingBrace++;   
            }
         }
         else
         {
            sb.append(letter);
         }    
      }
      
      // For case: "))(("
      while(!tempStack.isEmpty())
      {
         sb.deleteCharAt(tempStack.pop() - closingBrace);
      }
 
      return sb.toString();   
   }
   
   
   // Bruteforce Approach (doesn't work)
   /*
   public static String minRemoveToMakeValid(String s)
   {
      StringBuilder sb = new StringBuilder();
      Stack<Character> tempStack = new Stack<>();
      
      for(int i=0; i < s.length(); i++)
      {
         if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z')
         {
            sb.append(s.charAt(i));
         }
         else if(s.charAt(i) == '(')
         {
            sb.append(s.charAt(i));
            tempStack.push(s.charAt(i));
         }
         else if(s.charAt(i) == ')' && !tempStack.isEmpty())
         {
            sb.append(s.charAt(i));
            tempStack.pop();
         }
      }
      
      if(tempStack.isEmpty())
      {
         return "";
      }
      else
      {
         return sb.toString();
      }     
   }
   */
}