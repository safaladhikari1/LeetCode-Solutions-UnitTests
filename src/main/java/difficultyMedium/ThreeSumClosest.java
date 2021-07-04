// Problem Source: 3Sum Closest, https://leetcode.com/problems/3sum-closest/

// Hint: https://leetcode.com/problems/3sum-closest/discuss/7872/Java-solution-with-O(n2)-for-reference

public class ThreeSumClosest
{
    public static void main(String[] args)
    {
        //System.out.println(threeSumClosest(new int[] {-1, 2, 1, -4}, 1));

        //System.out.println(threeSumClosest(new int[] {1, 1, -1, -1, 3}, 1));
    }

    // Bruteforce solution: Sliding window, doesn't work
    /*
    public static int threeSumClosest(int[] nums, int target)
    {
        int windowStart = 0;
        int closestSum = 0;
        int minDiff = Integer.MAX_VALUE;
        int difference = 0;
        int currentSum = 0;

        for(int windowEnd = 0; windowEnd < nums.length; windowEnd++)
        {
            currentSum += nums[windowEnd];

            if(windowEnd >= 2)
            {
                difference = Math.abs(currentSum - target);
                if(difference < minDiff)
                {
                    minDiff = Math.min(difference, minDiff);

                    closestSum = currentSum;
                }
                currentSum -= nums[windowStart];
                windowStart++;
            }
        }
        return closestSum;
    }
     */
}









