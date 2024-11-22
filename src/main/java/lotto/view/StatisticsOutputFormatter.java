package lotto.view;

import lotto.model.entity.LottoStatistic;
import lotto.model.type.WinningType;

public class StatisticsOutputFormatter implements OutputFormatter {
    private final String STATISTICS_OUTPUT_FORMAT = "%d개 일치 (%,d원) - %d개";
    private final String STATISTICS_OUTPUT_FORMAT_WHEN_MATCH_FIVE_WITH_BONUS = "%d개 일치, 보너스 볼 일치 (%,d원) - %d개";
    private final String WINNING_RATE_OUTPUT_FORMAT = "총 수익률은 %.1f%%입니다.";
    private final String STATICS_MESSAGE = "당첨 통계"+ System.lineSeparator() + "---"+System.lineSeparator();

    private final LottoStatistic statistics;
    private String outputContents="";

    public StatisticsOutputFormatter(LottoStatistic statistics) {
        this.statistics = statistics;
    }

    @Override
    public String format() {
        outputContents += STATICS_MESSAGE;
        for (WinningType type : statistics.getEntry()) {
            singleFormat(type);
        }
        calculateWinningRate();
        return outputContents;
    }

    private void calculateWinningRate() {
        outputContents += String.format(WINNING_RATE_OUTPUT_FORMAT, statistics.calculateWinningRate());
    }

    private void singleFormat(WinningType type) {
        int countCondition = type.getCountCondition();
        int prize = type.getPrize();
        int count = statistics.getCount(type);
        if(type == WinningType.SECOND) {
            bounusFormat(countCondition, prize, count);
        }
        if(type != WinningType.SECOND && type != WinningType.NONE) {
            regularFormat(countCondition, prize, count);
        }
    }

    private void regularFormat(int countCondition, int prize, int count) {
        outputContents += String.format(STATISTICS_OUTPUT_FORMAT, countCondition, prize, count)
                + System.lineSeparator();
    }
    private void bounusFormat(int countCondition, int prize, int count) {
        outputContents += String.format(
                STATISTICS_OUTPUT_FORMAT_WHEN_MATCH_FIVE_WITH_BONUS,
                countCondition, prize, count)
                + System.lineSeparator();
    }
}
