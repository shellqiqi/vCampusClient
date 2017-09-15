package seu.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;


import javafx.event.ActionEvent;

/**
 * Created by Q on 2017/9/14.
 */
public class courseController {


    @FXML
    private TableView<studentSelectCourseTable> courseTable;

    @FXML
    private TableColumn<studentSelectCourseTable, String> courseName;
    @FXML
    private TableColumn<studentSelectCourseTable, String> choice;

    @FXML
    private TableColumn<studentSelectCourseTable, Integer> CourseID,Credit,period,teacherID;

    @FXML
    private TableView<studentCourseSelecTable> resultTable;

    @FXML
    private TableColumn<studentCourseSelecTable, String> CourseName;
    @FXML
    private TableColumn<studentCourseSelecTable, String> cancel;

    @FXML
    private TableColumn<studentCourseSelecTable, Integer> courseID,credit,Period,TeacherID,grades;



    private  ObservableList<studentCourseSelecTable> couLists;

    public ObservableList<studentSelectCourseTable> getCourseData() {

        studentSelectCourseTable stu1 = new studentSelectCourseTable("高等数学", 001, 5,64,233);
        studentSelectCourseTable stu2 = new studentSelectCourseTable("中等数学", 002, 5,64,332);
        studentSelectCourseTable stu3 = new studentSelectCourseTable("低等数学", 003, 5,64,323);


        ObservableList<studentSelectCourseTable> couLists = FXCollections.observableArrayList(stu1, stu2, stu3);
        return couLists;
    }



    public void showCourseTable(ObservableList<studentSelectCourseTable> couLists) {
        courseName.setCellValueFactory(new PropertyValueFactory<studentSelectCourseTable,String>("courseName"));

        CourseID.setCellValueFactory(new PropertyValueFactory<studentSelectCourseTable,Integer>("CourseID"));
        Credit.setCellValueFactory(new PropertyValueFactory<studentSelectCourseTable,Integer>("Credit"));
        period.setCellValueFactory(new PropertyValueFactory<studentSelectCourseTable,Integer>("period"));
        teacherID.setCellValueFactory(new PropertyValueFactory<studentSelectCourseTable,Integer>("teacherID"));

        choice.setCellValueFactory(new PropertyValueFactory<studentSelectCourseTable,String>("DUMMY"));

        Callback<TableColumn<studentSelectCourseTable, String>, TableCell<studentSelectCourseTable, String>> cellFactory
                = //
                new Callback<TableColumn<studentSelectCourseTable, String>, TableCell<studentSelectCourseTable, String>>() {
                    @Override
                    public TableCell call(final TableColumn<studentSelectCourseTable, String> param) {
                        final TableCell<studentSelectCourseTable, String> cell = new TableCell<studentSelectCourseTable, String>() {

                            final Button btn = new Button("确认选课");

                            @Override
                            public void updateItem(String item, boolean empty) {
                                super.updateItem(item, empty);
                                if (empty) {
                                    setGraphic(null);
                                    setText(null);
                                } else {
                                    btn.setOnAction(new EventHandler<ActionEvent>(){
                                        @Override
                                        public void handle(ActionEvent event) {
                                            System.out.println("Button clicked");
                                            btn.setDisable(true);

                                        }
                                    });

                                    //   studentCourseSelecTable person = getTableView().getItems().get(getIndex());
                                    setGraphic(btn);
                                    setText(null);
                                }
                            }
                        };
                        return cell;
                    }
                };

        choice.setCellFactory(cellFactory);

        courseTable.setItems(this.getCourseData());
    }
    public void selectCourse(Event event) {
        this.showCourseTable(this.getCourseData());
    }



    public ObservableList<studentCourseSelecTable> getCourseResultData() {

        studentCourseSelecTable stu1 = new studentCourseSelecTable("大学物理", 001, 5,64,233,100);
        studentCourseSelecTable stu2 = new studentCourseSelecTable("高等物理", 002, 5,64,332,95);
        studentCourseSelecTable stu3 = new studentCourseSelecTable("量子力学", 003, 5,64,323,0);


        couLists = FXCollections.observableArrayList(stu1, stu2, stu3);
        return couLists;
    }


    public void showCourseResultTable(ObservableList<studentCourseSelecTable> couLists) {
        CourseName.setCellValueFactory(new PropertyValueFactory<studentCourseSelecTable,String>("CourseName"));
        courseID.setCellValueFactory(new PropertyValueFactory<studentCourseSelecTable,Integer>("courseID"));
        credit.setCellValueFactory(new PropertyValueFactory<studentCourseSelecTable,Integer>("credit"));
        Period.setCellValueFactory(new PropertyValueFactory<studentCourseSelecTable,Integer>("Period"));
        TeacherID.setCellValueFactory(new PropertyValueFactory<studentCourseSelecTable,Integer>("TeacherID"));
        grades.setCellValueFactory(new PropertyValueFactory<studentCourseSelecTable,Integer>("grades"));

        cancel.setCellValueFactory(new PropertyValueFactory<studentCourseSelecTable,String>("DUMMY"));

        Callback<TableColumn<studentCourseSelecTable, String>, TableCell<studentCourseSelecTable, String>> cellFactory
                = //
                new Callback<TableColumn<studentCourseSelecTable, String>, TableCell<studentCourseSelecTable, String>>() {
                    @Override
                    public TableCell call(final TableColumn<studentCourseSelecTable, String> param) {
                        final TableCell<studentCourseSelecTable, String> cell = new TableCell<studentCourseSelecTable, String>() {

                            final Button btn = new Button("取消选课");

                            @Override
                            public void updateItem(String item, boolean empty) {
                                super.updateItem(item, empty);
                                if (empty) {
                                    setGraphic(null);
                                    setText(null);
                                } else {
                                    btn.setOnAction(new EventHandler<ActionEvent>(){
                                        @Override
                                        public void handle(ActionEvent event) {
                                            System.out.println("Button clicked");
                                            studentCourseSelecTable person = getTableView().getItems().get(getIndex());
                                            show(getIndex());
                                        }
                                    });

                                    //   studentCourseSelecTable person = getTableView().getItems().get(getIndex());
                                    setGraphic(btn);
                                    setText(null);
                                }
                            }
                        };
                        return cell;
                    }
                };

        cancel.setCellFactory(cellFactory);



        resultTable.setItems(this.getCourseResultData());
    }

    public void show(int a)
    {
        couLists.remove(a);
        resultTable.refresh();


    }

    public void courseResult(Event event) {this.showCourseResultTable(this.getCourseResultData());
    }
}
