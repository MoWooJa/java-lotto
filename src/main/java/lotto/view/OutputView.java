package lotto.view;

import lotto.domain.model.LottoRank;

import java.util.EnumMap;

public class OutputView {

    public void displayLottoQuantity(int size) {
        System.out.println(size + "개를 구매했습니다.");
    }

    public void displayLottos() {

    }

    public void displayResult(EnumMap<LottoRank, Integer> rankCount) {
        System.out.println("당첨 통계");
        StringBuilder result = new StringBuilder("---\n");

        for (LottoRank rank : LottoRank.values()) {
            int count = rankCount.getOrDefault(rank, 0);
            long prize = rank.getPrize();

            result.append(String.format("%s (%s원) - %d개%n",
                    rank.getDisplayBoard(),
                    String.format("%,d", prize),
                    count));
        }
        System.out.println(result);
    }


    public void displayProfitRate(double profitRate) {
        System.out.println("총 수익률은 " + profitRate+ "%입니다.");
    }


}

