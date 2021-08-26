package difficultyEasy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindTheHighestAltitudeTest {

    private FindTheHighestAltitude solution;

    @BeforeEach
    void setUp() {
        solution = new FindTheHighestAltitude();
    }

    @Test
    void largestAltitude() {
        assertEquals(1, solution.largestAltitude(new int[] {-5, 1, 5, 0, -7}),
                "The highest altitude of a point is not correct");

        assertEquals(0, solution.largestAltitude(new int[] {-4, -3, -2, -1, 4, 3, 2}),
                "The highest altitude of a point is not correct");
    }
}