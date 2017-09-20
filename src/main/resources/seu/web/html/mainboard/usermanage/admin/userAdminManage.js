var json = userManageController.getAllAdmin();
var objs = jQuery.parseJSON(json);
var html = '';
for (var i=0;i<objs.length;i++)
{
    html += '<tr><th>' + objs[i].adminId;
    html += '</td></tr>';
}
$('#infoTable').html(html);

$('#addAdminButton').click(function () {
    var adminId = $('#inputAddAdminId').val();
    var adminPassword = $('#inputAddAdminPassword').val();
    if (isAllNumber(adminId) && adminPassword !== '') {
        var flag = userManageController.addAdmin(adminId, adminPassword);
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

$('#deleteAdminButton').click(function () {
    var adminId = $('#inputDeleteAdminId').val();
    if (isAllNumber(adminId)) {
        var flag = userManageController.deleteAdmin(adminId);
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

$('#updateAdminButton').click(function () {
    var adminId = $('#inputUpdateAdminId').val();
    var adminPassword = $('#inputUpdateAdminPassword').val();
    if (isAllNumber(adminId) && adminPassword !== '') {
        var flag = userManageController.updateAdmin(adminId, adminPassword);
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
