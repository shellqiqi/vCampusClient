// 加载首页
$(document).ready(function () {
    $('#main-board').load('overView.html');
    if (getUrlParam('role') === '1' || getUrlParam('role') === '2') {
        $('#userManageLink').hide();
    }
});

// 顶部导航
$('#setting').click(function () {
    removeSideActive();
    $('#main-board').load('setting.html');
});

$('#about').click(function () {
    removeSideActive();
    $('#main-board').load('about.html');
});

$('#logout').click(function () {
    loginController.logout();
    $(location).attr('href', 'login.html');
});

function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if (r !== null) return unescape(r[2]);
    return null;
}