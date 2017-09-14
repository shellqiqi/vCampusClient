package seu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seu.dao.StudentDao;
import seu.domain.Student;

import java.util.List;
@Service
public class SchoolRollService {
    @Autowired
    StudentDao studentDao;

    public StudentDao getStudentDao() {
        return studentDao;
    }

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    //添加学生信息
    public int addSchoolRoll(Student student){

    }

    public int addStudentRoll(int studentId, String studentName, int classId, int dormitoryId, int balance, String password){

    }

    //删除学生学籍信息
    public int deleteSchoolRollById(int id){

    }

    //更改信息
    public int changeStudentNameByStudentId(int id, String name){

    }

    public int changeClassIdByStudentId(int studentId, int classId){

    }

    public int changeDormitoryIdByStudentId(int studentId, int dormitoryId){

    }

    public int changeBalanceByStudentId(int studentId, int balance){

    }

    public int changePasswordByStudentId(int studentId, String password){

    }

    //获取学生信息
    public Student getStudentRollByStudentId(int studentId){

    }

    public List<Student> getStudentRollByClassId(int classId){

    }

    public List<Student> getStudentRollByCourseId(int courseId){

    }

    public Student getStudentRollByBookId(int bookId){

    }

    public List<Student> getStudentByDormitoryId(int dormitoryId){

    }

    public List<Student> getSchoolRollAll(){

    }
}
