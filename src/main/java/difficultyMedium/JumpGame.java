/*
   Jump Game
   
   Problem Source: https://leetcode.com/problems/jump-game/
   
   Review: https://leetcode.com/problems/jump-game/discuss/?currentPage=1&orderBy=most_votes&query=

*/

class JumpGame
{
   public static void main(String[] args)
   {
      System.out.println(canJump(new int[] {2, 3, 1, 1, 4}));
      
      System.out.println(canJump(new int[] {3, 2, 1, 0, 4}));
      
      System.out.println(canJump(new int[] {1, 2, 3}));
   }
   
   // Bruteforce attempt at canJump doesn't work yet
   public static boolean canJump(int[] nums)
   {
      if(nums.length == 1)
      {
         if(nums[0] == 1)
         {
            return true;
         }
      }
      
      int targetIndex = nums.length - 1;
      
      for(int i=0; i < nums.length; i++)
      {
         if(i + nums[i] == targetIndex)
         {
            return true;
         }
      }
      
      return false;     
   }
}