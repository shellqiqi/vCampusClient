var role = mainController.getRole();
$(document).ready(function () {
    if (role === 1) {
        $('#courseBoard').load('course/student/student.html');
    } else if (role === 2) {
        $('#courseBoard').load('course/teacher/teacher.html');
    } else if (role === 3) {
        $('#courseBoard').load('course/admin/admin.html');
    }
});
