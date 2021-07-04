/*
   Count of Matches in Tournament
   
   Problem Source: https://leetcode.com/problems/count-of-matches-in-tournament/
   
   -----
   
   Approach 1:
   
   Algorithm:
   
   1. Getting the input n, to 1
      
      And storing the count in a count variable, while following the if / else logic per problem description.
      
   
   Time-Complexity: O(log N), we we are diving N by half on each iteration in the while loop, until it's 1
   Space-Complexity: O(1)
   
   ----
   
   Approach 2:
   
   https://leetcode.com/problems/count-of-matches-in-tournament/discuss/970311/Just-return-n-1-O(1)
   
   Time-Complexity: O(1)
   Space-Complexity: O(1)
   

*/

class CountOfMatches
{
   public static void main(String[] args)
   {
      System.out.println(numberOfMatches(7));   
   }
   
   public static int numberOfMatches(int n)
   {
      int count = 0;
      
      while(n > 1)
      {
         if(n % 2 == 0)
         {
            count += n/2;
            n = n/2;          
         }
         else
         {
            count += (n-1)/2;
            n = ((n-1)/2) + 1;
         }
      }
      
      return count; 
   }
}