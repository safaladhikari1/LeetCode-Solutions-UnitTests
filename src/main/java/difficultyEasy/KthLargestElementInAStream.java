package difficultyEasy;

import java.util.PriorityQueue;

/**
 * Kth Largest Element in a Stream
 *
 * Problem Source: https://leetcode.com/problems/kth-largest-element-in-a-stream/
 *
 * Algorithm:
 *
 * 1. It wants us to find kth Largest Element in a Stream of numbers, that keeps getting added
 *    i.e. find kth largest element at any moment, when the numbers are getting added
 *
 *    For example:
 *
 *    when k = 3, array = [4, 5, 8, 2]
 *
 *    Once we sorted in descending order, 8, 5, 4, 2
 *    The third largest element is 4
 *
 *    But we don't want to keep sorting the numbers, when each element are added.
 *    We use Priority Queue. It use Max Heap, to make sure that only 3rd largest element is kept at the peek of the
 *    complete binary tree.
 *
 * 2. We first make a private Priority Queue
 *    make a size field
 *
 *    On the constructor, we pass in the input k, and input array
 *      size = k
 *      instantiate the priority queue of only size k
 *      Then call add method for each num in that array
 *
 *    The reason why we only want to have a Priority Queue of size k
 *    For example:
 *
 *    when k = 3
 *
 *    In the add method,
 *    We only add up to 3
 *
 *    [4, 5, 8, 2]
 *
 *    4 gets added, 5 gets added, 8 gets added
 *
 *    But 4 is at the peek, because it's the smallest and also the third largest at this moment.
 *          4
 *      5       8
 *
 *    If we added 3, we will ignore because if we sort the numbers
 *    8, 5, 4, 3
 *
 *    4 is still the third largest, so we ignore until the num is bigger than 4 (priority queue.peek)
 *
 * 3. When we added 5
 *        It is bigger than peek, so we remove the the peek, by calling pq.poll()
 *        Then add that number 5
 *
 *        This will also try to maintain the min Heap in the complete binary tree, that costs us Log(K) time complexity
 *
 *    At the end of add method, we just return pq.peek(), which is the 3rd largest at that moment.
 *
 * Time-Complexity: constructor costs O(N * log(K)), where N is the number of elements that are being added in the stream,
 *                  Olog(K) is the time-complexity to maintain the min-heap balance of the complete binary tree for each N (worst case)
 *
 *                  add() costs us Olog(k)
 *
 * Space-Complexity: O(K), we use size K for our priority queue at all times.
 *
 * More explanation:
 *
 * https://youtu.be/G5CVOjWDAmY
 * https://leetcode.com/problems/kth-largest-element-in-a-stream/discuss/152588/Explanation-of-MinHeap-solution-(NO-CODE)
 *
 */
public class KthLargestElementInAStream {

    private PriorityQueue<Integer> tempQueue;
    private int size;

    public KthLargestElementInAStream(int k, int[] nums) {
        this.size = k;
        tempQueue = new PriorityQueue<>(k);
        for(int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if(tempQueue.size() < size) {
            tempQueue.add(val);
        }
        else {
            if(val > tempQueue.peek()) {
                tempQueue.poll();
                tempQueue.add(val);
            }
        }

        return tempQueue.peek();
    }

    public static void main(String[] args) {
        KthLargestElementInAStream solution = new KthLargestElementInAStream(3, new int[] {4, 5, 8, 2});
        System.out.println(solution.add(3));
        System.out.println(solution.add(5));
    }
}
