package seu.controller;

import com.owlike.genson.Genson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import seu.domain.Course;
import seu.service.CourseSelectService;
import seu.service.CourseService;
import seu.service.StudentService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CourseController {

    @Autowired
    CourseSelectService courseSelectService;
    @Autowired
    CourseService courseService;
    @Autowired
    StudentService studentService;

    private Genson genson = new Genson();

    public String getAllCourse() {
        return genson.serialize(courseService.queryAll());
    }

    public String getAllCourseSelect() {
        return genson.serialize(courseSelectService.getCourseSelectAll());
    }

    public String getCourse(int id) {
        return genson.serialize(courseService.queryCourseByCourseId(id));
    }

    public String getStudent(int id) {
        return genson.serialize(studentService.queryStudentByStudentId(id));
    }

    public String getSelectedCourse() {
        return genson.serialize(courseService.queryCourseByStudentId(MainController.account));
    }

    public String getNoSelectedCourse() {
        List<Course> all = courseService.queryAll();
        List<Course> selected = courseService.queryCourseByStudentId(MainController.account);
        List<Course> noSelected = new ArrayList<Course>();
        for (int i = 0; i < all.size(); i++) {
            boolean contain = false;
            for (int j = 0; j < selected.size(); j++) {
                if (all.get(i).getCourseId() == selected.get(j).getCourseId()) {
                    contain = true;
                }
            }
            if (!contain)
                noSelected.add(all.get(i));
        }
        return genson.serialize(noSelected);
    }

    public int addCourseSelect(int id) {
        return courseSelectService.insertCourseSelect(MainController.account, id);
    }

    public int deleteCourseSelect(int id) {
        return courseSelectService.deleteCourseSelectByCourseIDAndStudentID(MainController.account, id);
    }

    public String getAllCourseByTeacherId() {
        return genson.serialize(courseService.queryCourseByTeacherId(MainController.account));
    }

    public String getStudentByCourseId(int id) {
        return genson.serialize(studentService.queryStudentByCourseId(id));
    }

    public int teacherDelectCourseSelect(int studentId, int courseId) {
        return courseSelectService.deleteCourseSelectByCourseIDAndStudentID(studentId, courseId);
    }

    public int deleteCourseById(int id) {
        return courseService.deleteCourse(id);
    }

    public int addCourse(int courseId, String courseName, int credit, int period, int teacherId) {
        return courseService.insertCourse(new Course(courseId, courseName, credit, period, teacherId));
    }
}
