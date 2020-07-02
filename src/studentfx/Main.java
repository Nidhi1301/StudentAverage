/*
 * Name - Nidhi Nidhi
 * Date - March 8, 2020
 */
package studentfx;

import content.Student;
import java.io.IOException;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    private final ArrayList<Student> studentList = new ArrayList<>();

    private final Label lblStudentId = new Label("Student Id:");
    private final TextField txtStudentId = new TextField();
    private final Label lbl = new Label("Average Scores Below -");
    private final Label lblJava = new Label("Java :");
    private final TextField txtJava = new TextField();
    private final Label lblData = new Label("Data Networking :");
    private final TextField txtData = new TextField();
    private final Label lblLinux = new Label("Linux :");
    private final TextField txtLinux = new TextField();
    private final Label lblWeb = new Label("Web-Programming :");
    private final TextField txtWeb = new TextField();
    private final Label lblMath = new Label("Maths :");
    private final TextField txtMath = new TextField();
    private final Button btnSaveFile = new Button("Save");
    private final Button btnAddStudent = new Button(" Add ");
    private final Button btnDisplayData = new Button("Display");

    @Override
    public void start(Stage primaryStage) {

        btnAddStudent.setOnAction((e) -> {
            addStudent();
        });
        btnDisplayData.setOnAction((e) -> {
            DisplayStage ds = new DisplayStage(studentList);
            ds.show();
        });
        btnSaveFile.setOnAction((e) -> {
            try {
                DisplayStage.setData("Student.dat", studentList);
                DisplayStage.getData("Student.dat");

            } catch (IOException ex) {
                System.out.println(e);
            }
        });

        Scene scene = new Scene(addPane(), 300, 250);
        primaryStage.setTitle("StudentFX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void addStudent() {
        int studentId = Integer.parseInt(txtStudentId.getText());
        double java = Double.parseDouble(txtJava.getText());
        double data = Double.parseDouble(txtData.getText());
        double web = Double.parseDouble(txtWeb.getText());
        double linux = Double.parseDouble(txtLinux.getText());
        double math = Double.parseDouble(txtMath.getText());

        Student one = new Student(studentId);
        one.setJava(java);
        one.setData(data);
        one.setWeb(web);
        one.setLinux(linux);
        one.setMath(math);

        studentList.add(one);
        txtStudentId.clear();
        txtJava.clear();
        txtData.clear();
        txtWeb.clear();
        txtLinux.clear();
        txtMath.clear();

    }

    private GridPane addPane() {

        GridPane pane = new GridPane();
        pane.add(lblStudentId, 0, 0);
        pane.add(txtStudentId, 1, 0);
        pane.add(lbl, 0, 3);
        pane.add(lblJava, 0, 4);
        pane.add(txtJava, 1, 4);
        pane.add(lblData, 0, 5);
        pane.add(txtData, 1, 5);
        pane.add(lblLinux, 0, 6);
        pane.add(txtLinux, 1, 6);
        pane.add(lblWeb, 0, 7);
        pane.add(txtWeb, 1, 7);
        pane.add(lblMath, 0, 8);
        pane.add(txtMath, 1, 8);
        pane.add(btnAddStudent, 0, 9);
        pane.add(btnDisplayData, 1, 9);
        pane.add(btnSaveFile, 0, 10);

        return pane;
    }

    public static void main(String[] args) {
        launch(args);
    }

}
