package seu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seu.domain.Student;
import seu.socket.Client;
import seu.socket.ClientRequest;

import java.util.List;

@Service
public class StudentService {

    private Client client;

    @Autowired
    public void setClient(Client client) {
        this.client = client;
    }

    private String serviceName;

    public StudentService() {
        serviceName = "studentService";
    }

    public int login(int studentId, String passwd) {
        return (int) client.send(new ClientRequest(serviceName, "login", new Class[]{int.class, String.class}, new Object[]{studentId, passwd})).getData();
    }

    public String logout() {
        return (String) client.send(new ClientRequest(serviceName, "logout")).getData();
    }

    public int insertStudent(Student student) {
        return (int) client.send(new ClientRequest(serviceName, "insertStudent", new Class[]{Student.class}, new Object[]{student})).getData();
    }

    public int deleteStudent(int studentId) {
        return (int) client.send(new ClientRequest(serviceName, "deleteStudent", new Class[]{int.class}, new Object[]{studentId})).getData();
    }

    public int updateStudentPassword(int studentID, String passwd) {
        return (int) client.send(new ClientRequest(serviceName, "updateStudentPassword", new Class[]{int.class, String.class}, new Object[]{studentID, passwd})).getData();
    }

    public int updateStudent(Student student) {
        return (int) client.send(new ClientRequest(serviceName, "updateStudent", new Class[]{Student.class}, new Object[]{student})).getData();
    }

    public Student queryStudentByStudentId(int id) {
        return (Student) client.send(new ClientRequest(serviceName, "queryStudentByStudentId", new Class[]{int.class}, new Object[]{id})).getData();
    }

    public List<Student> queryStudentByClassId(int classID) {
        return (List<Student>) client.send(new ClientRequest(serviceName, "queryStudentByClassId", new Class[]{int.class}, new Object[]{classID})).getData();
    }

    public List<Student> queryStudentByDormitoryId(int dormitoryID) {
        return (List<Student>) client.send(new ClientRequest(serviceName, "queryStudentByDormitoryId", new Class[]{int.class}, new Object[]{dormitoryID})).getData();
    }

    public List<Student> queryStudentByCourseId(int courseID) {
        return (List<Student>) client.send(new ClientRequest(serviceName, "queryStudentByCourseId", new Class[]{int.class}, new Object[]{courseID})).getData();
    }

    public Student queryStudentByBookId(int bookID) {
        return (Student) client.send(new ClientRequest(serviceName, "queryStudentByBookId", new Class[]{int.class}, new Object[]{bookID})).getData();
    }

    public List<Student> queryAllStudent() {
        return (List<Student>) client.send(new ClientRequest(serviceName, "queryAllStudent")).getData();
    }
}
