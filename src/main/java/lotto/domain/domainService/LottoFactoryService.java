package lotto.domain.domainService;

import lotto.domain.Lotto;
import lotto.domain.LottoNumberGenerator;
import lotto.domain.Money;

import java.util.ArrayList;
import java.util.List;

public class LottoFactoryService {
    private LottoNumberGenerator lottoNumberGenerator;

    public LottoFactoryService(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
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
        List<Integer> numbers = lottoNumberGenerator.generateNumbers();
        return Lotto.create(numbers);
    }


}
