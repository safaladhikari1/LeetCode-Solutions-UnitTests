package difficultyEasy;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RansomNoteTest {

    private RansomNote solution;

    @Before
    public void setUp() throws Exception {
        solution = new RansomNote();
    }

    @Test
    public void canConstructTest() {

        String ransomNote = "a";
        String magazine = "b";
        assertEquals(ransomNote + " in ransomNote cannot be constructed with " + magazine + " from magazine",
                false, solution.canConstruct(ransomNote, magazine));

        String ransomNote2 = "aa";
        String magazine2 = "bb";
        assertEquals(ransomNote2 + " in ransomNote cannot be constructed with " + magazine2 + " from magazine",
                false, solution.canConstruct(ransomNote2, magazine2));

        String ransomNote3 = "aa";
        String magazine3 = "aab";
        assertEquals(ransomNote2 + " in ransomNote cannot be constructed with " + magazine2 + " from magazine",
                true, solution.canConstruct(ransomNote3, magazine3));
    }
}