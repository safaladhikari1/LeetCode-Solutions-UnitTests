/*
   Partition Array Into Three Parts With Equal Sum
   
   Problem Source:  https://leetcode.com/problems/partition-array-into-three-parts-with-equal-sum/
   
   ----
   
   Algorithm:
   
   The intuition is if we have three parts with the same sum in the array.
   Let's fine the firstPart, and check if the second and third part are the same as firstPart
   If they are, it returns true. Otherwise at the end it returns false
   
   1. Get the total sum, by looping through all the elements in the array
   
   2. If totalSum % 3 is not zero, then we know the sum of the array cannot be divided into three equal parts
         return false
   
   3. Get the first part = totalSum / 3, set the count to 0
   
   4. Loop through the array
      
      currentSum += nums[i]
      
      if currentSum is same as each Part
         reset the currentSum to 0
         increment the count 
         
         if the count is 3 in this whole loop
            then we know that there are three parts with same sum, return true
            
   5. Otherwise return false
   
   -----------
   
   Time-Complexity: O(N), where N is the number of elements in the array
   Space-Complexity: O(1)              
           
*/

class PartitionArrayThreePartsEqualSum
{
   public static void main(String[] args)
   {
      System.out.println(canThreePartsEqualSum(new int[] {3, 3, 6, 5, -2, 2, 5, 1, -9, 4}));   
   }
   
   public static boolean canThreePartsEqualSum(int[] nums)
   {
      int totalSum = 0;
      
      for(int i=0; i < nums.length; i++)
      {
         totalSum += nums[i];
      }
      
      if(totalSum % 3 != 0)
      {
         return false;
      }
      
      int eachPart = totalSum / 3;
      int currentSum = 0;
      int count = 0;
      
      for(int i=0; i < nums.length; i++)
      {
         currentSum += nums[i];
         
         if(currentSum == eachPart)
         {
            currentSum = 0;
            count++;
            
            if(count == 3)
            {
               return true;
            }           
         }
         
      }
    
      return false;     
   }

   // Bruteforce Approach
   /*
   public static boolean canThreePartsEqualSum(int[] nums)
   {
      int totalSum = 0;
      boolean result = false;
      
      for(int i=0; i < nums.length; i++)
      {
         totalSum += nums[i];
      }
      
      int eachSum = totalSum / 3;
      
      int index1 = 0;
      int index2 = 0;
      int index3 = 0;
      
      int firstPart = 0;
      int secondPart = 0;
      int thirdPart = 0;
       
      while(index1 < nums.length)
      {
         firstPart += nums[index1];
         
         if(firstPart == eachSum)
         {
            index2 = index1 + 1;
            
            while(index2 < nums.length)
            {
               secondPart += nums[index2];
               
               if(secondPart == firstPart)
               {
                  index3 = index2 + 1;
                  
                  while(index3 < nums.length)
                  {
                     thirdPart += nums[index3];
                     index3++;
                     
                     if(index3 == nums.length)
                     {
                        if(firstPart == secondPart && secondPart == thirdPart)
                        {
                           result = true;  
                        }                        
                     }                                        
                  }                                 
               }              
               index2++;                 
            }              
         }        
         index1++;   
      }
      
      return result;
   }
   */
}