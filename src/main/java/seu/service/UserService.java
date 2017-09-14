package seu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seu.dao.AdminDao;
import seu.dao.StudentDao;
import seu.dao.TeacherDao;
import seu.domain.Admin;
import seu.domain.Student;
import seu.domain.Teacher;

import java.util.List;
@Service
public class UserService {

    @Autowired
    private AdminDao adminDao;
    private StudentDao studentDao;
    private TeacherDao teacherDao;

    public void setAdminDao(AdminDao adminDao) {
        this.adminDao = adminDao;
    }

    public AdminDao getAdminDao() {
        return adminDao;
    }

    //管理员登录
     public boolean adminSignIn(int id, String password){

    }

    //学生登录
    public boolean studentSignIn(int id, String password){

    }

    //教师登录
    public boolean teacherSignIn(int id, String password){

    }

    //管理员注册
    public int addAdmin(Admin admin) {

    }

    public int addAdmin(int id, String password){

    }

    //学生注册
    public int addStudent(Student student){

    }

    public int addStudent(int id, String studentName, int classId, int dormitoryId, int balance, String password){

    }

    //教师注册
    public int addTeacher(Teacher teacher){

    }

    public int addTeacher(int id, String teacherName, int phoneNumber, String password){

    }

    //注销管理员账户
    public int deleteAdminById(int id){

    }

    //注销学生账户
    public int deleteStudentByStudentId(int id){

    }

    //注销老师账户
    public int deleteTeacherByTeacherId(int id){

    }

    //修改管理员密码
    public int changeAdminPasswordById(int id, String password){

    }

    //修改学生密码
    public int changeStudentPasswordByStudentId(int id, String password){

    }

    //修改教师密码
    public int changeTeacherPasswordByTeacherId(int id, String password){

    }

    //获取管理员信息
    public Admin getAdminById(int id){

    }

    public List<Admin> getAdmin(){

    }

    //获取学生信息
    public Student getStudentByStudentId(int id){

    }

    public List<Student> getStudent(){

    }

    //获取教师信息
    public Teacher getTeacherByTeacherId(int id){

    }

    public List<Teacher> getTeacher(){

    }
}
