package lotto;

public enum ErrorMassage {
    EXCEED_MAX_ATTMPTS("[ERROR] 5번 이상 실패하여 종료합니다."),
    OUT_OF_LOTTO_NUMBER_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    WRONG_LOTTO_SIZE("[ERROR] 로또 번호는 6개여야 합니다."),
    DUPLICATED_NUMBER_EXIST("[ERROR] 로또 번호는 중복될 수 없습니다."),
    INVALID_INPUT_FORM("[ERROR] 유효하지 않은 입력입니다."),
    WRONG_PURCHASE_UNIT("[ERROR] 구입 금액은 1000원 단위로 입력 해야 합니다.")
    ;

    private final String message;

    ErrorMassage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
