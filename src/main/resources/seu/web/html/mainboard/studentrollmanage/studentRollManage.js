var role = mainController.getRole();
$(document).ready(function () {
    if (role === 1) {
        $('#studentRollBoard').load('studentrollmanage/student/student.html');
    } else if (role === 2) {
        $('#studentRollBoard').load('studentrollmanage/teacher/teacher.html');
    }
});
