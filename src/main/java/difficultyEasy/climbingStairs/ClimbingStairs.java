/**
   Climbing Stairs
   
   You are climbing a staircase. It takes n steps to reach to the top.
   
   Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb
   to the top?
   
   Example 1:
   
   Input: 2
   Output: 2
   
   Explanation: There are two ways to climb to the top.
   
   Example 2:
   
   Input: 3
   Output: 3
   
   Explanation: There are three ways to climb to the top.
   
   1. 1 step + 1 step + 1 step
   2. 1 step + 2 steps
   3. 2 steps + 1 step
   
   ----
   
   Referenced Video: https://youtu.be/NFJ3m9a1oJQ
   Referenced Code: https://github.com/bephrem1/backtobackswe/tree/master/Dynamic%20Programming%2C%20Recursion%2C%20%26%20Backtracking/ClimbingStairs
   
   ----
   
   Solution 1:
   
   This is a Top Down, No Memoization depth first approach.
   Time Complexity: O(2^N), where N is the number of nodes (depth of the recursion) in the tree.
   
   Space Complexity: O(N), where N is the call stack max depth of the recursion tree
   
   Duplicating sub problems makes it very inefficient.
   
      
   1. For 6 stairs, we break it down into sub problems
      
      we take 1 step
      n - 1, 5 stairs remaining
      
      we take 2 steps
      n - 2, 4 stairs remaining
      
      and so on.
      
   2. When n == 0, there are no more steps to take, we reach at the 6th stairs
      return 1
      
      When n < 0, we took 1 extra step, so we fall
      return 0
      
   3. return climbStairsHelper(n - 1) + climbStairsHelper(n - 2);
      we add the sum of the answer to the subproblems, n-1 and n-2, recursively.
      
      Which will give us total number of ways, we can climb the given number of stairs.
   
   ------
    
   Solution 2:
   
   Algorithm:
   
   This is a Top Down, Memoization depth first approach.
   
   1. This uses the same approach as above, but with a little tweaking
      
      If we draw our tree diagram for input: 6 (number of stairs)
      
      We were duplicating our sub problems
      
      For example: 
      
      When n = 1,
      
      climbStairsHelper(n - 1)
         climbStairsHelper(0)
            since n == 0, it returned us 1
            
      
      But we duplicating the above recursion again and again on various subproblems
      down the depth first recursion
      
      So we created a int[] memo array
      
      Which stores the value of memo[n]
      
      So, when n == 1, we know it returns us 1
      So we store memo[1] = 1
      
    2. Then pass the reference to that memo[] array on each sub problems
    
       we check if (memo[n] > 0)
         return memo[n] , so on sub problems it does not have to go down the recursion
         because we will have already known the answer from previous similar sub problem
         this saves us time and memory.
         
    3. At the end, we return memo[n] which is memo[6], for 6 number of stairs.
 
   Time Complexity:  
   O(N), where N is the total number stairs to climb
   
   Space Complexity:
   O(N), where N is the space we use to store our sub problems
   
   -----
   Solution 3:
   
   Dynamic Programming Array
   
*/

class ClimbingStairs
{
   // Solution 2  
   public int climbStairs(int n)
   {
      int[] memo = new int[n + 1];
      return climbStairsHelper(n, memo);      
   }
   
   private int climbStairsHelper(int n, int[] memo)
   {
      if(n < 0)
      {
         return 0;
      }
      
      if(n == 0)
      {
         return 1;
      }
      
      if(memo[n] > 0)
      {
         return memo[n];
      }
      
      memo[n] = climbStairsHelper(n - 1, memo) + climbStairsHelper(n - 2, memo);
      
      return memo[n];   
   }  
   
   // Solution 1
   
   /*
   public int climbStairs(int n)
   {
      return climbStairsHelper(n);   
   }
   
   private int climbStairsHelper(int n)
   {
      if(n < 0)
      {
         return 0;
      }
      
      if(n == 0)
      {
         return 1;
      }
      
      return climbStairsHelper(n - 1) + climbStairsHelper(n - 2);
   }
   */   
}