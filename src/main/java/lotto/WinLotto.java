package lotto;

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

    public Bonus getBonus() {
        return bonus;
    }
}
