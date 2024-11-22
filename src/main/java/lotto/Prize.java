package lotto;

import java.util.Objects;

public enum Prize {
    FIRST(false, 2000000000L, 6),
    SECOND(true, 30000000L, 5),
    THIRD(false, 1500000L, 5),
    FOURTH(false, 50000L, 4),
    FIFTH(false, 5000L, 3),
    NONE(false, 0L, 0);

    private final boolean bonusStatus;
    private final Long prize;
    private final Integer count;

    Prize(boolean bonusStatus, Long prize, Integer count) {
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
}
