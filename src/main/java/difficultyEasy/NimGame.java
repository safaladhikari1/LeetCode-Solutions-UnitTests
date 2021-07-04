/*
   Nim Game
   
   Problem Source/Solution Explanation: https://leetcode.com/problems/nim-game/solution/
   
   -------
   
   Time Complexity : O(1)
   Space Complexity : O(1)

*/

class NimGame
{
   public static void main(String[] args)
   {
      System.out.println(canWinNim(8));
   }
   
   public static boolean canWinNim(int n)
   {
      return n%4 != 0;
   }
}