package seu.view;

/**
 * Created by Q on 2017/9/13.
 */
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
public class teacherSceneController {
    @FXML
    private AnchorPane teacherView;

    public void showTeacherInfo(ActionEvent actionEvent) throws IOException {
       teacherView.getChildren().clear();
        Parent child = FXMLLoader.load(getClass().getResource("/view//teacherInfoPane.fxml"));
        teacherView.getChildren().add(child);
    }

    public void classManage(ActionEvent actionEvent) throws IOException {
        teacherView.getChildren().clear();
        Parent child = FXMLLoader.load(getClass().getResource("/view//classManagePane.fxml"));
        teacherView.getChildren().add(child);
    }

    public void CourseManage(ActionEvent actionEvent) throws IOException {
        teacherView.getChildren().clear();
        Parent child = FXMLLoader.load(getClass().getResource("/view//courseManagePane.fxml"));
        teacherView.getChildren().add(child);
    }
}
