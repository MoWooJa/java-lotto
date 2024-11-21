package lotto.domain;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateNumberRange(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("ERROR : 로또 번호는 6개 여야 합니다.");
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                throw new IllegalArgumentException("ERROR : 로또 숫자는 1 ~ 45");
            }
        }
    }

    private void validateDuplicateNumber(List<Integer> numbers) {
        Set set = new HashSet(numbers);
        if (set.size() != numbers.size()) {
            throw new IllegalArgumentException("ERROR : 중복된 숫자는 존재할 수 없음");
        }
    }

    public void printLotto() {
        for (Integer number : numbers) {
            System.out.print(number + " ");
        }
    }

    public static Lotto create(List<Integer> lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    public LottoResult compareToWinningLotto(Lotto winningLotto, BonusNumber bonusNumber) {
        List<Integer> winningNumbers = winningLotto.getNumbers();

        int matchCount = 0;
        boolean isInBonusNumber = false;

        for (Integer number : numbers) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }

        if (bonusNumber.isInWinningLotto(winningLotto)) {
            isInBonusNumber = true;
        }


        return new LottoResult(matchCount, isInBonusNumber);
    }

    // TODO: 추가 기능 구현
}
