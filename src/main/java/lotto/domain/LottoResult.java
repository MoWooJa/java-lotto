package lotto.domain;

public class LottoResult {
    private int matchCount;
    private boolean hasBonusNumber;

    public LottoResult(int matchCount, boolean hasBonusNumber) {
        this.matchCount = matchCount;
        this.hasBonusNumber = hasBonusNumber;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isHasBonusNumber() {
        return hasBonusNumber;
    }
}
