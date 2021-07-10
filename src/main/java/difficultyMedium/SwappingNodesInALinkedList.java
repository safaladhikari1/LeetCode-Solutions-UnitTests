package difficultyMedium;

import helperClass.ListNode;

/**
 * Swapping Nodes in a LinkedList
 *
 * Problem Source: https://leetcode.com/problems/swapping-nodes-in-a-linked-list/
 *
 * Algorithm:
 *
 * 1. The idea is to swap the values from the kth node from the end and beginning, and return the head
 *
 *    For example:
 *    k = 2
 *
 *    1 -> 2 -> 3 -> 4 -> 5
 *
 *    will be
 *
 *    1 -> 4 -> 3 -> 2 -> 5
 *
 *    Because 2 and 4 will be swapped, 2 is 2nd from left, 4 is 2nd from right
 *
 * 2. We create a dummy node
 *    Point dummy.next to head
 *
 *    Then, we have fast, slow and kthNode pointing at dummy
 *
 * 3. while fast.next is not null, i.e. when fast is at the end of LinkedList
 *
 *         fast = fast.next
 *
 *         if slow is not dummy
 *              Then move slow = slow.next
 *
 *         We use pre decrement
 *         --k == 0, means k will decrement first before executing this expression
 *         k-- == 0, means k will decrement after executing this expression
 *
 *         More info: https://www.geeksforgeeks.org/pre-increment-and-post-increment-in-c/
 *
 *         When --k == 0, means when fast is pointing at 2nd node from the left
 *              Store that node using kthNode
 *              Now start moving slow = slow.next, this way when fast is pointing at the end of the last at the end
 *              slow is kth number before fast, or end of the list, and we can swap the values.
 *
 *
 * 4. Fast.next != null
 *          Fast reaches at the end of list, exits the loop
 *          Slow is pointing at the kth number from the right
 *
 *          We swap the values between kthNode and Slow.
 *
 * 5. Return dummy.next, which is pointing at head.
 *
 * Time-Complexity: O(N), where N is the number of nodes in the Linked List
 * Space-Complexity: O(1)
 *
 * Idea is similar to: https://leetcode.com/problems/swapping-nodes-in-a-linked-list/discuss/1009800/C%2B%2BJP3-One-Pass
 * Another similar approach: https://leetcode.com/problems/swapping-nodes-in-a-linked-list/discuss/1009918/Java-or-Two-Pointers-or-Beginner-Friendly-Detailed-Explanation-or-O(n)-time-O(1)-space
 *
 */
public class SwappingNodesInALinkedList {

    public ListNode swapNodes(ListNode head, int k) {

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        ListNode kthNode = dummy;

        while(fast.next != null) {
            fast = fast.next;

            if(slow != dummy) {
                slow = slow.next;
            }

            if(--k == 0) {
                kthNode = fast;
                slow = slow.next;
            }
        }

        int temp = kthNode.val;
        kthNode.val = slow.val;
        slow.val = temp;

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        SwappingNodesInALinkedList solution = new SwappingNodesInALinkedList();
        solution.swapNodes(list, 2);
    }
}
