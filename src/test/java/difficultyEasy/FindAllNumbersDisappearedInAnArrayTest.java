package difficultyEasy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;

class FindAllNumbersDisappearedInAnArrayTest {

    private FindAllNumbersDisappearedInAnArray solution;

    @BeforeEach
    void setUp() {
        solution = new FindAllNumbersDisappearedInAnArray();
    }

    @Test
    void findDisappearedNumbers() {
        List<Integer> resultList = solution.findDisappearedNumbers(new int[] {4, 3, 2, 7, 8, 2, 3, 1});
        assertThat("All the numbers disappeared in an Array do not appear in result array", resultList,
                contains(5, 6));

        resultList = solution.findDisappearedNumbers(new int[] {1, 1});
        assertThat("All the numbers disappeared in an Array do not appear in result array", resultList,
                contains(2));
    }
}