package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoResults {
    List<LottoResult> lottoResults;

    public LottoResults() {
        this.lottoResults = new ArrayList<>();
    }
    public void add(LottoResult lottoResult) {
        lottoResults.add(lottoResult);
    }
    public List<LottoResult> getLottoResults() {
        return lottoResults;
    }
}
