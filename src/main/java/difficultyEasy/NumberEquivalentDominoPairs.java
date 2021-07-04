/*
   Number of Equivalent Domino Pairs
   
   Problem Source: https://leetcode.com/problems/number-of-equivalent-domino-pairs/
   -----
   
   Algorithm:
   
   Based on the https://leetcode.com/problems/number-of-equivalent-domino-pairs/discuss/339969/JavaPython-3-O(n)-code-with-brief-explanation-and-analysis.
   
   1. Because of constraint,
      
      1 <= dominoes[i][j] <= 9
      
      we can hash every element (domino) from the dominos list using:
      
      min * 10 + max
      
      where,
      
      min = Math.min(dominoes[i], dominoes[j])
      max = Math.max(dominoes[i], dominoes[j])
      
   2. Hash value will be key, pairs will be value on our HashMap
   
   3. If we have the same key for each domino element from the list, we will increment the pair.
      The number of pairs is the number of dominoes already in the map.
   
   4. Count keeps track of the number of pairs.
   
   5. Return count.
   
   -----
   
   Time-Complexity: O(N), where N is the number of domino elements in the dominoes list. Or the dominoes length.
   Space-Complexity: O(N) for our HashMap.

*/

import java.util.Map;
import java.util.HashMap;

class NumberEquivalentDominoPairs
{
   public static void main(String[] args)
   {
      System.out.println(numEquivDominoPairs(new int[][] {{1,2}, {2, 1}, {3, 4}, {5, 6}}));
   }
   
   public static int numEquivDominoPairs(int[][] dominoes)
   {
      int count = 0;
      Map<Integer, Integer> pairMap = new HashMap<>();
      
      for(int[] domino : dominoes)
      {
         int min = Math.min(domino[0], domino[1]);
         int max = Math.max(domino[0], domino[1]);
         
         int key = min * 10 + max;
         
         int pair = pairMap.getOrDefault(key, 0);
         
         count += pair;
         
         pairMap.put(key, pair + 1);
      }
      
      return count;     
   }
   
   // Bruteforce Algorithm, didn't work
   /*
   public static int numEquivDominoPairs(int[][] dominoes)
   {
      int count = 0;
      
      for(int i=0; i < dominoes.length-1; i++)
      {
         for(int j=0; j < dominoes[i].length - 1; j++)
         {
            if(dominoes[i][j] == dominoes[i+1][j] && dominoes[i][j+1] == dominoes[i+1][j+1])
            {
               count++;
            }
            
            if(dominoes[i][j] == dominoes[i+1][j+1] && dominoes[i][j+1] == dominoes[i+1][j])
            {
               count++;
            }
         }
      }
      
      return count;
   }
   */
}