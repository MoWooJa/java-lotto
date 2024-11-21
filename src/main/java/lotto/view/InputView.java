package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String getMoney() {
        System.out.println("구입금액을 입력해주세요.");
        return Console.readLine();
    }

    public String getWinningNumbers() {
        System.out.println("당첨번호를 입력해주세요");
        return Console.readLine();
    }

    public String getBonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해주세요");
        return Console.readLine();
    }
}