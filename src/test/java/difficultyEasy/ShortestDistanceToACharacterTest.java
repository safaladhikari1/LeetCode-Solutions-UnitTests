package difficultyEasy;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ShortestDistanceToACharacterTest {

    private ShortestDistanceToACharacter solution;

    @Before
    public void setUp() throws Exception {
        solution = new ShortestDistanceToACharacter();
    }

    @Test
    public void shortestToCharTest() {
        assertArrayEquals("Array of integers is not correct",
                new int[] {3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0},
                solution.shortestToChar("loveleetcode", 'e'));

        assertArrayEquals("Array of integers is not correct",
                new int[] {3, 2, 1, 0},
                solution.shortestToChar("aaab", 'b'));
    }
}