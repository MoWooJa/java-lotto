package lotto.util;

import static org.junit.platform.commons.util.StringUtils.isBlank;

import java.util.List;
import lotto.ErrorMassage;


public class PurchaseInputParser implements InputParser {
    public static final int ZERO = 0;
    public static final int PURCHASE_UNIT = 1000;

    public List<Integer> parse(String input) {
        if (isBlank(input)) {
            throw new IllegalArgumentException(ErrorMassage.INVALID_INPUT_FORM.getMessage());
        }
        int target = tryParseAndSave(input);
        checkMoneyFormat(target);
        return List.of(target / PURCHASE_UNIT);
    }

    private void checkMoneyFormat(int target) {
        if (target < ZERO || (target % PURCHASE_UNIT) != ZERO) {
            throw new IllegalArgumentException(ErrorMassage.WRONG_PURCHASE_UNIT.getMessage());
        }
    }

    private int tryParseAndSave(String input) {
        int result;
        try {
            result = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMassage.INVALID_INPUT_FORM.getMessage());
        }
        return result;
    }
}
