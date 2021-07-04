/*
   Backspace String Compare
   
   Given two strings S and T, return if they are equal when both are typed into empty text editors.
   # means a backspace character.
   
   Note that after backspacing an empty text, the text will continue empty.
   
   Example:
   
   Input: S = "ab#c", T = "ad#c"
   Output: true
   Explanation: Both S and T become "ac".
   
   ------------
   Algorithm:
   
   1. This approach is like, we will build a string for both S and T, compare if it's equal.
   2. On our helper method,
   
      We built a stack of Stack<Character>
      
      we will pass in the first String: "ab#c"
      
      we will convert the string to char array
      
      we will check each char in the array,
         if char != '#'
            push it our stack
         else if(stack is not empty)
            pop the char from the stack
            
      
   3. Stack is Last In First Out,
      So, we have [a, b, #, c]
      
      We will push: a, b
      We see #, we will pop the b
      
      At the end we will have a, c in the Stack
      
      We will convert the string out of that Stack<Character>
      
   4. On our public method, we will do the above for both strings, and compare if it's equal.
   
   --------
   
   Time-Complexity: O(M + N), where M and N are lengths of String S and T respectively. This is because, we will build out strings
                     twice for S and T, and we loop through every chars on those strings.
                     
   Space-Complexity: O(M + N), the bigger the length of the String S and T, the bigger our stacks on build method.                
                                     
*/

import java.util.Stack;

class BackspaceStringCompare
{
   public static void main(String[] args)
   {
      String test1 = "ab#c";
      String test2 = "ad#c";
      
      System.out.println(backspaceCompare(test1, test2));
   }
   
   public static boolean backspaceCompare(String S, String T)
   {
      return build(S).equals(build(T));
   }
   
   private static String build(String str)
   {
      Stack<Character> result = new Stack<>();
      char[] strChar = str.toCharArray();
      
      for(char c : strChar)
      {
         if(c != '#')
         {
            result.push(c);
         }
         else if(!result.empty())
         {
            result.pop();
         }
      }
      
      return String.valueOf(result);
   }
   
   // Approach 2
   /*
   public static boolean backspaceCompare(String S, String T)
   {
      Stack<Character> s1 = new Stack<>();
      Stack<Character> s2 = new Stack<>();
      
      for(int i=0; i < S.length(); i++)
      {
         if(S.charAt(i) != '#')
         {
            s1.push(S.charAt(i));
         }
         else if(!s1.empty())
         {
            s1.pop();
         }
      }
      
      for(int i=0; i < T.length(); i++)
      {
         if(T.charAt(i) != '#')
         {
            s2.push(T.charAt(i));
         }
         else if(!s2.empty())
         {
           s2.pop();
         }
      }
      
      return s1.toString().equals(s2.toString());
   }
   */ 
}