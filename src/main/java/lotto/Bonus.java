package lotto;

import static lotto.Exceptions.LOTTO_NUMBER_RANGE_ERROR;

import java.util.List;

public class Bonus {
    private final Integer number;

    public Bonus(Integer number) {
        validate(number);
        this.number = number;
    }

    private void validate(Integer number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(LOTTO_NUMBER_RANGE_ERROR.getMessage());
        }
    }

    public Integer getNumber() {
        return number;
    }

    public boolean containBonus(List<Integer> numbers) {
        return numbers.contains(number);
    }
}
