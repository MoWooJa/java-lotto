package lotto.model.agriation;

import java.util.List;
import lotto.model.entity.Lotto;
import lotto.model.entity.LottoStatistic;
import lotto.model.entity.WinningLotto;
import lotto.model.type.WinningType;
import lotto.util.NumbersGenerator;
import lotto.view.OutputView;

public class LottoStore {
    private static final int INDEX_OF_FIRST = 0;

    private final Lottos lottos;
    private final LottoStatistic lottoStatistic;
    private WinningLotto winningLotto;
    private int purchaseAmount;

    public LottoStore(NumbersGenerator numbersGenerator) {
        this.lottos = new Lottos(numbersGenerator);
        this.lottoStatistic = new LottoStatistic();
    }

    public void saveWinningLotto(List<Integer> numbers) {
        winningLotto = new WinningLotto(numbers);
    }

    public void purchaseLottos(List<Integer> amountInput) {
        this.purchaseAmount = amountInput.get(INDEX_OF_FIRST);
        lottos.purchaseLottos(purchaseAmount);
    }

    public void saveBonusNumber(List<Integer> number) {
        winningLotto.validateAndSetBonusNumber(number.get(INDEX_OF_FIRST));
    }

    public void checkWinning() {
        for (Lotto lotto : lottos.getLottos()) {
            WinningType rank = winningLotto.checkWiningType(lotto);
            lottoStatistic.increment(rank);
        }
    }

    public void displayLottos(OutputView outputView) {
        outputView.print(lottos.displayLottos());
    }

    public void displayStatistics(OutputView outputView) {
        outputView.print(lottoStatistic);
    }

    public void displayPurchaseAmount(OutputView outputView) {
        outputView.print(purchaseAmount);
    }

    public String toStringLottos() {
        return lottos.displayLottos();
    }

    @Override
    public String toString() {
        return "lotto list\n" + lottos.displayLottos() + winningLotto.toString() + lottoStatistic;
    }
}
