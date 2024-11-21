package lotto.domain.model;

import lotto.domain.dto.LottoResult;

public enum LottoRank {
    SIX_MATCH(6, 2_000_000_000, false, "6개 일치"),
    FIVE_MATCH_BONUS(5, 30_000_000, true, "5개 일치, 보너스 볼 일치"),
    FIVE_MATCH(5, 1_500_000, false, "5개 일치"),
    FOUR_MATCH(4, 50_000, false, "4개 일치"),
    THREE_MATCH(3, 5_000, false, "3개 일치"),
    ELSE(0, 0, false, "꽝");

    private int matchedCount;
    private int prize;
    private Boolean isMatchedBonus;
    private String displayBoard;

    public String getDisplayBoard() {
        return displayBoard;
    }

    public int getPrize() {
        return prize;
    }

    LottoRank(int matchedCount, int prize, Boolean isMatchedBonus, String displayBoard) {
        this.matchedCount = matchedCount;
        this.prize = prize;
        this.isMatchedBonus = isMatchedBonus;
        this.displayBoard = displayBoard;
    }

    //5개 일때는 보너스 번호 boolean을 따져야 하고, 아닐 때는 안 따져도 됨..
    public static LottoRank findRankByMatching(LottoResult lottoResult) {
        int matchCount = lottoResult.getMatchCount();
        boolean hasBonus = lottoResult.isHasBonusNumber();

        if (matchCount == 5) {
            for (LottoRank value : LottoRank.values()) {
                if (value.matchedCount == 5 && value.isMatchedBonus == hasBonus) {
                    return value;
                }
            }
        }
        for (LottoRank value : LottoRank.values()) {
            if (value.matchedCount == matchCount) {
                return value;
            }
        }
        return ELSE;
    }
}
