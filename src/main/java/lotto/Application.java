package lotto;


import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        Validator validator = new Validator();
        Parser parser = new Parser();
        OutputView outputView = new OutputView();

        String amountStr;
        while (true) {
            try {
                amountStr = inputView.getAmount();
                validator.validateAmount(amountStr);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        }

        int amount = Integer.parseInt(amountStr);
        int lottoQuantity = amount / 1000;

        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoQuantity; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(lottoNumbers));
        }
        outputView.printLottos(lottos);


        String numbersStr;
        List<Integer> numbers;
        Lotto winningLotto;
        while (true) {
            try {
                numbersStr = inputView.getLottoNumbers();
                numbers = parser.parse(numbersStr);
                winningLotto = new Lotto(numbers);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        String bonusNumberStr;
        while (true) {
            try {
                bonusNumberStr = inputView.getBonusNumber();
                validator.validateBonusNumber(bonusNumberStr);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        List<LottoRank> lottoRanks = new ArrayList<>();
        for (Lotto singleLotto : lottos) {
            boolean isBonusInLotto = false;
            int matchedCount = singleLotto.compareToWinningLotto(winningLotto);

            LottoRank lottoRank = LottoRank.findRankByMatching(matchedCount, isBonusInLotto);

            lottoRanks.add(lottoRank);
        }
        long totalPrize = 0L;


        for (LottoRank lottoRank : lottoRanks) {
            totalPrize += lottoRank.getPrize();
        }

        double profitRate = Math.round((totalPrize * 100 / (double) amount) * 100) / 100.0;

        EnumMap<LottoRank, Integer> rankCounts = new EnumMap<>(LottoRank.class);

        for (LottoRank rank : LottoRank.values()) {
            rankCounts.put(rank, 0);
        }
        for (LottoRank rank : lottoRanks) {
            rankCounts.put(rank, rankCounts.get(rank) + 1);
        }

        for (LottoRank rank : LottoRank.values()) {
            System.out.printf("%s (%d원) - %d개%n", rank.getDescription(), rank.getPrize(), rankCounts.get(rank));
        }

        outputView.printProfitRate(profitRate);



    }

    static class OutputView {
        public void printLottos(List<Lotto> lottos) {
            for (Lotto lotto : lottos) {
                lotto.printLotto();
            }
        }
        public void printProfitRate(double profitRate) {
            System.out.printf("총 수익률은 %.1f%%입니다.",profitRate);
        }
    }

    static class InputView {
        public String getAmount() {
            System.out.println("금액을 입력하세요");
            return Console.readLine();
        }

        public String getLottoNumbers() {
            System.out.println("로또 번호 입력하세요");
            return Console.readLine();
        }

        public String getBonusNumber() {
            System.out.println("보너스번호 입력하세요");
            return Console.readLine();
        }
    }

    static class Parser {
        private static final String DELIMITER = ",";

        public List<Integer> parse(String input) {
            return Arrays.stream(input.split(DELIMITER))
                    .map(Integer::parseInt)
                    .toList();
        }

    }

    static class Validator {
        private static final String DELIMITER = ",";


        public void validateAmount(String input) {
            try {
                int amount = Integer.parseInt(input);
                if (amount % 1000 != 0 || amount <= 0) {
                    throw new IllegalArgumentException("1000으로 나눠떨어져야 합니다.");
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("ERROR: 숫자만 입력해주세요");
            }
        }

        public void validateBonusNumber(String input) {
            try {
                int bonusNumber = Integer.parseInt(input);
                if (bonusNumber <= 0 || bonusNumber > 45) {
                    throw new IllegalArgumentException("ERROR: 보너스 넘버는 1~45");
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("ERROR : 숫자를 입력해주세요");
            }
        }

    }
}
