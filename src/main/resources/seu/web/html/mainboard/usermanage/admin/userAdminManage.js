var infoObjs = jQuery.parseJSON(userManageController.getAllAdmin());
var template = $.templates('#infoTemplate');
var app = {
    info: infoObjs
};
template.link('#infoTable', app);

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

$('#infoTable').on('click', '.deleteButton', function () {
    var dataItem = $.view(this).data;
    $('#userDeleteModal').modal('show');
    $('#inputDeleteAdminId').val(dataItem.adminId);
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
});

$('#infoTable').on('click', '.updateButton', function () {
    var dataItem = $.view(this).data;
    $('#userUpdateModal').modal('show');
    $('#inputUpdateAdminId').val(dataItem.adminId);
    $('#inputUpdateAdminPassword').val(dataItem.password);
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
});

$('#userAddModal').on('hidden.bs.modal', function () {
    $('#user-manage-board').load('usermanage/admin/userAdminManage.html');
});
$('#userDeleteModal').on('hidden.bs.modal', function () {
    $('#user-manage-board').load('usermanage/admin/userAdminManage.html');
});
$('#userUpdateModal').on('hidden.bs.modal', function () {
    $('#user-manage-board').load('usermanage/admin/userAdminManage.html');
});
