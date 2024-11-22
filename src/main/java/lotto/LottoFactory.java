package lotto;

public class LottoFactory {
    public static LottoController lottoController() {
        return new LottoController(inputHandler(), lottoService(), outputView());
    }

    private static LottoService lottoService() {
        return new LottoService(lottoGenerator());
    }

    private static LottoGenerator lottoGenerator() {
        return new LottoGenerator();
    }

    private static InputHandler inputHandler() {
        return new InputHandler(inputView());
    }

    private static InputView inputView() {
        return new InputView();
    }

    private static OutputView outputView() {
        return new OutputView();
    }
}
