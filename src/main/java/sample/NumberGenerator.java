package sample;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NumberGenerator {

    public List<Integer> getSevenOfFortyNine() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            list.add(getNumber(49, list));
        }
        return list;
    }

    /**
     * Generates Number between 1 and @param max (include).
     * @param actualNumbers The already choosen numbers.
     * @return Returns a number that isn't picked already
     */
    private Integer getNumber(int max, List<Integer> actualNumbers) {
        Random random = new Random();
        int number = random.nextInt(max)+1;
        if (actualNumbers.contains(number)) {
            number = getNumber(max, actualNumbers);
        }
        return number;
    }

}
