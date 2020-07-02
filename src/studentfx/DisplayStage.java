/*
 *Name - Nidhi Nidhi
 * Date - March 8, 2020
 */
package studentfx;

import content.Student;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class DisplayStage extends Stage {

    private ArrayList<Student> studentList = new ArrayList<>();
    private double javattl;
    private double datattl;
    private double linuxttl;
    private double webttl;
    private double mathttl;
    private double studntTtl;
    private double javaAvg;
    private double webAvg;
    private double dataAvg;
    private double linuxAvg;
    private double mathAvg;
    private double stdntAvg;

    public DisplayStage(ArrayList<Student> studentList) {
        this.studentList = studentList;
//        this.studentList = studentList;
        setScene(addScene());
    }
    String average = new String();
    String elements = new String();

    TextArea txtDisplay = new TextArea();
    TextArea txtAverage = new TextArea();

    private Scene addScene() {

       for (int i = 0; i < studentList.size(); i++) {
            Student one = studentList.get(i);
            elements += (" Student With Id : " + one.getStudentId()
                    + " have the Scores Below :" + "\n" + "Score in java are : "
                    + one.getJava() + "\n" + "Score in Data are : "
                    + one.getData() + "\n" + "Score in Web are : " + one.getWeb()
                    + "\n" + "Score in Linux are : " + one.getLinux() + "\n"
                    + "Scores in Maths are : " + one.getMath() + "\n"
                    + "Overall Scores are : " + one.getOverallAvg() + "\n\n"
                    + "..............................................." + "\n");

        }

        for (int i = 0; i < studentList.size(); i++) {
            Student one = studentList.get(i);
            javattl += one.getJava();
            linuxttl += one.getLinux();
            webttl += one.getData();
            datattl += one.getData();
            mathttl += one.getMath();
            studntTtl += one.getOverallAvg();
        }

        javaAvg = javattl / (studentList.size());
        webAvg = linuxttl / (studentList.size());
        dataAvg = webttl / (studentList.size());
        linuxAvg = datattl / (studentList.size());
        mathAvg = mathttl / (studentList.size());
        stdntAvg = studntTtl / (studentList.size());

        average = ("java OverAll Average is " + javaAvg + "\n"
                + "Linux OverAll Average is " + linuxAvg + "\n"
                + "Web OverAll Average is " + webAvg + "\n"
                + "Data OverAll Average is " + dataAvg + "\n"
                + "Maths OverAll Average is " + mathAvg + "\n"
                + "Students OverAll Average is " + stdntAvg + "\n\n"
                + "..............................................." + "\n");

        txtDisplay.setText(elements);
        txtAverage.setText(average);

        Scene scene = new Scene(getGrid(), 460, 460);
        return scene;

    }

    private GridPane getGrid() {

        GridPane pane = new GridPane();
        pane.add(txtDisplay, 0, 0);
        pane.add(txtAverage, 0, 1);
        return pane;
    }

    public static void setData(String fileName, ArrayList<Student> studentList)
            throws IOException {

        FileWriter fw = new FileWriter(fileName);
        BufferedWriter bw = new BufferedWriter(fw);
        String data = new String();
        for (int i = 0; i < studentList.size(); i++) {
            Student one = studentList.get(i);

            data += (" Student With Id : " + one.getStudentId()
                    + " have the Scores Below :" + "\n" + "Score in java are : "
                    + one.getJava() + "\n" + "Score in Data are : "
                    + one.getData() + "\n" + "Score in Web are : " + one.getWeb()
                    + "\n" + "Score in Linux are : " + one.getLinux() + "\n"
                    + "Scores in Maths are : " + one.getMath() + "\n"
                    + "Overall Scores are : " + one.getOverallAvg() + "\n\n"
                    + "..............................................." + "\n");
            bw.write(data);
            bw.newLine();

        }

        bw.close();
        fw.close();
    }

    public static String getData(String fileName) throws IOException {
        String sData = new String();
        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();

        while (line != null) {
            sData += line + "/n";
        }
        return sData;
    }

}
