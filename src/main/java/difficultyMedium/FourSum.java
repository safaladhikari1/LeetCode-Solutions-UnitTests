import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class FourSum
{
   public static void main(String[] args)
   {
      //System.out.println(fourSum(new int[] {1, 0, -1, 0, -2, 2}, 0));
      
      System.out.println(fourSum(new int[] {0, 0, 0, 0}, 0));
      
      System.out.println(fourSum(new int[] {-2, -1, -1, 1, 1, 2, 2}, 0));   
   }
   
   public static List<List<Integer>> fourSum(int[] nums, int target) 
   {
      List<List<Integer>> res = new ArrayList<>();
      
      if (nums == null || nums.length < 4) 
      {
         return res;
      }
      
      int n = nums.length;
      Arrays.sort(nums);

      for(int i = 0; i <= n-4; i++) 
      {
         if(i > 0 && nums[i] == nums[i-1]) 
         { 
            continue;
         } // deduplicate
         
         for(int j = i+1; j <= n-3; j++) 
         {
            if (j > i+1 && nums[j] == nums[j-1]) 
            {
                     continue;
            } // deduplicate
            
            int sub = target - nums[i] - nums[j];
            int left = j+1; 
            int right = n-1;
            
            while (left < right) 
            {
                if (nums[left] + nums[right] == sub) 
                {
                    res.add(Arrays.asList(nums[i],nums[j], nums[left], nums[right]));
                    
                    while (left < right && nums[left] == nums[left+1]) 
                    {
                        left++;
                    }
                    
                    while (right > left && nums[right] == nums[right-1]) 
                    {
                        right--;
                    } // deduplicate;
                    left++;
                    right--;
                } 
                else if (nums[left] + nums[right] < sub) 
                {
                    left++;
                } 
                else 
                {
                    right--;
                }
            }
        }
      }
      
     return res;    
   }
   
   /*
   public static List<List<Integer>> fourSum(int[] nums, int target)
   {
      List<List<Integer>> result = new ArrayList<>();
      
      Arrays.sort(nums);
      
      for(int i=0; i <= nums.length - 4; i++)
      {
         for(int j = i+1; j <= nums.length - 3; j++)
         {
            if(i == 0 || (nums[i] > nums[i - 1] && nums[j] > nums[i]))
            {
               int start = j + 1;
               int end = nums.length - 1;
               
               while(start < end)
               {
                  int sum = nums[i] + nums[j] + nums[start] + nums[end];
                  
                  if(sum - target == 0)
                  {
                     result.add(Arrays.asList(nums[i], nums[j], nums[start], nums[end]));
                  }
                  
                  if(sum - target < 0)
                  {
                     int currentStart = start;
                     
                     while(nums[start] == nums[currentStart] && start < end)
                     {
                        start++;
                     }
                     
                  }
                  else
                  {
                     int currentEnd = end;
                     
                     while(nums[end] == nums[currentEnd] && start < end)
                     {
                        end--;
                     }                  
                  }
               }
            }   
         }        
      }
            
      return result;
   }
   */  
}