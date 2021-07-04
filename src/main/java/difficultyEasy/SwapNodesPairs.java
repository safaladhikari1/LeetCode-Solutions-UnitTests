/**
 * Problem: Swap Nodes in Pairs
 * Source: https://leetcode.com/problems/swap-nodes-in-pairs/
 *
 * Algorithm is based on: https://leetcode.com/problems/swap-nodes-in-pairs/discuss/11046/My-simple-JAVA-solution-for-share/186959
 *
 * ----
 *
 * Time-Complexity: O(N), where N is the number of nodes in the LinkedList
 * Space-Complexity: O(1)
 */


public class SwapNodesPairs {
    public static void main(String[] args) {

        ListNode testList = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));

        //System.out.println(swapPairs(testList));
        //System.out.println(swapPairs(new ListNode(1)));

    }

    /**
     * Given a linked list, swaps every two adjacent nodes and returns the head
     * @param head the head pointer of the LinkedList
     * @return head pointer of the LinkedList after the swap
     */
    public static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode point = dummy;
        dummy.next = head;

        while(point.next != null && point.next.next != null) {
            ListNode swap1 = point.next;
            ListNode swap2 = point.next.next;

            point.next = swap2;
            swap1.next = swap2.next;
            swap2.next = swap1;
            point = swap1;
        }

        return dummy.next;
    }

    // Bruteforce solution doesn't work as expected
    /*
    public static ListNode swapPairs(ListNode head) {
        if(head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null) {
            fast = fast.next;

            int temp = fast.val;
            fast.val = slow.val;
            slow.val = temp;

            fast = fast.next;
            slow = fast;
        }

        return head;
    }

    */

    private static class ListNode {
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
