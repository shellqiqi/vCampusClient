var shopObjs = jQuery.parseJSON(shopController.getAllGoods());
var template = $.templates('#shopTemplate');
var app = {
    goods: shopObjs
};
template.link('#shop', app);

$('#addGoodsButton').click(function () {
    var commodityId = $('#inputAddCommodityId').val();
    var commodityName = $('#inputAddCommodityName').val();
    var prize = $('#inputAddPrize').val();
    var inventory = $('#inputAddInventory').val();
    if (isAllNumber(commodityId) && commodityName !== '' && isAllNumber(prize) && isAllNumber(inventory)) {
        var flag = shopController.addGoods(commodityId, commodityName, prize, inventory);
        if (flag === 1) {
            $('#goodsAddModal').modal('hide')
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

$('#shop').on('click', '.deleteButton', function () {
    var dataItem = $.view(this).data;
    $('#goodsDeleteModal').modal('show');
    $('#inputDeleteCommodityId').val(dataItem.commodityId);
    $('#deleteGoodsButton').click(function () {
        var commodityId = $('#inputDeleteCommodityId').val();
        if (isAllNumber(commodityId)) {
            var flag = shopController.deleteGoods(dataItem.commodityId);
            if (flag === 1) {
                $('#goodsDeleteModal').modal('hide')
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

$('#shop').on('click', '.updateButton', function () {
    var dataItem = $.view(this).data;
    $('#goodsUpdateModal').modal('show');

    $('#inputUpdateCommodityId').val(dataItem.commodityId);
    $('#inputUpdateCommodityName').val(dataItem.commodityName);
    $('#inputUpdatePrize').val(dataItem.prize);
    $('#inputUpdateInventory').val(dataItem.inventory);

    $('#updateGoodsButton').click(function () {
        var commodityId = $('#inputUpdateCommodityId').val();
        var commodityName = $('#inputUpdateCommodityName').val();
        var prize = $('#inputUpdatePrize').val();
        var inventory = $('#inputUpdateInventory').val();
        if (isAllNumber(commodityId) && commodityName !== '' && isAllNumber(prize) && isAllNumber(inventory)) {
            var flag = shopController.updateGoods(commodityId, commodityName, prize, inventory);
            if (flag === 1) {
                $('#goodsUpdateModal').modal('hide')
                $('#updateAlert').hide();
            } else {
                $('#updateAlert').text('更新失败');
                $('#updateAlert').slideDown();
            }
        } else {
            $('#updateAlert').text('请确保符合规范');
            $('#updateAlert').slideDown();
        }
    });
});

$('#goodsAddModal').on('hidden.bs.modal', function () {
    $('#shopBoard').load('shop/admin/admin.html');
});
$('#goodsDeleteModal').on('hidden.bs.modal', function () {
    $('#shopBoard').load('shop/admin/admin.html');
});
$('#goodsUpdateModal').on('hidden.bs.modal', function () {
    $('#shopBoard').load('shop/admin/admin.html');
});
