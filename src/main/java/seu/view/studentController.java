package seu.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

import static com.sun.org.apache.xerces.internal.utils.SecuritySupport.getResourceAsStream;

/**
 * Created by Q on 2017/9/9.
 */

public class studentController {

    @FXML
    private AnchorPane changeView;
    @FXML
    private Button schoolroll;

    @FXML
    private Button Course;

    @FXML
    private Button Library;

    @FXML
    private Button dormitory;

    @FXML
    private Button commodity;

    public studentController() throws IOException {
        ImageView delICON = new ImageView(getClass().getResource("/images/information.png").toString());
        /*schoolroll.setGraphic(deICON);*/

    }

    public void showSchoolrollInfo(ActionEvent actionEvent) throws IOException {
        changeView.getChildren().clear();
        Parent child = FXMLLoader.load(getClass().getResource("/view//schoolrollPane.fxml"));
        changeView.getChildren().add(child);

    }



    public void showLibraryInfo(ActionEvent actionEvent) throws IOException {
        changeView.getChildren().clear();
        Parent child = FXMLLoader.load(getClass().getResource("/view//totalLibrary.fxml"));
        changeView.getChildren().add(child);

    }
    

    public void showDormitoryInfo(ActionEvent actionEvent) throws IOException {
        changeView.getChildren().clear();
        Parent child = FXMLLoader.load(getClass().getResource("/view//dormitoryPane.fxml"));


        changeView.getChildren().add(child);

    }

    public void showCourseInfo(ActionEvent actionEvent) throws IOException {
        changeView.getChildren().clear();
        Parent child = FXMLLoader.load(getClass().getResource("/view//course.fxml"));
        changeView.getChildren().add(child);


    }

    public void showCommodityInfo(ActionEvent actionEvent) throws IOException {
        changeView.getChildren().clear();
        Parent child = FXMLLoader.load(getClass().getResource("/view//commodityPane.fxml"));
        changeView.getChildren().add(child);


    }

    public void courseSelectResult(ActionEvent actionEvent) throws IOException {

        changeView.getChildren().clear();
        Parent child = FXMLLoader.load(getClass().getResource("/view//courseSelectResultPane.fxml"));
        changeView.getChildren().add(child);


    }


    public void exit(ActionEvent actionEvent) throws IOException {
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass()
                .getResource("/view//MyScene.fxml"));
        Stage stg = new Stage();
      stg.setTitle("虚拟校园登陆");
        Scene Scene = new Scene(root, 600, 400);
       stg.setScene(Scene);
        Scene.getStylesheets().add(
                getClass().getResource("/view//login.css")
                        .toExternalForm());
      stg.getIcons().add(new Image("/images/01.png"));
       stg.setResizable(false);
       stg.show();

    }
}
