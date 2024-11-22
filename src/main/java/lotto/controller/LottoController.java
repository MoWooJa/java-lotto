package lotto.controller;

import java.util.List;
import lotto.ErrorMassage;
import lotto.config.LottoConfig;
import lotto.model.agriation.LottoStore;
import lotto.util.InputParser;
import lotto.util.PurchaseInputParser;
import lotto.util.WinningLottoInputParser;
import lotto.view.InputType;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private static final int MAX_ATTEMPTS = 5;
    private final LottoStore lottoStore;
    private final OutputView outputView;
    private final InputView inputView;
    private InputParser inputParser;

    public LottoController(LottoConfig config) {
        this.lottoStore = config.getLottoStore();
        this.outputView = config.getOutputView();
        this.inputView = config.getInputView();
    }

    public void start() {
        repeatUntilSuccess(this::purchase);
        repeatUntilSuccess(this::getWinningLotto);
        repeatUntilSuccess(this::getWinningBonus);
        startStatistic();
    }

    public void repeatUntilSuccess(Runnable action) {
        int attempts = 0;
        while (true) {
            if (tryUntillAttemptsLimit(action, attempts)) {
                break;
            }
            attempts++;
        }

    }

    private static boolean tryUntillAttemptsLimit(Runnable action, int attempts) {
        try {
            action.run();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            if (attempts >= MAX_ATTEMPTS) {
                throw new IllegalArgumentException(ErrorMassage.EXCEED_MAX_ATTMPTS.getMessage());
            }
        }
        return false;
    }

    public void purchase() {
        List<Integer> purchaseAmount = getParsedInput(InputType.PURCHASE);
        lottoStore.purchaseLottos(purchaseAmount);
        lottoStore.displayPurchaseAmount(outputView);
        lottoStore.displayLottos(outputView);
    }


    public void getWinningLotto() {
        List<Integer> winningLottos = getParsedInput(InputType.WINNING_LOTTO);
        lottoStore.saveWinningLotto(winningLottos);
    }

    public void getWinningBonus() {
        List<Integer> bonusNumber = getParsedInput(InputType.WINNING_BONUS);
        lottoStore.saveBonusNumber(bonusNumber);
    }

    public void startStatistic() {
        lottoStore.checkWinning();
        lottoStore.displayStatistics(outputView);
    }

    private void selectParser(InputType inputType) {
        if (inputType == InputType.PURCHASE) {
            inputParser = new PurchaseInputParser();
        }
        if (inputType == InputType.WINNING_LOTTO || inputType == InputType.WINNING_BONUS) {
            inputParser = new WinningLottoInputParser();
        }
    }

    private List<Integer> getParsedInput(InputType inputType) {
        String input = inputView.getInput(inputType);
        selectParser(inputType);
        return inputParser.parse(input);
    }
}
