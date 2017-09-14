package seu.service;

import org.springframework.stereotype.Service;
import seu.domain.Admin;
import seu.domain.Student;
import seu.domain.Teacher;

import java.util.List;
@Service
public class UserService {

    //管理员登录
     public boolean adminSignIn(int id, String password){
        return false;
    }

    //学生登录
    public boolean studentSignIn(int id, String password){
        return false;
    }

    //教师登录
    public boolean teacherSignIn(int id, String password){
        return false;
    }

    //管理员注册
    public int addAdmin(Admin admin) {
        return 0;
    }

    public int addAdmin(int id, String password){
        return 0;
    }

    //学生注册
    public int addStudent(Student student){
        return 0;
    }

    public int addStudent(int id, String studentName, int classId, int dormitoryId, int balance, String password){
        return 0;
    }

    //教师注册
    public int addTeacher(Teacher teacher){
        return 0;
    }

    public int addTeacher(int id, String teacherName, int phoneNumber, String password){
        return 0;
    }

    //注销管理员账户
    public int deleteAdminById(int id){
        return 0;
    }

    //注销学生账户
    public int deleteStudentByStudentId(int id){
        return 0;
    }

    //注销老师账户
    public int deleteTeacherByTeacherId(int id){
        return 0;
    }

    //修改管理员密码
    public int changeAdminPasswordById(int id, String password){
        return 0;
    }

    //修改学生密码
    public int changeStudentPasswordByStudentId(int id, String password){
        return 0;
    }

    //修改教师密码
    public int changeTeacherPasswordByTeacherId(int id, String password){
        return 0;
    }

    //获取管理员信息
    public Admin getAdminById(int id){
        return null;
    }

    public List<Admin> getAdmin(){
        return null;
    }

    //获取学生信息
    public Student getStudentByStudentId(int id){
        return null;
    }

    public List<Student> getStudent(){
        return null;
    }

    //获取教师信息
    public Teacher getTeacherByTeacherId(int id){
        return null;
    }

    public List<Teacher> getTeacher(){
        return null;
    }
}
