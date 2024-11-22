package lotto;

public enum Exceptions {
    NO_NUMBER("[ERROR] 숫자만 입력 가능합니다."),

    INVALID_AMOUNT("[ERROR] 1000원 단위만 입력 가능합니다.");
    private final String message;

    Exceptions(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
