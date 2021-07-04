/*
   Given a string s containing just the characters
   
   '(' , ')' , '{' , '}' , '[' and ']'
   
   determine if the input string is valid.
   
   An input string is valid if:
   
   1. Open brackets must be closed by the same type of brackets.
   2. Open brackets must be closed in the correct order.
   
   Example 1:
   
   Input: s = "()"
   Output: True
   
   Example 2:
   
   Input: s = "()[]{}"
   Output: True
   
   Example 3:
   
   Input: s = "(]"
   Output: False
  
   ---
   Algorthm based on video: https://youtu.be/hUOkKDqVlig
   
   1. Compare the charAt(i) of String, to get the char value of the indices of String
   2. If the char value is '[', '{' or '(' , push it to stack
   3. If it's not, compare it to the top of the stack, does it closes it?
      If it closes, pop from the stack
      Otherwise, return false, because it's not related to [, { or )
   4. At the end, find out if the stack is empty, if it is empty, which means it is a valid parenthesis.
       
*/

import java.util.Stack;

class ValidParentheses
{
   public static void main(String[] args)
   {
      String testString = "()[]{}";
      String testString2 = "{[]}";
      String testString3 = "([)]";
      System.out.println(isValid(testString));
   }
   
   public static boolean isValid(String s)
   {
      Stack<Character> myStack = new Stack<>();
      
      for(int i=0; i < s.length(); i++)
      {
         char currentChar = s.charAt(i);
         
         if(currentChar == '[' || currentChar == '{' || currentChar == '(')
         {
            myStack.push(currentChar);
         }
         
         else if(!myStack.isEmpty() && currentChar == ']' && myStack.peek() == '[')
         {
            myStack.pop();
         }
         
         else if(!myStack.isEmpty() && currentChar == '}' && myStack.peek() == '{')
         {
            myStack.pop();
         }
         
         else if(!myStack.isEmpty() && currentChar == ')' && myStack.peek() == '(')
         {
            myStack.pop();
         }
         
         else
         {
            return false;
         }           
      }
      
      return myStack.isEmpty();    
   }
   
   /*
   public static boolean isValid(String s)
   {    
      int roundBracket = 0;
      int curlyBracket = 0;
      int squareBracket = 0;
      
      for(int i=0; i < s.length(); i++)
      {                 
         char current = s.charAt(i);        
         
         if(current == '(')
         {
            roundBracket++;
         }
         
         else if(current == '{')
         {
            curlyBracket++;
         }
         
         else if(current == '[')
         {
            squareBracket++;
         }
         
         else if(current == ')')
         {
            roundBracket--;
         }
         
         else if(current == '}')
         {
            curlyBracket--;
         }
         
         else if(current == ']')
         {
            squareBracket--;
         }
      }
      
      return (roundBracket == 0 && curlyBracket == 0 && squareBracket == 0);
   }
   */
}