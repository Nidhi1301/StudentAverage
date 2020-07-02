/*
 * Name - Nidhi Nidhi
 * Date - March 8, 2020
 */

package content;
import java.util.ArrayList;

public class Student {

    private final int studentId;
    private double java;
    private double data;
    private double linux;
    private double web;
    private double math;
    private double overallAvg;
    private double average;
   
    private final ArrayList<Student> studentList = new ArrayList<>();

    public Student(int studentId) {
        this.studentId = studentId;
    }

    public int getStudentId() {
        return studentId;
    }

    public double getJava() {
        return java;
    }

    public void setJava(double java) {
        this.java = java;
    }

    public double getData() {
        return data;
    }

    public void setData(double data) {
        this.data = data;
    }

    public double getLinux() {
        return linux;
    }

    public void setLinux(double linux) {
        this.linux = linux;
    }

    public double getWeb() {
        return web;
    }

    public void setWeb(double web) {
        this.web = web;
    }

    public double getMath() {
        return math;
    }

    public void setMath(double math) {
        this.math = math;
    }

    public double getOverallAvg() {
        calculateOverallAvg();
        return overallAvg;
    }

    private void calculateOverallAvg() {
        this.overallAvg = (this.java + this.data
                + this.linux + this.web + this.math) / 5;

    }
}