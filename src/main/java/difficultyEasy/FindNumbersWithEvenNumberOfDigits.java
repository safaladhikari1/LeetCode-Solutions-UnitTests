/**
 * Find Numbers with Even Number of Digits
 *
 * Problem Source: https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
 *
 * Algorithm:
 *
 * 1. Visit every elements in the array
 * 2. Make a finalCount to 0
 *     For each element, keep on dividing my 10, that will give us how many numbers are in that element
 *
 *     If the count is even,
 *          increment the finalCount
 * 3. At the end, return the final Count
 *
 * Time-Complexity: O(N), where N is the number of elements in the array
 * Space-Complexity: O(1)
 *
 * More info:
 * https://leetcode.com/problems/find-numbers-with-even-number-of-digits/discuss/458937/JAVA-MUST-READ-Solution-with-EXPLANATION-and-EXAMPLE-%3A)
 *
 */

public class FindNumbersWithEvenNumberOfDigits {
    public static void main(String[] args) {
        System.out.println(findNumbers(new int[] {12, 345, 2, 6, 7896}));

        System.out.println(findNumbers(new int[] {555, 901, 482, 1771}));
    }

    public static int findNumbers(int[] nums) {
        int finalCount = 0;

        for(int i=0; i < nums.length; i++) {
            int element = nums[i];
            int count = 0;

            while(element > 0) {
                element /= 10;
                count++;
            }

            if(count % 2 == 0) {
                finalCount++;
            }
        }

        return finalCount;
    }
}
