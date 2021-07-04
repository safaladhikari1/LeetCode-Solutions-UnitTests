/*
   Valid Perfect Square
   
   Given a positive integer num, write a function which returns True if num is a perfect square else False.
   
   Examples:
   
   Input: num = 16
   Output: true
   
   Constraints: 1 <= num <= 2^31 - 1
   
   ------
   
   Algorithm:
   
   1. Let's say we have numbers from
      
      1, 2, 3, 4, 5, 6, 7, 8, 9
      
      If our num is 9
      
      Our output should be 3, because 3 * 3 is 9
      
      Any numbers that are below and equal to 9, when squared, should equal to 9. And 3 is that number.
      
   2. So, we will use binary search to get our answer 3.
      
      But instead of storing our left and right and mid variables in int,
      We will use long because per our num's constraint:
      
      if left is 1
      and right is 2^31 - 1 (2147483647)
      
      our mid becomes 1073741824
      
      Now if we calculate mid * mid, it will overflow because int cannot handle such a huge numbers.
      So we need to store it in long.
      
   3. We first check if the num is 1,
      If it is, return true, because 1 * 1 is perfect square.
      
      Then we will do binary search. If you are having trouble with that idea, review the video: https://youtu.be/-oqZCmhJ2Zs
      
   4. If we find any mid, when squared that is equal to num
      return true
      
      Otherwise
      
      return false at the end.
      
   -------
   Time-Complexity: O(log N)
   Space-Complexity: N   
      
*/

class ValidPerfectSquare
{
   public static void main(String[] args)
   {
      System.out.println(isPerfectSquare(16));
      System.out.println(isPerfectSquare(14));
   }
   
   public static boolean isPerfectSquare(int num)
   {
      if(num == 1)
      {
         return true;
      }
      
      long left = 1;
      long right = num;
      
      while(left <= right)
      {
         long mid = left + (right - left)/2;
         
         if(num == mid * mid)
         {
            return true;
         }
         else if(num < mid * mid)
         {
            right = mid - 1;
         }
         else if(num > mid * mid)
         {
            left = mid + 1;
         }         
      }
      
      return false;
   }   
}