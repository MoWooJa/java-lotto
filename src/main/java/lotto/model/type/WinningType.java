package lotto.model.type;

public enum WinningType {
    FIRST(1, 6, 2_000_000_000),
    SECOND(2, 5, 30_000_000),
    THIRD(3, 5, 1_500_000),
    FOURTH(4, 4, 50_000),
    FIFTH(5, 3, 5_000),
    NONE(0,0,0);

    private final int rank;
    private final int count;
    private final int prise;

    WinningType(int rank, int count, int prise) {
        this.rank = rank;
        this.count = count;
        this.prise = prise;
    }

    public int getCount() {
        return count;
    }

    public int getPrise() {
        return prise;
    }

    public int getRank() {
        return rank;
    }

    public static WinningType getTypeByCount(int count) {
        for (WinningType type : WinningType.values()) {
            boolean isExist = (type.getCount() == count);
            boolean isNotSecondAndThird = (count != SECOND.count);
            if (isExist && isNotSecondAndThird) {
                return type;
            }
            if (count < FIFTH.getCount() && count >= NONE.getCount()) {
                return NONE;
            }
        }
        return NONE;
    }
}
