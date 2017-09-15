package seu.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;

import java.awt.*;
import java.net.URL;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass()
                    .getResource("/view//MyScene.fxml"));
            primaryStage.setTitle("虚拟校园登陆");
            Scene Scene = new Scene(root, 600, 400);
            primaryStage.setScene(Scene);
            Scene.getStylesheets().add(
                    getClass().getResource("/view//login.css")
                            .toExternalForm());
            primaryStage.getIcons().add(new Image("/images/01.png"));
            primaryStage.setResizable(false);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        launch(args);
    }
}
