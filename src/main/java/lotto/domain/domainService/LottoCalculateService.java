package lotto.domain.domainService;

import lotto.domain.*;

import java.util.EnumMap;
import java.util.Map;

public class LottoCalculateService {

    public LottoCalculateService(){
    }

    public EnumMap<LottoRank, Integer> determineRank(Lottos lottos, Lotto winningLotto,BonusNumber bonusNumber) {
        EnumMap<LottoRank, Integer> rankCount = new EnumMap<>(LottoRank.class);

        for (LottoRank value : LottoRank.values()) {
            rankCount.put(value, 0);
        }

        LottoResults lottoResults = lottos.compareLottos(winningLotto, bonusNumber);

        for (LottoResult lottoResult : lottoResults.getLottoResults()) {
            LottoRank lottoRank = LottoRank.findRankByMatching(lottoResult);
            rankCount.put(lottoRank, rankCount.get(lottoRank) + 1);
        }

        return rankCount;
    }

    public double calculateProfitRate(EnumMap<LottoRank, Integer> rankCount) {
        long totalPrize = 0L;
        long totalMoneySpent = rankCount.size() * 1000L;

        for (Map.Entry<LottoRank, Integer> entry : rankCount.entrySet()) {
            totalPrize += ((long) entry.getValue() * entry.getKey().getPrize());
        }

        double profitRate = ((double) totalPrize / totalMoneySpent);
        return Math.round(profitRate * 100) / 100.0;
    }

}
