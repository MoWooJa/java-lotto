package lotto.view;

public enum InputType {
    PURCHASE("구입금액을 입력해 주세요."+System.lineSeparator()),
    WINNING_LOTTO("당첨 번호를 입력해 주세요."+System.lineSeparator()),
    WINNING_BONUS("보너스 번호를 입력해 주세요."+System.lineSeparator());

    private final String message;

    InputType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
