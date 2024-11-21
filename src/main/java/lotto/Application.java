package lotto;

import lotto.config.AppConfig;
import lotto.controller.Controller;


public class Application {
    public static void main(String[] args) {
        AppConfig appconfig = new AppConfig();
        Controller controller = appconfig.getController();
        controller.run();

    }
}
