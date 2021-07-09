package difficultyEasy;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class KthLargestElementInAStreamTest {

    private KthLargestElementInAStream solution;

    @Before
    public void setUp() throws Exception {
        solution = new KthLargestElementInAStream(3, new int[] {4, 5, 8, 2});
    }

    @Test
    public void addTest() {
        assertEquals(4, solution.add(3));
        assertEquals(5, solution.add(5));
        assertEquals(5, solution.add(10));
        assertEquals(8, solution.add(9));
        assertEquals(8, solution.add(4));
    }
}