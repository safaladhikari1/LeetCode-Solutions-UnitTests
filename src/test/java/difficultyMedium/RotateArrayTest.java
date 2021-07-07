package difficultyMedium;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RotateArrayTest {

    private RotateArray solution;

    @Before
    public void setUp() throws Exception {
        solution = new RotateArray();
    }

    @Test
    public void test_rotate() {
        int[] inputArray = new int[] {1, 2, 3, 4, 5, 6, 7};
        solution.rotate(inputArray, 3);
        assertArrayEquals(new int[] {5, 6, 7, 1, 2, 3, 4}, inputArray);

        inputArray = new int[] {-1, -100, 3, 99};
        solution.rotate(inputArray, 2);
        assertArrayEquals(new int[] {3, 99, -1, -100}, inputArray);
    }
}