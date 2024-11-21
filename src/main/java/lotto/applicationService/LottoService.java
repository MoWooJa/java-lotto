package lotto.applicationService;

import lotto.domain.*;
import lotto.domain.domainService.LottoCalculateService;
import lotto.domain.domainService.LottoFactoryService;

import java.util.EnumMap;
import java.util.List;

public class LottoService {
    private LottoFactoryService lottoFactoryService;
    private LottoCalculateService lottoCalculateService;

    public LottoService(LottoFactoryService lottoFactoryService, LottoCalculateService lottoCalculateService) {
        this.lottoFactoryService = lottoFactoryService;
        this.lottoCalculateService = lottoCalculateService;
    }

    public Lottos purchaseLotto(Money money) {
        List<Lotto> lottos = lottoFactoryService.createLottos(money);
        return Lottos.createLottos(lottos);
    }

    public EnumMap<LottoRank, Integer> calculateRankCount(Lottos lottos, Lotto winningLotto, BonusNumber bonusNumber) {
        return lottoCalculateService.determineRank(lottos, winningLotto, bonusNumber);
    }

    public double calculateProfitRate(EnumMap<LottoRank, Integer> rankCount) {
        return lottoCalculateService.calculateProfitRate(rankCount);
    }

}
