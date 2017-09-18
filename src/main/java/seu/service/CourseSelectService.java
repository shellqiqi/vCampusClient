package seu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seu.domain.Course;
import seu.domain.CourseSelect;
import seu.socket.Client;
import seu.socket.ClientRequest;

import java.util.List;

@Service
public class CourseSelectService {

    private Client client;

    @Autowired
    public void setClient(Client client) {
        this.client = client;
    }

    private String serviceName;

    public CourseSelectService() {
        serviceName = "courseSelectService";
    }

    //学生添加选课
    public int insertCourseSelect(final int studentID, final int courseID) {
        return (int) client.send(new ClientRequest(serviceName, "insertCourseSelect", new Class[]{int.class, int.class}, new Object[]{studentID, courseID})).getData();
    }

    //学生删除所选课程
    public int deleteCourseSelectByCourseIDAndStudentID(int studentID, int courseID) {
        return (int) client.send(new ClientRequest(serviceName, "deleteCourseSelectByCourseIDAndStudentID", new Class[]{int.class, int.class}, new Object[]{studentID, courseID})).getData();
    }

    //学生更新选课信息
    public int updateGradeByCourseIDAndStudentID(int studentID, int courseID, int grade) {
        return (int) client.send(new ClientRequest(serviceName, "updateGradeByCourseIDAndStudentID", new Class[]{int.class, int.class, int.class}, new Object[]{studentID, courseID, grade})).getData();
    }

    //学生获取成绩
    public int queryGradeByCourseIDAndStudentID(int studentID, int courseID) {
        return (int) client.send(new ClientRequest(serviceName, "queryGradeByCourseIDAndStudentID", new Class[]{int.class, int.class}, new Object[]{studentID, courseID})).getData();
    }

    //学生获取学生的id，选课id，课程id和成绩
    public List<CourseSelect> getCourseSelectAll() {
        return (List<CourseSelect>) client.send(new ClientRequest(serviceName, "getCourseSelectAll")).getData();
    }

    //学生通过学生id查询课程
    public List<Course> queryCourseByStudentId(int studentID) {
        return (List<Course>) client.send(new ClientRequest(serviceName, "queryCourseByStudentId", new Class[]{int.class}, new Object[]{studentID})).getData();
    }

    //学生通过教师id查询课程
    public List<Course> queryCourseByTeacherID(int teacherID) {
        return (List<Course>) client.send(new ClientRequest(serviceName, "queryCourseByTeacherID", new Class[]{int.class}, new Object[]{teacherID})).getData();
    }

    //获取所有课程的全部信息
    public List<Course> getCourseAll() {
        return (List<Course>) client.send(new ClientRequest(serviceName, "getCourseAll")).getData();
    }
}
