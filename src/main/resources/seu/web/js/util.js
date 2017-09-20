// 获取URL参数
function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if (r !== null) return unescape(r[2]);
    return null;
}

function isAllNumber(value) {
    var ex = /^\d+$/;
    return ex.test(value);
}

// 取消侧边栏活跃状态
function removeSideActive() {
    $('#sidebar').children().filter('.active').removeClass('active');
}

// 取消用户管理导航栏活跃状态
function removeUserManageNavActive() {
    $('#UserManageNav').children().filter('.active').removeClass('active');
}