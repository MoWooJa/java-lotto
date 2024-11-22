package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {

    public Purchase purchaseLotto() {
        String input = Console.readLine();
        Integer amount = InputParser.toInteger(input);

        return new Purchase(amount);
    }

    public Lotto getLottoNumber() {
        String input = Console.readLine();
        List<Integer> numbers = InputParser.splitByDelimiter(input);

        return new Lotto(numbers);
    }

    public WinLotto getBonusNumber(Lotto lotto) {
        String input = Console.readLine();
        Integer bonusNumber = InputParser.toInteger(input);
        Bonus bonus = new Bonus(bonusNumber);

        return new WinLotto(lotto, bonus);
    }
}
