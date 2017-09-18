package seu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seu.domain.Teacher;
import seu.socket.Client;
import seu.socket.ClientRequest;

import java.util.List;

@Service
public class TeacherService {

    private Client client;

    @Autowired
    public void setClient(Client client) {
        this.client = client;
    }

    private String serviceName;

    public TeacherService() {
        serviceName = "teacherService";
    }


    public int login(int teacherId, String passwd) {
        return (int) client.send(new ClientRequest(serviceName, "login", new Class[]{int.class, String.class}, new Object[]{teacherId, passwd})).getData();
    }

    //TODO: 增加返回值
    public void logout() {
        client.send(new ClientRequest(serviceName, "logout"));
    }

    public int insertTeacher(Teacher teacher) {
        return (int) client.send(new ClientRequest(serviceName, "insertTeacher", new Class[]{Teacher.class}, new Object[]{teacher})).getData();
    }

    public int deleteTeacher(int teacherID) {
        return (int) client.send(new ClientRequest(serviceName, "deleteTeacher", new Class[]{int.class}, new Object[]{teacherID})).getData();
    }

    public int updateTeacherPassword(int teacherID, String passsword) {
        return (int) client.send(new ClientRequest(serviceName, "updateTeacherPassword", new Class[]{int.class, String.class}, new Object[]{teacherID, passsword})).getData();
    }

    public int updateTeacher(Teacher teacher) {
        return (int) client.send(new ClientRequest(serviceName, "updateTeacher", new Class[]{Teacher.class}, new Object[]{teacher})).getData();
    }

    public Teacher queryTeacherByTeacherId(int teahcerID) {
        return (Teacher) client.send(new ClientRequest(serviceName, "queryTeacherByTeacherId", new Class[]{int.class}, new Object[]{teahcerID})).getData();
    }

    public Teacher queryTeacherByClassId(int classID) {
        return (Teacher) client.send(new ClientRequest(serviceName, "queryTeacherByClassId", new Class[]{int.class}, new Object[]{classID})).getData();
    }

    public Teacher queryTeacherByCourseId(int courseID) {
        return (Teacher) client.send(new ClientRequest(serviceName, "queryTeacherByCourseId", new Class[]{int.class}, new Object[]{courseID})).getData();
    }

    public List<Teacher> queryAllTeacher() {
        return (List<Teacher>) client.send(new ClientRequest(serviceName, "queryAllTeacher")).getData();
    }
}
