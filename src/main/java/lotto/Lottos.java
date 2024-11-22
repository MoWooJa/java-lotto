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

    public List<WinLottoDto> compareWithWinLotto(WinLotto winLotto) {
        List<WinLottoDto> winLottos = new ArrayList<>();
        for (Lotto lotto : lottos) {
            WinLottoDto winLottoDto = winLotto.compareWinNumber(lotto.getNumbers());
            winLottos.add(winLottoDto);
        }
        return winLottos;
    }
}
