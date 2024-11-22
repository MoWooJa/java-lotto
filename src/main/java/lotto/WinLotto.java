package lotto;

import java.util.List;

public class WinLotto {
    private final Lotto lotto;

    private final Bonus bonus;

    public WinLotto(Lotto lotto, Bonus bonus) {
        lotto.isSameWithBonus(bonus);
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public Lotto getLotto() {
        return lotto;
    }

    public Integer getBonusNumber() {
        return bonus.getNumber();
    }

    public WinLottoDto compareWinNumber(List<Integer> numbers) {
        boolean bonusStatus = bonus.containBonus(numbers);
        int count = lotto.containNumber(numbers);
        Prize prize = Prize.of(count, bonusStatus);
        return WinLottoDto.of(prize, bonusStatus);
    }
}
