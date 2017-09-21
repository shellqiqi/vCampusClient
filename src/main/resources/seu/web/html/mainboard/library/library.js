var role = mainController.getRole();
$(document).ready(function () {
    if (role === 1) {
        $('#libraryBoard').load('library/student/student.html');
    } else if (role === 3) {
        $('#libraryBoard').load('library/admin/admin.html');
    }
});
