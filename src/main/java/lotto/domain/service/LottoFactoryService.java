package lotto.domain.service;

import lotto.domain.model.Lotto;
import lotto.domain.vo.Money;

import java.util.ArrayList;
import java.util.List;

public class LottoFactoryService {
    private LottoNumberGeneratorService lottoNumberGeneratorService;

    public LottoFactoryService(LottoNumberGeneratorService lottoNumberGeneratorService) {
        this.lottoNumberGeneratorService = lottoNumberGeneratorService;
    }

    public List<Lotto> createLottos(Money money) {
        List<Lotto> lottos = new ArrayList<>();
        int LottoQuantity = money.canBuyLottoQuantity();

        for (int i = 0; i < LottoQuantity; i++) {
            Lotto lotto = createLotto();
            lottos.add(lotto);
        }
        return lottos;
    }

    private Lotto createLotto() {
        List<Integer> numbers = lottoNumberGeneratorService.generateNumbers();
        return Lotto.create(numbers);
    }


}
