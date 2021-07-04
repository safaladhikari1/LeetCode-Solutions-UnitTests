/*
   Generate Parentheses
   
   Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
   
   Example 1:
   
   Input: n = 3
   Output: ["((()))","(()())","(())()","()(())","()()()"]
   
   Example 2:
   
   Input: n = 1
   Output: ["()"]
   
   -------
   
   Algorithm:
   
   1. The goal is to collect a string of "()" such that "(" matches ")"
      
      If we have 1 pair: "()", the output will only have "()"
      
      But if we have multiple pairs, there will be different way to form a combination such that it opens with "(" and closes with ")"
      
      Each string will have the string.length = 2 * n, where n is the number of pairs.
      
   2. So our base case will be:
   
      If the string.length == 2 * n
         add the string to our List
         return
         
   3. Now on our recursive case, we will need to add "(" and ")"
   
   4. If the number of "(" is less than n
      add "(" to a string
         recurse
         
      Now the later half of n, should be ")"
      So, if the number of "(" is less than ")"
         add to the string
            
      When the string.length == 2 * n
         add the string to the list.
         
   5. When n = 2
      
      "(())" gets added first
      "()()" gets added second.
      
   Detailed Explanation: 
   
   https://leetcode.com/problems/generate-parentheses/discuss/10100/Easy-to-understand-Java-backtracking-solution
   
   Complexity Analysis:
   
   https://leetcode.com/problems/generate-parentheses/solution/
                    
*/

import java.util.ArrayList;
import java.util.List;

class GenerateParenthesis
{
   public static void main(String[] args)
   {
      System.out.println(generateParenthesis(3));   
   }
   
   public static List<String> generateParenthesis(int n)
   {
      List<String> resultList = new ArrayList<>();
      backTrack(resultList, "", 0, 0, n);
      
      return resultList;
   }
   
   private static void backTrack(List<String> list, String str, int open, int close, int max)
   {
      if(str.length() == max*2)
      {
         list.add(str);
         return;
      }
      
      if(open < max)
      {
         backTrack(list, str + "(", open + 1, close, max);
      }
      
      if(close < open)
      {
         backTrack(list, str + ")", open, close + 1, max);
      }
   }
}