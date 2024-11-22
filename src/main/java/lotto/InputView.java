package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {

    public Purchase purchaseLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        Integer amount = InputParser.toInteger(input);

        return new Purchase(amount);
    }

    public Lotto getLottoNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        List<Integer> numbers = InputParser.splitByDelimiter(input);

        return new Lotto(numbers);
    }

    public WinLotto getBonusNumber(Lotto lotto) {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        Integer bonusNumber = InputParser.toInteger(input);
        Bonus bonus = new Bonus(bonusNumber);

        return new WinLotto(lotto, bonus);
    }
}
