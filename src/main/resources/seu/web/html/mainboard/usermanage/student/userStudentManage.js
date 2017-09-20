var json = userManageController.getAllStudent();
var objs = jQuery.parseJSON(json);
var html = '';
for (var i = 0; i < objs.length; i++) {
    html += '<tr><th>' + objs[i].studentId;
    html += '</th><td>' + objs[i].studentName;
    html += '</td><td>' + objs[i].classId;
    html += '</td><td>' + objs[i].dormitoryId;
    html += '</td><td>' + objs[i].balance;
    html += '</td></tr>';
}
$('#infoTable').html(html);

$('#addStudentButton').click(function () {
    var studentId = $('#inputAddStudentId').val();
    var studentName = $('#inputAddStudentName').val();
    var studentClassId = $('#inputAddStudentClassId').val();
    var studentDormitoryId = $('#inputAddStudentDormitoryId').val();
    var studentBalance = $('#inputAddStudentBalance').val();
    var studentPassword = $('#inputAddStudentPassword').val();
    if (isAllNumber(studentId) && studentName !== '' && isAllNumber(studentClassId) && isAllNumber(studentDormitoryId) && isAllNumber(studentBalance) && studentPassword !== '') {
        var flag = userManageController.addStudent(studentId, studentName, studentClassId, studentDormitoryId, studentBalance, studentPassword);
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

$('#deleteStudentButton').click(function () {
    var studentId = $('#inputDeleteStudentId').val();
    if (isAllNumber(studentId)) {
        var flag = userManageController.deleteStudent(studentId);
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

$('#updateStudentButton').click(function () {
    var studentId = $('#inputUpdateStudentId').val();
    var studentName = $('#inputUpdateStudentName').val();
    var studentClassId = $('#inputUpdateStudentClassId').val();
    var studentDormitoryId = $('#inputUpdateStudentDormitoryId').val();
    var studentBalance = $('#inputUpdateStudentBalance').val();
    var studentPassword = $('#inputUpdateStudentPassword').val();
    if (isAllNumber(studentId) && studentName !== '' && isAllNumber(studentClassId) && isAllNumber(studentDormitoryId) && isAllNumber(studentBalance) && studentPassword !== '') {
        var flag = userManageController.updateStudent(studentId, studentName, studentClassId, studentDormitoryId, studentBalance, studentPassword);
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
