package lotto.domain;

import java.util.List;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos createLottos(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public LottoResults compareLottos(Lotto winningLotto, BonusNumber bonusNumber) {
        LottoResults lottoResults = new LottoResults();

        for (Lotto lotto : lottos) {
            LottoResult lottoResult = lotto.compareToWinningLotto(winningLotto, bonusNumber);
            lottoResults.add(lottoResult);
        }
        return lottoResults;
    }

    public void displayLottos() {

        for (Lotto lotto : lottos) {
            lotto.printLotto();
            System.out.println();
        }
        System.out.println();

    }

    public int size() {
        return lottos.size();
    }



}
