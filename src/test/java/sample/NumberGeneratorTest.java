package sample;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class NumberGeneratorTest {

    private NumberGenerator numberGenerator;

    @Before
    public void setUp() {
        numberGenerator = new NumberGenerator();
    }

    @Test
    public void getSevenOfFortyNine() {
        List<Integer> numbers = numberGenerator.getSevenOfFortyNine();
        for (Integer number : numbers) {
            Assert.assertTrue(number >= 1);
            Assert.assertTrue(number <= 49);
            Assert.assertEquals(7, numbers.size());
        }

    }
}