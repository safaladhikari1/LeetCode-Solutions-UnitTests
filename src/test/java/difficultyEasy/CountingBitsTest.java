package difficultyEasy;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class CountingBitsTest {

    private CountingBits solution;

    @Before
    public void setUp() throws Exception {
        solution = new CountingBits();
    }

    @Test
    public void countBits() {
        assertArrayEquals("Number of 1's in int[i] is not correct",
                new int[] {0, 1, 1}, solution.countBits(2));

        assertArrayEquals("Number of 1's in int[i] is not correct",
                new int[] {0, 1, 1, 2, 1, 2}, solution.countBits(5));

    }
}