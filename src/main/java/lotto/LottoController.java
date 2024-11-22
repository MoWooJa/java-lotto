package lotto;

public class LottoController {
    private final InputHandler inputHandler;
    private final LottoService lottoService;
    private final OutputView outputView;

    public LottoController(InputHandler inputHandler, LottoService lottoService, OutputView outputView) {
        this.inputHandler = inputHandler;
        this.lottoService = lottoService;
        this.outputView = outputView;
    }

    public void run() {
        Purchase purchase = inputHandler.purchaseLotto();
        Lotto lotto = inputHandler.askLottoNumber();
        WinLotto winLotto = inputHandler.askBonusNumber(lotto);
        // 로또 발행 및 출력
        Lottos publishedLotto = lottoService.publish(purchase.getQuantity());
        outputView.printPublishedLotto(purchase, publishedLotto);

    }
}
