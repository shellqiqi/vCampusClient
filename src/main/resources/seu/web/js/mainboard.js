// 加载首页
$(document).ready(function () {
    $('#main-board').load('overView.html');
});

// 顶部导航
$('#setting').click(function () {
    removeListAttr();
    $('#main-board').load('setting.html');
});

$('#about').click(function () {
    removeListAttr();
    $('#main-board').load('about.html');
});

$('#logout').click(function () {
    $(location).attr('href', 'login.html');
});

// 侧边栏
$('#overView').click(function () {
    removeListAttr();
    $('#overView').addClass('active');
    $('#main-board').load('overView.html');
});

$('#userManageLink').click(function () {
    removeListAttr();
    $('#userManageLink').addClass('active');
    $('#main-board').load('userManage.html');
});

$('#studentManageLink').click(function () {
    removeListAttr();
    $('#studentManageLink').addClass('active');
    $('#main-board').load('studentManage.html');
});

$('#courseLink').click(function () {
    removeListAttr();
    $('#courseLink').addClass('active');
    $('#main-board').load('course.html');
});

$('#libraryLink').click(function () {
    removeListAttr();
    $('#libraryLink').addClass('active');
    $('#main-board').load('library.html');
});

$('#shopLink').click(function () {
    removeListAttr();
    $('#shopLink').addClass('active');
    $('#main-board').load('shop.html');
});

$('#dormitoryLink').click(function () {
    removeListAttr();
    $('#dormitoryLink').addClass('active');
    $('#main-board').load('dormitory.html');
});

function removeListAttr() {
    $("li[class='active']").removeClass('active');
}

