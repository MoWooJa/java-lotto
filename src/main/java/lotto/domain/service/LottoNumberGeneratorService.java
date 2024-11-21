package lotto.domain.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoNumberGeneratorService {

    public List<Integer> generateNumbers() {
        return Randoms.pickUniqueNumbersInRange(1,45,6);
    }
}
