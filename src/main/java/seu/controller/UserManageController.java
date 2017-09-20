package seu.controller;

import com.owlike.genson.Genson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import seu.Main;
import seu.domain.Admin;
import seu.domain.Student;
import seu.domain.Teacher;
import seu.service.AdminService;
import seu.service.StudentService;
import seu.service.TeacherService;

@Controller
public class UserManageController {

    @Autowired
    StudentService studentService;
    @Autowired
    TeacherService teacherService;
    @Autowired
    AdminService adminService;

    private Genson genson = new Genson();

    public String getAllStudent() {
        return genson.serialize(studentService.queryAllStudent());
    }
    
    public int addStudent(int studentId, String studentName, int classId, int dormitoryId, int balance, String password) {
        return studentService.insertStudent(new Student(studentId, studentName, classId, dormitoryId, balance, password));
    }

    public int deleteStudent(int studentId) {
        return studentService.deleteStudent(studentId);
    }

    public int updateStudent(int studentId, String studentName, int classId, int dormitoryId, int balance, String password) {
        return studentService.updateStudent(new Student(studentId, studentName, classId, dormitoryId, balance, password));
    }

    public String getAllTeacher() {
        return genson.serialize(teacherService.queryAllTeacher());
    }
    
    public int addTeacher(int teacherId, String teacherName, int teacherPhoneNumber, String password) {
        return teacherService.insertTeacher(new Teacher(teacherId, teacherName, teacherPhoneNumber, password));
    }

    public int deleteTeacher(int teacherId) {
        return teacherService.deleteTeacher(teacherId);
    }

    public int updateTeacher(int teacherId, String teacherName, int teacherPhoneNumber, String password) {
        return teacherService.updateTeacher(new Teacher(teacherId, teacherName, teacherPhoneNumber, password));
    }

    public String getAllAdmin() {
        return genson.serialize(adminService.queryAll());
    }

    public int addAdmin(int adminId, String password) {
        if (MainController.account != 1)
            return 0;
        return adminService.insertAdmin(new Admin(adminId, password));
    }

    public int deleteAdmin(int adminId) {
        if (MainController.account == adminId || MainController.account != 1)
            return 0;
        return adminService.deleteAdmin(adminId);
    }

    public int updateAdmin(int adminId, String password) {
        if (MainController.account == adminId || MainController.account == 1)
            return adminService.updateAdmin(new Admin(adminId, password));
        return 0;
    }
}
