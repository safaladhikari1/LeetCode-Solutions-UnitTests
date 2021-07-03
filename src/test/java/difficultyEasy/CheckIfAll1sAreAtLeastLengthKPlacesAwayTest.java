package difficultyEasy;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CheckIfAll1sAreAtLeastLengthKPlacesAwayTest {

    private CheckIfAll1sAreAtLeastLengthKPlacesAway solution;

    @Before
    public void setUp() throws Exception {
        solution = new CheckIfAll1sAreAtLeastLengthKPlacesAway();
    }

    @Test
    public void kLengthApart() {
        assertTrue(solution.kLengthApart(new int[] {1, 0, 0, 0, 1, 0, 0, 1}, 2));
        assertFalse(solution.kLengthApart(new int[] {1, 0, 0, 1, 0, 1}, 2));
        assertFalse(solution.kLengthApart(new int[] {1, 1, 1, 0}, 3));
    }
}