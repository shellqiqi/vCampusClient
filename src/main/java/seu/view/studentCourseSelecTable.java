package seu.view;

/**
 * Created by Q on 2017/9/13.
 */
public class studentCourseSelecTable {
    private String courseName;
    private int courseID,credit,period,teacherID,grades;

    public studentCourseSelecTable(String courseName, int courseID, int credit, int period, int teacherID, int grades) {
        this.courseName = courseName;
        this.courseID = courseID;
        this.credit = credit;
        this.period = period;
        this.teacherID = teacherID;
        this.grades = grades;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public int getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(int teacherID) {
        this.teacherID = teacherID;
    }

    public int getGrades() {
        return grades;
    }

    public void setGrades(int grades) {
        this.grades = grades;
    }
}
