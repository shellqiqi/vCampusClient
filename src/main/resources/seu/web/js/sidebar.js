// 侧边栏
$('#overView').click(function () {
    removeSideActive();
    $('#overView').addClass('active');
    $('#main-board').load('overView.html');
});

$('#userManageLink').click(function () {
    removeSideActive();
    $('#userManageLink').addClass('active');
    $('#main-board').load('userManage.html');
});

$('#studentManageLink').click(function () {
    removeSideActive();
    $('#studentManageLink').addClass('active');
    $('#main-board').load('studentManage.html');
});

$('#courseLink').click(function () {
    removeSideActive();
    $('#courseLink').addClass('active');
    $('#main-board').load('course.html');
});

$('#libraryLink').click(function () {
    removeSideActive();
    $('#libraryLink').addClass('active');
    $('#main-board').load('library.html');
});

$('#shopLink').click(function () {
    removeSideActive();
    $('#shopLink').addClass('active');
    $('#main-board').load('shop.html');
});

$('#dormitoryLink').click(function () {
    removeSideActive();
    $('#dormitoryLink').addClass('active');
    $('#main-board').load('dormitory.html');
});

function removeSideActive() {
    $('#sidebar').children().filter('.active').removeClass('active');
}

$(window).scroll(function(){
    if ($(window).scrollTop()>0){
        $("#returnTop").fadeIn();
    }
    else
    {
        $("#returnTop").fadeOut();
    }
});

$("#returnTop").click(function(){
    $('body,html').animate({scrollTop:0},200);
    return false;
});
