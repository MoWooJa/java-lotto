package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.model.entity.Lotto;
import lotto.model.entity.WinningLotto;
import lotto.model.type.WinningType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class WinninglottoTest {
    @DisplayName("보너스 넘버가 당첨번호와 중복되면 예외가 발생한다.")
    @Test
    void createWininglottoByDuplicatedBonusNumber() {
        assertThatThrownBy(() -> {
            WinningLotto win = new WinningLotto(List.of(1, 2, 3, 4, 5, 6));
            win.validateAndSetBonusNumber(1);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 중복될 수 없습니다.");
    }

    @DisplayName("보너스 넘버가 45보다 크면 예외가 발생한다.")
    @Test
    void createWininglottoByOverMaximumBonusNumber() {
        assertThatThrownBy(() -> {
            WinningLotto win = new WinningLotto(List.of(1, 2, 3, 4, 5, 6));
            win.validateAndSetBonusNumber(46);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("보너스 넘버가 1보다 작으면 예외가 발생한다.")
    @Test
    void createWininglottoByUnderMinimumBonusNumber() {
        assertThatThrownBy(() -> {
            WinningLotto win = new WinningLotto(List.of(1, 2, 3, 4, 5, 6));
            win.validateAndSetBonusNumber(-1);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("로또 객체의 당첨 등수를 알 수 있다.")
    @ParameterizedTest(name = "로또 번호: {0}, 예상 등수: {1}")
    @CsvSource({
            "'1,2,3,4,5,6','FIRST'",
            "'1,2,3,4,5,7','SECOND'",
            "'1,2,3,4,5,8','THIRD'",
            "'1,2,3,4,7,8','FOURTH'",
            "'1,2,3,7,8,9','FIFTH'",
            "'1,2,7,8,9,10','NONE'"
    })
    void canCheckRankOfLottoTest(String lottoNumbers, String expectedRank) {
        //given
        List<Integer> lottoNumberList = Arrays.stream(lottoNumbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        Lotto lotto = new Lotto(lottoNumberList);
        WinningLotto win = new WinningLotto(List.of(1, 2, 3, 4, 5, 6));
        win.validateAndSetBonusNumber(7);

        //when
        WinningType rank = win.checkWiningType(lotto);

        //then
        assertThat(rank).isInstanceOf(WinningType.class)
                .isEqualTo(WinningType.valueOf(expectedRank));
    }

    @Test
    @DisplayName("winning lotto toString 테스트")
    void toStringTest() {
        WinningLotto win = new WinningLotto(List.of(1, 2, 3, 4, 5, 6));
        win.validateAndSetBonusNumber(7);
        assertThat(win.toString()).isEqualTo("winningLotto: [1, 2, 3, 4, 5, 6] bonus: 7");
    }
}
