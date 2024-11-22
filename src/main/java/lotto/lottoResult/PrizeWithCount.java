package lotto.lottoResult;

public class PrizeWithCount {
    private final Prize prize;

    private int count;

    public PrizeWithCount(Prize prize, int count) {
        this.prize = prize;
        this.count = count;
    }

    public void increaseCount() {
        count++;
    }

    public Prize getPrize() {
        return prize;
    }

    public int getCount() {
        return count;
    }
}

