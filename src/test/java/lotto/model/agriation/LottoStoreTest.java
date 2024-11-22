package lotto.model.agriation;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import lotto.util.NumbersGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoStoreTest {
    private LottoStore lottoStore;

    public class StubNumbersGenerator implements NumbersGenerator {
        private final List<Integer> fixedNumbers;

        public StubNumbersGenerator(List<Integer> numbers) {
            fixedNumbers = numbers;
        }

        @Override
        public List<Integer> generate() {
            return fixedNumbers;
        }
    }

    @BeforeEach
    void setUp() {
        NumbersGenerator numberGenerator = new StubNumbersGenerator(List.of(1,2,3,4,5,6));
        lottoStore = new LottoStore(numberGenerator);
    }

    @Test
    @DisplayName("로또를 구매하면 지정된 개수만큼 로또가 발급된다.")
    void purchaseLottosTest() {
        //given
        List<Integer> purchaseAmount = List.of(5);

        //when
        lottoStore.purchaseLottos(purchaseAmount);

        //then
        String displayLottos = lottoStore.toStringLottos();
        int actualCount = Arrays.stream(displayLottos.split(System.lineSeparator())).toList().size();
        assertThat(actualCount).isEqualTo(purchaseAmount.get(0));
    }


    @Test
    @DisplayName("당첨 로또 번호를 저장할 수 있다.")
    void saveWinningLottoTest() {
        //given
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        //when
        lottoStore.saveWinningLotto(winningNumbers);

        //then
        String storeToString = lottoStore.toString();
        assertThat(storeToString).contains(winningNumbers.toString());
    }

    @Test
    @DisplayName("보너스 번호를 저장할 수 있다.")
    void saveBonusNumberTest() {
        //given
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> bonusNumber = List.of(7);

        //when
        lottoStore.saveWinningLotto(winningNumbers);
        lottoStore.saveBonusNumber(bonusNumber);

        //then
        String storeToString = lottoStore.toString();
        assertThat(storeToString).contains(String.valueOf(bonusNumber.get(0)));
    }

    @Test
    @DisplayName("당첨 결과를 계산할 수 있다.")
    void checkWinningTest() {

        //given
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> bonusNumber = List.of(7);
        List<Integer> amount = List.of(1);
        lottoStore.purchaseLottos(amount); // 구매한 로또는 랜덤하게 생성됨
        lottoStore.saveWinningLotto(winningNumbers);
        lottoStore.saveBonusNumber(bonusNumber);

        //when
        lottoStore.checkWinning();
        //then
        //통계 정보
        assertThat(lottoStore.toString())
                .contains("=1").contains("FIRST", "SECOND", "THIRD", "FOURTH", "FIFTH", "NONE");
        System.out.println(lottoStore.toString());
    }

    @Test
    @DisplayName("잘못된 로또 번호로 당첨 번호를 저장하면 예외가 발생한다.")
    void saveWinningLottoInvalidTest() {
        //given
        List<Integer> invalidWinningNumbers = Arrays.asList(1, 2, 3, 4, 5); // 5개만 있음

        //when & then
        assertThrows(IllegalArgumentException.class, () -> lottoStore.saveWinningLotto(invalidWinningNumbers));
    }

    @Test
    @DisplayName("보너스 번호가 범위를 벗어나면 예외가 발생한다.")
    void saveBonusNumberInvalidTest() {
        //given
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> invalidBonusNumber = List.of(46); // 범위를 초과

        lottoStore.saveWinningLotto(winningNumbers);

        //when & then
        assertThrows(IllegalArgumentException.class, () -> lottoStore.saveBonusNumber(invalidBonusNumber));
    }


}
