package lotto.domain;

public class Money {
    private int money;

    public Money(String money) {
        try{
            this.money = Integer.parseInt(money);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] : 1000원 단위로 나눠떨어져야 합니다");
        }
        if (this.money <= 0) {
            throw new IllegalArgumentException("[ERROR] : 빈 값 혹은 0 혹은 음수는 안됩니다. ");
        }
        if (this.money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] : 1000원 단위로 나눠떨어져야..");
        }
    }

    public int canBuyLottoQuantity() {
        return this.money / 1000;
    }

    public int getMoney() {
        return money;
    }
}
