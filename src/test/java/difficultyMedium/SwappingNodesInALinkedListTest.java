package difficultyMedium;

import helperClass.ListNode;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SwappingNodesInALinkedListTest {

    private SwappingNodesInALinkedList solution;
    private ListNode inputList;
    private ListNode outputList;

    @Before
    public void setUp() throws Exception {
        solution = new SwappingNodesInALinkedList();
    }

    /**
    @Test
    public void swapNodes() {

        inputList = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        outputList = new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5)))));

        assertSame(outputList, solution.swapNodes(inputList, 2));
    }
    **/
}