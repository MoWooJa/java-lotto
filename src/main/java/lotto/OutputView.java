package lotto;

import java.util.List;

public class OutputView {

    public void printPublishedLotto(Purchase purchase, Lottos lottos) {
        System.out.printf("%d개를 구매했습니다.", purchase.getQuantity());
        System.out.println();
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }

    public void printLottoResult(LottoResult lottoResult) {
        System.out.println("당첨 통계");
        System.out.println("---");
        String benefitRate = lottoResult.getBenefitRate();
        List<PrizeWithCount> prizeWithCounts = lottoResult.getPrizeWithCounts();
        printPrizeWithCounts(prizeWithCounts);
        printRate(benefitRate);
    }

    private void printPrizeWithCounts(List<PrizeWithCount> prizeWithCounts) {
        for (PrizeWithCount prizeWithCount : prizeWithCounts) {
            if (prizeWithCount.getPrize() == Prize.NONE) {
                continue;
            }
            System.out.printf("%s - %d개", prizeWithCount.getPrize().getMessage(), prizeWithCount.getCount());
            System.out.println();
        }
    }

    public void printRate(String benefitRate) {
        System.out.printf("총 수익률은 %s%%입니다.", benefitRate);
    }
}
