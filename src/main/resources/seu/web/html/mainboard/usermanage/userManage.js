$(document).ready(function () {
    $('#user-manage-board').load('usermanage/student/userStudentManage.html');
});

$('#userStudentManage').click(function () {
    removeUserManageNavActive();
    $('#user-manage-board').load('usermanage/student/userStudentManage.html');
    $('#userStudentManage').addClass('active');
});

$('#userTeacherManage').click(function () {
    removeUserManageNavActive();
    $('#user-manage-board').load('usermanage/teacher/userTeacherManage.html');
    $('#userTeacherManage').addClass('active');
});

$('#userAdminManage').click(function () {
    removeUserManageNavActive();
    $('#user-manage-board').load('usermanage/admin/userAdminManage.html');
    $('#userAdminManage').addClass('active');
});

// 取消用户管理导航栏活跃状态
function removeUserManageNavActive() {
    $('#UserManageNav').children().filter('.active').removeClass('active');
}
