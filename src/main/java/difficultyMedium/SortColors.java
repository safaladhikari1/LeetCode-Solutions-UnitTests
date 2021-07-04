import java.util.Arrays;

class SortColors
{
   public static void main(String[] args)
   {
      int[] testArray1 = {2, 0, 2, 1, 1, 0};
      
      System.out.println(Arrays.toString(sortColors(testArray1)));
   }
   
   public static int[] sortColors(int[] nums)
   {
      for(int i=0; i<nums.length - 1; i++)
      {
         for(int j=i+1; j<nums.length; j++)
         {
            if(nums[j] < nums[i])
            {
               int temp = nums[j];
               nums[j] = nums[i];
               nums[i] = temp;
            }
         }
      }
      
      
      return nums;
   }
}