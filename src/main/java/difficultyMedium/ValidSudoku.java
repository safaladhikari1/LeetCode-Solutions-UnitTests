/*
   Valid Sudoku
   
   Problem Source: https://leetcode.com/problems/valid-sudoku/
   
   -----
   
   Algorithm:
   
   1. Goal is to do one pass of every cells in the sudoku's total 81 cells
      and check if they pass the following conditions:
      
         - There is no rows with duplicates
         - There is no columns with duplicates
         - There is no regions with duplicates
         
   2. Make arrays of rowSet, columnSet and regionSet of length 9
      
      We are saying 
      
      our rowSet will have an array of HashSet that represents each rows in the board. In total there will be 9 rows
      our columnSet will have an array of HashSet that represents each columns in the board. 9 columns
      our regionSet will have an array of HashSet that represents 9 regions in the board.
      
      0     3     6     9
         
         0     1     2
      
      3
      
         3     4     5      
      
      6
      
         6     7     8
      
      9
     
      
  3. Create a for loop that loops up to length 9
      
     Instantiate rowSet[i] = new HashSet<>();
     
  4. Loop through i an j and get the 
     
     char value of the board[i][j] 
     
     For region, we have a helper method that will give us the appropriate regionNum according to row and column number.
     
     if the value is not '.'
      
         convert the char value to int
         
         and add it to rowSet[i], columnSet[j] and regionSet[regionNum]  
         If you can't add it, return false, that means we have duplicates.
              
  5. Otherwise, return true.
  
  -----
  
  Time-Complexity: O(1), our double for loop loops exactly 81 times and does not scale up according to the input of the method.
  Space-Complexity: O(1), same reason as above, the size of the hash table does not grow, regardless of the input.     

*/


import java.util.Set;
import java.util.HashSet;

class ValidSudoku
{
   public static void main(String[] args)
   {
      char[][] testBoard = new char[][]{
         {'5','3','.','.','7','.','.','.','.'},
         {'6','.','.','1','9','5','.','.','.'}
      }; 
      
      isValidSudoku(testBoard);  
   }
   
   public static boolean isValidSudoku(char[][] board)
   {
      Set<Integer>[] rowSet = new HashSet[9];
      Set<Integer>[] columnSet = new HashSet[9];
      Set<Integer>[] regionSet = new HashSet[9];
      
      for(int i=0; i < 9; i++)
      {
         rowSet[i] = new HashSet<Integer>();
         columnSet[i] = new HashSet<Integer>();
         regionSet[i] = new HashSet<Integer>();
      }
      
      for(int i=0; i < 9; i++)
      {
         for(int j=0; j < 9; j++)
         {
            char value = board[i][j];
            int regionNum = getRegionNum(i, j);
            
            if(value != '.')
            {
               int valueInt = Character.getNumericValue(value);
               
               if(!rowSet[i].add(valueInt) || !columnSet[j].add(valueInt) || !regionSet[regionNum].add(valueInt))
               {
                  return false;
               }
            }   
         }
      }
      
      return true;
   }
   
   public static int getRegionNum(int row, int column)
   {
      if(row < 3 && column < 3)
      {
         return 0;
      }
      else if(row < 3 && column < 6)
      {
         return 1;
      }
      else if(row < 3 && column < 9)
      {
         return 2;
      }
      else if(row < 6 && column < 3)
      {
         return 3;
      }
      else if(row < 6 && column < 6)
      {
         return 4;
      }
      else if(row < 6 && column < 9)
      {
         return 5;
      }
      else if(row < 9 && column < 3)
      {
         return 6;
      }
      else if(row < 9 && column < 6)
      {
         return 7;
      }
      else if(row < 9 && column < 9)
      {
         return 8;
      }
      else 
      {
         return -1;
      }     
   }
}