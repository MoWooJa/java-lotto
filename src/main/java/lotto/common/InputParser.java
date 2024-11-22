package lotto.common;

import static lotto.common.Exceptions.*;

import java.util.ArrayList;
import java.util.List;

public class InputParser {

    private static final String DELIMITER = ",";

    public static Integer toInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NO_NUMBER.getMessage());
        }
    }

    public static List<Integer> splitByDelimiter(String input) {
        String[] arr = input.split(DELIMITER);
        List<Integer> numbers = new ArrayList<>();
        for (String s : arr) {
            Integer lottoNumber = toInteger(s);
            numbers.add(lottoNumber);
        }
        return numbers;
    }
}
