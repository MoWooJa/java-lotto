package lotto.lotto;

import static lotto.common.Exceptions.LOTTO_NUMBER_DUPLICATED;
import static lotto.common.Exceptions.LOTTO_NUMBER_RANGE_ERROR;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sortedNumbers(numbers);
    }

    private List<Integer> sortedNumbers(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .toList();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(LOTTO_NUMBER_RANGE_ERROR.getMessage());
            }
        }
        Set<Integer> lottoSet = new HashSet<>(numbers);
        if (lottoSet.size() != numbers.size()) {
            throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATED.getMessage());
        }
    }

    public void isSameWithBonus(Bonus bonus) {
        for (Integer number : numbers) {
            if (Objects.equals(number, bonus.getNumber())) {
                throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATED.getMessage());
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int containNumber(List<Integer> numbers) {
        int count = 0;
        for (Integer number : numbers) {
            if (this.numbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    // TODO: 추가 기능 구현
}
