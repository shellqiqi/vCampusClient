var role = mainController.getRole();
$(document).ready(function () {
    if (role === 1) {
        $('#shopBoard').load('shop/student/student.html');
    } else if (role === 3) {
        $('#shopBoard').load('shop/admin/admin.html');
    }
});
