package lotto.presentation;

import java.util.List;
import lotto.lottoResult.LottoResult;
import lotto.lottoResult.Prize;
import lotto.lottoResult.PrizeWithCount;

public class LottoResultView {

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
