package lotto;

public record WinLottoDto(Prize prize, boolean bonusStatus) {
    public static WinLottoDto of(Prize prize, boolean bonusStatus) {
        return new WinLottoDto(prize, bonusStatus);
    }
}
