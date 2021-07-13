package difficultyEasy;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FindWordsThatCanBeFormedByCharactersTest {

    private FindWordsThatCanBeFormedByCharacters solution;

    @Before
    public void setUp() throws Exception {
        solution = new FindWordsThatCanBeFormedByCharacters();
    }

    @Test
    public void countCharacters() {
        assertEquals("The sum of lengths of all good strings is incorrect",
                6, solution.countCharacters(new String[] {"cat", "bt", "hat", "tree"}, "atach"));

        assertEquals("The sum of lengths of all good strings is incorrect",
                10, solution.countCharacters(new String[] {"hello","world","leetcode"}, "welldonehoneyr"));
    }
}