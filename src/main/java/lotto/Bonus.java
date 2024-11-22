package lotto;

import static lotto.Exceptions.LOTTO_NUMBER_RANGE_ERROR;

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
}
