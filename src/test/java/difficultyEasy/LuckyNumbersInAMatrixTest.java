package difficultyEasy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

class LuckyNumbersInAMatrixTest {

    private LuckyNumbersInAMatrix solution;

    @BeforeEach
    void setUp() {
        solution = new LuckyNumbersInAMatrix();
    }

    @Test
    void luckyNumbers() {
        List<Integer> resultList = solution.luckyNumbers(new int[][] {{3, 7, 8}, {9, 11, 13}, {15, 16, 17}});
        assertThat("Lucky number: minimum element in its row and maximum in its column is not in the result list.",
                resultList,
                contains(15));

        resultList = solution.luckyNumbers(new int[][] {{1, 10, 4, 2}, {9, 3, 8, 7}, {15, 16, 17, 12}});
        assertThat("Lucky number: minimum element in its row and maximum in its column is not in the result list.",
                resultList,
                contains(12));
    }
}