package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public Purchase purchaseLotto() {
        String input = Console.readLine();
        Integer amount = InputParser.toInteger(input);
        return new Purchase(amount);
    }
}
