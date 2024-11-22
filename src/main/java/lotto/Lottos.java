package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public List<Prize> compareWithWinLotto(WinLotto winLotto) {
        List<Prize> prizes = new ArrayList<>();
        // 로또 prize 개수 세기
        for (Lotto lotto : lottos) {
            Prize prize = winLotto.compareWinNumber(lotto.getNumbers());
            prizes.add(prize);
        }
        return prizes;
    }
}
