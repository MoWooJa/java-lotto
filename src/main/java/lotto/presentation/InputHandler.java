package lotto.presentation;

import java.util.function.Supplier;
import lotto.lotto.Purchase;
import lotto.lotto.WinLotto;
import lotto.lotto.Lotto;

public class InputHandler {

    private final InputView inputView;

    public InputHandler(InputView inputView) {
        this.inputView = inputView;
    }

    public Purchase purchaseLotto() {
        return handle(inputView::purchaseLotto);
    }

    public Lotto askLottoNumber() {
        return handle(inputView::getLottoNumber);
    }

    public WinLotto askBonusNumber(Lotto lotto) {
        return handle(() -> inputView.getBonusNumber(lotto));
    }


    private <T> T handle(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
