package seu.controller;

import de.felixroske.jfxsupport.FXMLController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebView;

@FXMLController
public class MainController {

    @FXML
    private WebView mainWebView;

    @FXML
    private Button testButton;

    public void test(ActionEvent event) {
        mainWebView.getEngine().load("https://www.baidu.com");
    }
}
