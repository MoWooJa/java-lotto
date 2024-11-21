package lotto.domain;

public class BonusNumber {
    //TODO 보너스 넘버는 당첨 로또와 겹치면 안됨..
    // 보너스 넘버는 1~45
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private int bonusNumber;

    public BonusNumber(String bonusNumber) {
        try{
            this.bonusNumber = Integer.parseInt(bonusNumber);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("ERROR : 올바르지 않은 보너스 넘버 형식입니다.");
        }
        validateNumberRange();
    }

    private void validateNumberRange() {
        if (bonusNumber < MIN_NUMBER || bonusNumber > MAX_NUMBER) {
            throw new IllegalArgumentException("ERROR : 보너스 숫자는 1 ~ 45");
        }
    }
    public void printBonusNumber() {
        System.out.println(bonusNumber);
    }
    public Boolean isInWinningLotto(Lotto winningLotto) {
        return winningLotto.getNumbers().contains(bonusNumber);
    }
}
