package lotto.config;

import lotto.application.LottoService;
import lotto.controller.Controller;
import lotto.domain.service.LottoNumberGeneratorService;
import lotto.domain.service.LottoCalculateService;
import lotto.domain.service.LottoFactoryService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class AppConfig {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final LottoNumberGeneratorService lottoNumberGeneratorService = new LottoNumberGeneratorService();
    private final LottoCalculateService lottoCalculateService = new LottoCalculateService();
    private final LottoFactoryService lottoFactoryService = new LottoFactoryService(lottoNumberGeneratorService);
    private final LottoService lottoService = new LottoService(lottoFactoryService,lottoCalculateService);
    private final Controller controller = new Controller(lottoService, inputView, outputView);

    public InputView getInputView() {
        return inputView;
    }
    public OutputView getOutputView() {
        return outputView;
    }

    public Controller getController() {
        return controller;
    }
    public LottoService getLottoService() {
        return lottoService;
    }
}
