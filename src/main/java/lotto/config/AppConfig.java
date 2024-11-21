package lotto.config;

import lotto.applicationService.LottoService;
import lotto.controller.Controller;
import lotto.domain.LottoNumberGenerator;
import lotto.domain.domainService.LottoCalculateService;
import lotto.domain.domainService.LottoFactoryService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class AppConfig {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
    private final LottoCalculateService lottoCalculateService = new LottoCalculateService();
    private final LottoFactoryService lottoFactoryService = new LottoFactoryService(lottoNumberGenerator);
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
