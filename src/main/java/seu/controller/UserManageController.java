package seu.controller;

import com.owlike.genson.Genson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    public String getAllTeacher() {
        return genson.serialize(teacherService.queryAllTeacher());
    }

    public String getAllAdmin() {
        return genson.serialize(adminService.queryAll());
    }
}
