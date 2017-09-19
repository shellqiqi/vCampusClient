package seu.controller;

import de.felixroske.jfxsupport.FXMLController;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker.State;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.StageStyle;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import seu.Main;

@FXMLController
public class MainController {

    private static boolean load = false;

    @FXML
    WebView webView;

    @Autowired
    private ApplicationContext context;

    public void load(MouseEvent mouseEvent) {
        if (!load) {
            load = true;
            WebEngine webEngine = webView.getEngine();
            webEngine.load(getClass().getResource("/seu/web/login.html").toExternalForm());
            webEngine.getLoadWorker().stateProperty().addListener((ObservableValue<? extends State> ov, State oldState, State newState) -> {
                if (newState == State.SUCCEEDED) {
                    JSObject win = (JSObject) webEngine.executeScript("window");
                    loadController(win);
                }
            });
        }
    }

    private void loadController(JSObject jsObject) {
        jsObject.setMember("mainController", context.getBean("mainController"));
        jsObject.setMember("loginController", context.getBean("loginController"));
    }
}
