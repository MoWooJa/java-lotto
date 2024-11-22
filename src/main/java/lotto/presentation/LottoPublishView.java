package lotto.presentation;

import lotto.lotto.Lottos;
import lotto.lotto.Purchase;
import lotto.lotto.Lotto;

public class LottoPublishView {

    public void printPublishedLotto(Purchase purchase, Lottos lottos) {
        System.out.printf("%d개를 구매했습니다.", purchase.getQuantity());
        System.out.println();
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }
}
