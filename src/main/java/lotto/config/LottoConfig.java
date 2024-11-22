package lotto.config;

import lotto.model.agriation.LottoStore;
import lotto.util.NumbersGenerator;
import lotto.util.RandomNumbersGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoConfig {
    private final LottoStore lottoStore;
    private final OutputView outputView;
    private final InputView inputView;


    public LottoConfig() {
        NumbersGenerator numbersGenerator = new RandomNumbersGenerator();
        this.lottoStore = new LottoStore(numbersGenerator);
        this.outputView = new OutputView();
        this.inputView = new InputView();
    }

    public LottoStore getLottoStore() {
        return this.lottoStore;
    }

    public OutputView getOutputView() {
        return this.outputView;
    }
    public InputView getInputView() {
        return this.inputView;
    }
}
