package seu.view;

/**
 * Created by Q on 2017/9/13.
 */
public class studentSelectCourseTable {

    private String CourseName;
    private int courseID;
    private int credit;
    private int period;
    private int teacherID;

    public studentSelectCourseTable(String courseName, int courseID, int credit, int period, int teacherID) {
        this.CourseName = courseName;
        this.courseID = courseID;
        this.credit = credit;
        this.period = period;
        this.teacherID = teacherID;
    }



    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String courseName) {
        this.CourseName = courseName;
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
}

