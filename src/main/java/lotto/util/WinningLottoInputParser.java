package lotto.util;

import java.util.Arrays;
import java.util.List;
import lotto.ErrorMassage;

public class WinningLottoInputParser implements InputParser {
    public List<Integer> parse(String input) {
        try {
            return parseTrial(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMassage.INVALID_INPUT_FORM.getMessage());
        }
    }

    public List<Integer> parseTrial(String input) {
        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .toList();
    }
}
