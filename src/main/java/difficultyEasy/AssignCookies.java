/*
   Assign Cookies
   
   Problem Source: https://leetcode.com/problems/assign-cookies/
   
   ------
   
   Algorithm:
   
   Reference: https://leetcode.com/problems/assign-cookies/discuss/93997/Array-sort-%2B-Two-pointer-greedy-solution-O(nlogn)
   
   1. Arrays.sort 
         int[] g and int[] s
         
   2. Initialize pointerG and pointerS to 0       
   
   3. Make a while loop
      (pointerG less than g.length && pointerS less than s.length)
         
         Only move pointerG, if greedy children are satisfied by cookie size
         if(s[pointerS] >= g[pointerG])
         {
            pointerG++;
            pointerS++;
         }
         
         Otherwise, move pointerS
         else
         {
            pointerS++;
         }
  
  4. Return the pointerG.
  
  -----
  
  Time-Complexity: 
  
  Due to two sorting of arrays g and s
  
  O(mlogm + nlogn + m + n), where m and n are the length of arrays g and s respectively.
  
  Space-Complexity: 
  
  O(mlogm) + O(nlogn), Arrays.sort() method uses quick sort algorithm
  

*/

import java.util.Arrays;

class AssignCookies
{
   public static void main(String[] args)
   {
      System.out.println(findContentChildren(new int[] {1, 2, 3}, new int[] {1, 1}));
      
      System.out.println(findContentChildren(new int[] {1, 2}, new int[] {1, 2, 3}));   
   }
   
   public static int findContentChildren(int[] g, int[] s)
   {
      Arrays.sort(g);
      Arrays.sort(s);
      
      int pointerG = 0;
      int pointerS = 0;
      
      while(pointerG < g.length && pointerS < s.length)
      {
         if(s[pointerS] >= g[pointerG])
         {
            pointerG++;
            pointerS++;
         }
         else
         {
            pointerS++;
         }
      }
      
      return pointerG;
   }
   
   // Bruteforce Solution, does not work
   /*
   public static int findContentChildren(int[] g, int[] s)
   {
      int content = 0;
      
      for(int i=0; i < g.length; i++)
      {
         int greed = g[i];
            
         for(int j=0; j < s.length; j++)
         {
            if(s[j] == greed)
            {
               content++;
               s[j] = -1;
               break;
            }
         }
      }
      
      return content;         
   }
   */ 
}