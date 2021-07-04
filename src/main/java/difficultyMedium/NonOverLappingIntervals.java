class NonOverLappingIntervals
{
   public static void main(String[] args)
   {
      int[][] testArray = new int[][] { {1,2}, {2,3}, {3,4}, {1, 3}};
      
      int[][] testArray2 = new int[][] { {1,2}, {1, 2}, {1, 2}};
      
      int[][] testArray3 = new int[][] { {1,100}, {11, 22}, {1, 11}, {2, 12}};
      
      //System.out.println(eraseOverlapIntervals(testArray3));
   }
   
   // Bruteforce Solution, doesn't work for all test cases
   /*
   public static int eraseOverlapIntervals(int[][] intervals)
   {
      int count = 0;
      
      for(int i=0; i < intervals.length - 1; i++)
      {
         
         for(int j=0; j < intervals[i].length - 1; j++)
         {
            int s1 = intervals[i][j];
            int s2 = intervals[i + 1][j];
            int e1 = intervals[i][j+1];
            int e2 = intervals[i + 1][j + 1];
            
            if(s2 < e1 && s1 <= e2)
            {
               count++;
            }   
         }
      }
      
      return count;
   }
   */
}