package seu.service;

import org.springframework.stereotype.Service;
import seu.domain.Student;

import java.util.List;
@Service
public class SchoolRollService {

    //添加学生信息
    public int addSchoolRoll(Student student){
return 0;
    }

    public int addStudentRoll(int studentId, String studentName, int classId, int dormitoryId, int balance, String password){
return 0;
    }

    //删除学生学籍信息
    public int deleteSchoolRollById(int id){
return 0;
    }

    //更改信息
    public int changeStudentNameByStudentId(int id, String name){
return 0;
    }

    public int changeClassIdByStudentId(int studentId, int classId){
return 0;
    }

    public int changeDormitoryIdByStudentId(int studentId, int dormitoryId){
return 0;
    }

    public int changeBalanceByStudentId(int studentId, int balance){
return 0;
    }

    public int changePasswordByStudentId(int studentId, String password){
return 0;
    }

    //获取学生信息
    public Student getStudentRollByStudentId(int studentId){
return null;
    }

    public List<Student> getStudentRollByClassId(int classId){
return null;
    }

    public List<Student> getStudentRollByCourseId(int courseId){
return null;
    }

    public Student getStudentRollByBookId(int bookId){
return null;
    }

    public List<Student> getStudentByDormitoryId(int dormitoryId){
return null;
    }

    public List<Student> getSchoolRollAll(){
return null;
    }
}
