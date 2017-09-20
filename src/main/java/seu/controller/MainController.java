package seu.controller;

import de.felixroske.jfxsupport.FXMLController;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.concurrent.Worker.State;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.util.Set;

@FXMLController
public class MainController {

    private static boolean load = false;
    public static int role = 0;
    public static int account = 0;

    @FXML
    WebView webView;

    @Autowired
    private ApplicationContext context;

    public void load(MouseEvent mouseEvent) {
        if (!load) {
            load = true;
            WebEngine webEngine = webView.getEngine();
            webEngine.load(getClass().getResource("/seu/web/html/login/login.html").toExternalForm());
            webEngine.getLoadWorker().stateProperty().addListener((ObservableValue<? extends State> ov, State oldState, State newState) -> {
                if (newState == State.SUCCEEDED) {
                    JSObject win = (JSObject) webEngine.executeScript("window");
                    loadController(win);
                }
            });
            webView.getChildrenUnmodifiable().addListener((ListChangeListener<Node>) change -> {
                Set<Node> deadSeaScrolls = webView.lookupAll(".scroll-bar");
                for (Node scroll : deadSeaScrolls) {
                    scroll.setVisible(false);
                }
            });
        }
    }

    private void loadController(JSObject jsObject) {
        jsObject.setMember("mainController", context.getBean("mainController"));
        jsObject.setMember("loginController", context.getBean("loginController"));
        jsObject.setMember("userManageController", context.getBean("userManageController"));
        jsObject.setMember("studentRollController", context.getBean("studentRollController"));
        jsObject.setMember("courseController", context.getBean("courseController"));
        jsObject.setMember("libraryController", context.getBean("libraryController"));
        jsObject.setMember("shopController", context.getBean("shopController"));
    }
}
