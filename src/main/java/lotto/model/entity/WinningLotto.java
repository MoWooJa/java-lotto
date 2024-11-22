package lotto.model.entity;

import java.util.ArrayList;
import java.util.List;
import lotto.model.type.WinningType;

public class WinningLotto extends Lotto {
    private int bonus;

    public WinningLotto(List<Integer> numbers) {
        super(numbers);
    }

    public void validateAndSetBonusNumber(int bonus) {
        boolean isValid = isValidBonusNumber(bonus);
        if (isValid) {
            this.bonus = bonus;
        }
    }

    protected boolean isValidBonusNumber(int bonus) {
        List<Integer> targetNumbers = new ArrayList<>(super.getNumbers());
        targetNumbers.add(bonus);
        validateLottoRange(targetNumbers);
        validateLottoDuplication(targetNumbers);
        return true;
    }

    public WinningType checkWiningType(Lotto lotto) {
        List<Integer> target = lotto.getNumbers();
        int score = 0;
        for (int element : super.getNumbers()) {
            if (target.contains(element)) {
                score++;
            }
        }
        return scoreConverter(score, target);
    }

    private WinningType scoreConverter(int score, List<Integer> target) {
        if (score == WinningType.SECOND.getCountCondition()) {
            if (target.contains(bonus)) {
                return WinningType.SECOND;
            }
            return WinningType.THIRD;
        }
        return WinningType.getTypeByCount(score);
    }

    @Override
    public String toString() {
        return "winningLotto: " + super.toString()+" bonus: " + bonus;
    }
}
