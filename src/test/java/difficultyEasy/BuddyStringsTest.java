package difficultyEasy;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BuddyStringsTest {

    private BuddyStrings solution;

    @Before
    public void setUp() throws Exception {
        solution = new BuddyStrings();
    }

    @Test
    public void buddyStrings() {
        assertTrue("Swapping two letters in s, does not equal to goal"
        , solution.buddyStrings("ab", "ba"));

        assertFalse("Swapping two letters in s, does not equal to goal"
                , solution.buddyStrings("ab", "ab"));

        assertTrue("Swapping two letters in s, does not equal to goal"
                , solution.buddyStrings("aaaaaaabc", "aaaaaaacb"));

    }
}