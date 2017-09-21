var shopJson = shopController.getAllGoods();
var shopObjs = jQuery.parseJSON(shopJson);
var template = $.templates('#shopTemplate');
var app = {
    goods: shopObjs
};
template.link('#shop', app);

$('#shop').on('click', '.buyButton', function () {
    var dataItem = $.view(this).data;
    $('#borrowModal').modal('show');
    $('#buyButton').click(function () {
        var flag = shopController.buyGoods(dataItem.commodityId);
        if (flag === 1) {
            $('#borrowModal').modal('hide')
            $('#addAlert').hide();
        } else {
            $('#addAlert').text('购买失败');
            $('#addAlert').slideDown();
        }
    });
});

$('#borrowModal').on('hidden.bs.modal', function () {
    $('#main-board').load('shop/shop.html');
});
