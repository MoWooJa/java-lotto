package lotto.view;

import lotto.model.entity.LottoStatistic;

public class OutputView {
    private final String PURCHASE_AMOUNT_OUTPUT_FORMAT = "%d개를 구매했습니다.";


    public void print(int amount) {
        System.out.printf(PURCHASE_AMOUNT_OUTPUT_FORMAT, amount);
    }

    public void print(String message) {
        System.out.println(message);
    }

    public void print(LottoStatistic statistic) {
        StatisticsOutputFormatter formatter = new StatisticsOutputFormatter(statistic);
        System.out.println(formatter.format());
    }
}
