package lotto;

import static lotto.Exceptions.*;

public class InputParser {

    public static Integer toInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NO_NUMBER.getMessage());
        }
    }

}
