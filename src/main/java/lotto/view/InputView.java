package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String getInput(InputType inputType) {
        System.out.println(inputType.getMessage());
        return Console.readLine();
    }
}
