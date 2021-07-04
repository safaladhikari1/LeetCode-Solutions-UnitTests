/*
   The K Weakest Rows in a Matrix
   
   Problem Source: https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/
   
   Algorithm:
   
   1. We have a 2D array
   
      Loop through the row (1st loop)
         initialize the soldiers = 0         
         loop through the column (2nd loop)
            count the soldiers
         Store the index, soldiers count on a map
   
   2. Start a second loop, up the length of k (length of our result array)
      
      Get the collection of map.values, and find the minimum value among those values
      
      Another for loop, of our key,value entry pair
         if pair.getvalue equals min
            this means, we need to get the key of that minimum value, store it our result array
            remove the key from our map
            break
      
      Repeat
      
   3. Return the result array. 
   
   ------
   
   Time-Complexity: O(M * N), where M the size of the row, N is the size of the columns on our 2D array.
   Space-Complexity: O(M), where M is the size of the row. We are storing the key-value pairs for every row from the array. So, the higher the row, the more space our map will take in memory.
                              
*/

import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Collections;

class KWeakestRowsMatrix
{
   public static void main(String[] args)
   {
      int[][] testArray = new int[][] {{1, 1, 0, 0, 0}, {1, 1, 1, 1, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 0, 0}, {1, 1, 1, 1, 1}};
      
      System.out.println(Arrays.toString(kWeakestRows(testArray, 3)));
      
   }
   
   public static int[] kWeakestRows(int[][] mat, int k)
   {
      int[] result = new int[k];
      
      Map<Integer, Integer> counterMap = new HashMap<>();
          
      for(int i=0; i<mat.length; i++)
      {   
         int soldiers = 0;
         
         for(int j=0; j<mat[i].length; j++)
         {
            if(mat[i][j] == 1)
            {
               soldiers++;
            }
         }
         
         counterMap.put(i, soldiers);              
      }      
      
      for(int i=0; i < k; i++)
      {
         int min = Collections.min(counterMap.values());
         
         for(Map.Entry<Integer, Integer> pair : counterMap.entrySet())
         {
            if(pair.getValue() == min)
            {
               result[i] = pair.getKey();
               counterMap.remove(pair.getKey());
               break;  
            }
         }         
      }
      
      return result;
   }
}