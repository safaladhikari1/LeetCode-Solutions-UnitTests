/*
   Longest Substring Without Repeating Characters
   
   Given a string s, find the length of the longest substring without repeating characters.
   
   Source: https://leetcode.com/problems/longest-substring-without-repeating-characters/
   
   Example 1:
   
   Input: s = "abcabcbb"
   Output: 3
   
   The answer is "abc", with the length of 3.
   
   Example 2:
   
   Input: s = "pwwkew"
   Output: 3
   
   The answer is "wke", with the length of 3.

   -------
   
   Algorithm:
   Explanation on video: https://youtu.be/WKTgajDkVcA
   
   1. We will use the HashSet to track the longest substring without repeating characters so far.
   
      We created HashSet of Character.
      
      In string = "pwwkew"
      
      We have two pointers slow and fast, both pointing at letter 'p'
      
      maxLength is initiliazed to 0.
      
   2. while (fast < s.length())
   
         if our set does not contain the letter, fast is pointing
            add the letter to set
            increment fast
            
            Calculate the maximum value between maxLength and set.size(), and assign it to maxLength.
            
         else
            It means, set already contains that letter,
            Remove the letter slow is pointing at in the string
            increment the slow
            
            
     For string = "pwwkew"
     
     It adds pw to the set, since our set contains w, it removes p from the set
     Since our set contains w, it removes w from the set. Increment the fast.
     
     Now, set does not have anything, maxLength is 2.
     
     It adds w, k, e, Set.size is 3, maxLength is 3.
     
     Then it checks the last 2, our set contains w, it removes w from our s.
     
     set.size is 2, but our maxLength is already 3 and it returns maxLength as 3.
           
   
   3. Return maxLength.
   
   ---------
   
   Time-Complexity: On the best case, it is O(N), where N is the number of character in the input string.
                    On the worst case, it is O(2N), where our fast and slow pointer will visit each character twice.
   
   Space-Complexity: O(K), where K is the space occupied by our HashSet. 
   
   More information on the Complexity Analysis is on Approach 2: Sliding Window section of the article: https://leetcode.com/problems/longest-substring-without-repeating-characters/solution/                               
      
*/



//import java.util.Stack;

import java.util.HashSet;
import java.util.Set;

class LongestSubstring
{
   public static void main(String[] args)
   {
      String testWord1 = "abcabcbb";
      String testWord2 = "bbbbb";
      String testWord3 = "pwwkew";
      String testWord4 = " ";
      String testWord5 = "dvdf";
      
      System.out.println(lengthOfLongestSubstring(testWord3));
   }
   
   public static int lengthOfLongestSubstring(String s)
   {
      Set<Character> mySet = new HashSet<>();
      
      int slow = 0;
      int fast = 0;
      int maxLength = 0;
      
      while(fast < s.length())
      {
         if(!mySet.contains(s.charAt(fast)))
         {
            mySet.add(s.charAt(fast));
            fast++;
            
            maxLength = Math.max(mySet.size(), maxLength);
         }
         else
         {
            mySet.remove(s.charAt(slow));
            slow++;
         }   
      }
      
      return maxLength;
   }   
   
   /*
   public static int lengthOfLongestSubstring(String s)
   {
      char[] sChar = s.toCharArray();
      
      int maxLength = 0;
      
      Stack<Character> myStack = new Stack<>();
      
      for(char c : sChar)
      {
         if(!myStack.contains(c))
         {
            myStack.push(c);
            
            if(maxLength < myStack.size())
            {
               maxLength = myStack.size();
            }
         }
         else
         {       
            myStack.clear();
            myStack.push(c);
         }
      }
            
      return maxLength;
   }
   */
}