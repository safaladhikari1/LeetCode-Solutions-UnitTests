import java.util.HashMap;
import java.util.Map;

/**
 * Check Array Formation Through Concatenation
 *
 * Problem Source: https://leetcode.com/problems/check-array-formation-through-concatenation/
 *
 * Algorithm:
 *
 * 1. We have a arr = [91, 4, 64, 78]
 *
 *    pieces = [
 *      [78],
 *      [4, 64],
 *      [91]
 *    ]
 *
 * 2. Check if it is possible to form the arr from pieces. Elements on both arr and pieces are unique
 *
 * 3. Make a hashmap of Integer, Integer.
 *
 * 4. Loop through the pieces.length
 *      Store the pieces[0][i]
 *      On the storePieces map it will be,
 *      78, 0
 *      4, 1
 *      91, 2
 *
 * 5. Now loop through arr
 *
 *    Check if piecesMap contains arr[i]
 *          Let's say if the arr is 91, check if our storePieces map has 91
 *          It does, now get the array of [91] from the storePieces map
 *          int[] pieceFromMap = pieces[piecesMap.get(arr[i])]
 *
 *          Since our map store 91, 2
 *          2 is the index, row of the 2d array
 *
 *          pieces[2] gives us the array on that particular row
 *          [91]
 *
 *          Now loop through that pierceFromMap array
 *              if arr[i] is not equal to pieceFromMap[k]
 *                  return false
 *                  We are checking the ordering of element in arr, matches the ordering of element in pieceFromMap array
 *
 *              i++
 *              k++
 *     Else, the storePieces map does not contain arr[i]
 *          return false;
 *
 * 6. If it passes the above two, return true.
 *
 * Time-Complexity: O(N + M), N and M are the length of arr and pieces respectively.
 * Space-Complexity: O(M), for each row in the pieces 2d array, we are storing a pair in our HashMap
 *
 */
public class CheckArrayFormationThroughConcatenation {
    public static void main(String[] args) {
        int[] testArr = new int[] {91, 4, 64, 78};
        int[][] testPieces = new int[][] { {78}, {4, 64}, {91}};

        System.out.println(canFormArray(testArr, testPieces));
    }

    /**
     * Checks if it is possible to form the array arr from pieces.
     *
     * @param arr the input array
     * @param pieces the input 2d pieces array
     * @return true or false
     */
    public static boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, Integer> storePieces = new HashMap<>();

        for(int i=0; i < pieces.length; i++) {
            storePieces.put(pieces[i][0], i);
        }

        for(int i=0; i < arr.length;) {
            if(storePieces.containsKey(arr[i])) {
                int[] pieceFromMap = pieces[storePieces.get(arr[i])];
                int k = 0;

                while(k < pieceFromMap.length) {
                    if(arr[i] != pieceFromMap[k]) {
                        return false;
                    }
                    i++;
                    k++;
                }
            }
            else {
                return false;
            }
        }
        return true;
    }
}
