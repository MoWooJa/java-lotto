package lotto.model.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sortNumbers(numbers);
    }

    protected static List<Integer> sortNumbers(List<Integer> numbers) {
        List<Integer> sortedList = numbers.stream()
                .sorted()
                .collect(Collectors.toList());
        return sortedList;
    }


    protected void validate(List<Integer> numbers) {
        validateLottoSize(numbers);
        validateLottoRange(numbers);
        validateLottoDuplication(numbers);
    }


    protected void validateLottoRange(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            int number = numbers.get(i);
            if (number < 0 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    private void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    protected void validateLottoDuplication(List<Integer> numbers) {
        Set<Integer> checkDuplicated = new HashSet<>(numbers);
        if (checkDuplicated.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
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