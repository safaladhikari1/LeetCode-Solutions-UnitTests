/*
   Camelcase Matching
   
   A query word matches a given pattern if we can insert lowercase letters to the pattern word so that it equals the query. (We may insert each character at any position, and may insert 0 characters.)
   
   Given a list of queries, and a pattern, return an answer list of booleans, where answer[i] is true if and only if queries[i] matches the pattern.
   
   Examples:
   
   Input: queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FB"
   Output: [true,false,true,true,false]
   Explanation: 
   "FooBar" can be generated like this "F" + "oo" + "B" + "ar".
   "FootBall" can be generated like this "F" + "oot" + "B" + "all".
   "FrameBuffer" can be generated like this "F" + "rame" + "B" + "uffer".
   
   --------
   
   Algorithm:
   
   1. Let's say on our input, we have:
   
      queries = ["FooBar", "FooBarTest", "FootBall"]
      
      pattern = "FB"
      
      Our output should be: [true, false, true]
      
      Because, "FooBar" only has uppercase letter F and B. All other letters are lowercases.
      "FooBarTest" returns false, because it has three uppercase letters F, B, T which does not match our patter "FB"
      
   2. So we really need to check if we have the same number of upper case letters on each string from our queries and our pattern.
      
      On camelMatch method,
         
         we instantiate our resultList, which is our ArrayList, and we are going to add the boolean values in this list.
         
         We will do a for each loop, so we can bring in one string at a time from queries array
         
            we will call our helper method, which will return true or false if the string matches the pattern
            the result of that method, we will add to our result List.
            
         Return the resultList. 
         
    3. On our helper method
       
       we will have two Pointers,
       patternPointer and queryPointer, both will be 0 at first
       
       Then for loop, that will go on until the length of our input string
         
         if the patterPointer is less than our pattern string's length && letter at inputstring is equal to letter to our pattern
            This means, it's a upper case letter that our pattern string contains, so we should increment our patternPointer
         
         Otherwise, if the letter at inputString is greater than A or less than Z
            If it reach to this condition, that means our pattern string does not contain that upper case letter, so we should return false.
                                     
       for loop continues for all lowercase letters, by default.
       
       At the end, we are checking if the patternPointer is equal to our original pattern.length
       If it's equal, that means we have same number of upper case letters on each string from our queries and our pattern.
       
   -------
   
   Time-Complexity: O(N), where N is the number of string elements on our queries array.
   Space-Complexity: O(N), for each N are storing the boolean results on our resultList (ArrayList)     

*/


import java.util.List;
import java.util.ArrayList;

class CamelcaseMatching
{
   public static void main(String[] args)
   {
      System.out.println(camelMatch(new String[] {"FooBar", "FooBarTest", "FootBall"}, "FB"));
   }
   
   public static List<Boolean> camelMatch(String[] queries, String pattern)
   {
      List<Boolean> resultList = new ArrayList<>();
      
      for(String query : queries)
      {
         resultList.add(helper(query, pattern));
      }
      
      return resultList;
   }
   
   private static boolean helper(String query, String pattern)
   {
      int patternPointer = 0;
      
      for(int queryPointer = 0; queryPointer < query.length(); queryPointer++)
      {
         if(patternPointer < pattern.length() && query.charAt(queryPointer) == pattern.charAt(patternPointer))
         {
            patternPointer++;
         }
         else if(query.charAt(queryPointer) >= 'A' && query.charAt(queryPointer) <= 'Z')
         {
            return false;
         }
      }
      
      return patternPointer == pattern.length();
   }
}