package lotto.lottoPublish;

import java.util.List;
import lotto.lotto.Lottos;
import lotto.lotto.Purchase;
import lotto.lotto.WinLotto;
import lotto.lottoResult.Prize;
import lotto.presentation.LottoPublishView;

public class LottoPublishController {
    private final LottoService lottoService;
    private final LottoPublishView lottoPublishView;

    public LottoPublishController(LottoService lottoService, LottoPublishView lottoPublishView) {
        this.lottoService = lottoService;
        this.lottoPublishView = lottoPublishView;
    }

    public List<Prize> lottoPublish(Purchase purchase, WinLotto winLotto) {
        Lottos publishedLotto = lottoService.publish(purchase.getQuantity());
        lottoPublishView.printPublishedLotto(purchase, publishedLotto);

        return publishedLotto.compareWithWinLotto(winLotto);
    }
}
