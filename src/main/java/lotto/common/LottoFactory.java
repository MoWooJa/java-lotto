package lotto.common;

import lotto.lottoPublish.LottoGenerator;
import lotto.lottoPublish.LottoPublishController;
import lotto.lottoResult.LottoResultController;
import lotto.lottoPublish.LottoService;
import lotto.MainController;
import lotto.presentation.GetLottoController;
import lotto.presentation.InputHandler;
import lotto.presentation.InputView;
import lotto.presentation.LottoPublishView;
import lotto.presentation.LottoResultView;

public class LottoFactory {
    public static MainController mainController() {
        return new MainController(lottoPublishController(), lottoResultController(), getLottoController());
    }

    private static GetLottoController getLottoController() {
        return new GetLottoController(inputHandler());
    }

    private static LottoResultController lottoResultController() {
        return new LottoResultController(lottoResultView());
    }

    private static LottoResultView lottoResultView() {
        return new LottoResultView();
    }

    private static LottoPublishController lottoPublishController() {
        return new LottoPublishController(lottoService(), lottoPublishView());
    }

    private static LottoService lottoService() {
        return new LottoService(lottoGenerator());
    }

    private static LottoGenerator lottoGenerator() {
        return new LottoGenerator();
    }

    private static InputHandler inputHandler() {
        return new InputHandler(inputView());
    }

    private static InputView inputView() {
        return new InputView();
    }

    private static LottoPublishView lottoPublishView() {
        return new LottoPublishView();
    }
}
