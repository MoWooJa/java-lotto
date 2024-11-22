package lotto.model.type;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class WinningTypeTest {
    @ParameterizedTest(name = "count: {0}, expected type: {1}")
    @CsvSource({
            "6, FIRST",
            "4, FOURTH",
            "3, FIFTH",
            "2, NONE",
            "1, NONE",
            "0, NONE"
    })
    void getTypeByCountTest(int count, String expectedTypeName) {
        //when
        WinningType actualType = WinningType.getTypeByCount(count);
        //then
        assertThat(actualType).isEqualTo(WinningType.valueOf(expectedTypeName));
    }


    @ParameterizedTest(name = "WiningType {0}은 등수 {1}, 맞춘 갯수 {2}, 상금 {3}")
    @CsvSource({
            "FIRST, 1, 6, 2_000_000_000",
            "SECOND, 2, 5, 30_000_000",
            "THIRD, 3, 5, 1_500_000",
            "FOURTH, 4, 4, 50_000",
            "FIFTH, 5, 3, 5_000",
            "NONE, 0, 0, 0"
    })
    void propertiesTest(String typeName, int expectedRank, int expectedCount, int expectedPrise) {
        //given
        WinningType type = WinningType.valueOf(typeName);

        //then
        assertThat(type.getRank()).isEqualTo(expectedRank);
        assertThat(type.getCountCondition()).isEqualTo(expectedCount);
        assertThat(type.getPrize()).isEqualTo(expectedPrise);
    }
}
