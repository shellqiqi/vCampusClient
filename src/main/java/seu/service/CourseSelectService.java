package seu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seu.dao.CourseDao;
import seu.dao.CourseSelectDao;
import seu.domain.Course;
import seu.domain.CourseSelect;

import java.util.List;
@Service
public class CourseSelectService {
    @Autowired
    CourseSelectDao courseSelectDao;
    @Autowired
    CourseDao courseDao;

    public CourseSelectDao getCourseSelect() {
        return courseSelectDao;
    }

    public void setCourseSelect(CourseSelectDao courseSelect) {
        this.courseSelectDao = courseSelect;
    }

    //学生添加选课
    public int insertCourseSelect(CourseSelect courseSelect) {

    }

    //学生删除所选课程
    public int deleteCourseSelectByCourseIDAndStudentID( int studentID ,  int courseID) {

    }

    //学生更新选课信息
    public int updateGradeByCourseIDAndStudentID( int studentID,  int courseID,  int grade) {

    }

    //学生获取成绩
    public int queryGradeByCourseIDAndStudentID(  int studentID,  int courseID) {

    }

    //学生获取学生的id，选课id，课程id和成绩
    public List<CourseSelect> getCourseSelectAll() {

    }

    //学生通过学生id查询课程
    public List<Course> queryCourseByStudentId(int id) {

    }

    //学生通过教师id查询课程
    public List<Course> queryCourseByTeacherID(int id) {

    }

    //获取所有课程的全部信息
    public List<Course> getCourseAll() {

   }
}
