package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {

    public static List<Integer> parse(String winningNumbers) {
        if (!winningNumbers.matches("^(\\d+,)*\\d+$")) {
            throw new IllegalArgumentException("[ERROR] : 쉼표 앞뒤로 숫자가 있어야 합니다.");
        }
        return Arrays.stream(winningNumbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
