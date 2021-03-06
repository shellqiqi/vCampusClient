var infoObjs = jQuery.parseJSON(userManageController.getAllTeacher());
var template = $.templates('#infoTemplate');
var app = {
    info: infoObjs
};
template.link('#infoTable', app);

$('#addTeacherButton').click(function () {
    var teacherId = $('#inputAddTeacherId').val();
    var teacherName = $('#inputAddTeacherName').val();
    var teacherPhoneNumber = $('#inputAddTeacherPhoneNumber').val();
    var teacherPassword = $('#inputAddTeacherPassword').val();
    if (isAllNumber(teacherId) && teacherName !== '' && isAllNumber(teacherPhoneNumber) && teacherPassword !== '') {
        var flag = userManageController.addTeacher(teacherId, teacherName, teacherPhoneNumber, teacherPassword);
        if (flag === 1) {
            $('#userAddModal').modal('hide')
            $('#addAlert').hide();
        } else {
            $('#addAlert').text('添加失败');
            $('#addAlert').slideDown();
        }
    } else {
        $('#addAlert').text('请填写所有字段且确保符合规范');
        $('#addAlert').slideDown();
    }
});

$('#infoTable').on('click', '.deleteButton', function () {
    var dataItem = $.view(this).data;
    $('#userDeleteModal').modal('show');
    $('#inputDeleteTeacherId').val(dataItem.teacherId);
    $('#deleteTeacherButton').click(function () {
        var teacherId = $('#inputDeleteTeacherId').val();
        if (isAllNumber(teacherId)) {
            var flag = userManageController.deleteTeacher(teacherId);
            if (flag === 1) {
                $('#userDeleteModal').modal('hide')
                $('#deleteAlert').hide();
            } else {
                $('#deleteAlert').text('删除失败');
                $('#deleteAlert').slideDown();
            }
        } else {
            $('#deleteAlert').text('请确保符合规范');
            $('#deleteAlert').slideDown();
        }
    });
});

$('#infoTable').on('click', '.updateButton', function () {
    var dataItem = $.view(this).data;
    $('#userUpdateModal').modal('show');

    $('#inputUpdateTeacherId').val(dataItem.teacherId);
    $('#inputUpdateTeacherName').val(dataItem.teacherName);
    $('#inputUpdateTeacherPhoneNumber').val(dataItem.teacherPhoneNumber);
    $('#inputUpdateTeacherPassword').val(dataItem.password);
    
    $('#updateTeacherButton').click(function () {
        var teacherId = $('#inputUpdateTeacherId').val();
        var teacherName = $('#inputUpdateTeacherName').val();
        var teacherPhoneNumber = $('#inputUpdateTeacherPhoneNumber').val();
        var teacherPassword = $('#inputUpdateTeacherPassword').val();
        if (isAllNumber(teacherId) && teacherName !== '' && isAllNumber(teacherPhoneNumber) && teacherPassword !== '') {
            var flag = userManageController.updateTeacher(teacherId, teacherName, teacherPhoneNumber, teacherPassword);
            if (flag === 1) {
                $('#userUpdateModal').modal('hide')
                $('#updateAlert').hide();
            } else {
                $('#updateAlert').text('修改失败');
                $('#updateAlert').slideDown();
            }
        } else {
            $('#updateAlert').text('请填写所有字段且确保符合规范');
            $('#updateAlert').slideDown();
        }
    });
});

$('#userAddModal').on('hidden.bs.modal', function () {
    $('#user-manage-board').load('usermanage/teacher/userTeacherManage.html');
});
$('#userDeleteModal').on('hidden.bs.modal', function () {
    $('#user-manage-board').load('usermanage/teacher/userTeacherManage.html');
});
$('#userUpdateModal').on('hidden.bs.modal', function () {
    $('#user-manage-board').load('usermanage/teacher/userTeacherManage.html');
});
