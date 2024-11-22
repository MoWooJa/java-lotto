package lotto;

import static lotto.Exceptions.INVALID_AMOUNT;

public class Purchase {
    public Integer getAmount() {
        return amount;
    }

    public Integer getQuantity() {
        return quantity;
    }

    private final Integer amount;

    private final Integer quantity;

    public Purchase(Integer amount) {
        validate(amount);
        this.amount = amount;
        this.quantity = amount / 1000;
    }

    private void validate(Integer amount) {
        if (amount == 0 || amount % 1000 != 0) {
            throw new IllegalArgumentException(INVALID_AMOUNT.getMessage());
        }
    }
}
