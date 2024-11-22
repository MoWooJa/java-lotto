package lotto;

import java.util.List;
import lotto.lottoPublish.LottoPublishController;
import lotto.lottoResult.Prize;
import lotto.lottoResult.LottoResultController;
import lotto.presentation.GetLottoController;
import lotto.presentation.LottoInfoFromUserDto;

public class MainController {

    private final LottoPublishController lottoPublishController;
    private final LottoResultController lottoResultController;

    private final GetLottoController getLottoController;

    public MainController(LottoPublishController lottoPublishController, LottoResultController lottoResultController,
                          GetLottoController getLottoController) {
        this.lottoPublishController = lottoPublishController;
        this.lottoResultController = lottoResultController;
        this.getLottoController = getLottoController;
    }

    public void run() {
        LottoInfoFromUserDto lottoFromUser = getLottoController.getLottoFromUser();
        List<Prize> prizes = lottoPublishController.lottoPublish(lottoFromUser.purchase(), lottoFromUser.winLotto());
        lottoResultController.lottoResult(prizes, lottoFromUser.purchase());
    }
}
