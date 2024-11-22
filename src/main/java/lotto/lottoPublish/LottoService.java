package lotto.lottoPublish;

import java.util.ArrayList;
import java.util.List;
import lotto.lotto.Lotto;
import lotto.lotto.Lottos;

public class LottoService {
    private final LottoGenerator lottoGenerator;

    public LottoService(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public Lottos publish(Integer quantity) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            Lotto lotto = new Lotto(lottoGenerator.generate());
            lottos.add(lotto);
        }
        return new Lottos(lottos);
    }
}
