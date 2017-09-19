package seu.controller;

import de.felixroske.jfxsupport.FXMLController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.web.WebView;
import netscape.javascript.JSObject;

@FXMLController
public class MainController {

    @FXML
    WebView webView;

    public void buttonClick1(ActionEvent actionEvent) {
        webView.getEngine().load(getClass().getResource("/index.html").toExternalForm());
        JSObject win = (JSObject) webView.getEngine().executeScript("window");
        win.setMember("app", new MainController());
    }

    public String sout(String s) {
        System.out.println(s);
        return s + s;
    }

    public void buttonClick2(ActionEvent actionEvent) {
        webView.getEngine().load("https://getbootstrap.com/docs/4.0/examples/dashboard/");
    }
}
