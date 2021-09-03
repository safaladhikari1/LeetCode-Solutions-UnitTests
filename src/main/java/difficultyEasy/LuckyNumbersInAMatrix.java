package difficultyEasy;

import java.util.LinkedList;
import java.util.List;

/**
 * Lucky Numbers in a Matrix
 *
 * Problem Source: https://leetcode.com/problems/lucky-numbers-in-a-matrix/
 *
 * Algorithm:
 *
 * 1. Initiate result list.
 * 2. Loop through the elements in the 2d array
 * 3. For every row
 *      loop through column for that row
 *      Keep track of the minimum number in that row and it's index
 *
 *      Then loop through the row for only the column of the minimum number that is identified above
 *      If the minimum number above is the maximum number in its column
 *          we can identify it using the flag, add it to the resultList.
 * 4. At the end, return the resultList
 *
 * Time-Complexity: O(M * N), where M is the number of row and N is the number of columns in the matrix.
 * Space-Complexity: O(1)
 *
 * Another approach using Set: Method 2 in the article: https://leetcode.com/problems/lucky-numbers-in-a-matrix/discuss/539731/JavaPython-3-Two-23-pass-codes-w-brief-explanation-and-analysis.
 */
public class LuckyNumbersInAMatrix {

    public static void main(String[] args) {
        LuckyNumbersInAMatrix solution = new LuckyNumbersInAMatrix();
        System.out.println(solution.luckyNumbers(new int[][] {{3, 7, 8}, {9, 11, 13}, {15, 16, 17}}));
    }

    public List<Integer> luckyNumbers(int[][] matrix) {

        List<Integer> resultList = new LinkedList<>();

        int number;
        int minNumber;
        int minIndex = 0;
        boolean flag;

        for(int i=0; i < matrix.length; i++) {
            flag = true;
            minNumber = matrix[i][0];
            for(int j=0; j < matrix[i].length; j++) {
                number = matrix[i][j];
                if(number < minNumber) {
                    minNumber = number;
                    minIndex = j;
                }
            }

            for(int k=0; k < matrix.length; k++) {
                number = matrix[k][minIndex];
                if(number > minNumber) {
                    flag = false;
                }
            }

            if(flag) {
                resultList.add(minNumber);
            }
        }

        return resultList;
    }

}

















