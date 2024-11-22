package lotto.presentation;

import lotto.lotto.Purchase;
import lotto.lotto.WinLotto;

public record LottoInfoFromUserDto(Purchase purchase, WinLotto winLotto) {
    public static LottoInfoFromUserDto of(Purchase purchase, WinLotto winLotto) {
        return new LottoInfoFromUserDto(purchase, winLotto);
    }
}
