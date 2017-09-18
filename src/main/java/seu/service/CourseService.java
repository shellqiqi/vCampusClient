package seu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seu.domain.Course;
import seu.socket.Client;
import seu.socket.ClientRequest;

import java.util.List;

@Service
public class CourseService {

    private Client client;

    @Autowired
    public void setClient(Client client) {
        this.client = client;
    }

    private String serviceName;

    public CourseService() {
        serviceName = "courseService";
    }


    public int insertCourse(Course course) {
        return (int) client.send(new ClientRequest(serviceName, "insertCourse", new Class[]{Course.class}, new Object[]{course})).getData();
    }

    public int deleteCourse(int courseID) {
        return (int) client.send(new ClientRequest(serviceName, "deleteCourse", new Class[]{int.class}, new Object[]{courseID})).getData();
    }

    public int updateCourse(Course course) {
        return (int) client.send(new ClientRequest(serviceName, "updateCourse", new Class[]{Course.class}, new Object[]{course})).getData();
    }

    public Course queryCourseByCourseId(int courseID) {
        return (Course) client.send(new ClientRequest(serviceName, "queryCourseByCourseId", new Class[]{int.class}, new Object[]{courseID})).getData();
    }

    public List<Course> queryCourseByStudentId(int studentID) {
        return (List<Course>) client.send(new ClientRequest(serviceName, "queryCourseByStudentId", new Class[]{int.class}, new Object[]{studentID})).getData();
    }

    public List<Course> queryCourseByTeacherId(int teacherID) {
        return (List<Course>) client.send(new ClientRequest(serviceName, "queryCourseByTeacherId", new Class[]{int.class}, new Object[]{teacherID})).getData();
    }

    public List<Course> queryAll() {
        return (List<Course>) client.send(new ClientRequest(serviceName, "queryAll")).getData();
    }
}
