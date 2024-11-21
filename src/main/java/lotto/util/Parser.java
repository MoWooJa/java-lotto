package lotto.util;

import java.util.Arrays;
import java.util.List;

public class Parser {

    public static List<Integer> parse(String winningNumbers) {
        String[] numbers = winningNumbers.split(",");

        return (List<Integer>) Arrays.stream(numbers)
                .map(Integer::parseInt)
                .toList();
    }
}
