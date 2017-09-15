package seu.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class Controller {
    @FXML
    private AnchorPane adminView;


    public void showStudentManage(ActionEvent actionEvent) throws IOException {
        adminView.getChildren().clear();
        Parent child = FXMLLoader.load(getClass().getResource("/view//StudentManage.fxml"));
        adminView.getChildren().add(child);

    }

    public void showTeacherManage(ActionEvent actionEvent) throws IOException {
        adminView.getChildren().clear();
        Parent child = FXMLLoader.load(getClass().getResource("/view//TeacherManage.fxml"));
        adminView.getChildren().add(child);
    }

    public void showLibraryManage(ActionEvent actionEvent) throws IOException {
        adminView.getChildren().clear();
        Parent child = FXMLLoader.load(getClass().getResource("/view//LibraryManage.fxml"));
        adminView.getChildren().add(child);
    }

    public void showDormitoryManage(ActionEvent actionEvent) throws IOException {
        adminView.getChildren().clear();
        Parent child = FXMLLoader.load(getClass().getResource("/view//DormitoryManage.fxml"));
        adminView.getChildren().add(child);

    }

    public void showShopManage(ActionEvent actionEvent) throws IOException {
        adminView.getChildren().clear();
        Parent child = FXMLLoader.load(getClass().getResource("/view//ShopManage.fxml"));
        adminView.getChildren().add(child);

    }

}