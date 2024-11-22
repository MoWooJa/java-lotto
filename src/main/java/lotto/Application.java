package lotto;

import lotto.common.LottoFactory;

public class Application {
    public static void main(String[] args) {
        MainController mainController = LottoFactory.mainController();
        mainController.run();
    }
}
