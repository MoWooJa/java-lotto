package lotto.model.entity;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import lotto.model.type.WinningType;

public class LottoStatistic {
    public static final int PURCHASE_UNIT = 1000;
    public static final int PERCENTAGE = 100;
    private final LinkedHashMap<WinningType, Integer> statistic;

    public LottoStatistic() {
        this.statistic = new LinkedHashMap<>();
        for (WinningType winningType : WinningType.values()) {
            this.statistic.put(winningType, 0);
        }
    }

    public void increment(WinningType type) {
        statistic.put(type, statistic.get(type) + 1);
    }

    public int getCount(WinningType type) {
        return statistic.getOrDefault(type, 0);
    }

    public List<WinningType> getEntry() {
        return new ArrayList<>(statistic.keySet());
    }

    public double calculateWinningRate() {
        double total = 0;
        for (WinningType type : WinningType.values()) {
            total += type.getPrize() * getCount(type);
        }
        return total / purchaseAmount() * PERCENTAGE;
    }

    private double purchaseAmount() {
        double amount = 0;
        for (WinningType type : WinningType.values()) {
            amount += getCount(type);
        }
        return amount * PURCHASE_UNIT;
    }

    public String toString() {
        return "\nstatistic: " + statistic.toString();
    }
}
