package lotto.presentation;

import lotto.lotto.Purchase;
import lotto.lotto.WinLotto;
import lotto.lotto.Lotto;

public class GetLottoController {
    private final InputHandler inputHandler;

    public GetLottoController(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

    public LottoInfoFromUserDto getLottoFromUser() {
        Purchase purchase = inputHandler.purchaseLotto();
        Lotto lotto = inputHandler.askLottoNumber();
        WinLotto winLotto = inputHandler.askBonusNumber(lotto);
        return LottoInfoFromUserDto.of(purchase, winLotto);
    }
}
