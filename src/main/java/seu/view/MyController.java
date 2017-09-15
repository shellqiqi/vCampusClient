package seu.view;

/**
 * Created by Q on 2017/9/9.
 */


import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.Event;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;


import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.image.Image;

public class MyController implements Initializable
    {

        @FXML
        private Button signIn;
        @FXML
        private Button signOut;

        @FXML
        private TextField password;
        @FXML
        private TextField accountNumber;

        @FXML
        private RadioButton student;
        @FXML
        private RadioButton admin;
        @FXML
        private RadioButton teacher;

        private ToggleGroup group= new ToggleGroup();


        @Override
        public void initialize(URL location, ResourceBundle resources) {

            // TODO (don't really need to do anything here).
            student.setToggleGroup(group);
            student.setSelected(true);
            teacher.setToggleGroup(group);
            admin.setToggleGroup(group);
        }



        public void signIn(Event event )
        {
            ((Node)(event.getSource())).getScene().getWindow().hide();
            System.out.println("Button Clicked!");
                    if(group.getSelectedToggle()==student)
                    {
                        System.out.println("student");
                        try {
                            Parent target = (Parent)FXMLLoader.load(getClass().getResource("/view//studentScene.fxml"));
                    //载入窗口B的定义文件；<span style="white-space:pre"> </span>
                            Scene scene = new Scene(target); //创建场景；
                            Stage stg = new Stage();//创建舞台；
                            stg.setTitle("学生服务界面");
                            stg.setScene(scene); //将场景载入舞台；
                            scene.getStylesheets().add(
                                    getClass().getResource("/view//Student.css")
                                            .toExternalForm());
                            stg.setResizable(false);
                            stg.show(); //显示窗口；

                            /*;

                            AnchorPane contain = (AnchorPane) father.lookup("#container");*/
                        }

                        catch(Exception e) {
                            e.printStackTrace();
                        }
                    }

                    if(group.getSelectedToggle()==teacher)
                    {
                        ((Node)(event.getSource())).getScene().getWindow().hide();
                        System.out.println("teacher");
                        try {
                            Parent target = FXMLLoader.load(getClass().getResource("/view//teacherScene.fxml"));//载入窗口B的定义文件；<span style="white-space:pre"> </span>

                            Scene scene = new Scene(target); //创建场景；
                            Stage stg = new Stage();//创建舞台；
                            scene.getStylesheets().add(
                                    getClass().getResource("/view//login.css")
                                            .toExternalForm());
                            stg.setTitle("教师服务界面");
                            stg.setScene(scene); //将场景载入舞台；
                            stg.setResizable(false);
                            stg.show(); //显示窗口；
                        }

                        catch(Exception e) {
                            e.printStackTrace();
                        }
                    }

                    if(group.getSelectedToggle()==admin)
                    {
                        ((Node)(event.getSource())).getScene().getWindow().hide();
                        System.out.println("admin");
                        try {
                            Parent target = FXMLLoader.load(getClass().getResource("/view//admin.fxml"));//载入窗口B的定义文件；<span style="white-space:pre"> </span>
                            Scene scene = new Scene(target); //创建场景；
                            Stage stg = new Stage();//创建舞台；
                            scene.getStylesheets().add(
                                    getClass().getResource("/view//login.css")
                                            .toExternalForm());
                            stg.setTitle("管理员管理界面");
                            stg.setScene(scene); //将场景载入舞台；
                            stg.setResizable(false);
                            stg.show(); //显示窗口；
                        }

                        catch(Exception e) {
                            e.printStackTrace();
                        }
                    }

        }

        public void signOut(ActionEvent event )
        {
            System.out.println("Button Clicked!");
            System.exit(0);
        }


        public void accountNumber()
        {

        }

        public void password()
        {

        }



    }

