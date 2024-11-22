package lotto.model.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.ErrorMassage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sortNumbers(numbers);
    }

    protected static List<Integer> sortNumbers(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }


    protected void validate(List<Integer> numbers) {
        validateLottoSize(numbers);
        validateLottoRange(numbers);
        validateLottoDuplication(numbers);
    }


    protected void validateLottoRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 0 || number > 45) {
                throw new IllegalArgumentException(ErrorMassage.OUT_OF_LOTTO_NUMBER_RANGE.getMessage());
            }
        }
    }

    private void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMassage.WRONG_LOTTO_SIZE.getMessage());
        }
    }

    protected void validateLottoDuplication(List<Integer> numbers) {
        Set<Integer> checkDuplicated = new HashSet<>(numbers);
        if (checkDuplicated.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMassage.DUPLICATED_NUMBER_EXIST.getMessage());
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    protected List<Integer> getNumbers() {
        return numbers;
    }
}
