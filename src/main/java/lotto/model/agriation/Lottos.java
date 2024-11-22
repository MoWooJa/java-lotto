package lotto.model.agriation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.model.entity.Lotto;
import lotto.util.NumbersGenerator;

public class Lottos {
    private final List<Lotto> lottos;
    private final NumbersGenerator numbersGenerator;

    public Lottos(NumbersGenerator numbersGenerator) {
        this.lottos = new ArrayList<>();
        this.numbersGenerator = numbersGenerator;
    }

    public void purchaseLottos(int amount) {
        for (int i = 0; i < amount; i++) {
            issue();
        }
    }

    private void issue() {
        List<Integer> numbers = numbersGenerator.generate();
        Lotto lotto = new Lotto(numbers);
        lottos.add(lotto);
    }


    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    public String displayLottos() {
        StringBuilder lottos = new StringBuilder();
        for (Lotto lotto : this.lottos) {
            lottos.append(lotto.toString()).append(System.lineSeparator());
        }
        return lottos.toString();
    }
}
