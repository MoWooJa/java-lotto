package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoNumberGenerator {

    public List<Integer> generateNumbers() {
        return Randoms.pickUniqueNumbersInRange(1,45,6);
    }
}