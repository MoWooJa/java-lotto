package lotto.model.type;

public enum WinningType {
    NONE(0, 0, 0),
    FIFTH(5, 3, 5_000),
    FOURTH(4, 4, 50_000),
    THIRD(3, 5, 1_500_000),
    SECOND(2, 5, 30_000_000),
    FIRST(1, 6, 2_000_000_000);

    private final int rank;
    private final int countCndition;
    private final int prize;

    WinningType(int rank, int count, int prize) {
        this.rank = rank;
        this.countCndition = count;
        this.prize = prize;
    }

    public int getCountCondition() {
        return countCndition;
    }

    public int getPrize() {
        return prize;
    }

    public int getRank() {
        return rank;
    }

    public static WinningType getTypeByCount(int count) {
        for (WinningType type : WinningType.values()) {
            boolean isExist = (type.getCountCondition() == count);
            boolean isNotSecondAndThird = (count != SECOND.getCountCondition());
            if (isExist && isNotSecondAndThird) {
                return type;
            }
            if (count < FIFTH.getCountCondition() && count >= NONE.getCountCondition()) {
                return NONE;
            }
        }
        return NONE;
    }
}
