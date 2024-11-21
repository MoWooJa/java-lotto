package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public void printLotto() {
        String lottoNumbers = numbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));

        System.out.println("[" + lottoNumbers + "]");
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int compareToWinningLotto(Lotto winningLotto) {
        int matchedCount = 0;
        for (Integer number : numbers) {
            if (winningLotto.getNumbers().contains(number)) {
                matchedCount++;
            }
        }
        return matchedCount;
    }
    public boolean hasBonusNumber(int bonusNumber) {
        boolean isInBonusNumber = false;
        if (numbers.contains(bonusNumber)) {
            isInBonusNumber = true;
        }
        return isInBonusNumber;
    }

    // TODO: 추가 기능 구현
}
