/*
   Replace Elements with Greatest Element on Right Side
   
   Problem Source: https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/
   
   -----
   
   Algorithm:
   
   Source: https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/discuss/463249/JavaC%2B%2BPython-Straight-Forward
   
   1. Iterate from the back from the array
   2. Initialize maxValue to -1
   3. Create a temp variable
   4. On the for loop from the back
         
         Store the currentValue "arr[i]" in temp
         assign arr[i] to maxValue (this way maxValue is always the max on the right)
         maxValue is the maximum of temp and maxValue
         
   5. Repeat the same steps again
   6. At the end return the array
   
   Time-Complexity: O(N), where N is the number of elements in the array
   Space-Complexity: O(1)
   
   Another similar approach: https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/discuss/482693/Java-O(n)-TimeO(1)-Space-SimpleClear-(100)-Solution     

*/


import java.util.Arrays;

class ReplaceElementsGreatestElementRightSide
{
   public static void main(String[] args)
   {
      System.out.println(Arrays.toString(replaceElements(new int[] {17, 18, 5, 4, 6, 1})));  
   }
   
   public static int[] replaceElements(int[] arr)
   {
      int arrLength = arr.length;
      int temp;
      int maxValue = -1;
      
      for(int i = arrLength - 1; i >=0; i--)
      {        
         temp = arr[i];
         arr[i] = maxValue;
         maxValue = Math.max(maxValue, temp);
         
      }
      
      return arr;
   }
   
   // Bruteforce Solution, Works
   /*
   public static int[] replaceElements(int[] arr)
   {
      if(arr.length == 1)
      {
         arr[0] = -1;
         return arr;
      }
      else
      {
         int max = 0;
         
         for(int i=0; i < arr.length - 1; i++)
         {
            for(int j = i+1; j < arr.length; j++)
            {              
               max = Math.max(max, arr[j]);   
            }
            
            arr[i] = max;
            max = 0;
         }
         
         arr[arr.length - 1] = -1;
      }
      
      return arr;
   }
   */
}