package lotto.common;

public enum Exceptions {
    NO_NUMBER("[ERROR] 숫자만 입력 가능합니다."),
    INVALID_AMOUNT("[ERROR] 1000원 단위만 입력 가능합니다."),
    LOTTO_NUMBER_RANGE_ERROR("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    LOTTO_NUMBER_DUPLICATED("[ERROR] 로또 넘버가 중복됩니다.");
    private final String message;

    Exceptions(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
