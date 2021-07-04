/*
   Sum of Square Numbers
   
   Given a non-negative integer c, decide whether there're two integers a and b such that a2 + b2 = c.
   
   Examples:
   
   Input: c = 5
   Output: true
   Explanation: 1 * 1 + 2 * 2 = 5
   
   Input: c = 3
   Output: false 
   
   --------
   
   Algorithm:
   
   1. Let's say we have c = 5 , which is also our right bound.
   
      0, 1, 2, 3, 4, 5
      
      So we need to check if we have a and b, such that a2 + b2 = c
      
      Now, a and b must be greater than or equal to 0 and less than or equal to 5 and also in sorted order for the above condition to exist.
            
      So on the above case, the largest possible number to form c = 5, is
      
      Sum of 0 on the left + Sqrt(5) on the right
      
  2.  Few explanation on this algorithm:
         
      https://leetcode.com/problems/sum-of-square-numbers/discuss/104930/Java-Two-Pointers-Solution    
      
      https://youtu.be/d_ly84d2f3U
      
  
  -------
  
  Time-Complexity: O(SquareRoot(c))
  Space-Complexity: O(1)   
      
*/


class SumOfSquareNumbers
{
   public static void main(String[] args)
   {
      System.out.println(judgeSquareSum(5));
      System.out.println(judgeSquareSum(3));
   }
   
   public static boolean judgeSquareSum(int c)
   {
      int left = 0;
      int right = (int)Math.sqrt(c);
      
      while(left <= right)
      {
         int sum = left * left + right * right;
         
         if(sum == c)
         {
            return true;
         }
         else if(sum > c)
         {
            right--;
         }
         else if(sum < c)
         {
            left++;
         }
      }
      
      return false;
   }
}  