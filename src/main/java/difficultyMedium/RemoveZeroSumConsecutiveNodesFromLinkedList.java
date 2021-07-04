import java.util.HashMap;
import java.util.Map;

/**
 * Remove Zero Sum Consecutive Nodes from Linked List
 *
 * Problem Source: https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/
 *
 * Algorithm:
 *
 * 1. Based on the intuition from community posts:
 *
 *    https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/discuss/413134/Java-O(N)-with-detail-explanation
 *
 *    https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/discuss/366337/Java-Iterative-and-Recursive-solution
 *
 *    https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/discuss/366319/JavaC%2B%2BPython-Greedily-Skip-with-HashMap
 *
 * 2. Initialize sum to 0
 *
 * 3. Make a new dummyNode, point dummyNode.next to head
 *
 * 4. Make a HashMap of Integer and ListNode
 *
 * 5. Create a for loop, that is iterating with ListNode i = dummyNode
 *      sum += i.val
 *
 *      Store the sum and node with map.put(sum, i)
 *
 * 6. Reset the sum to 0
 *
 * 7. Do another for loop
 *      sum += i.val
 *      This time, point i.next to map.get(sum).next
 *
 *      if the sum exists already in the map, point i.next to that nodeValue.next
 *
 *      For example:
 *
 *      [1, 2, 3, -3, 4]
 *
 *      In the HashMap
 *
 *      (1, 1)
 *      (3, 2)
 *      (6, 3)
 *      (3, -3)
 *      (7, 4)
 *
 *      In the 2nd, loop
 *      we point from
 *
 *      1, 2, since 3 already exists
 *
 *      we point 1, 2, and 4
 *
 * -----
 *
 * Time-Complexity: O(N), where N is the number of nodes in the Linked List
 * Space-Complexity: O(N), where N is used on our Hash Table.
 *
 */
public class RemoveZeroSumConsecutiveNodesFromLinkedList {

    public static void main(String[] args) {

    }

    public static ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        int sum = 0;

        Map<Integer, ListNode> tempMap = new HashMap<>();

        for(ListNode i = dummyNode; i != null; i = i.next) {
            sum += i.val;
            tempMap.put(sum, i);
        }

        sum = 0;

        for(ListNode i = dummyNode; i != null; i = i.next) {
            sum += i.val;
            i.next = tempMap.get(sum).next;
        }

        return dummyNode.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {

        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
