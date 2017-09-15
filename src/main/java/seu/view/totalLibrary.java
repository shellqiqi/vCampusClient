package seu.view;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Callback;


import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Q on 2017/9/14.
 */
public class totalLibrary {

    @FXML
    private TableView<studentLibraryTable> studentBookTable;

    @FXML
    private TableColumn<studentLibraryTable, String> bookName, startDate, returnBook;

    @FXML
    private TableColumn<studentLibraryTable, Integer> bookID;


    private ObservableList<studentLibraryTable> bookLists;

    /*public void initialize(URL location, ResourceBundle resources) {
        this.showBooksTable(this.getBooksData());
    }*/


    public ObservableList<studentLibraryTable> getBooksData() {

        studentLibraryTable stu1 = new studentLibraryTable("上学记", 001, "2017.09.01");
        studentLibraryTable stu2 = new studentLibraryTable("拿破仑传", 002, "2017.09.02");
        studentLibraryTable stu3 = new studentLibraryTable("李鸿章传", 003, "2017.09.03");


        bookLists = FXCollections.observableArrayList(stu1, stu2, stu3);
        return bookLists;
    }


    public void showBooksTable(ObservableList<studentLibraryTable> bookLists) {
        bookName.setCellValueFactory(new PropertyValueFactory<studentLibraryTable, String>("bookName"));
        bookID.setCellValueFactory(new PropertyValueFactory<studentLibraryTable, Integer>("bookID"));
        startDate.setCellValueFactory(new PropertyValueFactory<studentLibraryTable, String>("startDate"));


        returnBook.setCellValueFactory(new PropertyValueFactory<studentLibraryTable, String>("DUMMY"));

        Callback<TableColumn<studentLibraryTable, String>, TableCell<studentLibraryTable, String>> cellFactory
                = //
                new Callback<TableColumn<studentLibraryTable, String>, TableCell<studentLibraryTable, String>>() {
                    @Override
                    public TableCell call(final TableColumn<studentLibraryTable, String> param) {
                        final TableCell<studentLibraryTable, String> cell = new TableCell<studentLibraryTable, String>() {

                            final Button btn = new Button("确认还书");

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
                                            show(getIndex());
                                        }
                                    });

                                    setGraphic(btn);
                                    setText(null);
                                }
                            }
                        };
                        return cell;
                    }
                };



        returnBook.setCellFactory(cellFactory);






        studentBookTable.setItems(this.getBooksData());
    }

    public void show(int a) {
        bookLists.remove(a);
        studentBookTable.refresh();

    }

    ;

    public void searchBooks(ActionEvent actionEvent) {
    }

    public void returnTab(Event event) {
        this.showBooksTable(this.getBooksData());
    }




}



