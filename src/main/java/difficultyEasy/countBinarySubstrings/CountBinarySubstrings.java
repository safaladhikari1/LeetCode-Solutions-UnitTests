/*
   Count Binary Substrings
   
   Problem Source: https://leetcode.com/problems/count-binary-substrings/
   
   ---
   
   Explanation 1: in the picture
   
   for 
   
   Input: "00110011"
   Output: 6
   
   Explanation 2:
   
   Let's take an example, 00011 here currentLength will become 1 -> 2 ->3 because bits at index 0, 1 and 2 are same i.e. 0's. Then we encounter a 1 bit and at this point we reset the currLength and store it in prevLength.
   The most interesting part is in last if block, where result is incremented. When we are at index 3 i.e. first 1 bit then we would have seen substring 0001 and at this point 01 qualifies as a substring that could be counted towards the final result, so we increment the res. Similarly, when we encounter 2nd 1 bit at that point we would have seen substring 00011 and 0011 also qualifies as a substring that could be counted towards the final result, so we increment the res. Therefore, result is 2. 
   
   Source: https://leetcode.com/problems/count-binary-substrings/discuss/108600/Java-O(n)-Time-O(1)-Space
   
   https://leetcode.com/problems/count-binary-substrings/discuss/108610/Acceptable-JAVA-solution-with-explaination
   
   ----
   
   Time-Complexity: O(N)
   Space-Complexity: O(1)
   
*/

class CountBinarySubstrings
{
   public static void main(String[] args)
   {
      System.out.println(countBinarySubstrings("00110011"));
   }
   
   public static int countBinarySubstrings(String s)
   {
      int count = 0;
      int prevLength = 0;
      int currentLength = 1;
      
      for(int i=1; i < s.length(); i++)
      {
         if(s.charAt(i) == s.charAt(i-1))
         {
            currentLength++;
         }
         else
         {
            prevLength = currentLength;
            currentLength = 1;
         }
         
         if(prevLength >= currentLength)
         {
            count++;
         }
      }
      
      return count;
      
   }
   
   
   
   
   
   // BruteForce Approach, doesn't work
   /*
   public static int countBinarySubstrings(String s)
   {
      int count = 0;
      
      int[] sTable = new int[2];
      
      int windowStart = 0;
      
      for(int windowEnd=0; windowEnd < s.length(); windowEnd++)
      {
         if(s.charAt(windowEnd) == '1')
         {
            sTable[0]++;
         }
         else if(s.charAt(windowEnd) == '0')
         {
            sTable[1]++;
         }
         
         if(sTable[0] == sTable[1])
         {
            count++;
         }
         
         while(windowStart != windowEnd)
         {
            if(s.charAt(windowStart) == '1')
            {
               sTable[0]--;
            }
            else if(s.charAt(windowStart) == '0')
            {
               sTable[1]--;
            }
            
            if(sTable[0] == sTable[1])
            {
               count++;
            }

            windowStart++;
         }
      }
      
      return count;
      
   }
   */

}