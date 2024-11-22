package lotto.lottoResult;


public class RateCalculator {

    public static String calculateRate(Long totalBenefit, Integer purchaseAmount) {
        double total = totalBenefit / (double) purchaseAmount * 100;
        return String.format("%,.1f", total);
    }
}
