package lotto.controller;

import lotto.applicationService.LottoService;
import lotto.domain.*;
import lotto.util.Parser;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.EnumMap;
import java.util.List;

public class Controller {
    private LottoService lottoService;
    private InputView inputView;
    private OutputView outputView;

    public Controller(LottoService lottoService, InputView inputView, OutputView outputView) {
        this.lottoService = lottoService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Lottos lottos = purchaseLotto();
        outputView.displayLottoQuantity(lottos.size());
        lottos.displayLottos();

        Lotto winningLotto = enterWinningNumbers();
        BonusNumber bonusNumber = enterBonusNumber();

        EnumMap<LottoRank, Integer> rankCount = lottoService.calculateRankCount(lottos, winningLotto, bonusNumber);
        double profitRate = lottoService.calculateProfitRate(rankCount);

        outputView.displayResult(rankCount);
        outputView.displayProfitRate(profitRate);


    }

    private Lottos purchaseLotto() {
        String moneyStr;
        Money money;
        while (true) {
            try {
                moneyStr = inputView.getMoney();
                money = new Money(moneyStr);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return lottoService.purchaseLotto(money);
    }

    private Lotto enterWinningNumbers() {
        String winningNumbersStr;
        List<Integer> winningNumbers;
        Lotto winningLotto;
        while (true) {
            try {
                winningNumbersStr = inputView.getWinningNumbers();
                winningNumbers = Parser.parse(winningNumbersStr);
                winningLotto = new Lotto(winningNumbers);
                winningLotto.printLotto();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return winningLotto;
    }

    private BonusNumber enterBonusNumber() {
        String bonusNumberStr;
        BonusNumber bonusNumber;
        while (true) {
            try {
                bonusNumberStr = inputView.getBonusNumber();
                bonusNumber = new BonusNumber(bonusNumberStr);
                bonusNumber.printBonusNumber();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return bonusNumber;
    }
}
