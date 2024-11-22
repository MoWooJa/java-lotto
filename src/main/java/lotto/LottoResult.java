package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoResult {
    private final Long totalBenefit;
    private final String benefitRate;
    private final List<PrizeWithCount> prizeWithCounts;

    public LottoResult(List<Prize> prizes, Integer amount) {
        this.totalBenefit = totalBenefit(prizes, amount);
        this.benefitRate = benefitRate(totalBenefit, amount);
        this.prizeWithCounts = prizeWithCounts(prizes);
    }

    private List<PrizeWithCount> prizeWithCounts(List<Prize> prizes) {
        List<PrizeWithCount> prizeWithCounts = new ArrayList<>();

        for (Prize prize : Prize.values()) {
            prizeWithCounts.add(new PrizeWithCount(prize, 0));
        }

        for (PrizeWithCount prizeWithCount : prizeWithCounts) {
            for (Prize prize : prizes) {
                if (prize == prizeWithCount.getPrize()) {
                    prizeWithCount.increaseCount();
                }
            }
        }
        return prizeWithCounts;
    }

    private String benefitRate(Long totalBenefit, Integer amount) {
        return RateCalculator.calculateRate(totalBenefit, amount);
    }

    private Long totalBenefit(List<Prize> prizes, Integer amount) {
        Long total = 0L;
        for (Prize prize : prizes) {
            total += prize.getPrize();
        }
        return total;
    }

    public List<PrizeWithCount> getPrizeWithCounts() {
        return prizeWithCounts;
    }

    public String getBenefitRate() {
        return benefitRate;
    }
}
