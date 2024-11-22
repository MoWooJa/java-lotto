package lotto.lottoResult;

import java.util.List;
import lotto.lotto.Purchase;
import lotto.presentation.LottoResultView;

public class LottoResultController {
    private final LottoResultView lottoResultView;

    public LottoResultController(LottoResultView lottoResultView) {
        this.lottoResultView = lottoResultView;
    }

    public void lottoResult(List<Prize> prizes, Purchase purchase) {
        LottoResult lottoResult = new LottoResult(prizes, purchase.getAmount());
        lottoResultView.printLottoResult(lottoResult);
    }
}
