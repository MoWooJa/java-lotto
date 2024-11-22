package lotto.lottoResult;

import java.util.Objects;

public enum Prize {
    NONE("", false, 0L, 0),
    FIFTH("3개 일치 (5,000원)", false, 5000L, 3),
    FOURTH("4개 일치 (50,000원)", false, 50000L, 4),
    THIRD("5개 일치 (1,500,000원)", false, 1500000L, 5),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원)", true, 30000000L, 5),
    FIRST("6개 일치 (2,000,000,000원)", false, 2000000000L, 6);


    private final String message;
    private final boolean bonusStatus;
    private final Long prize;
    private final Integer count;

    Prize(String message, boolean bonusStatus, Long prize, Integer count) {
        this.message = message;
        this.bonusStatus = bonusStatus;
        this.prize = prize;
        this.count = count;
    }

    public static Prize of(Integer count, boolean bonusStatus) {
        for (Prize prize : Prize.values()) {
            if (count == 5 && bonusStatus) {
                return SECOND;
            }
            if (Objects.equals(prize.count, count)) {
                return prize;
            }
        }
        return NONE;
    }

    public Long getPrize() {
        return prize;
    }

    public String getMessage() {
        return message;
    }
}
