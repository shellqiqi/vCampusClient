package seu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import seu.service.AdminService;
import seu.service.StudentService;
import seu.service.TeacherService;

@Controller
public class LoginController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private AdminService adminService;

    public int login(String account, String password, int role) {
        try {
            MainController.account = Integer.parseInt(account);
            switch (role) {
                case 1:
                    MainController.role = 1;
                    return studentService.login(MainController.account, password);
                case 2:
                    MainController.role = 2;
                    return teacherService.login(MainController.account, password);
                case 3:
                    MainController.role = 3;
                    return adminService.login(MainController.account, password);
                default:
                    return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public void logout() {
        MainController.role = 0;
        MainController.account = 0;
    }
}
